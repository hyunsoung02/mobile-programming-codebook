# P02 — Java에서 LinearLayout과 Button 3개 직접 생성

- 사용 기능: `new LinearLayout()`, `setOrientation()`, `new Button()`, `addView()`, `setContentView(View)`
- 코드: [MainActivity.java](app/src/main/java/com/example/myapplication/MainActivity.java)
- XML: 사용하지 않음. 이 예제의 목적은 화면을 Java에서 직접 만드는 것이다.
- 시험 수정: 가로 배치는 `LinearLayout.HORIZONTAL`, 버튼 문구는 각 `setText()`, 폭·높이는 `LayoutParams`를 바꾼다.
- 자주 발생하는 오류: 마지막 `setContentView(layout)`을 빼면 생성한 View가 화면에 표시되지 않는다.

검증 상태: Java 정적 검증 완료, 실행 미검증
