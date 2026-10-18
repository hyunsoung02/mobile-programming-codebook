# P07 — 여러 Activity 등록 및 화면 전환

- 사용 기능: `Intent`, `startActivity()`, `finish()`, `<activity>` 등록
- Java: [MainActivity.java](app/src/main/java/com/example/myapplication/MainActivity.java) · [SecondActivity.java](app/src/main/java/com/example/myapplication/SecondActivity.java)
- XML: [activity_main.xml](app/src/main/res/layout/activity_main.xml) · [activity_second.xml](app/src/main/res/layout/activity_second.xml)
- 설정: [AndroidManifest.xml](app/src/main/AndroidManifest.xml)
- 동작: 시작 Activity의 버튼 → `Intent`로 두 번째 Activity 실행 → 돌아가기 버튼에서 `finish()`.
- 시험 수정: 이동 대상이 바뀌면 `new Intent(MainActivity.this, SecondActivity.class)`의 클래스와 Manifest의 `<activity android:name>`을 함께 바꾼다.
- 시작 Activity 설정: 실행할 Activity에 `MAIN`/`LAUNCHER` intent-filter를 두고 Android 12 이상에서는 `android:exported="true"`를 지정한다.
- 자주 발생하는 오류: 새 Activity를 Manifest에 등록하지 않으면 실행 시 `ActivityNotFoundException`이 발생한다.

검증 상태: 정적 검증 완료, 실행 미검증
