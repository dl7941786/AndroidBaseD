package com.qianfeng.startactivityforrsultdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv;
    private int sum;
    private int n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();//获取启动这个页面的意图
        int n1 = intent.getIntExtra("n1", -1);
        int n2 =  intent.getIntExtra("n2", -1);
        //计算和
        sum = n1 + n2;
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(sum + "");

    }

    public void onClick2(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", sum);
        setResult(RESULT_OK, resultIntent);//设置返回的数据
       //setResult(RESULT_OK); 不携带数据返回
        finish();//关闭当前 activity
    }
}
