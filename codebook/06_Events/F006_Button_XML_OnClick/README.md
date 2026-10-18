# F006 Button XML onClick

핵심 기능은 XML의 `android:onClick="onButtonClicked"`로 Java의 `public void onButtonClicked(View v)`를 호출하는 선언형 클릭 처리다. 버튼 한 개를 눌러 `확인1 버튼이 눌렸어요.`라는 메시지가 나타나는 흐름을 학습한다. Toast는 클릭 결과를 관찰하기 위한 의존 기능이며, F008 토스트 기능의 독립 구현 예제가 아니다.

상태: **미검증**. XML 문법, 클릭 메서드명, 패키지와 레이아웃 참조의 정적 검사만 수행한다. Android 빌드와 에뮬레이터 실행은 수행하지 않았다.

## 강의 출처

- `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.35-40: p.35의 XML 버튼과 Java 연결, p.36의 import 안내, p.37의 `onButtonClicked(View v)`와 `Toast.makeText(this, "확인1 버튼이 눌렸어요.", Toast.LENGTH_LONG).show()`, p.38의 토스트 설명, p.39의 onClick 속성 지정, p.40의 실행 확인 흐름을 따른다.
- `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.76-78: p.76은 XML onClick에 메서드명을 지정하는 방식과 소스에서 리스너를 등록하는 방식을 구분한다. p.77-78은 위임 모델과 리스너 방식의 설명이며, 이 예제에는 리스너 방식 코드를 넣지 않는다.

페이지 번호는 PDF 페이지 기준이다. 기능 구분은 프로젝트 루트 `FEATURE_INDEX.md`의 F006/F008을 따른다.

## 파일과 실행 방법

- `app/src/main/java/com/example/myapplication/MainActivity.java`: 화면을 연결하고 XML에서 호출할 공개 메서드를 제공한다.
- `app/src/main/res/layout/activity_main.xml`: 버튼 한 개의 문구와 클릭 메서드명을 지정한다. 별도 Drawable과 권한은 필요하지 않다.

이 폴더는 전체 Java/XML 복사 예제다. Gradle 설정과 Manifest를 포함한 독립 빌드 프로젝트는 아니다.

1. 기존 프로젝트를 복사하여 연습용 프로젝트를 준비한다. 원본 프로젝트의 파일은 변경하지 않는다.
2. 연습용 프로젝트의 같은 상대 경로에 두 소스 파일을 복사한다. 패키지와 `namespace`는 `com.example.myapplication`로 맞춘다.
3. AppCompat 의존성과 AppCompat 계열 테마, Manifest의 `.MainActivity` 시작 액티비티 등록을 확인한다. 시작 액티비티에는 `MAIN`/`LAUNCHER`와 `android:exported="true"`가 필요하다.
4. 빌드 후 기기 또는 에뮬레이터에서 `확인 1` 버튼을 누른다. 예상 결과는 `확인1 버튼이 눌렸어요.` 토스트의 일시 표시다. 실제 실행 결과는 아직 확인하지 않았다.

## 시험 조건이 바뀌면

- 클릭 메서드 이름을 바꾸면 XML의 `android:onClick`과 Java의 메서드 이름을 대소문자까지 함께 바꾼다. XML에는 괄호와 매개변수를 쓰지 않는다.
- Java 클릭 메서드는 `public`, 반환형 `void`, `View` 매개변수 한 개를 유지한다. 매개변수명 `v`는 바꿔도 XML 값에는 영향이 없다. `v`는 클릭된 버튼을 전달받는다.
- 버튼 ID는 XML의 `@+id/button1`이다. 이 예제는 Java에서 ID를 조회하지 않으므로 XML ID만 바꿀 수 있다. ID 이름은 클릭 메서드명과 같을 필요가 없다.
- 버튼 문구는 XML의 `android:text`, 토스트 문구는 Java의 `Toast.makeText` 두 번째 인수를 바꾼다. 표시 기간 조건이 바뀌면 세 번째 인수를 `Toast.LENGTH_SHORT` 등으로 바꾼다. `show()`를 호출해야 화면에 표시된다.
- 버튼 크기는 `android:layout_width`·`android:layout_height`에서 바꾼다. `wrap_content`는 내용 크기, 루트의 `match_parent`는 부모의 사용 가능한 크기를 사용한다.
- XML 파일명을 바꾸면 Java의 `R.layout.activity_main`도 확장자 없이 새 이름으로 맞춘다. `onCreate` 이름과 서명은 유지한다.

## [추가 코드] 내역과 이유

- `package com.example.myapplication;`과 `Bundle`·`View`·`Toast`·`AppCompatActivity` import: p.37의 생략된 선언을 전체 파일로 복사할 수 있도록 보완하고 현재 프로젝트의 패키지 경로에 맞췄다.
- XML 선언·네임스페이스·루트 `LinearLayout`과 필수 크기·방향 속성: p.39의 속성 지정 설명을 실행용 전체 XML로 제공하기 위한 최소 화면 틀이다. 강의 화면의 전체 배치를 복제한 것은 아니다.
- 버튼 ID `button1`과 한국어 학습 주석: 수정 지점을 식별하고 동작 및 시험 조건 변경을 설명한다. ID는 이 예제의 메서드 연결에 사용되지 않는다.

별도 SDK 대응 변경은 없으므로 `[호환성 수정]` 항목은 없다. 정적 검사 통과는 빌드·실행 검증을 뜻하지 않는다.
