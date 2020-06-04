package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btn1, btn2, btn3, btn4;
    TextView tv1;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edt1=(EditText)findViewById(R.id.editTextTextPersonName);
        this.edt2=(EditText)findViewById(R.id.editTextTextPersonName2);

        this.btn1=(Button)findViewById(R.id.button1);
        this.btn2=(Button)findViewById(R.id.button2);
        this.btn3=(Button)findViewById(R.id.button3);
        this.btn4=(Button)findViewById(R.id.button4);

        this.tv1=(TextView)findViewById(R.id.textView);

        //덧셈
        this.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edt1.getText().toString();
                num2=edt2.getText().toString();
                result=Integer.parseInt(num1)+Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result);
            }
        });

        //뺄셈
        this.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edt1.getText().toString();
                num2=edt2.getText().toString();
                result=Integer.parseInt(num1)-Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
            }
        });

        //곱셈
        this.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edt1.getText().toString();
                num2=edt2.getText().toString();
                result=Integer.parseInt(num1)*Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
            }
        });

        //나눗셈
        this.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=edt1.getText().toString();
                num2=edt2.getText().toString();
                result=Integer.parseInt(num1)/Integer.parseInt(num2);
                tv1.setText("계산결과 : "+result.toString());
            }
        });
    }
}