# P05 — EditText, TextWatcher, Toast를 이용한 입력 처리

같은 기능이 실습과제 A04에 완성되어 있으므로 중복 코드를 만들지 않고 해당 예제를 사용한다. `TextWatcher.afterTextChanged()`에서 UTF-8 바이트 수를 계산하고 제한 초과를 `Toast`로 알린다.

- Java: [A04 MainActivity.java](../../10_Assignments/A04_SNS_Byte_Counter/app/src/main/java/com/example/myapplication/MainActivity.java)
- XML: [A04 activity_main.xml](../../10_Assignments/A04_SNS_Byte_Counter/app/src/main/res/layout/activity_main.xml)
- 핵심 메서드: `addTextChangedListener()`, `afterTextChanged()`, `Toast.makeText()`
- 시험 수정: 최대 바이트 수는 Java의 제한 상수, 안내 문구와 입력 힌트는 XML의 `android:text`·`android:hint`를 바꾼다.

검증 상태: A04 정적 검증 완료, 실행 미검증
