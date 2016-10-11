package com.qianfeng.scrollviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ScrollView scrollView;
    private LinearLayout lin;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        lin = (LinearLayout) findViewById(R.id.lin);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void onClick2(View view) {//
        switch (view.getId()) {
            case R.id.bt://将 tv从 lin 里面移除
                lin.removeView(tv);
                break;
            case R.id.noter://将 tv 添加到 lin
                if (tv.getParent() == null) {
                    lin.addView(tv,0);
                }
                TextView textView = new TextView(this);
                textView.setTextSize(30);
                textView.setText("这是代码创建的");
                textView.setTextColor(Color.RED);
                lin.addView(textView);
                break;
        }
    }
}
