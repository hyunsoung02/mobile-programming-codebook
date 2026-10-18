package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(view -> finish()); // 현재 Activity를 종료해 이전 화면으로 돌아간다.
    }
}
