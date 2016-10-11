package com.qianfeng.activitypassdatademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyData.ss = "这是Main设置的值";
    }

    public void onClick(View view) {
//        Intent intent = new Intent(this, Main2Activity.class);//启动页面,传递数据
//        intent.putExtra("name", "亚洲舞王尼古拉斯赵四");
//        intent.putExtra("age", 19);
//        Intent intent12 = new Intent();
//        intent12.putExtras(intent);
//        startActivity(intent12);
//        Intent intent = new Intent(this, Main2Activity.class);//启动页面,传递数据
//        Intent intent12 = new Intent();
//        intent12.putExtra("name", "亚洲舞王尼古拉斯赵四");
//        intent12.putExtra("age", 19);
//        intent.putExtras(intent12);//这种方式一般用于中转数据传递,比如A启动B, B 获取到A的意图后,进行相应的操作,然后再新建一个意图,将A的意图放进去直接启动到C 页面,这样C 页面也可以拿到数据
//        startActivity(intent);
//        Intent intent = new Intent(this, Main2Activity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("name", "猴哥");
//        bundle.putString("yulu","老板,老板,有一百个面包圈吗");
//        intent.putExtras(bundle);
//        startActivity(intent);
        ///////
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("name", "猴哥");
        startActivity(intent);
    }
}
