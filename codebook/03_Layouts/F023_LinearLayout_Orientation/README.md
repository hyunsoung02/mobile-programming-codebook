# F023 LinearLayout 수직·수평 방향 배치

핵심 기능은 `android:orientation`으로 자식 뷰를 쌓는 방향을 지정하는 것이다. 최상위 `LinearLayout`은 `vertical`, 내부 `LinearLayout`은 `horizontal`로 두어 한 화면에서 두 속성값을 비교한다. 버튼은 배치 확인용이며 동작을 등록하지 않는다.

상태: **미검증**. 방향·패키지·레이아웃 참조·XML 문법의 정적 검사만 수행했다. Android 빌드와 에뮬레이터 실행은 수행하지 않았다.

## 강의 출처

- `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.10-11: 대표 레이아웃 소개의 끝부분과 뷰의 필수 크기 속성, LinearLayout의 방향 지정 설명. p.10은 ScrollView 설명이며 방향 속성의 직접 근거는 p.11이다.
- 같은 PDF p.16-26: p.16은 `horizontal`·`vertical`, p.18은 최상위 LinearLayout의 수직 설정, p.20-22는 버튼을 순서대로 배치하는 실습이다. p.23-26은 수평 변경과 버튼 폭을 `match_parent`에서 `wrap_content`로 변경하는 실습이다.
- 같은 PDF p.31: Java에서 `setOrientation(LinearLayout.VERTICAL)`과 크기 매개변수를 사용하는 대안이다. 이 예제는 방향 설정을 XML에서만 수행한다.
- 화면 연결 코드: `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.20-24, 54에 근거한 F001과 같은 `onCreate`·`super.onCreate`·`setContentView` 구성을 사용한다.

페이지 번호는 PDF 페이지 기준이다. F014의 크기 속성은 배치에 필요한 기본 설정으로만 사용한다.

## 파일 관계와 실행 방법

- `app/src/main/java/com/example/myapplication/MainActivity.java`: `R.layout.activity_main`을 화면으로 연결한다.
- `app/src/main/res/layout/activity_main.xml`: 수직 루트 안에 버튼 2개와 수평 행을 순서대로 놓고, 수평 행 안에 버튼 2개를 나란히 놓는다. 별도 Drawable은 필요하지 않다.

이 폴더는 전체 Java/XML 복사 예제이며 Gradle 설정과 Manifest를 갖춘 독립 빌드 프로젝트는 아니다.

1. 기존 프로젝트를 복사하여 연습용 프로젝트를 준비한다.
2. 연습용 프로젝트의 같은 상대 경로에 Java/XML 두 파일을 복사한다. 패키지와 프로젝트 `namespace`는 `com.example.myapplication`로 맞춘다.
3. AppCompat 의존성과 AppCompat 계열 테마, Manifest의 `.MainActivity` 시작 액티비티 등록을 확인한다. 시작 액티비티에는 `MAIN`/`LAUNCHER`와 `android:exported="true"`가 필요하다. 별도 권한은 필요하지 않다.
4. Android Studio에서 빌드하고 기기나 에뮬레이터에서 실행한다. 예상 화면은 위에서부터 `수직 1`, `수직 2`, 그리고 `수평 1`·`수평 2`가 나란히 있는 행이다. 실제 결과는 아직 확인하지 않았다.

## 시험 조건이 바뀌면

- 루트의 `android:orientation`을 바꾸면 루트의 직접 자식인 두 버튼과 내부 행을 쌓는 방향이 바뀐다. 내부 행의 방향에는 영향을 주지 않는다.
- 내부 행의 `android:orientation`을 `vertical`로 바꾸면 그 행 안의 두 버튼만 위아래로 배치된다.
- 수평 행의 버튼 폭은 `wrap_content`다. 첫 버튼 폭을 `match_parent`로 바꾸면 뒤 버튼을 표시할 가로 공간이 부족할 수 있다. p.24-25의 크기·방향 관계를 함께 확인한다.
- 크기는 해당 뷰의 `android:layout_width`·`android:layout_height`, 표시 문구는 `android:text`에서 바꾼다. `match_parent`는 부모의 사용 가능한 크기, `wrap_content`는 내용에 필요한 크기를 사용한다.
- 레이아웃 ID는 `vertical_layout`·`horizontal_row`, 버튼 ID는 `vertical_button1`·`vertical_button2`·`horizontal_button1`·`horizontal_button2`다. 이 예제의 Java는 ID를 조회하지 않으므로 XML ID만 바꿀 수 있다.
- XML 파일명을 바꾸면 Java의 `R.layout.activity_main`도 새 파일명으로 맞춘다. `.xml` 확장자는 붙이지 않는다. `onCreate` 이름·서명은 유지한다.

## [추가 코드] 내역과 이유

- `package com.example.myapplication;`과 `Bundle`·`AppCompatActivity` import: 강의에서 생략되거나 현재 프로젝트와 다른 선언을 보완하여 전체 Java 파일로 복사할 수 있게 했다.
- XML 선언·네임스페이스·필수 크기 속성: 전체 XML 파일을 제공하고 Android 리소스로 해석되게 한다.
- 수직 루트 안의 수평 행과 버튼 4개 구성: 강의의 방향 변경 실습을 한 화면에서 비교하기 위한 최소 비교 구성이다. 강의 화면을 그대로 복제한 배치는 아니다.
- ID·한국어 버튼 문구·한국어 학습 주석: 두 방향을 구분하고 시험에서 수정할 지점을 찾도록 추가했다.

별도 SDK 대응 변경은 없으므로 `[호환성 수정]` 항목은 없다. 정적 검사 통과는 Android 빌드·실행 검증을 뜻하지 않는다.
