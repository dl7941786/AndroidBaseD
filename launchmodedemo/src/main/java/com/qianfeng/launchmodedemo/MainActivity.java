package com.qianfeng.launchmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText(getClass().getSimpleName() + i + "---" + toString()+"---task=="+getTaskId());
        i++;
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.star1:
                intent = new Intent(this, MainActivity.class);
               // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//有点类似于singleInstance,但是还不是,跟所的启动模式好像都不一样,主要是还牵扯到另外一个它要启动的目标 activity的启动方式 ,如果目标是 singletop, 会导致都没有反应,如果是其他,就是singleInstance
                startActivity(intent);
                break;
            case R.id.star2:
                intent = new Intent(this, Main2.class);
                startActivity(intent);
                break;
            case R.id.star3:
                intent = new Intent(this, Main3.class);
                startActivity(intent);
                break;
            case R.id.star4:
                intent = new Intent(this, Main4.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//清除我之上的栈顶,相当于 singletask
                startActivity(intent);
                break;
        }
    }

    /**
     * 又有一个意图来启动这个页面了,但是因为处于唯一对象状态,所以不会走声明周期,而走这个方法
     * @param intent 新的意图,如果需要就获取里面的数据
     */
    @Override
    protected void onNewIntent(Intent intent) {
        Log.e("自定义标签", "类名=="+getClass().getSimpleName() + "方法名==onNewIntent=====:" + "");
        super.onNewIntent(intent);
    }
}
