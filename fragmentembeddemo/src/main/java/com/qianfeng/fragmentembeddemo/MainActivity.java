package com.qianfeng.fragmentembeddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BlankFragment blankFragment = new BlankFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container,blankFragment).commit();
        //getFragmentManager();//掌管原生 fragment的 manager, 基本上不用
    }
}
