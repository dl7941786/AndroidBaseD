package com.qianfeng.asynctaskdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qianfeng.asynctaskdemo.R;
import com.qianfeng.asynctaskdemo.Utils;

public class MainActivity extends AppCompatActivity implements Utils.OnCompleteLoadingListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get:
                Utils.getData("http://www.zol.com.cn",this);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "网络请求已经开始");
                break;
        }
    }

    @Override
    public void onCompleteLoading(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(s);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv = null;
    }
}
