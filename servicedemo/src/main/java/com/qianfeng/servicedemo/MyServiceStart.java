package com.qianfeng.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyServiceStart extends Service {
    /**
     * binder 模式才会执行
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onBind=====:" + "");
        return null;
    }

    @Override
    public void onCreate() {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onCreate=====:" + "");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }

    /**
     * start 方式才会执行,已经被onStartCommand 替代
     *
     * @param intent
     * @param startId
     */
    @Override
    public void onStart(Intent intent, int startId) {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onStart=====:" + "");
        super.onStart(intent, startId);
    }

    /**
     * start 方式才会执行
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onStartCommand=====:" );
        //启动方式只能在这里去执行一些事情
        String key = intent.getStringExtra("key");
        aaaa(key);
        // START_STICKY 粘性服务,如果服务被意外终止,会重启服务, oncreate onStartCommand onStart 会重新执行,但是,它里面的意图是空的,如果用到意图了 需要判空
        // START_NOT_STICKY 非粘性服务,一旦被意外终止,不会再重启
        //START_REDELIVER_INTENT 粘性服务,如果服务被意外终止,会重启服务,然后将最后一次 intent 重新传入过来
//        START_FLAG_RETRY 是START_STICKY的相似的东西 它会在服务意外终止后尝试重启服务,但是不一定能成功
        return START_REDELIVER_INTENT;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==onUnbind=====:" + "");
        return super.onUnbind(intent);
    }

    private void aaaa(String s) {
        Log.e("自定义标签", "类名==MyServiceStart" + "方法名==aaaa=====:" + s);
        //处理完成了
//        stopSelf();//停止自己 停止服务
    }
}
