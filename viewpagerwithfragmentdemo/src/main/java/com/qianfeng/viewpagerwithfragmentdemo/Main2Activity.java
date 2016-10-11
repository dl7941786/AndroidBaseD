package com.qianfeng.viewpagerwithfragmentdemo;

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
            case R.id.bt1:
                getSupportFragmentManager().beginTransaction().replace( R.id.container,new OuterFragment()).commit();
                break;
            case R.id.bt2:
                getSupportFragmentManager().beginTransaction().replace( R.id.container,new OuterFragment()).commit();
                break;
            case R.id.bt3:
                getSupportFragmentManager().beginTransaction().replace( R.id.container,new OuterFragment()).commit();
                break;
            case R.id.bt4:
                getSupportFragmentManager().beginTransaction().replace( R.id.container,new OuterFragment()).commit();
                break;
        }
    }
}
