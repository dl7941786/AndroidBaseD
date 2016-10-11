package com.qianfeng.customanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                //启动动画
                MyAnimation myAnimation = new MyAnimation(iv, 400);
                myAnimation.setDuration(2000);
                myAnimation.setInterpolator(new BounceInterpolator());
                iv.startAnimation(myAnimation);
                break;
            case R.id.iv:
                Toast.makeText(this, "被点击了", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
