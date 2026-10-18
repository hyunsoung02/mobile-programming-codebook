// [추가 코드] 강의에서 생략된 패키지를 현재 프로젝트의 namespace와 소스 경로에 맞춘다.
package com.example.myapplication;

// [추가 코드] 전체 Java 파일로 복사할 수 있도록 필요한 import를 명시한다.
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part1)Chapter03_첫번째앱만들기.pdf PDF p.35-40, 특히 p.37의 전체 동작 흐름.
public class MainActivity extends AppCompatActivity {

    // [추가 코드] 한국어 주석은 동작 이해와 시험 조건 변경을 위한 학습 설명이다.
    // Android가 액티비티 생성 시 호출한다. 시험에서도 onCreate 이름과 서명은 유지한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 부모 클래스의 생성 처리를 먼저 수행한다.
        super.onCreate(savedInstanceState);
        // activity_main.xml을 화면으로 사용한다.
        // 시험: XML 파일명을 바꾸면 activity_main도 새 이름으로 바꾼다(.xml 제외).
        setContentView(R.layout.activity_main);
    }

    // XML android:onClick="onButtonClicked"가 이 공개 메서드를 찾아 호출한다.
    // 시험: 이름을 바꾸면 XML 속성값도 대소문자까지 함께 바꾼다.
    // public, void, View 매개변수 한 개는 유지한다. v에는 클릭된 버튼이 전달된다.
    // 매개변수명 v만 바꾸는 경우에는 XML을 바꾸지 않아도 된다.
    public void onButtonClicked(View v) {
        // this는 현재 액티비티의 Context다. 두 번째 인수는 메시지, 세 번째는 표시 기간이다.
        // 시험: 메시지는 아래 문자열, 짧은 표시 조건은 LENGTH_SHORT로 수정한다.
        // makeText로 만든 Toast에 show()를 호출해야 화면에 표시된다.
        Toast.makeText(this, "확인1 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
    }
}
