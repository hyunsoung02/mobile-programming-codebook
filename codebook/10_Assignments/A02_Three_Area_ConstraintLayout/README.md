# 과제 2. 위·아래·중앙 영역 채우기

ConstraintLayout과 Button 3개만으로 화면을 구성한다. 상단·하단 버튼은 가로 전체를 차지하며, 중앙 버튼은 두 버튼 사이의 남은 공간을 채운다. 클릭 이벤트는 없고 다른 과제와 파일을 공유하지 않는다.

출처: `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.107-108. p.107의 세 영역 그림·네 단계, p.108의 상단/하단과 부모 연결 및 중앙 버튼의 위·아래 연결 조언을 텍스트 추출과 페이지 렌더링으로 대조했다. 페이지 번호는 PDF 기준이다. 완성 소스가 제시된 페이지가 아니므로 아래 코드는 요구사항의 독립 구현이다.

## 파일과 복사·실행

- `app/src/main/java/com/example/myapplication/MainActivity.java`: 생성 콜백에서 레이아웃을 연결하는 전체 Java 파일.
- `app/src/main/res/layout/activity_main.xml`: 세 Button의 크기와 부모·형제 제약을 선언하는 전체 XML.

이 폴더는 Gradle·Manifest 없는 복사용 예제다.

1. Java/XML Views 연습 프로젝트 사본에 두 파일을 같은 상대 경로로 복사한다. 패키지와 `namespace`는 `com.example.myapplication`로 맞춘다.
2. 기존 프로젝트에 AppCompat와 AndroidX ConstraintLayout 의존성, AppCompat 계열 테마가 있는지 확인한다. 별도 기능 라이브러리나 권한은 필요 없다.
3. Manifest의 `.MainActivity` 시작 액티비티에 `MAIN`/`LAUNCHER`와 `android:exported="true"`를 확인한다.
4. Android Studio에서 빌드·실행한다. 예상 화면은 위쪽 버튼, 넓은 가운데 버튼, 아래쪽 버튼이다. 각 버튼의 뷰 경계가 콘텐츠 영역 가로 전체를 채우며 버튼 배경의 내부 inset·모양은 테마에 따라 다를 수 있다. 시스템 바 영역은 호스트 프로젝트 설정을 따른다.

## 수정 방법과 흔한 오류

- 세 버튼의 가로 `0dp`와 부모 start/end 제약을 함께 유지한다. ConstraintLayout의 `0dp`는 제약 사이 크기를 채우라는 의미다.
- 중앙의 `layout_height="0dp"`, `Top_toBottomOf="@id/top_button"`, `Bottom_toTopOf="@id/bottom_button"`이 남은 세로 공간을 채운다. `wrap_content`로 바꾸면 내용 높이로 줄고, 연결 대상을 반대로 쓰면 겹치거나 영역이 잘못 계산된다.
- 상단·하단 높이는 각각 `layout_height`에서 바꾼다. 중앙 높이를 직접 고정하면 남은 공간을 채우라는 요구에서 벗어난다.
- ID `top_button`·`bottom_button`을 바꾸면 중앙 제약의 참조도 바꾼다. Java는 ID를 직접 조회하지 않는다. 문구는 `android:text`, 파일명은 Java의 `R.layout.activity_main`과 함께 수정한다.
- `androidx.constraintlayout.widget.ConstraintLayout`은 AndroidX 라이브러리다. `xmlns:app="http://schemas.android.com/apk/res-auto"`와 `app:layout_constraint...`는 라이브러리 제약 속성을 선언한다. 의존성 누락·잘못된 네임스페이스는 리소스 오류의 원인이다.

## 추가·호환 코드와 검증

`[추가 코드]`: 완성 파일을 위한 package·import·AppCompatActivity·onCreate·setContentView, XML 선언·네임스페이스·필수 크기, ID·문구·한국어 학습 주석을 보완했다. XML의 제약 연결과 `0dp` 크기는 과제의 배치 요구를 코드화했다. AndroidX 패키지는 코드북의 기존 프로젝트 방식에 맞춘 선택이며 지정 페이지에서 패키지를 인용한 것은 아니다.

`[호환성 수정]`: 없음. 실제 SDK 호환 수정 없이 배치 요구만 구현했다.

상태: **미검증**. `xmllint` 문법 및 세 버튼의 양쪽 부모 제약·중앙 상하 연결·ID·패키지·이벤트 없음의 정적 self-check만 수행했다. Android 빌드와 에뮬레이터·실기기 실행은 하지 않았다. 실제 테마별 배경 모양과 시스템 바 배치는 실행 확인이 필요하다.
