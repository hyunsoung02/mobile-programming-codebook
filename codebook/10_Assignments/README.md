# 교수님 실습과제

[코드북 홈](../README.md) · [전체 기능 원장](../CODEBOOK_PLAN.md) · [과제 요구사항 전문](../../ASSIGNMENTS.md)

이 폴더는 교수님이 요구한 복합 화면 6개를 과제별 독립 예제로 제공한다. 기능 분류의 기존 ID를 교차 참조하며 새로운 기능 ID를 만들거나 85개 집계에 더하지 않는다. 여섯 과제는 모두 `작성 완료 · 미검증`이다.

| 과제 | 독립 예제 단위 | 관련 기능 ID와 문서 | PPT 출처 | 상태 |
|---|---|---|---|---|
| [1. 화면 아래쪽에 두 개의 버튼 추가하기](A01_Guideline_Two_Buttons/README.md) | ConstraintLayout의 하단 Guideline 위에 Button 2개 연결 | F005: [위젯](../04_Widgets/README.md), F016·F020: [레이아웃](../03_Layouts/README.md) | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.105-106 | 작성 완료 · 미검증 |
| [2. 위, 아래, 중앙의 공간을 차지하는 전형적인 화면 구성하기](A02_Three_Area_ConstraintLayout/README.md) | Button 3개의 제약 관계로 상단·중앙·하단 공간 채우기 | F005: [위젯](../04_Widgets/README.md), F016-F019: [레이아웃](../03_Layouts/README.md) | `(Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf` PDF p.107-108 | 작성 완료 · 미검증 |
| [3. 두 개의 이미지뷰에 이미지 번갈아 보여주기](A03_Toggle_ImageViews/README.md) | ScrollView/ImageView 두 세트 사이에서 버튼으로 같은 이미지 위치 전환 | F041-F045: [레이아웃](../03_Layouts/README.md), F055: [위젯](../04_Widgets/README.md) | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.125-126 | 작성 완료 · 미검증 |
| [4. SNS 입력 화면 만들고 글자의 수 표시하기](A04_SNS_Byte_Counter/README.md) | EditText 입력 변화, 80바이트 표시와 전송 Toast | F046-F050·F054·F059·F063-F064: [위젯](../04_Widgets/README.md), F008: [사용자 알림](../07_User_Feedback/README.md) | `(Part2)Chapter02_레이아웃익히기.pdf` PDF p.127-128 | 작성 완료 · 미검증 |
| [5. 두 종류의 버튼 모양 만들기](A05_Shape_Buttons/README.md) | 테두리 버튼과 채운 둥근 버튼의 Shape Drawable 비교 | F065·F067-F070: [드로어블](../05_Drawables/README.md) | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.170-171 | 작성 완료 · 미검증 |
| [6. 시크바와 프로그레스바 보여주기](A06_SeekBar_ProgressBar/README.md) | SeekBar 콜백의 현재 값을 수평 ProgressBar와 입력상자에 동기화 | F054: [위젯](../04_Widgets/README.md), F083: [진행 상태](../08_Progress/README.md), 과제 전용 SeekBar 콜백 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.172-173 | 작성 완료 · 미검증 |

과제 4는 PDF p.127의 `입력상자 아래·오른쪽` 바이트 표시와 p.128 조언의 `화면에서 가장 위쪽` 배치가 충돌한다. 또한 자료는 `80 바이트`의 계산 알고리즘을 명시하지 않는다. 구현 시 출제 화면 또는 교수님의 최신 지시를 확인하고 선택 근거를 예제 README에 기록한다. 단순 문자 수나 특정 인코딩을 임의로 정답으로 확정하지 않는다.

각 과제에는 필요한 전체 Java/XML·Drawable·실행 방법과 시험 조건 변경 지점을 제공한다. 요구된 기능 조합만 구현하며, 예를 들어 과제 4에 실제 SNS 통신을 추가하거나 과제 6에 자동 증가 타이머를 추가하지 않는다. PPT 외 코드는 `[추가 코드]`, 최신 SDK 대응 변경은 `[호환성 수정]`과 이유를 기록한다. 실제 빌드 또는 에뮬레이터 실행 전까지 검증 상태는 `미검증`이다.
