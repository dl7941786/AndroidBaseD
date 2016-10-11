package com.qianfeng.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyServiceDemo extends Service {
    public MyServiceDemo() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String id = intent.getStringExtra("id");
        aaaa(id);
        return START_NOT_STICKY;
    }

    /**
     * 具体处理业务的方法
     *
     * @param id
     */
    private void aaaa(String id) {
        if ("1234567890".equals(id)) {
            Log.e("自定义标签", "类名==MyServiceDemo" + "方法名==aaaa=====:" + "来了一位大爷,里面坐,翠花,上酸菜");
        }else{
            Log.e("自定义标签", "类名==MyServiceDemo" + "方法名==aaaa=====:" + "你先去叫号,排队,我们在9:00-11:00上班,排不到明天再来");
        }

        stopSelf();//处理完成之后停止
    }
}
