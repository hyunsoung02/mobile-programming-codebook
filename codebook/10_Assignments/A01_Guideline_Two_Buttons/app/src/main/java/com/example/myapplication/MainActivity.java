// [추가 코드] 전체 복사 예제의 패키지·import·화면 연결 코드다. 과제 페이지에는 완성 소스가 없다.
package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 과제 출처: (Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf PDF p.105-106.
public class MainActivity extends AppCompatActivity {

    // Android가 화면을 만들 때 호출한다. 호출 이름·서명과 super 호출은 유지한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // XML의 제약 관계만으로 배치한다. 버튼 클릭 이벤트는 이 과제의 범위가 아니다.
        // 시험: 레이아웃 파일명을 바꾸면 R.layout.activity_main도 함께 바꾼다.
        setContentView(R.layout.activity_main);
    }
}
