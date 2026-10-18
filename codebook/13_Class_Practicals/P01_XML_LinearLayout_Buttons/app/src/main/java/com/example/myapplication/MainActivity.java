package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // XML에 정의한 세로 LinearLayout과 버튼 3개를 현재 화면으로 연결한다.
        setContentView(R.layout.activity_main);
    }
}
