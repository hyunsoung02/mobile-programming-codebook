# 레이아웃

[코드북 홈](../README.md) · [전체 작성 상태](../CODEBOOK_PLAN.md)

화면 배치 방식과 동적 레이아웃, 뷰 중첩·전환·스크롤을 학습하는 분류다. 담당 기능은 22개다. 아래 한 행을 한 독립 예제 단위로 삼으며, 구현에 필요한 기본 UI만 포함한다. 공통적인 화면 연결 코드는 의존 코드로 설명하고 새 기능 구현으로 중복 집계하지 않는다.

| 기능 ID | 기능명 | PPT 출처 | 독립 예제 단위 |
|---|---|---|---|
| F016 | ConstraintLayout 기본 앵커 연결 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.51-64, 90-92 | ConstraintLayout 기본 앵커 연결만 구현하는 별도 예제 예정 |
| F017 | 네 방향 제약으로 중앙 배치 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.61-67 | 네 방향 제약으로 중앙 배치만 구현하는 별도 예제 예정 |
| F018 | 제약 바이어스 조절 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.68-72 | 제약 바이어스 조절만 구현하는 별도 예제 예정 |
| F019 | 제약 대상에 따른 가변 크기 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.73-76 | 제약 대상에 따른 가변 크기만 구현하는 별도 예제 예정 |
| F020 | Guideline 배치 | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.78-86, 93-95 | Guideline 배치만 구현하는 별도 예제 예정 |
| F023 | LinearLayout 방향 배치 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.10-11, 16-26, 31 | [LinearLayout의 수직·수평 방향 비교](F023_LinearLayout_Orientation/README.md) · 작성 완료 · 미검증 |
| F030 | 가중치로 공간 분할 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.68-78 | 가중치로 공간 분할만 구현하는 별도 예제 예정 |
| F031 | Java로 LinearLayout 생성 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.27-39 | Java로 LinearLayout 생성만 구현하는 별도 예제 예정 |
| F032 | Java로 자식 View 생성·추가 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.29-39 | Java로 자식 View 생성·추가만 구현하는 별도 예제 예정 |
| F033 | Context 전달 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.28-30 | Context 전달만 구현하는 별도 예제 예정 |
| F034 | RelativeLayout의 부모 기준 배치 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.79-89 | RelativeLayout의 부모 기준 배치만 구현하는 별도 예제 예정 |
| F035 | RelativeLayout의 다른 뷰 기준 배치 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.80-90 | RelativeLayout의 다른 뷰 기준 배치만 구현하는 별도 예제 예정 |
| F036 | 상대 배치로 상·중·하 영역 구성 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.82-88 | 상대 배치로 상·중·하 영역 구성만 구현하는 별도 예제 예정 |
| F037 | TableLayout 행·열 구성 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.92-96 | TableLayout 행·열 구성만 구현하는 별도 예제 예정 |
| F038 | 테이블 열 자동 확장·축소 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.97-99 | 테이블 열 자동 확장·축소만 구현하는 별도 예제 예정 |
| F039 | 테이블 열 위치·병합 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.100-102 | 테이블 열 위치·병합만 구현하는 별도 예제 예정 |
| F040 | FrameLayout 중첩 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.103-107 | FrameLayout 중첩만 구현하는 별도 예제 예정 |
| F041 | 가시성으로 뷰 전환 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.103-114 | 가시성으로 뷰 전환만 구현하는 별도 예제 예정 |
| F042 | 수직 스크롤 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.115-124 | 수직 스크롤만 구현하는 별도 예제 예정 |
| F043 | 수평·수직 동시 스크롤 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.116-124 | 수평·수직 동시 스크롤만 구현하는 별도 예제 예정 |
| F044 | 코드에서 드로어블 이미지 로드 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.118-121 | 코드에서 드로어블 이미지 로드만 구현하는 별도 예제 예정 |
| F045 | 원본 이미지 크기로 View 조정 | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.118-121 | 원본 이미지 크기로 View 조정만 구현하는 별도 예제 예정 |

각 예제는 필요한 전체 Java/XML, Drawable 및 실행 방법을 함께 제공한다. 시험 조건이 바뀌면 수정할 ID·변수·메서드·속성을 한국어 주석과 예제 README에 적는다. PPT 외 코드는 `[추가 코드]`, SDK 대응 변경은 `[호환성 수정]`으로 이유를 표시한다. 실제 작성 여부와 검증 상태는 [원장](../CODEBOOK_PLAN.md)에서 관리한다.

