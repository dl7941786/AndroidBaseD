package com.qianfeng.broadcastdemo3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    private static NotificationManager notificationManager;
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int type = intent.getIntExtra("type", -1);
        if (notificationManager == null) {
            notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        switch (type) {
            case 0://插入成功
                Notification.Builder builder = new Notification.Builder(context);
                builder.setTicker("插入数据成功");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("插入数据");
                builder.setContentText("呵呵哒");
                builder.setAutoCancel(true);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, new Intent(context, MainActivity.class), PendingIntent.FLAG_ONE_SHOT);
                builder.setContentIntent(pendingIntent);
                Notification notification = builder.getNotification();
                notificationManager.notify(1,notification);
                break;
        }
    }
}
