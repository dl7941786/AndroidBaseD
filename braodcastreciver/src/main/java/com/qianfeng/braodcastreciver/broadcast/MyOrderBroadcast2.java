package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyOrderBroadcast2 extends BroadcastReceiver {
    public MyOrderBroadcast2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        Log.e("自定义标签", "类名==MyOrderBroadcast2" + "市级收到的指标是" + resultData);
//        abortBroadcast();//中断广播
        setResultData("地主发粮了,每人五百斤");
    }
}
