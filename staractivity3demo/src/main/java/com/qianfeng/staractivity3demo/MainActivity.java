package com.qianfeng.staractivity3demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this, Main2Activity.class);//显式启动
//        startActivity(intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
//                Intent intent = new Intent(this, Main2Activity.class);
//                startActivity(intent);
                //要想使用隐式意图启动,必须在清单文件中 指定的 activity下增加意图过滤器 ,action 指定为对应的值,值可以随便写,但是不要重复,也不要太随便
                // 一般情况下,都是显式意图启动 activity, 用隐式一般都是跨程序启动,显式意图是在本程序内部查找对应的 activity, 隐式则是系统去查找所有的注册的 activity
//                Intent intent = new Intent("com.qianfeng.dierge");//隐式意图启动,相当于目标类的代号,好处就是不用显式的对外声明要启动谁,交给系统去选择
//                startActivity(intent);//
                Intent intent = new Intent("wohensuibian");//隐式意图启动,相当于目标类的代号,好处就是不用显式的对外声明要启动谁,交给系统去选择
                intent.addCategory("qishiwobusuibian");//分类,用于具体细分是哪个 activity, 每个 activity在设置意图的时候除了必须设置android.intent.category.DEFAULT这个addCategory之外
                //接上--->还可以设置自定义的分类,如果要访问这个 ,只需要在访问的 intent中增加对应的addCategory即可
                startActivity(intent);//
                break;
        }
    }
}
