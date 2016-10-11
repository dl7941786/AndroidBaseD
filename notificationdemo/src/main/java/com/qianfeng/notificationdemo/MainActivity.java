package com.qianfeng.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;
    private int i = 0;
    private int j = 0;
    private EditText editText;
    public static final String DOWNLOADURL = "http://url.tudown.com/down/%E8%93%9D%E8%89%B2%E5%85%89%E6%BB%A4%E6%B3%A2%E5%99%A82.2.1@83_1021061.exe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        editText = (EditText) findViewById(R.id.et);
    }

    /**
     * @param view
     */
    public void onClick(View view) {
        Notification.Builder builder = new Notification.Builder(this);//创建构造器
        i++;
        switch (view.getId()) {
            case R.id.send5:
                //发起一个通知
                //通知的 id 如果不一致,就显示多个通知
//                Notification notification = new Notification();
                builder.setSmallIcon(R.mipmap.ic_launcher);//设置小图片,必须得写,否则没有通知
                builder.setContentText("这是 contenttext");//下拉的时候显示的内容
                // builder.setSubText("这是 subtext");
                builder.setContentTitle("这是ContentTitle");//下拉的时候显示的内容的标题
                builder.setTicker("这是Ticker");//收到通知的时候通知栏预先显示的部分内容
                builder.setWhen(SystemClock.uptimeMillis());//什么时候显示
                Notification notification = builder.getNotification();
                //显示通知
                manager.notify(1, notification);
                break;
            case R.id.send5t:
                builder.setSmallIcon(R.mipmap.ic_launcher);//设置小图片,必须得写,否则没有通知
                builder.setContentText("六分钱,晚上一起吃饭,不要告诉五分钱");//下拉的时候显示的内容
                // builder.setSubText("这是 subtext");
                builder.setContentTitle("超哥发来的消息");//下拉的时候显示的内容的标题
                builder.setTicker("大姐,晚上有时间吗");//收到通知的时候通知栏预先显示的部分内容
                builder.setWhen(SystemClock.uptimeMillis());//什么时候显示
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("time", "时间是" + i);
                //PendingIntent.FLAG_ONE_SHOT 只发送一次数据,后续的都不在发送,不再发送的标准是 requestcode, 只要 requstcode 相同,然后通知还没有处理,那么就不在发送新的数据
                //PendingIntent.FLAG_UPDATE_CURRENT 每次会将相同 requestcode的数据更新为最新的
                //PendingIntent.FLAG_NO_CREATE 不创建新的意图,使用最后一次意图,参考方式是requestcode
                //FLAG_CANCEL_CURRENT 和FLAG_UPDATE_CURRENT ,一个是更新内容,一个是取消重新创建
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 100 + i, intent, PendingIntent.FLAG_ONE_SHOT);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);//是否自动取消
                Notification notification1 = builder.getNotification();
                manager.notify(2, notification1);//参数中的 id, 通知的标记,同一程序内 同一 id的通知,只显示一个,新的会把就得覆盖掉
                break;
            case R.id.sendc:
                builder.setSmallIcon(R.mipmap.ic_launcher);//设置小图片,必须得写,否则没有通知
                builder.setContentText("六分钱,晚上一起吃饭,不要告诉五分钱");//下拉的时候显示的内容
                // builder.setSubText("这是 subtext");
                builder.setContentTitle("超哥发来的消息");//下拉的时候显示的内容的标题
                builder.setTicker("大姐,晚上有时间吗");//收到通知的时候通知栏预先显示的部分内容
                builder.setWhen(SystemClock.uptimeMillis());//什么时候显示
                Intent intent2 = new Intent(this, Main2Activity.class);
                j++;
                intent2.putExtra("time", "时间是" + j);
                PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_CANCEL_CURRENT);
                builder.setContentIntent(pendingIntent2);
//                builder.setAutoCancel(true);//是否自动取消
                Notification notification2 = builder.getNotification();
//                notification2.flags = Notification.FLAG_AUTO_CANCEL;//设置自动取消,效果等同于builder.setAutoCancel(true);
                notification2.flags = Notification.FLAG_NO_CLEAR;//点击后通知不取消,下次点击还可以继续相应
                //notification2.defaults = Notification.DEFAULT_ALL;//通知的提示方式, 这个是 既有震动,又有声音,还有呼吸灯
                manager.notify(2, notification2);//参数中的 id, 通知的标记,同一程序内 同一 id的通知,只显示一个,新的会把就得覆盖掉
                break;

            case R.id.custom:
                //自定义view
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notifacation_custom);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ab_share);//给指定的图片空间设之内容
                //更新进度条
                remoteViews.setProgressBar(R.id.progress, 100, i, false);//设置进度条
                remoteViews.setImageViewBitmap(R.id.iv1, bitmap);//设置图片
                builder.setContent(remoteViews);//设置远程视图
                builder.setSmallIcon(R.mipmap.ab_edit);//设置小图标
                Notification notification3 = builder.getNotification();
                manager.notify(3, notification3);
                break;
            case R.id.download:
                //下载
                new MyAsyncTask(manager, this).execute(DOWNLOADURL);
                break;
            case R.id.custom2:

                break;
            case R.id.cancel:
                String s = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(s)) {
                    int id = Integer.parseInt(s);
                    manager.cancel(id);//取消指定 id的通知
                }
                break;
        }
    }
}
