// [추가 코드] 전체 복사 예제의 패키지·import·화면 연결 코드다. 과제 페이지에는 완성 소스가 없다.
package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 과제 출처: (Part2)Chapter01_안드로이드스튜디오와친숙해지기.pdf PDF p.107-108.
public class MainActivity extends AppCompatActivity {

    // Android의 생성 콜백이다. 부모 초기화 후 세 영역을 선언한 XML을 화면에 연결한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 시험: 파일명을 바꾸면 이 리소스 이름도 바꾼다. 버튼의 이벤트는 등록하지 않는다.
        setContentView(R.layout.activity_main);
    }
}
