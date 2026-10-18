# 과제 3. 두 ImageView에 같은 이미지 번갈아 표시하기

위·아래에 ScrollView와 ImageView를 한 세트씩 배치한다. 시작 시 위에만 샘플을 표시하고, 가운데 버튼을 누르면 현재 이미지를 지운 뒤 같은 리소스를 반대쪽에 표시한다. 다시 누르면 원래 위치로 돌아간다. 다른 과제와 코드·리소스를 공유하지 않는다.

출처: `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.125-126. p.125의 위·아래 영역, 각각 스크롤, 최초 위쪽 표시, 두 영역 사이 버튼 하나로 아래/위 반복 이동이라는 네 단계와 p.126의 ImageView·ScrollView 조언을 텍스트 추출과 페이지 렌더링으로 대조했다. 그림에는 화살표 두 개가 보이지만 본문이 명시한 버튼 하나를 따른다. 페이지 번호는 PDF 기준이며 완성 소스는 제시되어 있지 않다.

## 파일과 복사·실행

- `app/src/main/java/com/example/myapplication/MainActivity.java`: 화면 연결, XML ID 조회, 최초 위쪽 표시, 클릭마다 이미지 위치 반전의 전체 Java 파일.
- `app/src/main/res/layout/activity_main.xml`: ScrollView/ImageView 두 세트와 가운데 Button의 전체 XML.
- `app/src/main/res/drawable/sample_image.xml`: 자체 작성한 파랑→노랑 세로 그라데이션 샘플 이미지의 전체 Drawable XML.

이 폴더는 복사용 예제이며 Gradle·Manifest를 갖춘 독립 빌드 프로젝트는 아니다.

1. Java/XML Views 연습 프로젝트 사본에 세 파일을 같은 상대 경로로 복사한다. Drawable도 빠짐없이 복사해야 `R.drawable.sample_image`가 생성된다.
2. 패키지·`namespace`를 `com.example.myapplication`로 맞추고 기존 AppCompat 의존성과 AppCompat 계열 테마를 확인한다. 루트는 플랫폼 LinearLayout이므로 ConstraintLayout 의존성이나 `app` 네임스페이스는 이 과제에 필요 없다. AppCompatActivity의 AndroidX 사용은 기존 코드북 프로젝트에 맞춘 선택이다.
3. Manifest에 `.MainActivity`를 `MAIN`/`LAUNCHER`, `android:exported="true"`로 등록한다. 네트워크·저장소 권한은 필요 없다.
4. 빌드·실행 후 위쪽에만 이미지가 보이는지 확인한다. 버튼을 1회 누르면 아래쪽만, 2회면 위쪽만 보여야 한다. 표시된 영역을 세로로 드래그해 스크롤을 확인한다. 샘플 높이가 720dp이므로 각 영역이 이보다 작을 때 스크롤된다.

## 수정 방법과 흔한 오류

- 이벤트 흐름은 `onCreate` → XML 연결 → `findViewById` → 최초 위쪽 이미지 → 버튼 클릭 콜백 → 기존 뷰 비우기 → 반대 뷰에 동일 리소스 → `imageAtTop` 반전이다. 두 곳에 동시에 나타나면 XML의 `android:src`와 기존 뷰를 비우는 `setImageDrawable(null)`을 확인한다.
- XML의 `top_image`·`bottom_image`·`move_button`을 바꾸면 Java의 같은 `R.id`도 바꾼다. `findViewById`를 `setContentView` 전에 호출하면 뷰를 찾지 못한다. `top_scroll`·`bottom_scroll`은 Java에서 조회하지 않는다.
- 이미지를 바꾸려면 Java의 모든 `R.drawable.sample_image` 참조를 같은 새 리소스로 바꾼다. 서로 다른 이미지를 넣는 것은 과제 요구와 다르다. 현재 `fitXY`는 지정 크기로 늘리므로 사진을 쓰면 비율 유지 방식과 높이도 함께 조정한다.
- 각 ScrollView는 직접 자식이 하나다. 추가 뷰를 같은 ScrollView 안에 바로 나란히 넣으면 안 된다. 두 ImageView 높이가 스크롤 영역보다 작으면 스크롤되지 않는다. 두 높이 `720dp`와 Drawable의 고유 크기는 샘플용 구체값이므로 시험 조건에 맞춰 바꾼다.
- `layout_height="0dp"`와 같은 `layout_weight="1"`이 버튼을 제외한 세로 공간을 반씩 나눈다. 영역 비율은 weight에서, 버튼 문구는 `android:text`에서 바꾼다. 레이아웃 파일명은 Java의 `R.layout.activity_main`과 함께 수정한다.
- 화면 회전 등으로 Activity가 다시 생성되면 최초 조건대로 위쪽 표시로 돌아간다. 위치·스크롤 상태를 별도 저장하는 기능은 과제 범위에 포함하지 않았다. 빈 영역도 ImageView 크기를 유지하며 ScrollView마다 기존 스크롤 위치를 따로 가진다.

## 추가·호환 코드와 검증

`[추가 코드]`: 전체 복사를 위한 package·import·AppCompatActivity·생성 콜백·ID 조회, 과제 요구를 구현한 위치 boolean·클릭 리스너·이미지 지우기/설정, 전체 XML의 선언·ID·문구·크기·weight·접근성 설명·한국어 학습 주석을 작성했다. 페이지가 완성 코드를 제공하지 않으므로 요구 동작의 구현 선택을 명시한 것이다.

`[추가 코드] sample_image.xml`: 외부 이미지의 저작권·다운로드·바이너리 복사를 요구하지 않도록 자체 Shape Drawable을 넣었다. 이는 강의 사진을 재현한 것이 아니며, 동일 이미지 이동과 세로 스크롤을 확인하기 위한 최소 샘플이다. Drawable 문법은 이 과제 페이지에서 제시한 코드가 아니다. 720dp·색·scaleType은 샘플을 보이게 하는 구체값이다.

`[호환성 수정]`: 없음. 실제 SDK 호환 문제를 수정했다고 표시할 부분은 없다.

상태: **미검증**. `xmllint` 문법, Java/XML ID·Drawable 연결, ScrollView 직접 자식 수, 최초 한 곳 표시와 클릭 분기의 제거→설정 순서·동일 리소스 사용을 정적 self-check했다. Android 빌드와 에뮬레이터·실기기 실행은 하지 않았다. 실제 스크롤·기기별 화면 배치·이미지 표시 결과는 실행으로 확인해야 한다.
