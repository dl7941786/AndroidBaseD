package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyOrderBroadcast1 extends BroadcastReceiver {
    public MyOrderBroadcast1() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        setResultData("地主发粮了,每人一千斤");
    }
}
