# M01. RadioButton을 이용한 글자 색상 변경

사용자가 빨간색·파란색·초록색 중 하나를 고르고 **색상 적용** 버튼을 누르면 상단 제목과 회색 결과 영역의 글자색이 함께 바뀐다. 선택 직후에는 색상을 바꾸지 않으며, 적용 결과는 Toast로 알린다.

이 예제는 대화에서 제공된 모의시험 요구사항을 기준으로 작성했다. 첨부 스크린샷은 현재 Codex에서 확인할 수 없었으므로 화면을 보았다고 주장하지 않는다.

상태: **정적 검증 완료, 실행 미검증**. XML 문법, Java/XML ID 연결, 필수 API와 상대 링크를 확인했다. 임시 프로젝트 빌드는 Gradle 9.5.0 배포 파일이 로컬에 없고 네트워크가 제한되어 완료하지 못했다. 에뮬레이터·실기기 실행도 수행하지 않았다.

## 시험장에서 바로 열기

- [MainActivity.java 전체 코드](app/src/main/java/com/example/myapplication/MainActivity.java)
- [activity_main.xml 전체 코드](app/src/main/res/layout/activity_main.xml)
- 검색 키워드: `RadioButton`, `RadioGroup`, `getCheckedRadioButtonId`, `setOnClickListener`, `setTextColor`, `Toast`

## 사용 기능과 동작 순서

1. XML의 `RadioGroup`이 세 `RadioButton` 중 하나만 선택되도록 한다.
2. `android:checkedButton="@id/red_radio"`가 초기 선택을 빨간색으로 정한다.
3. `findViewById()`로 제목·결과·RadioGroup·버튼을 연결한다.
4. `Button.setOnClickListener()` 안에서 `RadioGroup.getCheckedRadioButtonId()`를 확인한다.
5. 선택 색상을 `TextView.setTextColor()`로 두 TextView에 적용하고 `Toast.makeText()`로 결과를 표시한다.

## 복사 및 실행

두 파일을 Java/XML Views 프로젝트의 동일한 `app/src/main/` 상대 경로에 복사한다. 프로젝트 `namespace`와 Java `package`는 `com.example.myapplication`로 맞추고, Manifest의 시작 Activity가 `.MainActivity`인지 확인한다. 별도 Drawable이나 권한은 필요 없다.

## 시험 조건 변경 시 수정 지점

- 선택지 추가·삭제: XML의 `RadioButton`과 Java의 `checkedId` 분기를 함께 수정한다.
- 색상 변경: Java의 `Color.RED/BLUE/GREEN`을 바꾸고 필요하면 XML 제목 초기색도 맞춘다.
- 초기 선택 변경: `RadioGroup`의 `android:checkedButton`을 바꾼다. 버튼 클릭 전에는 Java가 색상을 적용하지 않는다.
- 대상 TextView 변경: XML ID와 Java의 `R.id`, `setTextColor()` 호출 대상을 함께 수정한다.
- 문구·간격·회색 영역: XML의 `android:text`, `layout_marginTop`, `background`, `layout_height`를 수정한다.

`[추가 코드]`: 교수님 PDF의 기존 기능 예제가 아니라 사용자 제공 모의시험 문제를 실행 가능한 전체 Java/XML 파일로 구현했다. SDK 호환을 위해 별도로 바꾼 `[호환성 수정]`은 없다.
