package com.example.myapplication;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // [추가 코드] XML 없이 화면을 만들기 위해 컨테이너를 Java에서 직접 생성한다.
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL); // 시험에서 가로 배치이면 HORIZONTAL로 변경한다.

        int padding = (int) (24 * getResources().getDisplayMetrics().density);
        layout.setPadding(padding, padding, padding, padding);

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        Button firstButton = new Button(this);
        firstButton.setText("첫 번째 버튼");
        layout.addView(firstButton, buttonParams);

        Button secondButton = new Button(this);
        secondButton.setText("두 번째 버튼");
        layout.addView(secondButton, buttonParams);

        Button thirdButton = new Button(this);
        thirdButton.setText("세 번째 버튼");
        layout.addView(thirdButton, buttonParams);

        // 생성한 최상위 LinearLayout을 Activity의 화면으로 지정해야 보인다.
        setContentView(layout);
    }
}
