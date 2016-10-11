package com.qianfeng.activitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private Button button;

    /**
     *
     * @param savedInstanceState 保存状态的对象,默认是 null
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("自定义标签", "onCreate() called with: " + "savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button) findViewById(R.id.button);
        if (savedInstanceState != null) {
            //需要注意,因为重走了声明周期, 界面可能会发生变化,需要自己修正界面(比如 可以滚动的控件恢复到原始的滑动位置)
            String string = savedInstanceState.getString("string");
            button.setText(string);
        }
    }


    @Override
    protected void onPause() {
        Log.e("自定义标签", "类名==Main3Activity" + "方法名==onPause=====:" + "");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("自定义标签", "类名==Main3Activity" + "方法名==onStop=====:" + "");
        super.onStop();
    }

    /**
     * 保存状态的方法, activity 会在停止之前调用这个方法,会传递一个用于保存数据的对象过来,这个对象会在 activity 下次创建之前 传递到 oncreate 方法中,除非是程序退出
     * 这个方法建议重写,当然也参考程序的实际需求,因为你的 activity 一旦处于 onstop 状态,就可能会被系统回收,回收的时候,系统会保存这个方法中的 bundle 对象,等待下次创建的时候传递回 oncreate
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e("自定义标签", "onSaveInstanceState() called with: " + "outState = [" + outState + "]");
        outState.putString("string","这是我自己保存的内容");
        super.onSaveInstanceState(outState);
    }
}
