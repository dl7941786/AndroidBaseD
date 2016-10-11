package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyOrderBroadcast3 extends BroadcastReceiver {
    public MyOrderBroadcast3() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        Log.e("自定义标签", "类名==MyOrderBroadcast3" + "县级收到的指标是" + resultData);
        setResultData("地主发粮了,每人五斤");
    }
}
