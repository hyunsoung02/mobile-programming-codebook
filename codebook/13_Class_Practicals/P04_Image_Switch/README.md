# P04 — ImageView, ScrollView, 버튼을 이용한 이미지 전환

같은 기능이 실습과제 A03에 완성되어 있으므로 중복 코드를 만들지 않고 해당 예제를 사용한다. 버튼을 누르면 하나의 이미지를 위·아래 `ScrollView` 사이에서 전환한다.

- Java: [A03 MainActivity.java](../../10_Assignments/A03_Toggle_ImageViews/app/src/main/java/com/example/myapplication/MainActivity.java)
- XML: [A03 activity_main.xml](../../10_Assignments/A03_Toggle_ImageViews/app/src/main/res/layout/activity_main.xml)
- Drawable: [sample_image.xml](../../10_Assignments/A03_Toggle_ImageViews/app/src/main/res/drawable/sample_image.xml)
- 핵심 메서드: `findViewById()`, `setOnClickListener()`, `setVisibility()`
- 시험 수정: 전환할 이미지 리소스는 `android:src`, 처음 보이는 영역은 각 `ImageView`의 `android:visibility`를 바꾼다.

검증 상태: A03 정적 검증 완료, 실행 미검증
