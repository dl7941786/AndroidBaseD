package com.qianfeng.messengerserver;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e("自定义标签", "类名==MyService" + "方法名==handleMessage=====:" + "服务端收到消息了"+msg.what+"---"+msg.arg1+"====="+msg.getData().get("aa"));
            Messenger replyTo = msg.replyTo;
            Message message = obtainMessage();
            message.what = 100;
            try {
                replyTo.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };
    private Messenger messenger = new Messenger(handler);
}
