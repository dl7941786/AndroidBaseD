package com.qianfeng.scrollviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;

public class Main3Activity extends AppCompatActivity {

    private HorizontalScrollView horScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        horScrollView = (HorizontalScrollView) findViewById(R.id.horscroll);
    }

    public void onClick3(View view) {
        horScrollView.smoothScrollTo(500,0);//横向的滚动是x在动
    }
}
