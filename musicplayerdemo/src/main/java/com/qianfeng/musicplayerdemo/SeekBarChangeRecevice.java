package com.qianfeng.musicplayerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

public class SeekBarChangeRecevice extends BroadcastReceiver {
    //    public SeekBarChangeRecevice() {
//    }
    private Handler handler;

    public SeekBarChangeRecevice(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int type = intent.getIntExtra("type", -1);
        switch (type) {
            case 0://播放
                //获取歌曲有多长
                int time = intent.getIntExtra("time", -1);
                Message message = handler.obtainMessage();
                message.what = 100;
                message.arg1 = time;//设置播放时间
                message.sendToTarget();
                break;
            case 1://暂停
                handler.removeMessages(101);//暂停,停止更新进度条
                break;
            case 2://停止

                break;
            case 3://播放完成
                handler.removeMessages(101);//停止更新进度条
                handler.sendEmptyMessage(105);
                break;
        }
    }
}
