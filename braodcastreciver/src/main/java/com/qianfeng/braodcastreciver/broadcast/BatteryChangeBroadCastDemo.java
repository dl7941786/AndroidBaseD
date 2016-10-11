package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BatteryChangeBroadCastDemo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        Log.e("自定义标签", "类名==BatteryChangeBroadCastDemo" + "方法名==onReceive=====:" + "电量变化");
        int level = intent.getIntExtra("level", 0);//当前剩余电量的总是
        int scale = intent.getIntExtra("scale", 100);//电池总电量
        Log.e("自定义标签", "类名==BatteryChangeBroadCastDemo" + "方法名==onReceive=====:" + level+"----"+scale+"当前剩余电量为"+(level*100)/scale+"%");

    }
}
