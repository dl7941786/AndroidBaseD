package com.qianfeng.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

    private MyHandler myHandler = new MyHandler();
    private SeekBar seekBar;
    private Button button;
    int time = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
//        seekBar.setMax(100000);
        button = (Button) findViewById(R.id.send7);


    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.e("自定义标签", "类名==MyHandler" + "方法名==handleMessage=====:" + msg.what);

            switch (msg.what) {
                case 100://收到了更新进度条的申请
//                    seekBar.setProgress(seekBar.getProgress() + 500);
//                    if (seekBar.getProgress() < 100000) {//如果当前进度还不满,就重复发送更新进度条的请求
//                        sendEmptyMessageDelayed(100, 500);
//                    }
                    button.setText((--time)+"");
                    if (time > 0) {
                        sendEmptyMessageDelayed(100, 1000);
                    }else{
                        time = 10;
                        button.setEnabled(true);
                        button.setText("点击发送验证码");
                    }
                    break;
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send1:
                myHandler.post(new Runnable() {//如果是 post  runnable 方式 最终调用的是 run 放过
                    @Override
                    public void run() {
                        Log.e("自定义标签", "类名==Main2Activity" + "方法名==run=====:" + "");
                    }
                });
                break;
            case R.id.send2:
                Message message = new Message();
                message.what = 1;
                myHandler.sendMessage(message);
//                myHandler.sendEmptyMessage(1);
                break;
            case R.id.send3:
                Message ma = Message.obtain();//因为 android 知道我们会大量用到 handler, 需要 message 对象,于是系统默认封装一个对象池,内部有一定数量的 message,如果不够用就创建新的,够用就直接取
                ma.what = 2;
//                myHandler.sendMessage(ma);
                myHandler.sendMessageDelayed(ma, 10000);
                break;
            case R.id.send4:
                Message me = myHandler.obtainMessage();
                me.sendToTarget();//这种写法,必须给 message 指定好了 target
                // myHandler.sendMessage(me);//等同上面那一行
                break;
            case R.id.send5:
                Message ms = Message.obtain(myHandler, 2);//指定当前消息的目标 handler 和 what值
                ms.sendToTarget();// myHandler.sendMessage();
                break;
            case R.id.send6:
                myHandler.removeMessages(2);//移除指定 what的 Message
//                myHandler.removeCallbacks();//移除使用了指定Runnable 对象的消息,Runnable 对象不能为匿名对象
                break;
            case R.id.send7:
                //更新进度条
                view.setEnabled(false);
                button.setText(time+"");
//                myHandler.removeMessages(100);
//                myHandler.sendEmptyMessageDelayed(100, 500);
                myHandler.sendEmptyMessageDelayed(100, 1000);
                break;
        }
    }
}
