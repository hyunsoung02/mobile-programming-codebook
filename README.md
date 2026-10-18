# Mobile Programming Codebook

모바일프로그래밍 중간고사에서 빠르게 찾아 복사·수정할 수 있도록 정리한 Java/XML 코드북입니다. 교수님 강의자료를 기준으로 작성했으며, 원본 PDF는 저장소에 포함하지 않습니다.

## 시험장 빠른 바로가기

- [85개 기능군 전체 원장](codebook/CODEBOOK_PLAN.md) — 기능 ID, 분류, PPT 출처, 구현 파일, 작성 상태
- [F001 MainActivity와 XML 연결](codebook/01_Project/F001_MainActivity_XML/README.md)
- [F002 findViewById로 View 참조](codebook/02_View_Properties/F002_FindViewById/README.md)
- [F023 LinearLayout 수직·수평 배치](codebook/03_Layouts/F023_LinearLayout_Orientation/README.md)
- [F006 Button 클릭 이벤트](codebook/06_Events/F006_Button_XML_OnClick/README.md)

## 기능별 목차

85개 기능군의 상세 항목과 PPT 페이지는 [CODEBOOK_PLAN.md](codebook/CODEBOOK_PLAN.md)에서 한 번에 검색할 수 있습니다.

1. [프로젝트와 Activity](codebook/01_Project/README.md)
2. [View 공통 속성](codebook/02_View_Properties/README.md)
3. [레이아웃](codebook/03_Layouts/README.md)
4. [위젯](codebook/04_Widgets/README.md)
5. [Drawable](codebook/05_Drawables/README.md)
6. [이벤트 처리](codebook/06_Events/README.md)
7. [사용자 피드백](codebook/07_User_Feedback/README.md)
8. [Progress](codebook/08_Progress/README.md)
9. [Activity 생명주기](codebook/09_Activity_Lifecycle/README.md)
10. [교수님 실습과제](codebook/10_Assignments/README.md)
11. [시험 가이드](codebook/11_Exam_Guide/README.md)

## 교수님 실습과제 6개

- [A01](codebook/10_Assignments/A01_Guideline_Two_Buttons/README.md)
- [A02](codebook/10_Assignments/A02_Three_Area_ConstraintLayout/README.md)
- [A03 — 이미지 위치 전환](codebook/10_Assignments/A03_Toggle_ImageViews/README.md)
- [A04 — UTF-8 80바이트 카운터](codebook/10_Assignments/A04_SNS_Byte_Counter/README.md)
- [A05](codebook/10_Assignments/A05_Shape_Buttons/README.md)
- [A06 — SeekBar·ProgressBar 동기화](codebook/10_Assignments/A06_SeekBar_ProgressBar/README.md)

## 프로젝트 구성과 실행

- `app/`: 기존 Android Studio 앱 프로젝트
- `codebook/`: 기능별 독립 Java/XML 예제와 과제 코드
- `gradle/`, `gradlew`, `gradlew.bat`: Gradle Wrapper
- `AGENTS.md`, `FEATURE_INDEX.md`, `ASSIGNMENTS.md`: 작성 규칙과 분석 원장

Android Studio에서 저장소 루트를 연 뒤 Gradle 동기화를 수행합니다. 코드북 예제는 기존 `app/src/main/`을 자동으로 바꾸지 않으므로, 필요한 예제의 README를 확인하고 해당 Java/XML/Drawable을 시험 프로젝트에 복사해 사용합니다.

> 검증 상태는 각 예제 README와 `CODEBOOK_PLAN.md`를 기준으로 확인하세요. 실제 기기 또는 에뮬레이터에서 실행하지 않은 예제는 `미검증`으로 표시합니다.
