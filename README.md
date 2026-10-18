# Mobile Programming Codebook

## 시험장 10초 코드 검색

키워드를 찾은 뒤 **Java/XML 링크를 열어 전체 파일을 복사**한다. 현재 구현 완료 항목은 F001·F002·F006·F023과 A01~A06이며, 나머지 81개 기능군은 [계획/미구현 상태](codebook/CODEBOOK_PLAN.md)다.

### 키워드 바로가기

| 검색 키워드 | 가장 가까운 예제 |
|---|---|
| `ConstraintLayout` | [A02 XML](codebook/10_Assignments/A02_Three_Area_ConstraintLayout/app/src/main/res/layout/activity_main.xml) |
| `Guideline` | [A01 XML](codebook/10_Assignments/A01_Guideline_Two_Buttons/app/src/main/res/layout/activity_main.xml) |
| `LinearLayout` | [F023 XML](codebook/03_Layouts/F023_LinearLayout_Orientation/app/src/main/res/layout/activity_main.xml) · [A03 XML](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/res/layout/activity_main.xml) |
| `ScrollView` · `ImageView` | [A03 설명](codebook/10_Assignments/A03_Toggle_ImageViews/README.md) · [Java](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/res/layout/activity_main.xml) |
| `TextWatcher` | [A04 Java](codebook/10_Assignments/A04_SNS_Byte_Counter/app/src/main/java/com/example/myapplication/MainActivity.java) |
| `Toast` | [A04 Java](codebook/10_Assignments/A04_SNS_Byte_Counter/app/src/main/java/com/example/myapplication/MainActivity.java) · [F006 Java](codebook/06_Events/F006_Button_XML_OnClick/app/src/main/java/com/example/myapplication/MainActivity.java) |
| `Shape Drawable` | [A05 설명](codebook/10_Assignments/A05_Shape_Buttons/README.md) · [테두리](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_outline.xml) · [채움](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_filled.xml) |
| `SeekBar` · `ProgressBar` | [A06 Java](codebook/10_Assignments/A06_SeekBar_ProgressBar/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A06_SeekBar_ProgressBar/app/src/main/res/layout/activity_main.xml) |
| `findViewById` | [F002 Java](codebook/02_View_Properties/F002_FindViewById/app/src/main/java/com/example/myapplication/MainActivity.java) |

### 교수님 실습과제 A01~A06

| 과제 | 요구 기능 | 전체 코드 | 설명 | 시험 조건 변경 시 |
|---|---|---|---|---|
| A01 | Guideline 아래에 같은 폭의 버튼 2개 | [Java](codebook/10_Assignments/A01_Guideline_Two_Buttons/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A01_Guideline_Two_Buttons/app/src/main/res/layout/activity_main.xml) | [README](codebook/10_Assignments/A01_Guideline_Two_Buttons/README.md) | 기준선은 `layout_constraintGuide_end`, 간격은 `layout_marginBottom`을 수정한다. ID 변경 시 XML의 모든 제약 참조도 함께 바꾼다. |
| A02 | 위·아래 고정 영역과 남은 중앙 영역 | [Java](codebook/10_Assignments/A02_Three_Area_ConstraintLayout/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A02_Three_Area_ConstraintLayout/app/src/main/res/layout/activity_main.xml) | [README](codebook/10_Assignments/A02_Three_Area_ConstraintLayout/README.md) | 상·하단은 `layout_height`, 중앙은 `0dp`와 위·아래 제약을 수정한다. ID 변경 시 중앙 버튼의 형제 참조도 바꾼다. |
| A03 | 위·아래 ScrollView 사이에서 같은 이미지 이동 | [Java](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/res/layout/activity_main.xml) · [Drawable](codebook/10_Assignments/A03_Toggle_ImageViews/app/src/main/res/drawable/sample_image.xml) | [README](codebook/10_Assignments/A03_Toggle_ImageViews/README.md) | 이미지는 `R.drawable.sample_image`, 위치 상태는 `imageAtTop`, 영역 비율은 `layout_weight`를 수정한다. XML ID와 Java `R.id`는 같이 바꾼다. |
| A04 | UTF-8 바이트 자동 계산과 전송 Toast | [Java](codebook/10_Assignments/A04_SNS_Byte_Counter/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A04_SNS_Byte_Counter/app/src/main/res/layout/activity_main.xml) · Drawable 없음 | [README](codebook/10_Assignments/A04_SNS_Byte_Counter/README.md) | 제한값은 Java의 `"/80 바이트"`와 XML 초기 문구를 함께 바꾼다. 인코딩 기준 변경은 `getBytes(StandardCharsets.UTF_8)`를 수정한다. |
| A05 | 테두리 버튼과 채움·둥근 버튼 | [Java](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/layout/activity_main.xml) · [테두리 Drawable](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_outline.xml) · [채움 Drawable](codebook/10_Assignments/A05_Shape_Buttons/app/src/main/res/drawable/button_filled.xml) | [README](codebook/10_Assignments/A05_Shape_Buttons/README.md) | 색·두께는 `solid`/`stroke`, 둥근 정도는 `corners radius`를 수정한다. Drawable 이름을 바꾸면 버튼 `background`도 바꾼다. |
| A06 | SeekBar 값으로 ProgressBar와 입력값 동기화 | [Java](codebook/10_Assignments/A06_SeekBar_ProgressBar/app/src/main/java/com/example/myapplication/MainActivity.java) · [XML](codebook/10_Assignments/A06_SeekBar_ProgressBar/app/src/main/res/layout/activity_main.xml) · Drawable 없음 | [README](codebook/10_Assignments/A06_SeekBar_ProgressBar/README.md) | 범위는 두 위젯의 `android:max`, 초기값은 SeekBar의 `android:progress`를 수정한다. 표시 형식은 `onProgressChanged`의 `setText`를 바꾼다. |

### 구현 완료 독립 예제

| 기능 | Java 전체 코드 | XML 전체 코드 | 설명 |
|---|---|---|---|
| F001 MainActivity와 XML 연결 | [Java](codebook/01_Project/F001_MainActivity_XML/app/src/main/java/com/example/myapplication/MainActivity.java) | [XML](codebook/01_Project/F001_MainActivity_XML/app/src/main/res/layout/activity_main.xml) | [README](codebook/01_Project/F001_MainActivity_XML/README.md) |
| F002 `findViewById` | [Java](codebook/02_View_Properties/F002_FindViewById/app/src/main/java/com/example/myapplication/MainActivity.java) | [XML](codebook/02_View_Properties/F002_FindViewById/app/src/main/res/layout/activity_main.xml) | [README](codebook/02_View_Properties/F002_FindViewById/README.md) |
| F006 Button XML `onClick` | [Java](codebook/06_Events/F006_Button_XML_OnClick/app/src/main/java/com/example/myapplication/MainActivity.java) | [XML](codebook/06_Events/F006_Button_XML_OnClick/app/src/main/res/layout/activity_main.xml) | [README](codebook/06_Events/F006_Button_XML_OnClick/README.md) |
| F023 LinearLayout 수직·수평 | [Java](codebook/03_Layouts/F023_LinearLayout_Orientation/app/src/main/java/com/example/myapplication/MainActivity.java) | [XML](codebook/03_Layouts/F023_LinearLayout_Orientation/app/src/main/res/layout/activity_main.xml) | [README](codebook/03_Layouts/F023_LinearLayout_Orientation/README.md) |

## 85개 기능군 목차

[CODEBOOK_PLAN.md](codebook/CODEBOOK_PLAN.md)에 기능 ID, 분류, PPT 출처, 구현 파일과 상태가 기록되어 있다. **구현 완료 4개, 미구현 81개**이며 미구현 항목은 참고용 계획이다.

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

## 코드 복사와 Android Studio 적용 순서

1. 문제 키워드에 맞는 예제의 **Java/XML/Drawable 링크**를 연다.
2. 파일 전체를 시험 프로젝트의 동일한 `app/src/main/` 상대 경로에 복사한다. Drawable이 있는 과제는 함께 복사한다.
3. Java의 `package`, 프로젝트 `namespace`, Manifest의 Activity 이름을 맞춘다.
4. XML ID와 Java `R.id`, Drawable 참조가 모두 같은지 확인한 뒤 Gradle Sync → Build → Run 순서로 실행한다.
5. 조건이 달라졌다면 표의 수정 지점과 각 README의 시험 수정 지점만 바꾼다. 서로 다른 예제를 한 화면에 합치지 않는다.

> 각 예제의 정확한 검증 상태는 해당 README를 따른다. 정적 검사 통과는 에뮬레이터·실기기 실행 완료를 뜻하지 않는다.
