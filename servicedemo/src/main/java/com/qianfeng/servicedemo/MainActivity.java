package com.qianfeng.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * 服务的使用方式:
 * 1: 绑定模式
 */
public class MainActivity extends AppCompatActivity {

    private MyServiceConnection myServiceConnection;
    private MyBraoad receiver;
    private Intent intentSatrt;
    private int clickTimes;

    /**
     * 服务是在后台处理事情,这个后台是指的不可见的地方,不是子线程,经常用于处理一些循环重复的事情,JNI 可以做后台处理
     * 服务和线程的区别
     * 服务在主线程,四大组件都在主线程
     * 服务和activity的通信方式:使用广播, 2使用接口回调,仅限于绑定模式
     * 启动模式和绑定模式,服务只创建一次(同一个服务 oncreate 执行一次,不管是什么方式启动,哪怕两种方式一块启用,也只执行一次),但是绑定和启动的方法会执行多次  onServiceConnected和onStartCommand会执行多次
     * 服务可以通过隐式和显式意图两种方式启动,但是在5.0之后服务必须通过显式意图启动,否则就呵呵哒
     * 在 activity的生命周期中最好是 ondestory中取消注册或者停止服务,特殊情况除外
     * 通过某种方式把服务启动起来之后 调用服务里面的方法, 服务的生命周期由系统负责,不需要我们手动管理
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyService myService = new MyService();//不能这么写,这样写,就是一个普通类对象,声明周期等各种东西都无法掌控
//        myService.bbbb();
        IntentFilter intentFilter = new IntentFilter("aaaa");
        receiver = new MyBraoad();
        registerReceiver(receiver, intentFilter);
        //播放,暂停,下一首 上一周 随机播放,列表顺序,列表循环,单曲循环
    }


    @Override
    protected void onDestroy() {
        //unbindService(myServiceConnection);//页面销毁的时候需要解绑服务
        unregisterReceiver(receiver);
        //stopService(intentSatrt);//停止服务
        super.onDestroy();
    }


    public class MyBraoad extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String key = intent.getStringExtra("key");
            Log.e("自定义标签", "类名==MyBraoad" + "方法名==onReceive=====:" + key);
        }
    }

    public void onClick(View view) {
        String s = ((EditText) findViewById(R.id.et)).getText().toString();
        switch (view.getId()) {
            case R.id.binder:
//                Intent intent = new Intent(this, MyService.class);//创建目标服务的意图
                Intent intent = new Intent(this, MyServiceStart.class);//创建目标服务的意图
                myServiceConnection = new MyServiceConnection();
                bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);//绑定模式 参数2 ,与服务连接状态的回调对象, 第三个 启动方式,如果服务没有创建就自动创建
                break;

            case R.id.start:
                intentSatrt = new Intent(this, MyServiceStart.class);
                intentSatrt.putExtra("key", s);
                startService(intentSatrt);//启动方式启动服务
                break;
            case R.id.startdemo:
                Intent startDemo = new Intent(this, MyServiceDemo.class);
                startDemo.putExtra("id", s);
                startService(startDemo);//启动服务
                break;
            case R.id.binder2:
                Intent binder2 = new Intent(this, MyServiceBinder2.class);
                bindService(binder2, new MyServiceConnetion2(), BIND_AUTO_CREATE);
                break;
            case R.id.intentservice:
                clickTimes++;
                Intent intentservice = new Intent(this, MyIntentService.class);
//                Intent intentservice = new Intent("yinshiyitu");
                intentservice.putExtra("aa", clickTimes);
//                bindService(intentservice, new MyServiceConnection(), BIND_AUTO_CREATE);
                startService(intentservice);
                break;
        }
    }
}
