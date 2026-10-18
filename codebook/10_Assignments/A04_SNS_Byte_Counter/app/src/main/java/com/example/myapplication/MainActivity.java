package com.example.myapplication;

// [추가 코드] 과제 페이지는 완성 코드를 싣지 않으므로 필요한 import와 이벤트 구현을 제공한다.
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.nio.charset.StandardCharsets;

// 출처: (Part2)Chapter02_레이아웃익히기.pdf PDF p.127-128, 실습과제 (04).
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 화면 생성 → ID 연결 → 입력 감시/전송 이벤트 등록 순서다.
        setContentView(R.layout.activity_main);

        // XML의 @+id와 R.id 이름은 쌍으로 바꾼다. setContentView 전에 조회하면 안 된다.
        EditText messageInput = findViewById(R.id.message_input);
        TextView byteCount = findViewById(R.id.byte_count);
        Button sendButton = findViewById(R.id.send_button);

        // [추가 코드] p.128의 '입력될 때마다 호출' 조언을 TextWatcher로 구현한다.
        messageInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 변경 전에는 계산하지 않는다.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // [추가 코드] PDF에 인코딩 지정이 없어 UTF-8을 명시적으로 선택했다.
                // length()는 바이트 수가 아니다. 교수님 기준이 달라지면 이 계산식을 바꾼다.
                int bytes = s.toString().getBytes(StandardCharsets.UTF_8).length;
                byteCount.setText(bytes + "/80 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 입력값을 다시 setText하지 않아 감시 콜백의 재귀 호출을 피한다.
            }
        });

        // p.127: 전송 버튼 클릭 → 현재 입력 내용을 Toast로 표시한다.
        // [추가 코드] 요구 동작을 실행하는 리스너이며 실제 네트워크 전송은 하지 않는다.
        sendButton.setOnClickListener(view -> Toast.makeText(
                MainActivity.this, messageInput.getText().toString(), Toast.LENGTH_SHORT).show());
        // 닫기 버튼 동작이나 80바이트 입력 제한은 p.127-128에 없으므로 추가하지 않는다.
    }
}
