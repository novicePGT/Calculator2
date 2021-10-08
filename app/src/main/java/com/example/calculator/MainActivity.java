package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2; // EditText를 전역변수로 선언
    Button button1, button2, button3, button4; // Button을 전역변수로 선언
    TextView TextResult, TextResult2;  // TextView를 전역변수로 선언
    String num1, num2; // edit1, edit2에서 받은 변수를 저장 할 변수 선언(String으로 문자열 리턴)
    Integer result; // TextResult에서 받은 변수를 저장 할 변수 선언(Wrapper class로 데이터를 객체로 포장)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기"); // 타이틀 이름 설정

        edit1 = (EditText) findViewById(R.id.edit1); //xml에 있는 edit1 뷰를 가져오는 메소드
        edit2 = (EditText) findViewById(R.id.edit2); //xml에 있는 edit2 뷰를 가져오는 메소드

        button1 = (Button) findViewById(R.id.button1); // xml에 있는 button1 뷰를 가져오는 메소드
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        TextResult = (TextView) findViewById(R.id.TextResult); // xml에 있는 TextResult 뷰를 가져오는 메소드
        TextResult2 = (TextView) findViewById(R.id.TextResult2);

        button1.setOnTouchListener(new View.OnTouchListener() { // 이벤트리스너로 터치했을 경우 이벤트가 발생
            @Override                                         //onTouchListener은 추상메소드로 new를 사용하여 객체를 생성해야한다.
            public boolean onTouch(View arg0, MotionEvent arg1) { //boolean형으로 true or false으로 반환한다.
                num1 = edit1.getText().toString(); // edit1 박스 안 글자를 가져오라는 뜻으로 toString()이 문자열을 반환한다.
                num2 = edit2.getText().toString(); // edit1.getText() 까지 입력하면 EditTable을 반환함으로 주의.
                result = Integer.parseInt(num1) + Integer.parseInt(num2); //result를 Wrapper class로 선언해 Integer 사용
                TextResult.setText("계산 결과 : " + result.toString()); // result가 박싱되어 있으므로 .toString()사용해 객체를 가져옴
                TextResult2.setText(null); //
                return false; // 기존에 있던 기능들이 사라짐.
            }
        });

        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2); // - 연산자로 빼기연산 실행.
                TextResult.setText("계산 결과 : " + result.toString()); // 결과값을 출력하는 메소드
                TextResult2.setText(null);
                return false;
            }
        });

        button3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2); // * 연산자로 곱하기 연산 실행
                TextResult.setText("계산 결과 : " + result.toString());
                TextResult2.setText(null); // 결과값은 TextResult에 출력되기에 TextResult2는 초기화
                return false;
            }
        });

        button4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                float result = Float.parseFloat(num1) / Float.parseFloat(num2);
                // 결과값을 실숫값으로 출력 (integer는 Wrapper class int로 정수형을 나타내기 때문에 Float.parseFloat로 실수형으로 변환
                String result2 = String.format("%.2f", result); // result2 를 문자열로 불러와서 0.00자리까지 출력하는 메소드
                TextResult2.setText("계산 결과 : " + result2); // TextResult2 텍스트뷰에 나누기 값을 출력
                TextResult.setText(null); // TextResult2에 결과값을 만들었으므로 TextResult는 초기화
                return false;
            }
        });
    }
}