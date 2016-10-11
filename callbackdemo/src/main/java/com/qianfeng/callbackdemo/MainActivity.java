package com.qianfeng.callbackdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = new ImageView(this);
        BitMapCallBack bitMapCallBack = new BitMapCallBack(imageView);
        Utils utils = new Utils(bitMapCallBack);
        utils.getData("图片地址");
    }
}
