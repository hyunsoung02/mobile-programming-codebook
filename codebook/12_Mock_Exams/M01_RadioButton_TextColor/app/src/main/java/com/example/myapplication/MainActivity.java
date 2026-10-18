package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // [추가 코드] XML ID와 Java 변수를 연결한다. ID를 바꾸면 두 파일을 함께 수정한다.
        TextView titleText = findViewById(R.id.title_text);
        TextView resultText = findViewById(R.id.result_text);
        RadioGroup colorGroup = findViewById(R.id.color_group);
        Button applyButton = findViewById(R.id.apply_button);

        // RadioButton을 누르는 동안에는 바꾸지 않고, 적용 버튼을 눌렀을 때만 색상을 반영한다.
        applyButton.setOnClickListener(view -> {
            int checkedId = colorGroup.getCheckedRadioButtonId();
            int selectedColor = Color.RED;
            String selectedColorName = "빨간색";

            // 시험에서 색상이나 선택지가 바뀌면 ID, Color 값, 안내 문구를 함께 수정한다.
            if (checkedId == R.id.blue_radio) {
                selectedColor = Color.BLUE;
                selectedColorName = "파란색";
            } else if (checkedId == R.id.green_radio) {
                selectedColor = Color.GREEN;
                selectedColorName = "초록색";
            }

            titleText.setTextColor(selectedColor);
            resultText.setTextColor(selectedColor);
            Toast.makeText(
                    MainActivity.this,
                    selectedColorName + "이 적용되었습니다.",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
