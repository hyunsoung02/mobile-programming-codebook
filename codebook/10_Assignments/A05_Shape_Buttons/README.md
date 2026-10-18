# A05 두 종류의 Shape 버튼

[과제 목록](../README.md) · [요구사항 전문](../../../ASSIGNMENTS.md)

투명한 내부·동일 색 테두리/글자를 가진 버튼과, 채운 배경·약간 둥근 모서리·흰 글자를 가진 버튼을 각각 Shape Drawable로 표시한다. 클릭 이벤트는 포함하지 않는 과제 5 독립 예제다.

상태: **미검증**. XML 문법, Drawable 연결과 요구사항을 정적으로 확인했다. Android 빌드와 에뮬레이터·실기기 실행은 수행하지 않았다.

## 출처

- `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.170: 서로 다른 두 버튼, 첫 버튼의 테두리와 같은 글자색, 둘째 버튼의 배경·둥근 모서리·흰 글자 조건과 그림.
- 같은 PDF p.171: Drawable 객체를 버튼 배경으로 설정하고 Drawable XML에서 모양을 결정한다는 교수님 조언.
- 두 페이지를 `pdftotext -layout` 추출과 `pdftoppm` PNG 렌더로 대조했다. 이미지로 들어간 상세 조건도 확인했으며 페이지 번호는 PDF 기준이다. 과제 페이지에 완성 Java/XML 코드가 있는 것으로 취급하지 않았다.

## 파일과 연결

| 파일 | 역할 |
|---|---|
| `app/src/main/java/com/example/myapplication/MainActivity.java` | `setContentView`로 화면 표시 |
| `app/src/main/res/layout/activity_main.xml` | 위/아래 버튼 배치, 배경 리소스·글자색 연결 |
| `app/src/main/res/drawable/button_outline.xml` | 투명 `solid`, 색상 테두리 `stroke` |
| `app/src/main/res/drawable/button_filled.xml` | 채운 `solid`, 작은 반경 `corners` |

`MainActivity` → `R.layout.activity_main` → 각 버튼의 `android:background` → 해당 Drawable 순서로 연결된다. ID는 `outline_button`/`filled_button`이며 Java 이벤트 연결에는 사용하지 않는다. `solid`가 배경색, `stroke`가 테두리, `corners`가 모서리 반경을 지정한다.

## 복사·실행

1. AppCompat 의존성과 AppCompat/Material 계열 테마가 있는 Java/XML 연습용 프로젝트를 준비한다. 이 폴더는 Gradle/Manifest가 없는 전체 파일 복사 예제다.
2. 위 네 파일을 연습용 프로젝트의 같은 상대 경로로 복사한다. 두 Drawable을 모두 복사해야 리소스 참조가 연결된다. 다른 과제의 화면과 합치지 않는다.
3. 패키지/`namespace`는 `com.example.myapplication`, Manifest 시작 액티비티는 `.MainActivity`로 맞춘다. 기존 `MAIN`/`LAUNCHER`와 `android:exported="true"` 등록을 사용할 수 있다. 권한은 추가하지 않는다.
4. 빌드·실행 후 첫 버튼은 투명 내부와 주황 테두리/글자, 둘째는 주황 배경·작게 둥근 모서리·흰 글자로 보이는지 확인한다. 아직 이 결과를 기기에서 확인하지 않았다.

실행 프로젝트가 edge-to-edge를 강제하면 루트 `main`의 padding/insets를 환경에 맞게 별도로 적용한다. 이 예제는 시스템 바 보정을 포함하지 않는다.

## 시험 수정 지점과 흔한 오류

- 첫 버튼 색: `button_outline.xml`의 `stroke color`와 `activity_main.xml`의 첫 버튼 `textColor`를 같은 값으로 바꾼다. 내부가 없어야 하므로 `solid`의 `#00000000`(완전 투명)을 유지한다.
- 둘째 배경/모서리: `button_filled.xml`의 `solid color`, `corners radius`를 수정한다. 둘째 글자색은 버튼의 `textColor="#FFFFFF"`로 별도 지정한다.
- 크기/간격: 레이아웃의 두 버튼 `layout_width`, `layout_height`, 둘째 `layout_marginTop`을 수정한다. 윤곽 두께는 첫 Drawable의 `stroke width`다.
- Drawable 파일명을 바꾸면 `android:background="@drawable/..."`도 함께 바꾼다. 리소스 참조에는 `.xml`을 붙이지 않는다. `background`와 `textColor` 역할을 혼동하지 않는다.
- 클릭 이벤트나 선택/눌림 상태별 색 전환은 과제에 없으므로 추가하지 않는다.

## 추가·호환 내역

- `[추가 코드]`: PDF 조건을 실행하는 최소 AppCompatActivity, 전체 레이아웃/Shape XML, 리소스 이름과 ID를 작성했다. `#E65100`, 테두리 `2dp`, 반경 `6dp`, 크기 `160dp × 52dp`, 간격 `24dp`는 조건을 구현하는 선택값이며 PDF가 정확한 수치를 지정한 것은 아니다.
- `[호환성 수정]`: 현재 원본 프로젝트의 테마가 `Theme.Material3.DayNight.NoActionBar`이므로 일반 `<Button>`이 테마 inflater에 의해 MaterialButton으로 대체되거나 배경 tint가 Shape 색을 덮을 수 있다. 명시적 `<android.widget.Button>`으로 플랫폼 클래스를 사용하고 `android:backgroundTint="@null"`로 배경 tint를 해제했다. 두 설정은 Shape 파일의 색과 모양을 그대로 표시하기 위한 것이며 클릭 동작을 추가하지 않는다. 실제 테마별 결과는 실행 미검증이다.
- 한국어 주석은 XML 속성·파일 연결과 시험 수정 지점을 설명한다. 추가 라이브러리·권한·클릭 리스너는 없다.

정적 검사는 리소스 구조만 확인한다. 남은 확인은 사용 테마에서 두 Shape가 의도한 색/모서리로 실제 표시되는지와 시스템 바 겹침 여부다.
