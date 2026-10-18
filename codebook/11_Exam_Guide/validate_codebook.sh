#!/usr/bin/env zsh
# [추가 코드] 코드북 구조 검증용
# 강의 예제 코드가 아니라 설계에 따른 파일 배치와 Java/XML 연결을 검사한다.
# 실행: zsh codebook/11_Exam_Guide/validate_codebook.sh
# 정적 검사 통과는 Android 빌드 또는 에뮬레이터 실행을 의미하지 않는다.

emulate -L zsh
setopt PIPE_FAIL

# 현재 작업 디렉터리와 무관하게 이 스크립트가 있는 프로젝트를 검사한다.
project_root=${0:A:h:h:h}
codebook_root="$project_root/codebook"
cd "$project_root" || exit 1
integer failures=0

fail() {
  print -r -- "FAIL: $1"
  (( failures += 1 ))
}

require_file() {
  [[ -f "$project_root/$1" ]] || fail "파일 누락: $1"
}

# 주석과 문자열 속 예시 코드는 실제 Java 선언·호출이 아니다.
# 줄 주석/블록 주석/문자열/문자 리터럴을 공백으로 바꾸되 줄 경계를 유지한다.
java_code() {
  awk '
    {
      output = ""
      for (i = 1; i <= length($0); i++) {
        current = substr($0, i, 1)
        following = substr($0, i + 1, 1)
        if (block_comment) {
          if (current == "*" && following == "/") {
            block_comment = 0
            i++
          }
          output = output " "
        } else if (quote != "") {
          if (current == "\\") i++
          else if (current == quote) quote = ""
          output = output " "
        } else if (current == "/" && following == "/") {
          break
        } else if (current == "/" && following == "*") {
          block_comment = 1
          output = output " "
          i++
        } else if (current == "\"" || current == sprintf("%c", 39)) {
          quote = current
          output = output " "
        } else {
          output = output current
        }
      }
      print output
    }
  ' "$1"
}

# 문자열 검색 대신 XML 파서로 실제 Android onClick 속성을 검사한다.
# namespace URI를 확인하므로 접두사·따옴표 종류에 의존하지 않는다.
xml_click_is_connected() {
  if command -v xmllint >/dev/null 2>&1; then
    local attributes='//@*[local-name()="onClick" and namespace-uri()="http://schemas.android.com/apk/res/android"]'
    local connected
    connected=$(xmllint --nonet --xpath "count(${attributes}) > 0 and count(${attributes}[. != 'onButtonClicked']) = 0" "$1" 2>/dev/null) || return 1
    [[ "$connected" == true ]]
  elif command -v python3 >/dev/null 2>&1; then
    # xmllint가 없는 환경에서도 주석을 속성으로 잘못 인정하지 않는다.
    python3 - "$1" <<'PY'
import sys
import xml.etree.ElementTree as ET
try:
    root = ET.parse(sys.argv[1]).getroot()
    key = "{http://schemas.android.com/apk/res/android}onClick"
    values = [element.attrib[key] for element in root.iter() if key in element.attrib]
    sys.exit(0 if values and all(value == "onButtonClicked" for value in values) else 1)
except (ET.ParseError, OSError):
    sys.exit(1)
PY
  else
    print -r -- 'FAIL: 실제 XML 속성 검사에 xmllint 또는 python3 필요' >&2
    return 1
  fi
}

folders=(
  01_Project 02_View_Properties 03_Layouts 04_Widgets 05_Drawables
  06_Events 07_User_Feedback 08_Progress 09_Activity_Lifecycle
  10_Assignments 11_Exam_Guide
)

require_file codebook/README.md
require_file codebook/CODEBOOK_PLAN.md
for folder in "${folders[@]}"; do
  [[ -d "$codebook_root/$folder" ]] || fail "분류 폴더 누락: codebook/$folder"
  require_file "codebook/$folder/README.md"
done

# [추가 코드] 원장 외의 모든 Markdown 문서도 재귀적으로 검사한다.
# URL을 실행하거나 네트워크로 열지 않고, 문서 기준 상대 경로의 존재만 확인한다.
# URL의 query/fragment를 먼저 제거해야 %23, %3F가 포함된 실제 파일명도 보존된다.
if command -v python3 >/dev/null 2>&1; then
  if ! python3 - "$codebook_root" <<'PY'
from pathlib import Path
import html
import re
import sys
from urllib.parse import unquote

root = Path(sys.argv[1])
checked = 0
broken = 0


def destination(text, start):
    """인라인 링크의 꺾쇠 경로, 균형 괄호, 역슬래시 이스케이프를 읽는다."""
    position = start
    while position < len(text) and text[position].isspace():
        position += 1
    angle = position < len(text) and text[position] == '<'
    if angle:
        position += 1
    beginning = position
    depth = 0
    while position < len(text):
        character = text[position]
        if character == '\\':
            position += 2
            continue
        if angle and character == '>':
            return text[beginning:position]
        if not angle:
            if character == '(':
                depth += 1
            elif character == ')':
                if depth == 0:
                    return text[beginning:position]
                depth -= 1
            elif character.isspace() and depth == 0:
                # 공백 뒤의 선택적 링크 제목은 파일명의 일부가 아니다.
                return text[beginning:position] if ')' in text[position:] else None
        position += 1
    return None


for document in sorted(root.rglob('*.md')):
    try:
        source = document.read_text(encoding='utf-8')
    except (OSError, UnicodeError) as error:
        print(f'FAIL: Markdown 읽기 실패: {document.relative_to(root.parent)}: {error}')
        broken += 1
        continue
    lines = source.splitlines(keepends=True)
    # 코드 블록과 인라인 코드는 링크가 아니다. 공백으로 바꿔 줄 번호를 보존한다.
    visible = []
    fence = None
    comment = False
    line_offset = 0
    inline_end = 0
    inline_or_comment = re.compile(r'(`+).*?\1|<!--', flags=re.DOTALL)
    for line in lines:
        # [추가 코드] 실제 코드 블록 밖의 주석을 fence 판별 전에 가린다.
        # 코드 블록 안의 주석 표시는 상태를 바꾸지 않으며 개행도 보존한다.
        # [추가 코드] fence 시작 줄의 info string은 HTML 주석을 시작하지 않는다.
        # 이미 HTML 주석 안이면 먼저 가려야 주석 속 fence도 계속 무시된다.
        if fence is None and (comment or not re.match(r' {0,3}(`{3,}|~{3,})', line)):
            parts = []
            position = 0
            while position < len(line):
                if line_offset + position < inline_end:
                    end = min(len(line), inline_end - line_offset)
                    parts.append(line[position:end])
                elif comment:
                    closing = line.find('-->', position)
                    end = closing + 3 if closing >= 0 else len(line)
                    parts.append(re.sub(r'[^\n]', ' ', line[position:end]))
                    comment = closing < 0
                else:
                    # 여러 줄 인라인 코드 속 주석 표시도 실제 주석이 아니다.
                    token = inline_or_comment.search(source, line_offset + position)
                    if token is None or token.start() >= line_offset + len(line):
                        parts.append(line[position:])
                        break
                    start = token.start() - line_offset
                    parts.append(line[position:start])
                    end = min(len(line), token.end() - line_offset)
                    comment = token.group() == '<!--'
                    if not comment:
                        inline_end = token.end()
                    parts.append(' ' * (end - start) if comment else line[start:end])
                position = end
            line = ''.join(parts)
        marker = re.match(r' {0,3}(`{3,}|~{3,})', line)
        hidden = fence is not None or marker is not None
        if marker:
            token = marker.group(1)
            if fence is None:
                fence = token
            elif token[0] == fence[0] and len(token) >= len(fence):
                fence = None
        visible.append(re.sub(r'[^\n]', ' ', line) if hidden else line)
        line_offset += len(line)
    text = ''.join(visible)
    text = re.sub(r'(`+).*?\1', lambda match: re.sub(r'[^\n]', ' ', match.group()), text, flags=re.DOTALL)
    for match in re.finditer(r'(?<!\\)!?\[(?:\\.|[^\]\\])*\]\(', text):
        raw = destination(text, match.end())
        if raw is None:
            continue
        target = html.unescape(re.sub(r'\\([!"#$%&\'()*+,\-./:;<=>?@\[\]\\^_`{|}~])', r'\1', raw))
        # 외부 URL, 절대 경로, 앵커 전용 및 현재 문서 query는 검사 대상이 아니다.
        if target.startswith(('/', '#', '?')) or re.match(r'^[a-zA-Z][a-zA-Z0-9+.-]*:', target):
            continue
        path = re.split(r'[?#]', target, maxsplit=1)[0]
        if not path:
            continue
        checked += 1
        line_number = text.count('\n', 0, match.start()) + 1
        try:
            decoded = unquote(path, encoding='utf-8', errors='strict')
            if '\0' in decoded:
                raise ValueError('파일명에 NUL 포함')
            exists = (document.parent / decoded).exists()
        except (OSError, UnicodeError, ValueError):
            exists = False
        if not exists:
            broken += 1
            print(f'FAIL: Markdown 상대 링크 대상 없음: {document.relative_to(root.parent)}:{line_number}: {raw}')

print(f'INFO: Markdown 상대 링크 {checked}개, 깨진 대상 {broken}개')
sys.exit(1 if broken else 0)
PY
  then
    fail 'Markdown 상대 링크 검사 실패'
  fi
else
  fail 'Markdown 상대 링크 검사에 python3 필요'
fi

# CODEBOOK_PLAN의 표는 ID, 기능명, 주 폴더, 코드북 문서, 구현 파일,
# PPT 출처, 상태의 7열이다. 표 밖의 설명에 나온 ID는 집계하지 않는다.
if [[ -f "$codebook_root/CODEBOOK_PLAN.md" ]]; then
  typeset -A seen
  integer row_count=0
  while IFS=$'\t' read -r feature_id main_folder document; do
    (( row_count += 1 ))
    seen[$feature_id]=$(( ${seen[$feature_id]:-0} + 1 ))
    (( ${seen[$feature_id]} == 1 )) || fail "기능 ID 중복: $feature_id"
    integer feature_number=$(( 10#${feature_id#F} ))
    if (( feature_number < 1 || feature_number > 85 )); then
      fail "범위 밖 기능 ID: $feature_id (허용: F001~F085)"
    fi

    # 주 폴더는 하나여야 하며 설계의 지정 폴더 중 하나여야 한다.
    if (( ${folders[(Ie)$main_folder]} == 0 )); then
      fail "$feature_id 주 폴더 불일치: $main_folder"
    fi

    # 문서 경로는 codebook 기준 또는 프로젝트 기준 경로를 허용한다.
    # Markdown 링크 [표시명](경로)도 허용하며 파일은 codebook 안에 있어야 한다.
    document=$(print -r -- "$document" | sed -E 's/^\[[^]]*\]\(([^)]*)\)$/\1/; s/^<([^>]*)>$/\1/')
    if [[ -z "$document" ]]; then
      fail "$feature_id 코드북 문서 경로 누락"
      continue
    elif [[ "$document" == codebook/* ]]; then
      resolved_document="$project_root/$document"
    else
      resolved_document="$codebook_root/$document"
    fi
    resolved_document=${resolved_document:A}
    if [[ "$resolved_document" != "$codebook_root/"* ]]; then
      fail "$feature_id 코드북 밖의 문서 경로: $document"
    elif [[ ! -f "$resolved_document" ]]; then
      fail "$feature_id 코드북 문서 누락: $document"
    fi
  done < <(awk -F '|' '
    function clean(value) {
      gsub(/`/, "", value)
      sub(/^[[:space:]]+/, "", value)
      sub(/[[:space:]]+$/, "", value)
      return value
    }
    /^\|/ {
      id = clean($2)
      if (id ~ /^F[0-9][0-9][0-9]$/) {
        printf "%s\t%s\t%s\n", id, clean($4), clean($5)
      }
    }
  ' "$codebook_root/CODEBOOK_PLAN.md")

  (( row_count == 85 )) || fail "기능 표 행 수: $row_count (필요: 85)"
  for number in {1..85}; do
    printf -v feature_id 'F%03d' "$number"
    (( ${seen[$feature_id]:-0} >= 1 )) || fail "기능 ID 누락: $feature_id"
  done
fi

examples=(
  01_Project/F001_MainActivity_XML
  03_Layouts/F023_LinearLayout_Orientation
  06_Events/F006_Button_XML_OnClick
)
optional_examples=(
  02_View_Properties/F002_FindViewById
  10_Assignments/A01_Guideline_Two_Buttons
  10_Assignments/A02_Three_Area_ConstraintLayout
  10_Assignments/A03_Toggle_ImageViews
  10_Assignments/A04_SNS_Byte_Counter
  10_Assignments/A05_Shape_Buttons
  10_Assignments/A06_SeekBar_ProgressBar
)
for example in "${optional_examples[@]}"; do
  # 작성 예정 픽스처에는 디렉터리가 없을 수 있다. 실제 코드북의 상위 README 링크가
  # 통째로 사라진 예제를 잡고, 디렉터리가 생긴 예제는 아래에서 전체 파일을 검사한다.
  [[ -e "$codebook_root/$example" ]] && examples+=("$example")
done
for example in "${examples[@]}"; do
  example_root="codebook/$example"
  java_file="$example_root/app/src/main/java/com/example/myapplication/MainActivity.java"
  xml_file="$example_root/app/src/main/res/layout/activity_main.xml"
  require_file "$example_root/README.md"
  require_file "$java_file"
  require_file "$xml_file"

  if [[ -f "$java_file" ]]; then
    java_source=$(java_code "$java_file")
    print -r -- "$java_source" | grep -Eq '^[[:space:]]*package[[:space:]]+com\.example\.myapplication[[:space:]]*;' ||
      fail "$example Java 패키지 불일치: com.example.myapplication 필요"
    print -r -- "$java_source" | grep -Eq 'setContentView[[:space:]]*\([[:space:]]*R\.layout\.activity_main[[:space:]]*\)' ||
      fail "$example 화면 연결 누락: setContentView(R.layout.activity_main) 필요"
  fi

  if [[ -f "$xml_file" ]]; then
    if command -v xmllint >/dev/null 2>&1; then
      xml_error=$(xmllint --noout --nonet "$xml_file" 2>&1)
      [[ $? == 0 ]] || fail "$example XML 문법 오류: $xml_error"
    else
      print -r -- "SKIP: xmllint 없음 — $xml_file XML 문법 파싱 미수행"
    fi
  fi
done

# [추가 코드] 과제 디렉터리가 작성된 경우 Java/XML 외의 필수 Drawable도 검사한다.
if [[ -d "$codebook_root/10_Assignments/A03_Toggle_ImageViews" ]]; then
  require_file codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/res/drawable/sample_image.xml
fi
if [[ -d "$codebook_root/10_Assignments/A05_Shape_Buttons" ]]; then
  require_file codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_outline.xml
  require_file codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_filled.xml
fi

event_root=codebook/06_Events/F006_Button_XML_OnClick/app/src/main
event_java="$event_root/java/com/example/myapplication/MainActivity.java"
event_xml="$event_root/res/layout/activity_main.xml"
if [[ -f "$event_java" && -f "$event_xml" ]]; then
  xml_click_is_connected "$event_xml" ||
    fail 'F006 XML 연결 누락: android:onClick="onButtonClicked" 필요'
  java_code "$event_java" | grep -Eq 'public[[:space:]]+void[[:space:]]+onButtonClicked[[:space:]]*\([[:space:]]*(android\.view\.)?View[[:space:]]+[[:alpha:]_][[:alnum:]_]*[[:space:]]*\)' ||
    fail 'F006 Java 연결 누락: public void onButtonClicked(View v) 필요'
fi

# Task 1에서 저장한 앱 지문이 있으면 파일 추가·삭제·내용 변경을 함께 검사한다.
baseline=/private/tmp/android-codebook-app-before.sha
if [[ -f "$baseline" ]]; then
  if ! cmp -s "$baseline" <(find app/src/main -type f -print0 | sort -z | xargs -0 shasum); then
    fail "기존 app/src/main 파일 지문 변경: $baseline 대비 불일치"
  fi
else
  print -r -- "SKIP: 앱 비교 기준 지문 없음 — $baseline"
fi

if (( failures > 0 )); then
  print -r -- "FAIL: 총 ${failures}개 구조 오류 (Android 실행 검증은 별도)"
  exit 1
fi
print -r -- 'PASS: 코드북 정적 구조 검사 통과 (빌드·에뮬레이터 미검증)'
exit 0
