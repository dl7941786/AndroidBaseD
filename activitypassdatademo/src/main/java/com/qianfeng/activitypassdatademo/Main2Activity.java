package com.qianfeng.activitypassdatademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView startInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        startInfo = (TextView) findViewById(R.id.startinfo);
        Intent intent = getIntent();//获取启动这个 activity的 intent, 一定不为空,只要这个 activity能被启动,一定有一个不为空的意图Intent
//        String name = intent.getStringExtra("name");
//        String yulu = intent.getStringExtra("yulu");
//        String name2 = intent.getStringExtra("name2");//如果传递的是引用类型数据,获取后如果要使用的话记住最好判空
//        int age = intent.getIntExtra("age", -1);// 默认值的作用,如果找不到这个属性,就赋值为默认值
//        int banji = intent.getIntExtra("banji", -1);
//        startInfo.setText("name="+name+"---age=="+age+"---banji=="+banji+"====name2=="+name2+"--yulu"+yulu);
//        String s = MyData.ss;
//        Log.e("自定义标签", "类名==Main2Activity" + "方法名==onCreate=====:" + s);
        Bundle extras = intent.getExtras();//注意,老版本需要判空,新版本系统内部判断了,没有的话返回一个空白的
        String name = extras.getString("name");
        startInfo.setText(name);
    }
}
