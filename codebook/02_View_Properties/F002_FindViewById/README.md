# F002 XML 뷰를 ID로 참조

핵심 기능은 XML의 `android:id="@+id/textView"`로 지정한 TextView를 Java의 `findViewById(R.id.textView)`로 찾아 변수에 연결하는 것이다. 화면을 만든 뒤 ID로 기존 View 객체를 참조하며, 조회가 새 View를 만드는 것은 아니다. 이벤트 처리나 Java 속성 변경은 포함하지 않는다.

상태: **미검증**. XML 문법과 Java/XML ID·패키지·레이아웃 참조의 정적 검사만 수행했다. Android 빌드와 기기·에뮬레이터 실행은 수행하지 않았다.

## 강의 출처

- `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.88-89: p.88은 최상위 레이아웃과 ConstraintLayout의 패키지, p.89는 `xmlns:android` 등 네임스페이스를 설명한다. 이 두 페이지를 ID 조회 코드의 출처로 주장하지 않는다.
- `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.109-111: p.109의 Java 화면에서 `setContentView(R.layout.activity_main)` 뒤 `imageView = findViewById(R.id.imageView)`를 실행하는 순서를 확인했다. p.110은 두 ImageView를 찾아 변수에 할당하는 설명이며, 같은 페이지의 이미지 전환 코드는 제외했다. p.111은 XML의 `@+id/아이디`, Java의 `R.id.아이디` 대응과 `findViewById`의 의미를 설명한다.
- 같은 Chapter02 PDF p.120: XML에서 지정한 `scrollView`·`imageView` ID를 `R.id.scrollView`·`R.id.imageView`로 전달해 객체를 참조하는 설명을 확인했다. 스크롤·이미지 기능은 이 예제에 포함하지 않는다.

페이지 번호는 PDF 페이지 기준이다. 지정된 여섯 페이지를 `pdftotext`로 추출하고 `pdftoppm`으로 렌더링하여 코드 이미지와 대조했다. 아래 전체 파일은 강의의 조회 원리를 TextView 한 개로 축소한 복사 예제이며 PPT 원문 전체 코드가 아니다.

## 파일과 실행 방법

- `app/src/main/java/com/example/myapplication/MainActivity.java`: 화면 설정 후 ID로 TextView를 찾아 필드에 저장한다.
- `app/src/main/res/layout/activity_main.xml`: 조회할 TextView와 ID를 정의한다. 별도 Drawable이나 권한은 필요하지 않다.

이 폴더는 전체 Java/XML 복사 예제이며 Gradle·Manifest를 포함한 독립 빌드 프로젝트는 아니다.

1. 기존 프로젝트를 복사해 연습용 프로젝트를 준비하고 위 두 파일을 같은 상대 경로에 복사한다.
2. Java 패키지와 프로젝트 `namespace`를 `com.example.myapplication`로 맞춘다. AppCompat 의존성, AppCompat 계열 테마, Manifest의 `.MainActivity` 시작 액티비티 등록을 확인한다. 시작 액티비티에는 `MAIN`/`LAUNCHER`와 `android:exported="true"`가 필요하다.
3. 빌드 후 실행하면 `ID로 참조할 TextView` 문구가 표시될 것으로 예상한다. 조회 자체는 화면을 바꾸지 않으므로 문구 표시만으로 ID 연결 성공을 판정하지 않는다.
4. 연결을 확인하려면 Android Studio에서 `findViewById` 대입 줄에 중단점을 걸고 한 줄 실행한 뒤 `textView` 필드가 null이 아닌 TextView인지 확인한다. 이 실행·디버거 확인은 아직 수행하지 않았다.

## 시험 조건이 바뀌면

- ID가 바뀌면 XML의 `@+id/textView`와 Java의 `R.id.textView`를 대소문자까지 함께 바꾼다. XML에는 `@+id/`, Java에는 `R.id.` 형식을 쓴다.
- Java 변수명 `textView`는 ID와 같아야 하는 것은 아니다. 변수명을 바꾸면 선언과 대입문의 왼쪽을 함께 바꾸고, ID를 유지한다면 `R.id.textView`는 유지한다.
- View 종류가 바뀌면 XML 태그와 Java 필드 타입·import를 함께 맞춘다. 다른 종류의 View를 TextView 변수로 받으면 타입 오류가 생길 수 있다.
- 레이아웃 파일명이 바뀌면 `R.layout.activity_main`을 새 파일명으로 바꾼다. `setContentView`는 해당 화면의 View를 조회하기 전에 호출한다.
- 현재 화면에 없는 ID는 조회 결과가 null일 수 있다. 프로젝트 어딘가에 ID가 정의되어 있다는 사실만으로 현재 화면에서 찾을 수 있는 것은 아니다. `android.R`를 import하지 않는다.

## [추가 코드] 내역과 이유

- 패키지 `com.example.myapplication`, `Bundle`·`TextView`·`AppCompatActivity` import와 전체 클래스 파일: 강의의 생략된 파일 부분을 복사 가능한 형태로 보완했다.
- TextView 한 개, Java의 `TextView textView` 필드와 조회문 `textView = findViewById(R.id.textView)`: p.109의 ImageView 조회 패턴을 이미지 리소스 없이 ID 연결만 학습하도록 바꿨다. 이 타입·변수·ID 조합은 PPT 원문이 아니다.
- XML 선언, 최소 LinearLayout 화면 틀, TextView의 필수 크기와 표시 문구: 화면에 참조 대상을 제공한다. `android:id="@+id/textView"`는 p.111의 ID 지정 형식을 이 대상에 적용했다.
- 한국어 주석과 디버거 확인 방법: 역할, 호출 순서, 시험 변경 위치와 흔한 오류를 설명한다.

SDK 호환을 위한 API 변경은 없으므로 `[호환성 수정]` 항목은 없다. 빌드·실행 검증은 남아 있다.
