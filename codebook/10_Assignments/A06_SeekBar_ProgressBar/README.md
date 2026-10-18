# A06 SeekBar와 수평 ProgressBar 동기화

[과제 목록](../README.md) · [요구사항 전문](../../../ASSIGNMENTS.md)

SeekBar 값을 바꾸면 같은 콜백에서 수평 ProgressBar와 입력상자 값을 함께 갱신한다. 자동 증가 타이머 없이 과제 6의 세 위젯만 연결하는 독립 예제다.

상태: **미검증**. XML 문법, ID 연결, 수평 스타일과 콜백의 두 갱신 호출을 정적으로 확인했다. Android 빌드·에뮬레이터·실기기 실행은 수행하지 않았다.

## 출처

- `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.172: SeekBar·ProgressBar·입력상자 배치, SeekBar 값 변경 시 막대와 입력상자 변경, 막대형 ProgressBar 조건.
- 같은 PDF p.173: SeekBar 값 변경을 알려 주는 콜백을 사용하고 그 콜백에서 ProgressBar와 입력상자에 값을 설정하라는 교수님 조언.
- 두 페이지를 `pdftotext -layout` 추출과 `pdftoppm` PNG 렌더로 대조했다. 상세 조건과 예시 값 `45`는 페이지 이미지에서 확인했다. 페이지 번호는 PDF 기준이며 완성 콜백 코드를 PDF에서 그대로 옮긴 것은 아니다.

## 파일과 연결

| 파일 | 역할 |
|---|---|
| `app/src/main/java/com/example/myapplication/MainActivity.java` | ID 조회, 초기 표시 맞춤, SeekBar 콜백에서 두 대상 갱신 |
| `app/src/main/res/layout/activity_main.xml` | SeekBar → 수평 ProgressBar → 입력상자의 세로 배치 |

`seek_bar`를 변경하면 `onProgressChanged`가 `progress`를 받는다. 같은 메서드에서 `progress_bar.setProgress(progress)`와 `value_input.setText(String.valueOf(progress))`를 호출한다. `onStartTrackingTouch`/`onStopTrackingTouch`는 리스너 인터페이스를 완성하는 빈 콜백이다. 리스너 등록 전에도 SeekBar 초기값을 읽어 두 표시를 맞춘다.

입력상자를 직접 수정하는 반대 방향 동기화는 요구되지 않았다. 직접 입력한 숫자는 SeekBar를 바꾸지 않으며, 다음 SeekBar 값 변경 때 현재 값으로 다시 표시된다. `fromUser`로 콜백을 제한하지 않아 코드로 값을 바꾸거나 상태를 복원하는 경우에도 갱신된다.

## 복사·실행

1. AppCompat 의존성과 AppCompat/Material 계열 테마를 사용하는 Java/XML 연습용 프로젝트를 준비한다. 이 폴더는 Gradle/Manifest를 포함하지 않는 전체 파일 복사 예제다.
2. 위 두 파일을 연습용 프로젝트의 동일 `app/src/main/` 상대 경로로 복사한다. 다른 과제 Java/XML을 섞지 않는다.
3. 패키지와 프로젝트 `namespace`를 `com.example.myapplication`로 맞춘다. Manifest에 `.MainActivity` 시작 등록(`MAIN`/`LAUNCHER`, `android:exported="true"`)을 사용한다. 별도 권한/Drawable은 필요 없다.
4. 빌드·실행한다. 처음에는 `45`가 표시되고, SeekBar를 양끝/중간으로 움직일 때 막대와 입력상자가 `0`/`100`/현재 값으로 함께 바뀌는지 확인한다. 이 결과는 실행으로 검증하지 않았다.

실행 프로젝트가 edge-to-edge를 강제하면 루트 `main`의 padding/insets를 환경에 맞게 별도로 적용한다. 이 예제는 시스템 바 보정을 포함하지 않는다.

## 시험 수정 지점과 흔한 오류

- 범위: `seek_bar`와 `progress_bar`의 `android:max="100"`을 함께 바꾼다. 한쪽만 바꾸면 같은 값이어도 화면의 진행 비율이 달라진다.
- 초기값: SeekBar의 `android:progress="45"`만 바꾸면 Java가 나머지 두 뷰의 초기값을 맞춘다. `max` 이하로 설정한다.
- 표시 형식: 콜백의 `valueInput.setText(String.valueOf(progress))`를 수정한다. 정수 `progress`를 `setText(progress)`로 바로 넣으면 문자열 리소스 ID로 해석되어 오류가 날 수 있다.
- ID 변경: XML의 `seek_bar`/`progress_bar`/`value_input`과 Java `R.id`를 함께 바꾼다. `findViewById`는 `setContentView` 뒤에 둔다.
- 수평 표시: `style="?android:attr/progressBarStyleHorizontal"`과 `indeterminate="false"`를 유지한다. 기본 ProgressBar를 그대로 쓰면 원형 표시가 될 수 있다.
- 동기화 두 호출은 `onProgressChanged` 안에 둔다. 드래그 종료 콜백에만 넣으면 움직이는 동안 실시간 반영되지 않는다.

## 추가·호환 내역

- `[추가 코드]`: PDF에는 화면과 동작 조건만 있어 Java 전체 클래스·import·ID 조회·`SeekBar.OnSeekBarChangeListener` 세 메서드·초기값 표시·전체 XML을 작성했다. 콜백 방식과 두 대상 동기화는 교수님 조언을 구현한 것이다.
- `[추가 코드]`: 최댓값 `100`, 세로 레이아웃/간격/ID, 입력상자의 숫자 키보드·중앙 정렬·힌트, 접근성 설명은 구현 선택이다. 초기 `45`는 PDF 그림의 값을 시작값으로 사용했다.
- 한국어 주석은 속성 역할, ID 연결, 이벤트 흐름과 흔한 오류를 설명한다. 별도의 `[호환성 수정]` 코드는 없다.
- 자동 타이머, ProgressDialog, 통신, 다른 과제 기능과 입력상자 역방향 이벤트는 포함하지 않았다.

정적 검사 통과는 실행 검증을 뜻하지 않는다. 남은 확인은 실제 SeekBar 드래그 중 값/막대 동기화와 실행 환경의 키보드·시스템 바 표시다.
