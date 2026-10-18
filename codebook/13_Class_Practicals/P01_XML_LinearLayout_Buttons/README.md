# P01 — XML LinearLayout에 Button 3개 세로 배치

- 사용 기능: `LinearLayout`, `orientation="vertical"`, `Button`
- 코드: [MainActivity.java](app/src/main/java/com/example/myapplication/MainActivity.java) · [activity_main.xml](app/src/main/res/layout/activity_main.xml)
- 핵심: Activity의 `setContentView()`가 XML 화면을 연결하고, `orientation`이 자식 View 배치 방향을 결정한다.
- 시험 수정: 가로 배치는 `android:orientation="horizontal"`, 버튼 문구는 각 `android:text`, 버튼 간격은 `android:layout_marginTop`을 바꾼다.
- 자주 발생하는 오류: `setContentView(R.layout.activity_main)`의 파일명과 실제 XML 파일명이 다르면 화면을 찾지 못한다.

검증 상태: 정적 검증 완료, 실행 미검증
