# A04 SNS 입력 화면과 바이트 표시

[과제 목록](../README.md) · [요구사항 전문](../../../ASSIGNMENTS.md)

입력상자 내용이 바뀌면 `N/80 바이트`를 자동 갱신하고, 전송 버튼을 누르면 입력 내용을 Toast로 표시한다. 닫기 버튼은 화면 배치만 제공한다. 과제 4만 포함하는 독립 복사 예제다.

상태: **미검증**. XML 문법과 Java/XML ID·리소스 참조 및 요구사항을 정적으로 확인했다. Android 빌드, 에뮬레이터, 실기기 실행은 수행하지 않았다.

## 출처와 해석

- `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.127: 위쪽 입력상자, 아래쪽 전송/닫기 가로 버튼, 입력상자 아래·오른쪽의 다른 색 바이트 표시, 한 줄 한글 약 8자, 전송 Toast 조건.
- 같은 PDF p.128: 바이트 표시를 화면에서 가장 위쪽에 배치하고, 입력될 때마다 자동 호출되는 메서드를 사용하라는 조언.
- 원본 PDF의 두 페이지를 `pdftotext -layout`로 추출하고 `pdftoppm` PNG로 렌더링해 대조했다. 텍스트 추출에서 빠지는 본문 이미지의 조건도 렌더에서 확인했다. 페이지 번호는 PDF 기준이다.

p.127의 **입력상자 아래·오른쪽**과 p.128의 **화면 맨 위**는 충돌한다. 이 예제는 p.128 교수님 조언을 우선하여 `byte_count`를 첫 번째 자식으로 두고 오른쪽 정렬한다. p.127 배치가 출제되면 `activity_main.xml`의 `byte_count` TextView 전체를 `message_input` EditText 바로 뒤, 버튼용 LinearLayout 바로 앞으로 옮긴다. `android:gravity="end"`는 유지한다. Java 변경은 없다.

PDF에는 바이트 계산 인코딩이나 알고리즘이 없다. 따라서 Java 기본 charset이나 문자열 `length()`를 교수님 정답으로 단정하지 않는다. 이 예제는 재현 가능한 동작을 위해 **명시적인 UTF-8**을 `[추가 코드]`로 선택했다. UTF-8에서 `A`는 1바이트, `가`는 3바이트, `😀`는 4바이트다. 교수님이 다른 계산 기준을 제시하면 Java의 `getBytes(StandardCharsets.UTF_8).length` 계산 지점을 바꾼다.

p.127-128에는 80바이트 초과 입력을 막으라는 조건이나 닫기 버튼 클릭 동작이 없다. `/80`은 표시 기준으로 사용하며 80바이트를 넘어도 계산·표시는 계속된다. `maxLength`, 입력 필터, `finish()`를 임의로 추가하지 않았다.

## 파일과 연결

| 파일 | 역할 |
|---|---|
| `app/src/main/java/com/example/myapplication/MainActivity.java` | XML 표시, ID 조회, TextWatcher 등록, 전송 Toast |
| `app/src/main/res/layout/activity_main.xml` | 맨 위 바이트 표시, 여러 줄 입력상자, 아래쪽 가로 버튼 |

`setContentView` → `findViewById` → `addTextChangedListener` → `onTextChanged`에서 바이트 표시 갱신 순서다. `send_button` 클릭은 현재 `message_input` 값을 Toast에 전달한다. `close_button`은 Java에서 조회하지 않는다. Drawable·추가 Manifest 권한은 필요 없다.

## 복사·실행

1. AppCompat 의존성과 AppCompat/Material 계열 테마가 있는 Java/XML 연습용 프로젝트를 준비한다. 이 폴더는 Gradle/Manifest를 포함하는 완전한 Android 프로젝트가 아니다.
2. 위 두 파일을 연습용 프로젝트의 동일한 `app/src/main/` 상대 경로에 복사한다. 다른 과제의 MainActivity/XML과 합치지 않는다.
3. 패키지와 프로젝트 `namespace`를 `com.example.myapplication`로 맞춘다. Manifest에는 `.MainActivity`를 시작 액티비티로 등록한다. `MAIN`/`LAUNCHER`, 외부 실행용 `android:exported="true"`가 있는 기존 등록을 사용할 수 있다. `android.R`을 import하지 않는다.
4. Android Studio에서 빌드·실행한다. 빈 입력은 `0/80 바이트`, `A가😀` 입력은 선택한 UTF-8 기준 `8/80 바이트`, 삭제 시 감소, 전송 시 같은 내용의 Toast가 예상된다. 이는 확인할 결과이며 실제 실행 결과가 아니다.
5. 한글 8자(`가나다라마바사아`)를 입력해 한 줄 표시를 확인한다. `36sp`/줄 간격 `8dp`는 시작값이므로 기기 가로폭·글꼴 배율에 맞춰 조정한다. 모든 화면에서 정확히 8자가 보이도록 보장하는 구현은 아니다.

실행 프로젝트가 edge-to-edge를 강제하면 상태 바·내비게이션 바와 겹칠 수 있으므로 루트 `main`의 padding/insets를 프로젝트 환경에 맞게 별도로 적용한다. 이 예제는 해당 환경별 처리를 포함하지 않는다.

## 시험 수정 지점과 흔한 오류

- 바이트 표시 위치: 위의 `byte_count` 태그 이동. 색: 해당 TextView의 `textColor`. 배경과 구별되는 색을 고른다.
- 입력 크기/줄 간격: `message_input`의 `textSize`, `lineSpacingExtra`. 여러 줄 입력은 `inputType="textMultiLine"`, 위에서부터 입력은 `gravity="top|start"`가 맡는다.
- ID 변경: XML `@+id/message_input`, `byte_count`, `send_button`과 Java `R.id`를 함께 변경한다. 파일명을 바꾸면 `R.layout.activity_main`도 변경한다.
- 표시 기준 80 변경: Java `"/80 바이트"`와 XML 초기 문자열 `0/80 바이트`를 함께 변경한다. 이 수치는 입력 제한이 아니다. `maxLength="80"`은 바이트 제한이 아니다.
- 바이트 수는 문자열 `length()`와 다르다. `afterTextChanged`에서 입력상자에 다시 `setText`하면 감시 콜백이 재진입할 수 있다. Toast는 `makeText`만 호출하지 말고 `show()`까지 호출한다.

## 추가·호환 내역

- `[추가 코드]`: PDF는 완성 소스 대신 화면/동작 조건을 제시하므로 Java 클래스·import·ID 연결·TextWatcher·클릭 리스너·전체 XML과 구체적인 크기/색상/초기 문자열을 작성했다. 입력/전송 이벤트는 요구된 동작을 구현하는 코드다.
- `[추가 코드]`: UTF-8 계산은 PDF에 없는 명시적인 구현 선택이다. `StandardCharsets.UTF_8`은 API 19 이상에서 제공되며 현재 원본 프로젝트 `minSdk 24`에서 사용할 수 있다.
- 한국어 주석은 속성 역할, 이벤트 흐름과 수정 지점을 위한 학습 설명이다. 별도의 `[호환성 수정]` 코드는 없다.
- 입력 제한, 닫기 이벤트, 실제 전송, 저장, 다른 과제 기능은 포함하지 않았다.

정적 검사 통과는 빌드·실행 검증을 의미하지 않는다. 남은 확인은 Toast, 한글 줄 폭/간격, 실제 키보드와 시스템 바를 포함한 기기 화면 동작이다.
