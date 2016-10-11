package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyOrderBroadcast4 extends BroadcastReceiver {
    public MyOrderBroadcast4() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        Log.e("自定义标签", "类名==MyOrderBroadcast4" + "老百姓收到的结果是" + resultData);
        abortBroadcast();
    }
}
