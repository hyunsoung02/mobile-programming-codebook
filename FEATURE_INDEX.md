# 중간고사 구현 기능 인덱스

## 분석 기준

- 기준 자료: `course_materials/`의 PDF 7개 전체(총 496쪽)
- 범위: Part 1 Chapter 01부터 Part 2 Chapter 03까지
- 집계 단위: 같은 목적과 같은 구현 흐름은 하나의 **기능군**으로 묶고, 목적이 같아도 구현 방식이 다른 경우(예: XML `onClick`과 `setOnClickListener`, XML 레이아웃과 Java 동적 생성)는 분리했다.
- 최종 집계: **85개 기능군**. 이전의 57개 추정치는 사용하지 않았다.
- 이 문서는 구현 범위를 확정하기 위한 분석 문서다. Java/XML 구현 코드는 생성하지 않았다.

## 출처 코드

| 코드 | PDF 파일명 | PDF 쪽수 |
|---|---|---:|
| P1-C1 | `(Part1)Chapter01_안드로이드란.pdf` | 7 |
| P1-C2 | `(Part1)Chapter02_개발도구설치하기 (1).pdf` | 13 |
| P1-C3 | `(Part1)Chapter03_첫번째앱만들기.pdf` | 55 |
| P1-C4 | `(Part1)Chapter04_실제단말연결하기.pdf` | 9 |
| P2-C1 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` | 109 |
| P2-C2 | `(Part2)Chapter02_레이아웃익히기.pdf` | 129 |
| P2-C3 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` | 174 |

표의 출처 표기는 위 파일명 코드와 **PDF 페이지 번호**를 사용한다.

## A. 앱·리소스·기본 화면 연결

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F001 | 액티비티 시작과 화면 설정 | `onCreate`, `super.onCreate`, `setContentView`, `R.layout.activity_main` | `activity_main.xml` | [P1-C3] p.20-24, 54 |
| F002 | XML 뷰를 ID로 참조 | `findViewById`, `R.id.<id>` | `android:id="@+id/..."` | [P2-C1] p.88-89; [P2-C2] p.109-111, 120 |
| F003 | 문자열 직접 표시 | — | `TextView`, `android:text` | [P1-C3] p.28-31; [P2-C3] p.5 |
| F004 | 문자열 리소스 분리·참조 | — | `res/values/strings.xml`, `<string>`, `@string/...` | [P2-C3] p.5-10 |
| F005 | 버튼 배치와 표시 | — | `Button`, `android:text`, 제약선/앵커 | [P1-C3] p.32-34, 41-48 |
| F006 | XML 선언형 클릭 처리 | `public void <method>(View v)` | `android:onClick` | [P1-C3] p.35-40, 50-52; [P2-C3] p.76 |
| F007 | 리스너 기반 클릭 처리 | `setOnClickListener`, `View.OnClickListener`, `onClick` | 버튼 ID 참조 | [P2-C3] p.21, 76-78, 121-122, 151 |
| F008 | 간단한 토스트 메시지 | `Toast.makeText`, `show`, `Toast.LENGTH_LONG/SHORT` | — | [P1-C3] p.37-40; [P2-C3] p.105-106, 138-139 |
| F009 | 웹 주소 열기 | `Intent`, `Intent.ACTION_VIEW`, `Uri.parse`, `startActivity` | 클릭 메서드 연결 | [P1-C3] p.49-52 |
| F010 | 전화 걸기 화면 열기 | `Intent`, `Intent.ACTION_VIEW`, `Uri.parse("tel:...")`, `startActivity` | 클릭 메서드 연결 | [P1-C3] p.49-52 |
| F011 | 소스·레이아웃·드로어블 위치 구분 | — | `app/src/main/java`, `app/src/main/res/layout`, `app/src/main/res/drawable` | [P2-C1] p.104 |
| F012 | 시작 액티비티 등록 | — | Manifest `<activity android:name>`, `MAIN`, `LAUNCHER` | [P2-C2] p.32, 38-39 |

## B. 공통 View 속성과 ConstraintLayout

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F013 | View/ViewGroup 구조 | `View`, `ViewGroup` | 위젯과 레이아웃의 포함 관계 | [P2-C1] p.32-38 |
| F014 | 폭·높이 크기 모드 | — | `layout_width`, `layout_height`, `match_parent`, `wrap_content`, 고정 `dp`, ConstraintLayout의 `0dp`/match constraint | [P2-C1] p.39-50, 73-76; [P2-C2] p.11-13 |
| F015 | XML 네임스페이스와 ID | — | `xmlns:android`, `xmlns:app`, `xmlns:tools`, `@+id` | [P2-C1] p.87-89 |
| F016 | ConstraintLayout 기본 앵커 연결 | — | `layout_constraintTop/Bottom/Start/End/Left/Right_*` | [P2-C1] p.51-64, 90-92 |
| F017 | 네 방향 제약으로 중앙 배치 | — | 상·하·좌·우 제약을 부모에 연결 | [P2-C1] p.61-67 |
| F018 | 제약 바이어스 조절 | — | `layout_constraintHorizontal_bias`, `layout_constraintVertical_bias` | [P2-C1] p.68-72 |
| F019 | 제약 대상에 따른 가변 크기 | — | `0dp`와 양쪽 제약, `wrap_content`, 고정 크기의 차이 | [P2-C1] p.73-76 |
| F020 | Guideline 배치 | — | `Guideline`, `orientation`, `layout_constraintGuide_begin`, `layout_constraintGuide_end`, `layout_constraintGuide_percent` | [P2-C1] p.78-86, 93-95 |
| F021 | 뷰 외부 여백 | — | `layout_margin`, `layout_marginTop/Bottom/Left/Right` | [P2-C1] p.99-103; [P2-C2] p.12-13, 60-67 |
| F022 | 크기 단위 선택 | — | `px`, `dp/dip`, `sp/sip`, `in`, `mm`, `em` | [P2-C1] p.96-98 |

## C. LinearLayout과 Java 동적 화면

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F023 | LinearLayout 방향 배치 | `setOrientation` | `LinearLayout`, `orientation="horizontal|vertical"` | [P2-C2] p.10-11, 16-26, 31 |
| F024 | 배경색과 ARGB | — | `background`, `#AARRGGBB` | [P2-C2] p.14-15, 60-67 |
| F025 | 내부 여백 | — | `padding`, `paddingTop/Bottom/Left/Right` | [P2-C2] p.12-13, 60-67 |
| F026 | 자식 뷰 자체 정렬 | — | `layout_gravity` | [P2-C2] p.40-45 |
| F027 | 자식 내용 정렬 | — | `gravity`, `left`, `right`, `top`, `bottom`, `center_horizontal`, `center_vertical`, `|` 조합 | [P2-C2] p.40-51 |
| F028 | 텍스트 표시 속성 조합 | — | `text`, `textColor`, `textSize`, `textStyle` | [P2-C2] p.46-51 |
| F029 | 텍스트 기준선 정렬 | — | `baselineAligned="true|false"` | [P2-C2] p.52-59 |
| F030 | 가중치로 공간 분할 | — | `layout_weight`, 분할 방향 크기 `0dp` | [P2-C2] p.68-78 |
| F031 | Java로 LinearLayout 생성 | `new LinearLayout(this)`, `setOrientation`, `setContentView` | XML 대신 객체로 루트 구성 | [P2-C2] p.27-39 |
| F032 | Java로 자식 View 생성·추가 | `new Button(this)`, `setText`, `setLayoutParams`, `addView` | `LinearLayout.LayoutParams`, `MATCH_PARENT`, `WRAP_CONTENT` | [P2-C2] p.29-39 |
| F033 | Context 전달 | `this`, `getApplicationContext` | View 생성자에 Context 전달 | [P2-C2] p.28-30 |

## D. RelativeLayout·TableLayout·FrameLayout·ScrollView

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F034 | RelativeLayout의 부모 기준 배치 | — | `layout_alignParentTop/Bottom/Left/Right`, `layout_centerHorizontal/Vertical/InParent` | [P2-C2] p.79-89 |
| F035 | RelativeLayout의 다른 뷰 기준 배치 | — | `layout_above`, `layout_below`, `layout_toLeftOf`, `layout_toRightOf`, `layout_alignTop/Bottom/Left/Right/Baseline` | [P2-C2] p.80-90 |
| F036 | 상대 배치로 상·중·하 영역 구성 | — | `layout_above`, `layout_below`, 부모 정렬 속성 | [P2-C2] p.82-88 |
| F037 | TableLayout 행·열 구성 | — | `TableLayout`, `TableRow`; 자식 순서가 열 인덱스 | [P2-C2] p.92-96 |
| F038 | 테이블 열 자동 확장·축소 | — | `stretchColumns`, `shrinkColumns`; 열 인덱스 목록 | [P2-C2] p.97-99 |
| F039 | 테이블 열 위치·병합 | — | `layout_column`, `layout_span` | [P2-C2] p.100-102 |
| F040 | FrameLayout 중첩 | `addView` | `FrameLayout`; 추가 순서대로 쌓임 | [P2-C2] p.103-107 |
| F041 | 가시성으로 뷰 전환 | `setVisibility`, `View.VISIBLE`, `View.INVISIBLE`, 상태 인덱스 | `visibility="visible|invisible|gone"` | [P2-C2] p.103-114 |
| F042 | 수직 스크롤 | — | `ScrollView`; 한 개의 직접 자식 컨테이너 | [P2-C2] p.115-124 |
| F043 | 수평·수직 동시 스크롤 | `setHorizontalScrollBarEnabled` | `HorizontalScrollView` 안에 `ScrollView`, 그 안에 `ImageView` | [P2-C2] p.116-124 |
| F044 | 코드에서 드로어블 이미지 로드 | `getResources`, `Resources.getDrawable`, `BitmapDrawable`, `setImageDrawable` | `res/drawable` 이미지 | [P2-C2] p.118-121 |
| F045 | 원본 이미지 크기로 View 조정 | `getIntrinsicWidth`, `getIntrinsicHeight`, `getLayoutParams().width/height` | `ImageView` | [P2-C2] p.118-121 |

## E. 기본 위젯과 텍스트 입력

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F046 | 텍스트 색상 | — | `textColor`, `#AARRGGBB` | [P2-C3] p.11-12 |
| F047 | 텍스트 크기 | — | `textSize`; 글자는 `sp` 권장 | [P2-C3] p.13-14 |
| F048 | 텍스트 스타일 | — | `textStyle="normal|bold|italic"`, `|` 조합 | [P2-C3] p.15-16 |
| F049 | 글꼴 계열 | — | `typeface="normal|sans|serif|monospace"` | [P2-C3] p.17-18 |
| F050 | 최대 줄 수 | — | `maxLines` | [P2-C3] p.19-20 |
| F051 | CompoundButton 상태 | `isChecked`, `setChecked`, `toggle`, `onCheckedChanged` | `CheckBox`, `RadioButton` | [P2-C3] p.22-26 |
| F052 | 라디오 버튼 단일 선택 그룹 | — | `RadioGroup` 안에 `RadioButton` | [P2-C3] p.24-27 |
| F053 | 이미지 전용 버튼 | 버튼과 동일한 클릭 처리 | `ImageButton` | [P2-C3] p.27, 32-39 |
| F054 | EditText 기본 입력 | `getText`, `Editable.toString` | `EditText`, `inputType`, `hint`, 빈 `text` | [P2-C3] p.28-31, 46-47 |
| F055 | 이미지 리소스 표시 | — | `ImageView`, `ImageButton`, `android:src` 또는 `app:srcCompat`, `@drawable/...` | [P2-C3] p.32-39 |
| F056 | 이미지 크기·색·배율 | — | `maxWidth`, `maxHeight`, `tint`, `scaleType`(`fitXY`, `centerCrop`, `centerInside`) | [P2-C3] p.33-35 |
| F057 | 커서·선택 제어 | `getSelectionStart/End`, `setSelection`, `extendSelection`, `selectAll` | `selectAllOnFocus`, `cursorVisible` | [P2-C3] p.41-42 |
| F058 | 자동 링크 | — | `autoLink` | [P2-C3] p.43 |
| F059 | 줄 간격 조절 | — | `lineSpacingMultiplier`, `lineSpacingExtra` | [P2-C3] p.43-44 |
| F060 | 대소문자 자동 표시 | — | `capitalize="characters|words|sentences"` | [P2-C3] p.45 |
| F061 | 말줄임 위치 | — | `ellipsize="none|start|middle|end"`, `maxLines` | [P2-C3] p.45 |
| F062 | 힌트 색과 편집 허용 | — | `hint`, `textColorHint`, `editable` | [P2-C3] p.46 |
| F063 | 입력 변화 감시 | `addTextChangedListener`, `TextWatcher`, `beforeTextChanged`, `onTextChanged`, `afterTextChanged` | `EditText` | [P2-C3] p.47-49 |
| F064 | 입력 길이 제한 | `setFilters`, `InputFilter`, `InputFilter.LengthFilter` | `EditText` | [P2-C3] p.49 |

## F. Drawable

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F065 | 정적 배경 이미지·색 | — | `background`, PNG/JPG, `@drawable/...` | [P2-C3] p.50-54 |
| F066 | 상태 셀렉터 드로어블 | — | `<selector>`, `<item>`, `state_pressed`, `state_focused`, `drawable` | [P2-C3] p.55-60 |
| F067 | 기본 Shape 드로어블 | — | `<shape shape="rectangle|oval">`, `<size>`, `<stroke>`, `<solid>`, `<padding>` | [P2-C3] p.61-66 |
| F068 | 그라데이션 배경 | — | `<gradient>`, `startColor`, `centerColor`, `endColor`, `angle`, `centerY`, `<corners radius>` | [P2-C3] p.67-69 |
| F069 | 여러 Shape 중첩과 테두리 버튼 | — | `<layer-list>`, `<item top/bottom/left/right>`, 투명 `<solid>`, 서로 다른 `<stroke>` | [P2-C3] p.70-74 |
| F070 | 버튼 배경 틴트 간섭 제거 | — | `backgroundTint="#00000000"`, `backgroundTintMode="Add"` | [P2-C2] p.84-85; [P2-C3] p.64, 73 |

## G. 터치·제스처·키·방향 전환 이벤트

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F071 | 뷰 이벤트 리스너 모델 | `onTouchEvent`, `onKeyDown`, `onKeyUp`; `OnTouchListener`, `OnKeyListener`, `OnClickListener`, `OnFocusChangeListener` | 터치·키·클릭·포커스·방향 변경 이벤트 | [P2-C3] p.75-83 |
| F072 | 터치 액션과 좌표 처리 | `setOnTouchListener`, `onTouch`, `MotionEvent.getAction/getX/getY`, `ACTION_DOWN/MOVE/UP`, `TextView.append` | 터치 대상 `View`와 결과 `TextView` | [P2-C3] p.85-94 |
| F073 | 제스처 판별 | `GestureDetector`, `OnGestureListener`, `onTouchEvent`, `onDown`, `onShowPress`, `onSingleTapUp`, `onScroll`, `onLongPress`, `onFling` | 제스처 대상 `View` | [P2-C3] p.83-84, 95-100 |
| F074 | 키 코드 처리 | `onKeyDown`, `onKey`, `KeyEvent`, `KEYCODE_BACK`, `KEYCODE_CAMERA`, DPAD·통화·볼륨·숫자·문자 키 코드 | — | [P2-C3] p.101-106 |
| F075 | 방향별 레이아웃 리소스 | 생명주기에 따라 액티비티 재생성 | `res/layout/activity_main.xml`, `res/layout-land/activity_main.xml` | [P2-C3] p.107-115 |
| F076 | 방향 전환 생명주기 확인 | `onCreate`, `onStart`, `onStop`, `onDestroy`, 사용자 `showToast` | 세로·가로 레이아웃 | [P2-C3] p.111-115 |
| F077 | 인스턴스 상태 저장·복원 | `onSaveInstanceState`, `Bundle.putString`, `Bundle.getString`, `savedInstanceState` | `EditText`, 확인 `Button` | [P2-C3] p.116-126 |
| F078 | 재생성 없이 방향 변경 수신 | `onConfigurationChanged`, `Configuration.orientation`, `ORIENTATION_LANDSCAPE/PORTRAIT` | Manifest `configChanges="orientation|screenSize|keyboardHidden"` | [P2-C3] p.127-135 |
| F079 | 화면 방향 고정 | — | Manifest `screenOrientation="landscape"` | [P2-C3] p.136-137 |

## H. 사용자 알림과 진행 상태

| ID | 기능군 | 핵심 Java 메서드·클래스 | 핵심 XML·리소스/UI | 출처 |
|---|---|---|---|---|
| F080 | 토스트 위치·여백·사용자 모양 | `Toast.setGravity`, `setMargin`, `LayoutInflater.inflate`, `new Toast`, `setDuration`, `setView`, `show` | 사용자 토스트 레이아웃과 Shape 배경 | [P2-C3] p.140-147 |
| F081 | Snackbar | `Snackbar.make(...).show` | 클릭 버튼, 화면 하단 메시지 | [P2-C3] p.148-149 |
| F082 | AlertDialog | `AlertDialog.Builder`, `setTitle`, `setMessage`, `setIcon`, `setPositiveButton`, `setNeutralButton`, `setNegativeButton`, `create`, `show`, `DialogInterface.OnClickListener` | 결과 표시 `TextView` | [P2-C3] p.150-158 |
| F083 | 화면 내 determinate ProgressBar | `setProgress`, `incrementProgressBy`, `setIndeterminate(false)` | `<ProgressBar>`, `max`, `progress`, `style="?android:attr/progressBarStyleHorizontal"` | [P2-C3] p.159-161, 163-168 |
| F084 | 윈도우 타이틀 영역 ProgressBar | `requestWindowFeature(Window.FEATURE_PROGRESS)` | 타이틀 영역의 0~10000 진행값 | [P2-C3] p.162 |
| F085 | 대화상자형 indeterminate 진행 표시 | `ProgressDialog`, `setProgressStyle(ProgressDialog.STYLE_SPINNER)`, `setMessage`, `show`, `dismiss` | 대화상자 밖 터치 또는 BACK으로 닫힘 | [P2-C3] p.163-169 |

## 실습과제에서 추가로 요구되는 조합

아래 항목은 새로운 API 기능군으로 중복 집계하지 않고, 위 기능군을 결합하는 **과제 요구 조합**으로 분리했다. 정확한 요구사항은 `ASSIGNMENTS.md`에 기록했다.

- ConstraintLayout 하단 가이드라인 위에 버튼 2개 배치: [P2-C1] p.105-106
- 상단·중앙·하단 3영역 화면 구성: [P2-C1] p.107-108
- 위·아래 ScrollView/ImageView 사이에서 이미지 이동: [P2-C2] p.125-126
- SNS 입력과 `현재 바이트/80 바이트` 표시, 전송 Toast: [P2-C2] p.127-128
- Shape Drawable로 서로 다른 버튼 2종 만들기: [P2-C3] p.170-171
- SeekBar 변화값을 수평 ProgressBar와 입력상자에 동기화: [P2-C3] p.172-173

## 강의자료의 오탈자·레거시 API 주의

- [P2-C3] p.121 이미지 코드는 상태 저장 호출을 `outState.outString(...)`으로 표시한다. Android `Bundle`의 실제 메서드는 `putString(...)`이다. 이후 구현 시 원문을 근거로 하되 **`[호환성 수정] Bundle.putString 사용`**이라고 명시해야 한다.
- [P2-C3] p.130 본문에는 `screeSize`, `configurationChanged`로 적힌 부분이 있으나, 같은 자료의 p.129·131 코드 이미지에는 각각 `screenSize`, `onConfigurationChanged`가 제시된다. 구현 시 코드 이미지의 표기를 기준으로 하고 정정 사실을 기록한다.
- [P2-C3] p.47-49 본문에는 `TextChangeListener`, `addTextChangeListener`로 적힌 부분이 있으나, 이미지 표와 Android API의 실제 명칭은 `TextWatcher`, `addTextChangedListener`다. 기능 인덱스에는 실제 명칭을 기록했다.
- [P2-C3] p.46의 `editable`, p.45의 `capitalize`, p.168의 `ProgressDialog`, [P2-C2] p.120-121의 인자 없는 `Resources.getDrawable` 등은 최신 SDK에서 폐기되었거나 권장되지 않을 수 있다. 실제 코드 단계에서 대체가 필요하면 반드시 `[호환성 수정]`으로 구분한다.
- [P2-C3] p.140은 API 30 이상에서 **글자만 있는 기본 Toast의 위치를 바꿀 수 없고 화면 아래 중앙에 표시**된다고 설명한다. 사용자 모양 Toast일 때만 위치 변경을 전제로 한다.
- [P2-C2] p.79는 `RelativeLayout`을 이해 대상으로 다루지만 새 화면에서는 권장하지 않는다고 명시한다. 시험에서 해당 방식을 요구할 때에만 그대로 구현한다.

## 검토 완전성 및 한계

- 누락된 PDF: 없음. 7개 파일 모두 열렸고 페이지 수와 텍스트 추출을 확인했다.
- 읽지 못해 기능 판단이 불가능한 페이지: 없음.
- 텍스트 레이어가 비어 있는 코드·표 중심 페이지는 렌더링 이미지로 직접 확인했다. 특히 첫 앱 Intent/Toast, Java 동적 레이아웃, FrameLayout 전환, ScrollView 이미지 처리, Drawable XML, 터치·제스처·방향 전환, Toast/Dialog/Progress 코드, 과제 6개 페이지를 시각 대조했다.
- 로컬 OCR 엔진은 사용할 수 없었으므로 모든 이미지 코드를 자동 전사하지는 않았다. 이 문서는 코드 전문이 아니라 **구현 기능·메서드·속성의 확정 목록**이며, 작은 IDE 캡처의 장식적 정보는 제외했다.
- Part 1 Chapter 01(p.3-6)은 Android 구조·특징, Chapter 02(p.3-12)는 개발도구 설치, Chapter 04(p.3-8)는 USB 디버깅·실단말 실행을 다룬다. 구현 API/위젯 기능군은 없으므로 85개 집계에는 포함하지 않았지만 전체 페이지는 검토했다.
