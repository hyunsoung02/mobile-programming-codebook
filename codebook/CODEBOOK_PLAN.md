# 85개 기능 배치와 작성 상태

[코드북 홈](README.md) · [기능 인덱스](../FEATURE_INDEX.md) · [과제 요구사항](../ASSIGNMENTS.md)

이 표를 기능 배치와 작성 상태의 단일 원장으로 사용한다. 각 ID는 주 폴더 하나에만 배치한다. `코드북 문서`는 현재 존재하는 분류 README이며, 각 README의 기능 행이 향후 독립 예제 단위를 안내한다. 출처는 기능 인덱스에서 확정한 PDF 파일명과 PDF 페이지 번호다.

F001·F002·F023·F006은 각각 README와 전체 Java/XML 파일을 작성했으며 상태는 `작성 완료 · 미검증`이다. 파일과 연결 관계는 구조 검증기로 확인한다. 나머지 81개는 `작성 예정`이다. `미검증`은 Android 빌드·에뮬레이터 실행을 하지 않았다는 뜻이며 정적 검사 통과만으로 바꾸지 않는다.

`구현 파일`은 codebook 기준 경로다. 첫 예제의 `app/src/main/`에는 전체 `java/com/example/myapplication/MainActivity.java`와 `res/layout/activity_main.xml`을 제공한다. `미정`은 예제 이름과 파일을 아직 만들지 않았다는 뜻이다.

| 기능 ID | 기능명 | 주 폴더 | 코드북 문서 | 구현 파일 | PPT 출처 | 상태 |
|---|---|---|---|---|---|---|
| F001 | 액티비티 시작과 화면 설정 | 01_Project | [README](01_Project/README.md) | `01_Project/F001_MainActivity_XML/app/src/main/java/com/example/myapplication/MainActivity.java`<br>`01_Project/F001_MainActivity_XML/app/src/main/res/layout/activity_main.xml` | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.20-24, 54 | 작성 완료 · 미검증 |
| F002 | XML 뷰를 ID로 참조 | 02_View_Properties | [README](02_View_Properties/F002_FindViewById/README.md) | `02_View_Properties/F002_FindViewById/app/src/main/java/com/example/myapplication/MainActivity.java`<br>`02_View_Properties/F002_FindViewById/app/src/main/res/layout/activity_main.xml` | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.88-89; `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.109-111, 120 | 작성 완료 · 미검증 |
| F003 | 문자열 직접 표시 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.28-31; `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.5 | 작성 예정 |
| F004 | 문자열 리소스 분리·참조 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.5-10 | 작성 예정 |
| F005 | 버튼 배치와 표시 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.32-34, 41-48 | 작성 예정 |
| F006 | XML 선언형 클릭 처리 | 06_Events | [README](06_Events/README.md) | `06_Events/F006_Button_XML_OnClick/app/src/main/java/com/example/myapplication/MainActivity.java`<br>`06_Events/F006_Button_XML_OnClick/app/src/main/res/layout/activity_main.xml` | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.35-40, 50-52; `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.76 | 작성 완료 · 미검증 |
| F007 | 리스너 기반 클릭 처리 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.21, 76-78, 121-122, 151 | 작성 예정 |
| F008 | 간단한 토스트 메시지 | 07_User_Feedback | [README](07_User_Feedback/README.md) | 미정 · 독립 예제 작성 예정 | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.37-40; `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.105-106, 138-139 | 작성 예정 |
| F009 | 웹 주소 열기 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.49-52 | 작성 예정 |
| F010 | 전화 걸기 화면 열기 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part1)Chapter03_첫번째앱만들기.pdf` PDF p.49-52 | 작성 예정 |
| F011 | 소스·레이아웃·드로어블 위치 구분 | 01_Project | [README](01_Project/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.104 | 작성 예정 |
| F012 | 시작 액티비티 등록 | 01_Project | [README](01_Project/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.32, 38-39 | 작성 예정 |
| F013 | View/ViewGroup 구조 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.32-38 | 작성 예정 |
| F014 | 폭·높이 크기 모드 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.39-50, 73-76; `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.11-13 | 작성 예정 |
| F015 | XML 네임스페이스와 ID | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.87-89 | 작성 예정 |
| F016 | ConstraintLayout 기본 앵커 연결 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.51-64, 90-92 | 작성 예정 |
| F017 | 네 방향 제약으로 중앙 배치 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.61-67 | 작성 예정 |
| F018 | 제약 바이어스 조절 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.68-72 | 작성 예정 |
| F019 | 제약 대상에 따른 가변 크기 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.73-76 | 작성 예정 |
| F020 | Guideline 배치 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.78-86, 93-95 | 작성 예정 |
| F021 | 뷰 외부 여백 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.99-103; `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.12-13, 60-67 | 작성 예정 |
| F022 | 크기 단위 선택 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.96-98 | 작성 예정 |
| F023 | LinearLayout 방향 배치 | 03_Layouts | [README](03_Layouts/README.md) | `03_Layouts/F023_LinearLayout_Orientation/app/src/main/java/com/example/myapplication/MainActivity.java`<br>`03_Layouts/F023_LinearLayout_Orientation/app/src/main/res/layout/activity_main.xml` | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.10-11, 16-26, 31 | 작성 완료 · 미검증 |
| F024 | 배경색과 ARGB | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.14-15, 60-67 | 작성 예정 |
| F025 | 내부 여백 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.12-13, 60-67 | 작성 예정 |
| F026 | 자식 뷰 자체 정렬 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.40-45 | 작성 예정 |
| F027 | 자식 내용 정렬 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.40-51 | 작성 예정 |
| F028 | 텍스트 표시 속성 조합 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.46-51 | 작성 예정 |
| F029 | 텍스트 기준선 정렬 | 02_View_Properties | [README](02_View_Properties/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.52-59 | 작성 예정 |
| F030 | 가중치로 공간 분할 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.68-78 | 작성 예정 |
| F031 | Java로 LinearLayout 생성 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.27-39 | 작성 예정 |
| F032 | Java로 자식 View 생성·추가 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.29-39 | 작성 예정 |
| F033 | Context 전달 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.28-30 | 작성 예정 |
| F034 | RelativeLayout의 부모 기준 배치 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.79-89 | 작성 예정 |
| F035 | RelativeLayout의 다른 뷰 기준 배치 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.80-90 | 작성 예정 |
| F036 | 상대 배치로 상·중·하 영역 구성 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.82-88 | 작성 예정 |
| F037 | TableLayout 행·열 구성 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.92-96 | 작성 예정 |
| F038 | 테이블 열 자동 확장·축소 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.97-99 | 작성 예정 |
| F039 | 테이블 열 위치·병합 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.100-102 | 작성 예정 |
| F040 | FrameLayout 중첩 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.103-107 | 작성 예정 |
| F041 | 가시성으로 뷰 전환 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.103-114 | 작성 예정 |
| F042 | 수직 스크롤 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.115-124 | 작성 예정 |
| F043 | 수평·수직 동시 스크롤 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.116-124 | 작성 예정 |
| F044 | 코드에서 드로어블 이미지 로드 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.118-121 | 작성 예정 |
| F045 | 원본 이미지 크기로 View 조정 | 03_Layouts | [README](03_Layouts/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.118-121 | 작성 예정 |
| F046 | 텍스트 색상 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.11-12 | 작성 예정 |
| F047 | 텍스트 크기 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.13-14 | 작성 예정 |
| F048 | 텍스트 스타일 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.15-16 | 작성 예정 |
| F049 | 글꼴 계열 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.17-18 | 작성 예정 |
| F050 | 최대 줄 수 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.19-20 | 작성 예정 |
| F051 | CompoundButton 상태 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.22-26 | 작성 예정 |
| F052 | 라디오 버튼 단일 선택 그룹 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.24-27 | 작성 예정 |
| F053 | 이미지 전용 버튼 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.27, 32-39 | 작성 예정 |
| F054 | EditText 기본 입력 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.28-31, 46-47 | 작성 예정 |
| F055 | 이미지 리소스 표시 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.32-39 | 작성 예정 |
| F056 | 이미지 크기·색·배율 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.33-35 | 작성 예정 |
| F057 | 커서·선택 제어 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.41-42 | 작성 예정 |
| F058 | 자동 링크 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.43 | 작성 예정 |
| F059 | 줄 간격 조절 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.43-44 | 작성 예정 |
| F060 | 대소문자 자동 표시 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.45 | 작성 예정 |
| F061 | 말줄임 위치 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.45 | 작성 예정 |
| F062 | 힌트 색과 편집 허용 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.46 | 작성 예정 |
| F063 | 입력 변화 감시 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.47-49 | 작성 예정 |
| F064 | 입력 길이 제한 | 04_Widgets | [README](04_Widgets/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.49 | 작성 예정 |
| F065 | 정적 배경 이미지·색 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.50-54 | 작성 예정 |
| F066 | 상태 셀렉터 드로어블 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.55-60 | 작성 예정 |
| F067 | 기본 Shape 드로어블 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.61-66 | 작성 예정 |
| F068 | 그라데이션 배경 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.67-69 | 작성 예정 |
| F069 | 여러 Shape 중첩과 테두리 버튼 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.70-74 | 작성 예정 |
| F070 | 버튼 배경 틴트 간섭 제거 | 05_Drawables | [README](05_Drawables/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.84-85; `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.64, 73 | 작성 예정 |
| F071 | 뷰 이벤트 리스너 모델 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.75-83 | 작성 예정 |
| F072 | 터치 액션과 좌표 처리 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.85-94 | 작성 예정 |
| F073 | 제스처 판별 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.83-84, 95-100 | 작성 예정 |
| F074 | 키 코드 처리 | 06_Events | [README](06_Events/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.101-106 | 작성 예정 |
| F075 | 방향별 레이아웃 리소스 | 09_Activity_Lifecycle | [README](09_Activity_Lifecycle/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.107-115 | 작성 예정 |
| F076 | 방향 전환 생명주기 확인 | 09_Activity_Lifecycle | [README](09_Activity_Lifecycle/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.111-115 | 작성 예정 |
| F077 | 인스턴스 상태 저장·복원 | 09_Activity_Lifecycle | [README](09_Activity_Lifecycle/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.116-126 | 작성 예정 |
| F078 | 재생성 없이 방향 변경 수신 | 09_Activity_Lifecycle | [README](09_Activity_Lifecycle/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.127-135 | 작성 예정 |
| F079 | 화면 방향 고정 | 09_Activity_Lifecycle | [README](09_Activity_Lifecycle/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.136-137 | 작성 예정 |
| F080 | 토스트 위치·여백·사용자 모양 | 07_User_Feedback | [README](07_User_Feedback/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.140-147 | 작성 예정 |
| F081 | Snackbar | 07_User_Feedback | [README](07_User_Feedback/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.148-149 | 작성 예정 |
| F082 | AlertDialog | 07_User_Feedback | [README](07_User_Feedback/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.150-158 | 작성 예정 |
| F083 | 화면 내 determinate ProgressBar | 08_Progress | [README](08_Progress/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.159-161, 163-168 | 작성 예정 |
| F084 | 윈도우 타이틀 영역 ProgressBar | 08_Progress | [README](08_Progress/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.162 | 작성 예정 |
| F085 | 대화상자형 indeterminate 진행 표시 | 08_Progress | [README](08_Progress/README.md) | 미정 · 독립 예제 작성 예정 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.163-169 | 작성 예정 |

## 폴더별 집계

| 주 폴더 | 기능 수 |
|---|---:|
| [01_Project](01_Project/README.md) | 3 |
| [02_View_Properties](02_View_Properties/README.md) | 12 |
| [03_Layouts](03_Layouts/README.md) | 22 |
| [04_Widgets](04_Widgets/README.md) | 22 |
| [05_Drawables](05_Drawables/README.md) | 6 |
| [06_Events](06_Events/README.md) | 8 |
| [07_User_Feedback](07_User_Feedback/README.md) | 4 |
| [08_Progress](08_Progress/README.md) | 3 |
| [09_Activity_Lifecycle](09_Activity_Lifecycle/README.md) | 5 |
| 합계 | 85 |

`10_Assignments`는 기존 ID를 교차 참조하고 `11_Exam_Guide`는 복사·실행·검증 규칙을 제공하므로 추가 기능 ID를 부여하지 않는다. 과제 6개는 각각 독립 복사 세트로 작성했다. 다음 기능 구현은 F013부터 View 참조·속성 → ConstraintLayout → 나머지 Layout → Widget → Drawable → Event → 사용자 알림 → Progress → Activity Lifecycle 순서로 진행한다.

