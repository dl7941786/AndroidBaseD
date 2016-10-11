package com.qianfeng.braodcastreciver.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("自定义标签", "类名==MyReceiver2" + "方法名==onReceive=====:" + "");
        //收到短息了.获取短信内容
        Bundle extras = intent.getExtras();
        Object[] pdus = (Object[]) extras.get("pdus");//获取短信
        for (Object pdu : pdus) {
            SmsMessage fromPdu = SmsMessage.createFromPdu((byte[]) pdu);//用发送的内容转换为消息对象
            String originatingAddress = fromPdu.getOriginatingAddress();//发送人的号码
            String displayMessageBody = fromPdu.getDisplayMessageBody();//发送的内容
            long timestampMillis = fromPdu.getTimestampMillis();//获取时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(new Date(timestampMillis));//转换时间
            Log.e("自定义标签", "类名==MyReceiver2" + "方法名==onReceive=====:" + originatingAddress + "----" + displayMessageBody + "=====" + format);
        }
        abortBroadcast();//停止广播
    }
}
