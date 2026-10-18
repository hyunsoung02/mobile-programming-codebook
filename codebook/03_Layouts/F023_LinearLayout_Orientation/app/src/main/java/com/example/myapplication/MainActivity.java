// [추가 코드] 현재 프로젝트의 namespace와 Java 소스 경로에 맞춘 패키지 선언이다.
package com.example.myapplication;

// [추가 코드] 강의에서 생략된 선언을 보완하여 전체 파일로 복사할 수 있도록 한다.
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 화면 연결 출처: (Part1)Chapter03_첫번째앱만들기.pdf PDF p.20-24, 54 (F001).
// 방향 배치 출처: (Part2)Chapter02_레이아웃익히기.pdf PDF p.16-26. 배치는 XML에서 설정한다.
public class MainActivity extends AppCompatActivity {

    // [추가 코드] 한국어 주석은 동작 이해와 시험 조건 변경 지점을 안내한다.
    // 액티비티 생성 시 호출된다. 시험에서도 onCreate의 이름과 서명은 유지한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 부모 클래스의 초기화를 먼저 수행한다. 매개변수 이름을 바꾸면 인수도 맞춘다.
        super.onCreate(savedInstanceState);

        // res/layout/activity_main.xml을 표시한다. 방향 속성은 해당 XML에서 바꾼다.
        // 시험: XML 파일명을 바꾸면 R.layout.activity_main의 리소스 이름도 함께 수정한다.
        setContentView(R.layout.activity_main);
    }
}
