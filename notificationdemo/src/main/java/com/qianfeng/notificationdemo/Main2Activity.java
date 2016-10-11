package com.qianfeng.notificationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String time = intent.getStringExtra("time");
        Log.e("自定义标签", "类名==Main2Activity" + "方法名==onCreate=====:" + time);
    }
}
