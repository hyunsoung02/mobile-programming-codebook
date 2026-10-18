# 시험용 복사·실행·검증 가이드

[코드북 홈](../README.md) · [전체 작성 상태](../CODEBOOK_PLAN.md) · [작업 규칙](../../AGENTS.md)

이 폴더는 기능 ID를 추가하지 않고 코드북의 파일 적용 방법과 검증 기준을 안내한다. 이 가이드는 운영 설명이며 PPT의 별도 구현 기능으로 집계하지 않는다. 코드 출처는 각 예제 README에 파일명과 PDF 페이지 번호로 기록한다.

## 파일 세트와 복사

현재 [F001](../01_Project/F001_MainActivity_XML/README.md), [F002](../02_View_Properties/F002_FindViewById/README.md), [F023](../03_Layouts/F023_LinearLayout_Orientation/README.md), [F006](../06_Events/F006_Button_XML_OnClick/README.md)과 [과제 6개](../10_Assignments/README.md)는 각각 생략 없는 Java 클래스, 전체 XML 레이아웃과 실행 방법을 제공한다. 과제 3·5에는 필요한 Drawable도 포함한다. 나머지 81개 기능은 작성 예정이다. 예제 안의 경로는 다음과 같다.

```text
app/src/main/
├── java/com/example/myapplication/MainActivity.java
└── res/
    ├── layout/activity_main.xml
    └── drawable/  (해당 예제에 필요할 때)
```

1. [원장](../CODEBOOK_PLAN.md)에서 필요한 기능 ID 하나를 찾고 해당 예제의 출처·상태·필요 파일을 읽는다.
2. 시험용 또는 별도 연습용 Android 프로젝트를 준비하고 기존 파일을 보관한다. 코드북 작업만으로 현재 프로젝트의 `app/src/main/`을 덮어쓰지 않는다.
3. 예제의 `app/src/main/` 상대 구조를 유지하여 필요한 Java/XML·리소스를 대상 프로젝트에 복사한다. 예제는 Gradle 모듈이 아니므로 예제 폴더만 열어 빌드할 수 없다.
4. 대상 프로젝트가 다른 패키지를 쓰면 `package`, 필요한 import와 Manifest의 액티비티 이름을 함께 맞춘다. 기준 패키지는 `com.example.myapplication`이다.
5. 대상 프로젝트의 시작 액티비티 및 의존성·테마 설정을 확인하고, 해당 예제에 필요하다고 명시한 Manifest 설정만 적용한다. 예제 간 코드를 임의로 합치지 않는다.

## 연결 관계와 시험 조건 변경

| 바꾸는 대상 | 함께 확인할 연결 |
|---|---|
| 레이아웃 파일명 | `setContentView(R.layout.activity_main)`의 리소스 이름 |
| View의 `android:id` | `findViewById(R.id...)`와 제약·상대 배치 참조 ID |
| XML의 `android:onClick` | Java의 동일 이름 `public void 메서드명(View v)`와 `android.view.View` import |
| 이미지·Drawable 파일명 | XML의 `@drawable/...` 및 Java의 `R.drawable...` |
| Java 패키지·액티비티 이름 | `package`, 참조 import, Manifest의 액티비티 등록 |
| 배치 조건·글자 크기·색 | 각 예제가 설명하는 `orientation`, 제약, 크기·여백·텍스트 속성 |

F006의 XML 선언형 클릭과 F007의 리스너 클릭은 별도 구현 방식이다. 시험에서 요구하는 방식을 선택한다. Java/XML 주요 부분의 한국어 주석에서 변경할 ID·변수·메서드·속성을 확인한다. PPT에 없는 코드는 `[추가 코드]`, 최신 SDK에 맞춰 변경한 코드는 `[호환성 수정]`으로 이유를 함께 남긴다.

## 검사와 실행 상태

프로젝트 루트에서 다음 구조 검사를 실행한다. 이 검증기는 코드북을 위해 추가한 도구이며 강의의 Android 예제 코드가 아니다.

```sh
zsh codebook/11_Exam_Guide/validate_codebook.sh
```

구조 검사는 11개 분류 README, 원장의 F001-F085 중복·누락 및 문서 경로, 작성된 기능·과제 예제의 파일·패키지·화면 연결, 과제용 Drawable과 F006의 XML/Java 클릭 연결을 확인한다. `python3`로 `codebook/` 안의 모든 Markdown 문서에 있는 인라인 상대 링크 대상도 검사하며 외부 URL·절대 경로·앵커 전용 링크는 제외한다. `python3`가 없으면 링크 검사 실패로 처리한다. `xmllint`가 있으면 XML 문법도 검사한다. 기존 앱 지문 기준 파일이 있으면 `app/src/main/` 변경 여부도 비교한다.

85행 배치만 검사할 때는 다음을 실행한다.

```sh
test "$(rg -o '^\| F[0-9]{3} \|' codebook/CODEBOOK_PLAN.md | wc -l | tr -d ' ')" = 85 && test "$(rg -o '^\| F[0-9]{3} \|' codebook/CODEBOOK_PLAN.md | sort -u | wc -l | tr -d ' ')" = 85
```

정적 검사는 Android 컴파일·실행을 대신하지 않는다. 대상 프로젝트에서 실제 Gradle 빌드와 필요한 에뮬레이터/실단말 동작 확인을 수행한 경우에만 그 검사 범위를 근거로 검증 결과를 적는다. 실행하지 않았거나 대상 기기를 확인하지 않은 예제는 `미검증`을 유지한다. 현재 작성된 기능 예제 4개와 과제 6개는 복사 가능한 파일 세트이며 Android 빌드·에뮬레이터 실행 전 상태다.

검사 결과에는 명령, 성공/실패 여부, 실패 이유와 미실행 항목을 남긴다. 출처 PDF는 수정·삭제하거나 GitHub에 커밋하지 않는다.
