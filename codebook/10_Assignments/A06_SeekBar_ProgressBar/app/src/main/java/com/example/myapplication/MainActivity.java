package com.example.myapplication;

// [추가 코드] PDF는 동작 조건만 제공하므로 전체 콜백 구현과 import를 제공한다.
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part2)Chapter03_기본위젯과드로어블사용하기.pdf PDF p.172-173, 실습과제 (06).
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML ID와 Java 참조는 함께 바꾼다. layout 설정 후 조회해야 null이 되지 않는다.
        SeekBar seekBar = findViewById(R.id.seek_bar);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        EditText valueInput = findViewById(R.id.value_input);

        // [추가 코드] 리스너 등록 전 XML 초기값도 같은 값으로 표시한다.
        progressBar.setProgress(seekBar.getProgress());
        // setText(int)는 문자열 리소스 ID로 해석하므로 반드시 문자열로 변환한다.
        valueInput.setText(String.valueOf(seekBar.getProgress()));

        // p.173: 값 변경 콜백 한 곳에서 두 표시 대상을 함께 갱신한다.
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                valueInput.setText(String.valueOf(progress));
                // fromUser로 제한하지 않아 코드/상태 복원에 따른 값 변경도 동기화된다.
            }

            @Override
            public void onStartTrackingTouch(SeekBar bar) {
                // 드래그 시작 시 별도 동작은 요구하지 않는다.
            }

            @Override
            public void onStopTrackingTouch(SeekBar bar) {
                // 드래그 중 이미 갱신하므로 종료 시 재계산/타이머가 필요 없다.
            }
        });
    }
}
