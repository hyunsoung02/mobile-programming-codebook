# Android 강의 코드북

교수님 PDF 7개에서 확정한 85개 기능군을 Java/XML 독립 예제로 찾아 쓰기 위한 코드북이다. 전체 기능·출처·작성 상태는 [CODEBOOK_PLAN.md](CODEBOOK_PLAN.md)에서 확인한다. 이 파일 세트는 독립 Gradle 모듈이 아니므로 실행할 때는 시험용 프로젝트에 필요한 파일을 복사한다.

기준 문서는 [작업 규칙](../AGENTS.md), [기능 인덱스](../FEATURE_INDEX.md), [과제 요구사항](../ASSIGNMENTS.md)다. 출처의 페이지는 슬라이드 내부 번호가 아닌 PDF 페이지 번호다. `course_materials/`의 원본 PDF는 수정·삭제하거나 GitHub에 커밋하지 않는다.

## 분류별 탐색

| 폴더 | 목적 | 주 기능 수 |
|---|---|---:|
| [01_Project](01_Project/README.md) | 앱 시작, 화면 연결, 프로젝트 위치, Manifest | 3 |
| [02_View_Properties](02_View_Properties/README.md) | ID 참조, 크기·여백·정렬·공통 속성 | 12 |
| [03_Layouts](03_Layouts/README.md) | ConstraintLayout, LinearLayout, 상대·표·중첩·스크롤 배치 | 22 |
| [04_Widgets](04_Widgets/README.md) | 텍스트·버튼·선택·이미지·입력 위젯 | 22 |
| [05_Drawables](05_Drawables/README.md) | 배경, Selector, Shape, Gradient, Layer-list | 6 |
| [06_Events](06_Events/README.md) | 클릭, Intent, 터치, 제스처, 키 | 8 |
| [07_User_Feedback](07_User_Feedback/README.md) | Toast, Snackbar, AlertDialog | 4 |
| [08_Progress](08_Progress/README.md) | 화면 내부·타이틀·대화상자 진행 표시 | 3 |
| [09_Activity_Lifecycle](09_Activity_Lifecycle/README.md) | 방향별 화면, 생명주기, 상태 복원, 방향 설정 | 5 |
| [10_Assignments](10_Assignments/README.md) | 교수님 과제 6개와 관련 기능 교차 참조 | 별도 집계 없음 |
| [11_Exam_Guide](11_Exam_Guide/README.md) | 파일 복사·실행·변경·검증 규칙 | 별도 집계 없음 |

## 시험장 빠른 바로가기

### 작성된 기능 예제

1. [F001: MainActivity와 XML 화면 연결](01_Project/F001_MainActivity_XML/README.md)
2. [F002: findViewById로 XML View 참조](02_View_Properties/F002_FindViewById/README.md)
3. [F023: LinearLayout 수직·수평 배치](03_Layouts/F023_LinearLayout_Orientation/README.md)
4. [F006: Button XML onClick 이벤트](06_Events/F006_Button_XML_OnClick/README.md)

### 교수님 실습과제 6개

1. [A01: Guideline 위에 버튼 2개 배치](10_Assignments/A01_Guideline_Two_Buttons/README.md)
2. [A02: 상단·중앙·하단 영역 구성](10_Assignments/A02_Three_Area_ConstraintLayout/README.md)
3. [A03: 두 ImageView 사이 이미지 전환](10_Assignments/A03_Toggle_ImageViews/README.md)
4. [A04: SNS 입력과 UTF-8 바이트 표시](10_Assignments/A04_SNS_Byte_Counter/README.md)
5. [A05: 테두리·채움 Shape 버튼](10_Assignments/A05_Shape_Buttons/README.md)
6. [A06: SeekBar·ProgressBar 값 동기화](10_Assignments/A06_SeekBar_ProgressBar/README.md)

위 네 예제는 각각 README와 전체 Java/XML 파일을 제공하며, 상태는 `작성 완료 · 미검증`이다. 교수님 [실습과제 6개](10_Assignments/README.md)도 과제별 독립 복사 세트로 작성했다. 파일과 연결 관계는 [구조 검증기](11_Exam_Guide/validate_codebook.sh)로 확인한다. 기능 ID 기준 나머지 81개는 작성 예정이다.

Java 패키지와 리소스 구조는 실제 프로젝트의 `com.example.myapplication` 및 `app/src/main/`을 따른다. 기존 앱 파일은 자동 변경하지 않는다. 예제를 적용할 때는 [복사·실행 규칙](11_Exam_Guide/README.md)을 따른다. 정적 검사 통과는 Android 빌드·에뮬레이터 실행 여부를 증명하지 않으며, 실행하지 않은 예제는 `미검증`으로 표시한다.
