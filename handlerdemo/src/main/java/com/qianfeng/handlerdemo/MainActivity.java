package com.qianfeng.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int FIRST = 1;
    public static final int SENCOND = 2;
    public static final int THIRD = 3;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {//因为系统不知道具体怎么处理你发送的消息,所以需要重写
            //具体怎么处理
            switch (msg.what) {//代表的哪一个消息, what是消息的标记
                case FIRST:
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:11111");
                    break;
                case SENCOND:
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:2222222");
                    break;
                case THIRD:
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:" + "哦");
                    break;
            }
        }
    };

    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.handler1:
                //Handler,主要是用于切换线程执行操作, 类似于接口回调
                //异步的时候  new Thread---> runonuithread()--> AysncTask--->onpost--> 主线程
                //传递内容
//                Message message= new Message();//消息对象
//                Message message= Message.obtain();//消息对象获取方式2 ,通过消息对象池获取,
                final Message message = handler.obtainMessage();//消息对象获取方式3 ,通过handler获取,内部调用的是Message.obtain
                message.what = FIRST;
                message.arg1 = 2;
                message.arg2 = 3;
                message.obj = "这是啥";
                handler.sendMessage(message);
                break;
            case R.id.handler2:
                new Thread() {
                    @Override
                    public void run() {
                        Message message2 = new Message();//消息对象
                        message2.what = SENCOND;
                        message2.arg1 = 2;
                        message2.arg2 = 3;
                        message2.obj = "这是新线程过来的";
                        handler.sendMessage(message2);
                     //   handler.dispatchMessage(message2);
//                        handler.handleMessage(message2);
                    }
                }.start();
                break;
            case R.id.handler3:
                handler.sendEmptyMessage(THIRD);//发送一个空消息,不需要额外的数据
                //  handler.sendEmptyMessageDelayed(THIRD, 5000);//延迟发送消息,等到多少毫秒发送
                long l = SystemClock.uptimeMillis();
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + l);
                //  handler.sendEmptyMessageAtTime(THIRD, 1100000);// 指定时间触发, 自开机后开始计算,多少秒后触发,如果时间已过,就立刻执行,未过则等待
//                handler.sendEmptyMessageDelayed(THIRD, -5000);
                break;
            case R.id.handler4:
                new Thread(){
                    @Override
                    public void run() {
                        Looper.prepare();
                        mHandler=new Handler(){
                            @Override
                            public void handleMessage(Message msg) {
                                //((TextView) view).setText("子线程的 handler 更新的内容");//注意 虽然 handler 可以用了, 但是这样的 handler是不能更新界面的
                                Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:" + "子线程创建的 handler 执行了"+Thread.currentThread().getName());
                            }
                        };
                        Looper.loop();//这是一个死循环,不会执行后面的代码, 阻塞的并不是你所理解的那个主线程
                    //    Log.e("自定义标签", "类名==MainActivity" + "方法名==run=====:" + "----------");
                    }
                }.start();
                break;
            case R.id.handler5:
                mHandler.sendEmptyMessage(FIRST);
                break;
        }
    }
}
