// [추가 코드] 생략된 파일 구성을 보완하고 연습 프로젝트의 namespace·경로에 맞춘다.
package com.example.myapplication;

// [추가 코드] 전체 Java 파일을 복사할 수 있도록 필요한 import를 명시한다.
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part2)Chapter02_레이아웃익히기.pdf PDF p.109-111, 120의 ID 조회 원리.
// [추가 코드] 강의의 ImageView 조회를 TextView 한 개로 축소했다. 아래 한국어 주석은 학습용 보완이다.
public class MainActivity extends AppCompatActivity {

    // [추가 코드] XML에서 찾은 TextView 객체의 참조를 보관한다. 새 View를 생성하지 않는다.
    // 시험: 변수명은 ID와 독립이다. 변수명을 바꾸면 아래 대입문의 왼쪽도 함께 바꾼다.
    TextView textView;

    // Android가 액티비티를 생성할 때 호출한다. 시험에서도 onCreate 이름과 서명은 유지한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 부모 액티비티의 생성 처리를 먼저 수행한다.
        super.onCreate(savedInstanceState);

        // p.109: 레이아웃을 먼저 화면에 연결해야 그 안의 View를 ID로 찾을 수 있다.
        // 시험: XML 파일명을 바꾸면 activity_main을 새 파일명으로 맞춘다(.xml 제외).
        setContentView(R.layout.activity_main);

        // [추가 코드] p.109의 조회 패턴을 TextView에 적용한다. p.111의 @+id/이름과 R.id.이름은 같은 ID다.
        // 시험: XML의 @+id/textView를 바꾸면 아래 R.id.textView도 대소문자까지 맞춘다.
        // 오류: 현재 화면에 해당 ID가 없으면 null일 수 있다. android.R를 import하지 않는다.
        // 확인: 중단점을 걸고 이 줄을 실행한 다음 textView 필드가 null이 아닌지 디버거로 본다.
        textView = findViewById(R.id.textView);
    }
}
