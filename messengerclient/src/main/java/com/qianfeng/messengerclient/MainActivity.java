package com.qianfeng.messengerclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Messenger serverMessenger,clientMessenger;//服务端和客户端的信使
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clientMessenger = new Messenger(handler);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.binder:
                Intent intent = new Intent("testmessenger");
                bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        try {
                            serverMessenger = new Messenger(service);//服务端的信使就创建完成了
                            Message message = new Message();
                            message.what = 1;
                            message.arg1 = 2;
                            Bundle bundle = new Bundle();
                            bundle.putString("aa", "55667788");
                            message.setData(bundle);//设置数据
                            message.replyTo = clientMessenger;//告诉你回复给谁
                            serverMessenger.send(message);//发消息
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                }, BIND_AUTO_CREATE);
                break;
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:" + "收到服务端发回的消息了"+msg.what);
        }
    };
}
