# F001 MainActivity와 XML 화면 연결

핵심 기능은 `MainActivity.onCreate(Bundle)`에서 `setContentView(R.layout.activity_main)`를 호출하여 XML 화면을 표시하는 것이다. `TextView` 한 개는 연결 결과를 확인하기 위한 최소 UI다.

상태: **미검증**. 패키지·레이아웃 참조·XML 문법의 정적 검사만 수행했다. Android 빌드와 에뮬레이터 실행은 수행하지 않았다.

## 강의 출처

- `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.20-24: `MainActivity`, `onCreate`, `super.onCreate`, `setContentView` 및 `activity_main.xml` 연결 설명. p.20의 Java 화면에 표시된 핵심 호출 순서를 따른다.
- 같은 PDF p.54: `setContentView`, `R.layout.activity_main`, 레이아웃 XML 위치를 정리한 표.
- 같은 PDF p.28-31: `TextView`의 `text` 속성으로 표시 문자열을 변경하는 설명. 여기서는 F003을 독립 기능으로 확장하지 않고 연결 확인용 UI에만 사용한다.

페이지 번호는 PDF 페이지 기준이다. 버튼·클릭 이벤트 등 다른 기능은 포함하지 않는다.

## 파일 관계

| 파일 | 역할 |
|---|---|
| `app/src/main/java/com/example/myapplication/MainActivity.java` | `onCreate`에서 부모 클래스의 초기화를 호출한 다음 레이아웃 리소스를 화면으로 설정한다. |
| `app/src/main/res/layout/activity_main.xml` | 실제 표시할 화면이다. `R.layout.activity_main`은 이 파일에서 확장자 `.xml`을 제외한 리소스 이름이다. |

Java 패키지는 실제 프로젝트의 `namespace`와 같은 `com.example.myapplication`이다. `R`은 Android 빌드 과정에서 생성되므로 직접 작성하거나 `android.R`을 import하지 않는다. 별도 Drawable은 필요하지 않다.

## 실행 방법

이 폴더는 Java/XML 전체 파일을 제공하는 복사 예제이며, Gradle 설정과 Manifest를 포함하는 독립 빌드 프로젝트는 아니다. 원본 프로젝트의 `app/src/main/`에는 이 작업에서 변경을 적용하지 않았다.

1. 기존 프로젝트를 복사하여 연습용 프로젝트를 준비한다.
2. 연습용 프로젝트의 같은 상대 경로에 위 Java/XML 두 파일을 복사한다. Java 파일의 패키지와 프로젝트의 `namespace`가 `com.example.myapplication`인지 확인한다.
3. AppCompat 의존성과 AppCompat 계열 테마가 있는지 확인한다. 현재 원본 프로젝트에는 `libs.appcompat` 의존성이 있다.
4. Manifest에서 `.MainActivity`가 시작 액티비티로 등록되어 있는지 확인한다. 현재 원본에는 `MAIN`/`LAUNCHER` 및 `android:exported="true"` 설정이 있다. 이 예제 때문에 Manifest를 추가로 변경할 필요는 없다.
5. Android Studio에서 연습용 프로젝트를 빌드하고 기기 또는 에뮬레이터에서 실행한다. 예상 결과는 `안녕, 안드로이드!` 표시다. 이 실행 결과는 아직 확인하지 않았다.

## 시험 조건이 바뀌면

- 화면 파일명을 `exam_screen.xml`로 바꾸면 Java의 `R.layout.activity_main`도 `R.layout.exam_screen`으로 바꾼다. 참조에는 `.xml`을 붙이지 않는다.
- 문구를 바꾸려면 XML의 `android:text`를 수정한다.
- 화면 크기를 바꾸려면 XML의 `android:layout_width`, `android:layout_height`를 수정한다. `match_parent`는 부모의 사용 가능한 크기, `wrap_content`는 내용에 필요한 크기다.
- ID를 바꾸려면 XML의 `@+id/screen_message`를 수정한다. 이 예제에서는 Java에서 ID를 참조하지 않는다.
- 저장된 상태 매개변수 `savedInstanceState`의 이름을 바꾸면 `super.onCreate(savedInstanceState)`의 인수도 같이 바꾼다. 생명주기 콜백인 `onCreate` 자체의 이름이나 서명은 임의로 바꾸지 않는다.
- 클래스를 바꾸는 문제라면 Java 파일명·클래스명·Manifest의 액티비티 이름을 함께 맞춘다. 패키지가 바뀌면 Java 선언·폴더 경로·프로젝트 `namespace` 관계도 확인한다.

## [추가 코드] 내역과 이유

- `package com.example.myapplication;`: 강의 화면의 프로젝트 패키지를 현재 프로젝트에 맞춘 선언이다. Java 파일을 실제 경로에 복사할 수 있도록 명시했다.
- `Bundle`, `AppCompatActivity` import: 강의 p.20 화면에서 import가 접혀 있어 전체 선언이 보이지 않는다. 생략 없는 Java 파일을 제공하기 위해 사용하는 클래스의 import를 명시했다.
- XML 전체 문서 및 `TextView` 루트 구성: 화면 연결만 확인하도록 컨테이너와 제약 배치를 생략한 최소 예제다. 전체 파일을 복사할 수 있도록 XML 선언·Android 네임스페이스·필수 크기 속성을 제공했다.
- `android:id="@+id/screen_message"`: 시험에서 ID 수정 위치를 설명하기 위한 식별자다. Java 조회나 이벤트 처리는 추가하지 않았다.
- 한국어 학습 주석: 주요 동작과 시험 수정 지점을 설명하기 위해 추가했다.

별도 SDK 대응 변경은 없으므로 `[호환성 수정]` 항목은 없다. 정적 검사 통과는 Android 빌드·실행 검증을 뜻하지 않는다.
