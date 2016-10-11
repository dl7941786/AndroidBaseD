package com.qianfeng.braodcastreciver.broadcast;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CancelNotification extends BroadcastReceiver {
    public CancelNotification() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("自定义标签", "类名==CancelNotification" + "方法名==onReceive=====:" + "");
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int id = intent.getIntExtra("id", -1);
        manager.cancel(id);
    }
}
