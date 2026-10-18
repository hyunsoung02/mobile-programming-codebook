# P03 — gravity와 layout_gravity 정렬 비교

- 사용 기능: `android:gravity`, `android:layout_gravity`
- 코드: [MainActivity.java](app/src/main/java/com/example/myapplication/MainActivity.java) · [activity_main.xml](app/src/main/res/layout/activity_main.xml)
- 핵심: `gravity`는 View **안의 내용/자식**을 정렬하고, `layout_gravity`는 View **자신**을 부모 안에서 정렬한다.
- 시험 수정: 가운데·왼쪽·오른쪽 조건에 따라 `center`, `start`, `end` 값을 바꾼다.
- 자주 발생하는 오류: 부모가 자식보다 넓거나 높아야 정렬 차이가 눈에 보인다.

검증 상태: 정적 검증 완료, 실행 미검증
