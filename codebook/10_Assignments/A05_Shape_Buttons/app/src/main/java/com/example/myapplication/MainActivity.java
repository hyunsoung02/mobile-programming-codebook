package com.example.myapplication;

// [추가 코드] 과제 도식을 실행할 최소 액티비티와 필요한 import를 제공한다.
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part2)Chapter03_기본위젯과드로어블사용하기.pdf PDF p.170-171, 실습과제 (05).
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML 버튼의 background가 Drawable을 참조한다. 클릭 리스너는 필요하지 않다.
        // 시험: 화면 XML 파일명을 바꾸면 아래 R.layout 이름도 함께 바꾼다.
        setContentView(R.layout.activity_main);
    }
}
