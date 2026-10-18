# 진행 상태

[코드북 홈](../README.md) · [전체 작성 상태](../CODEBOOK_PLAN.md)

화면 내부, 윈도우 타이틀, 대화상자의 진행 표시를 각각 학습하는 분류다. 담당 기능은 3개다. 아래 한 행을 한 독립 예제 단위로 삼으며, 구현에 필요한 기본 UI만 포함한다. 공통적인 화면 연결 코드는 의존 코드로 설명하고 새 기능 구현으로 중복 집계하지 않는다.

| 기능 ID | 기능명 | PPT 출처 | 독립 예제 단위 |
|---|---|---|---|
| F083 | 화면 내 determinate ProgressBar | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.159-161, 163-168 | 화면 내 determinate ProgressBar만 구현하는 별도 예제 예정 |
| F084 | 윈도우 타이틀 영역 ProgressBar | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.162 | 윈도우 타이틀 영역 ProgressBar만 구현하는 별도 예제 예정 |
| F085 | 대화상자형 indeterminate 진행 표시 | `(Part2)Chapter03_기본위젯과드로어블사용하기.pdf` PDF p.163-169 | 대화상자형 indeterminate 진행 표시만 구현하는 별도 예제 예정 |

각 예제는 필요한 전체 Java/XML, Drawable 및 실행 방법을 함께 제공한다. 시험 조건이 바뀌면 수정할 ID·변수·메서드·속성을 한국어 주석과 예제 README에 적는다. PPT 외 코드는 `[추가 코드]`, SDK 대응 변경은 `[호환성 수정]`으로 이유를 표시한다. 실제 작성 여부와 검증 상태는 [원장](../CODEBOOK_PLAN.md)에서 관리한다.

F084의 윈도우 타이틀 진행 표시와 F085의 ProgressDialog는 강의 방식이 포함된 레거시 API다. 구현 시 원문을 보존하고 최신 SDK 대응이 필요하면 `[호환성 수정]`으로 설명한다. SeekBar 동기화는 [과제 6](../10_Assignments/README.md)의 요구 조합으로 다룬다.

