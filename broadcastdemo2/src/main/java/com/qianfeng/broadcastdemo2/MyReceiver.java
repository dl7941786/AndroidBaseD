package com.qianfeng.broadcastdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====:" + "别人家的孩子");
        String id = intent.getStringExtra("id");
        Log.e("自定义标签", "类名==MyReceiver" + "方法名==onReceive=====:" + "别人收到的" + id + "---然后别人有女朋友");
    }
}
