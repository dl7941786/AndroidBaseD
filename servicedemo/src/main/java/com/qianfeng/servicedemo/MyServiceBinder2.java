package com.qianfeng.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyServiceBinder2 extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     *
     */
    private void aaaa(int money) {
        if (money > 10) {
            Log.e("自定义标签", "类名==MyServiceBinder2" + "方法名==aaaa=====:" + "通过委托执行");
        }else{
            Log.e("自定义标签", "类名==MyServiceBinder2" + "方法名==aaaa=====:" + "钱不是很够");
        }
    }

    public class MyBinder extends Binder {
//        public MyServiceBinder2 getService() {
//            return MyServiceBinder2.this;
//        }
public void aaa(int money) {
    if (money > 100000000) {
        aaaa(11);
    } else {
        Toast.makeText(MyServiceBinder2.this, "你贿赂的钱太少了,得再来几十个亿", Toast.LENGTH_SHORT).show();
    }
}

        public void cccc() {
            Log.e("自定义标签", "类名==MyBinder" + "方法名==cccc=====:" + "桑拿房间准备好了吗?拉菲买了吗?日照绿茶买了吗");
        }
    }
}
