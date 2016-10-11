package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HongbaoBroadCast extends BroadcastReceiver {
    public HongbaoBroadCast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("自定义标签", "类名==HongbaoBroadCast" + "方法名==onReceive=====:" + "你是单身狗,没有孩子");
        String id = intent.getStringExtra("id");
        Log.e("自定义标签", "类名==HongbaoBroadCast" + "方法名==onReceive=====:" + id);
    }
}
