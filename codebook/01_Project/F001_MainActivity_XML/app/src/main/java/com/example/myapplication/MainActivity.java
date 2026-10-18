// [추가 코드] 강의 화면의 패키지를 현재 프로젝트의 namespace와 소스 경로에 맞춘다.
package com.example.myapplication;

// [추가 코드] 강의 화면에서 접힌 import를 전체 파일로 복사할 수 있도록 명시한다.
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part1)Chapter03_첫번째앱만들기.pdf PDF p.20-24, 54.
public class MainActivity extends AppCompatActivity {

    // [추가 코드] 아래 한국어 주석은 동작 이해와 시험 조건 변경을 위한 설명이다.
    // 액티비티가 생성될 때 Android가 호출한다. 이 예제에서는 main 메서드를 직접 작성하지 않는다.
    // 시험: 콜백 이름과 서명은 유지한다. 매개변수 이름을 바꾸면 아래 인수도 같이 바꾼다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 부모 클래스의 생성 처리를 먼저 수행한다. savedInstanceState는 복원할 상태이며 null일 수 있다.
        super.onCreate(savedInstanceState);

        // res/layout/activity_main.xml을 읽어 이 액티비티가 보여 줄 화면으로 설정한다.
        // 시험: XML 파일명을 바꾸면 activity_main도 새 파일명으로 수정한다(.xml 제외).
        setContentView(R.layout.activity_main);
    }
}
