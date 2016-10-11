package com.qianfeng.braodcastreciver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                Intent intent = new Intent("com.qianfeng.youxuguangbo1");
                sendOrderedBroadcast(intent, "com.qianfeng.zheshisha");
                break;
        }
    }
}
