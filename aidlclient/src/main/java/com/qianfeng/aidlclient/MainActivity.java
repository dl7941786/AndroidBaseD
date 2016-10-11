package com.qianfeng.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.qianfeng.aidldemo.MyAidle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aidl:
                Intent intent = new Intent("testaidl");
                intent.setPackage("com.qianfeng.aidldemo");//加上这行是为了5.0之后正常运行,否则你懂得 呵呵哒
                bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyAidle myAidle = MyAidle.Stub.asInterface(service);//把 binder 对象转成MyAidl对象
                        try {
//                            myAidle.test();
//                            int sum = myAidle.getSum(5, 6);
//                            Bundle data = myAidle.getData();
//                            Log.e("自定义标签", "类名==MainActivity" + "方法名==onServiceConnected=====:" + "和是" + sum + "-----" + data.getInt("aa"));
                            String[] ss = new String[]{"姚川","五分钱","六分钱"};
                            myAidle.setData2(ss);//同步的
                            Log.e("自定义标签", "类名==MainActivity" + "方法名==onServiceConnected=====:" + ss[0]);
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
}
