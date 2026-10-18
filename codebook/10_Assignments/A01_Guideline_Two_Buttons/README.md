# 과제 1. 화면 아래쪽에 두 개의 버튼 추가하기

ConstraintLayout에 하단 수평 Guideline을 두고 두 Button의 아래쪽을 선에 연결한다. 두 버튼은 수평 체인으로 같은 폭을 나눠 가지며, 클릭 이벤트는 없다. 다른 과제와 파일을 공유하지 않는다.

출처: `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.105-106. p.105의 배치 그림·네 단계와 p.106의 부모·다른 뷰·Guideline 연결 조언을 텍스트 추출 및 페이지 렌더링으로 확인했다. 페이지 번호는 PDF 기준이다. 이 두 쪽은 완성 Java/XML 소스를 제공하지 않으므로 아래 파일은 요구사항을 코드로 옮긴 독립 구현이다.

## 파일과 복사·실행

- `app/src/main/java/com/example/myapplication/MainActivity.java`: `onCreate` → `super.onCreate` → `setContentView`로 XML을 표시하는 전체 Java 파일.
- `app/src/main/res/layout/activity_main.xml`: 하단 Guideline 1개와 Button 2개의 전체 XML.

이 폴더는 복사용 예제이며 Gradle·Manifest를 포함한 독립 빌드 프로젝트는 아니다.

1. Java와 XML Views를 사용하는 연습용 Android 프로젝트를 준비하고 위 두 파일을 같은 상대 경로에 복사한다. 기존 실습을 보존하려면 프로젝트 사본에 복사한다.
2. `namespace`와 패키지를 `com.example.myapplication`로 맞추고, AppCompat 및 AndroidX ConstraintLayout 의존성과 AppCompat 계열 테마가 있는지 확인한다. 과제에 필요한 기존 의존성만 사용하며 추가 기능 라이브러리는 필요 없다.
3. Manifest에 `.MainActivity`를 시작 액티비티로 등록한다. `MAIN`/`LAUNCHER` intent-filter와 `android:exported="true"`가 필요하며 별도 권한은 없다.
4. Android Studio에서 빌드·실행한다. 예상 결과는 화면 아래쪽에 같은 높이로 놓인 두 버튼이다. Guideline은 보이지 않는다. 부모는 시스템 바를 제외해 호스트가 제공하는 콘텐츠 영역을 기준으로 한다.

## 수정 방법과 흔한 오류

- 기준선 위치는 `layout_constraintGuide_end="48dp"`, 버튼과 선 사이는 두 버튼의 `layout_marginBottom="16dp"`에서 바꾼다. 두 버튼 모두 `bottom_guideline`에 연결되어야 한다.
- 가로 여백은 각 버튼의 start/end margin에서 바꾼다. 현재 버튼 사이 합계는 16dp이고 바깥 여백은 각각 16dp다. `0dp` 폭은 제약 사이 공간을 차지하는 match constraint이며, 연결 없이 `0dp`만 쓰면 폭을 결정하지 못한다.
- `left_button`·`right_button`·`bottom_guideline` 이름을 바꾸면 XML 내부의 모든 `@id/...` 참조도 바꾼다. Java는 ID를 직접 조회하지 않는다. 문구는 `android:text`, XML 파일명 변경은 Java의 `R.layout.activity_main`도 수정한다.
- ConstraintLayout은 AndroidX 라이브러리 위젯이므로 `androidx.constraintlayout.widget.ConstraintLayout`·`Guideline`을 사용한다. `xmlns:app="http://schemas.android.com/apk/res-auto"`는 라이브러리 제약 속성을 읽기 위한 선언이다. `android:layout_constraint...`로 쓰거나 의존성을 누락하면 리소스 오류가 난다.

## 추가·호환 코드와 검증

`[추가 코드]`: 전체 복사를 위한 package·import·AppCompatActivity·onCreate·화면 연결, XML 선언·필수 크기·네임스페이스, 요구사항을 구현하는 제약 속성·ID·문구·구체적 dp 간격과 한국어 학습 주석을 보완했다. AndroidX는 이 코드북의 기존 AppCompat/AndroidX 프로젝트에 맞춘 선택이며, 지정 페이지에 나온 정확한 패키지명을 인용한 것은 아니다. Guideline·두 버튼·연결 관계 자체는 과제 요구다.

`[호환성 수정]`: 없음. 실제 SDK 호환 문제를 수정한 것으로 주장하는 부분은 없다.

상태: **미검증**. `xmllint` 문법 검사와 패키지·레이아웃·ID 참조·제약 관계·이벤트 없음의 정적 self-check만 수행했다. Android 빌드, 화면 렌더링, 에뮬레이터·실기기 실행은 하지 않았다. 기기·테마별 실제 간격은 실행 후 확인해야 한다.
