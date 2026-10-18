// [추가 코드] 전체 복사에 필요한 패키지·import와 과제 요구를 구현한 이벤트 코드다.
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

// 출처: (Part2)Chapter02_레이아웃익히기.pdf PDF p.125-126. 페이지에는 완성 Java 소스가 없다.
public class MainActivity extends AppCompatActivity {

    // true는 위쪽에 이미지가 있다는 뜻이다. 시험: 다른 이미지를 쓰면 아래의 모든 resource 참조를 바꾼다.
    private boolean imageAtTop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 반드시 setContentView 뒤에 조회한다. XML ID를 바꾸면 여기의 R.id도 함께 바꾼다.
        final ImageView topImage = findViewById(R.id.top_image);
        final ImageView bottomImage = findViewById(R.id.bottom_image);
        Button moveButton = findViewById(R.id.move_button);

        // 시작 시 위에만 같은 샘플을 설정한다. XML 양쪽에 src를 지정하면 동시 표시 오류가 난다.
        topImage.setImageResource(R.drawable.sample_image);
        bottomImage.setImageDrawable(null);

        // 버튼 클릭 → 현재 위치의 이미지를 지움 → 반대쪽에 같은 리소스 설정 → 위치 상태 반전.
        // 기존 이미지를 먼저 비워 두 곳에 동시에 표시하지 않는다. ScrollView 자체는 계속 유지한다.
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageAtTop) {
                    topImage.setImageDrawable(null);
                    bottomImage.setImageResource(R.drawable.sample_image);
                } else {
                    bottomImage.setImageDrawable(null);
                    topImage.setImageResource(R.drawable.sample_image);
                }
                imageAtTop = !imageAtTop;
            }
        });
    }
}
