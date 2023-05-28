package com.example.a2025123051ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView show;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ACTIVITY 作为监听器
        show = (TextView) findViewById(R.id.show);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        //内部类作为监听器
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new btn2Listener() {
        });

        //使用匿名内部类作为监听器
        btn3 = (Button) findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setText("这是匿名内部类作为监听器");
            }
        });

        //lambda表达式
        findViewById(R.id.btn4).setOnClickListener(view -> {
            show.setText("这是lambda方式");
        });
        //用外部类作为监听器
        btn5 = findViewById(R.id.btn5);

        btn5.setOnClickListener(new externalListener(show));

        //显示系统信息
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSYSinfo();
            }
        });

        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProgessDialog();
            }
        });

    }

    @Override
    public void onClick(View view) {
        show.setText("这是ACTIVITY作为监听器");
    }

    //这是将监听器绑定标签
    public void clickHandler(View source){
        TextView show = (TextView)  findViewById(R.id.show);
        show.setText("这是将监听器绑定标签");
    }

    private class btn2Listener implements View.OnClickListener {
        public void onClick(View view) {
            show.setText("这是内部类作为监听器");
        }
    }
    public void openSYSinfo(){
        Intent intent = new Intent(this,configuration.class);
        startActivity(intent);
    }
    public void openProgessDialog(){
        Intent intent = new Intent(this,ProgressDialogTest.class);
        startActivity(intent);
    }
}