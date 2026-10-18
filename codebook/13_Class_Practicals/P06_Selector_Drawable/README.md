# P06 — Selector Drawable로 눌림 상태 이미지 변경

- 사용 기능: `selector`, `state_pressed`, `ImageView`
- 코드: [MainActivity.java](app/src/main/java/com/example/myapplication/MainActivity.java) · [activity_main.xml](app/src/main/res/layout/activity_main.xml)
- Drawable: [image_selector.xml](app/src/main/res/drawable/image_selector.xml) · [image_normal.xml](app/src/main/res/drawable/image_normal.xml) · [image_pressed.xml](app/src/main/res/drawable/image_pressed.xml)
- 핵심: `ImageView`의 `src`에 selector를 지정하면 누르는 동안 `state_pressed="true"` 항목이 자동 적용된다.
- 시험 수정: 실제 PNG를 쓸 때 selector의 `android:drawable`을 `@drawable/파일명`으로 교체한다. 눌림 항목은 기본 항목보다 위에 둔다.
- 자주 발생하는 오류: View가 클릭 가능하지 않으면 눌림 상태가 유지되지 않으므로 `clickable="true"`를 확인한다.

검증 상태: 정적 검증 완료, 실행 미검증
