package com.qianfeng.braodcastreciver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.qianfeng.braodcastreciver.broadcast.BatteryChangeBroadCastDemo;
import com.qianfeng.braodcastreciver.broadcast.HongbaoBroadCast;

/**
 * 在特定的时间,通过特定的方式,发送一些特定的数据, 接收的人只要监听这个特定的方式即可,有数据的时候就可以收到数据
 * 打开收音机,调频到某个频道, 如果这个频道对外发出了数据,你就可以收到
 */

/**
 * 广播使用方式
 * 第一步: 写一个类继承自 BroadcastReceiver,然后在清单文件中注册, 同时添加 intent-filter 指定一个action,然后在重写的方法中,按照需要执行自己的事情
 * 第二步,发送对应action 的广播即可,创建一个 intent, 指定 action ,如果需要数据就放到 intent中,然后通过 context.sendBroadcast 发送无序广播出去
 * 或者通过 context.sendOrderedBroadcast(intent,自定义权限)发送有序广播, 权限必须在清单文件中声明并使用,权限可以随便写
 * 广播运行在主线程中,所以不能执行耗时操作,超过五秒的事你都别做
 * 全局注册的广播生命周期从程序安装到卸载, 程序不需要启动也可以收到广播,也叫静态注册
 * 动态注册,生命周期从注册的代码到页面销毁,程序必须启动注册过之后才可以收到广播
 * 动态注册的步骤
 * IntentFilter intentFilter = new IntentFilter("qunzhufahongbao");//创建意图过滤器
 * registerReceiver(intentFilter);//这种方式注册的还是全局广播,跨程序也可以收到的
 * LocalBroadcastManager.getInstance(this).registerReceiver(new HongbaoBroadCast(), intentFilter);//动态注册本地广播,只收本程序自己的广播
 * 只要程序结束,动态注册的广播都会结束,再也收不到广播了
 * 本地广播必须动态注册,如果是全局注册,代表收到的是整个 android 系统内所有发出的广播,都能收到,本地广播是只收程序内部的广播,而本地广播要发送,代表程序必须已经启动,所以干脆要求是动态注册
 * 普通广播发出去之后 就不管了,不管有没有人接收,只管发,没人接收就立刻销毁,有人接收等接收处理完成onReceive完成后也就没了,另外特点,必须是先注册再发送才能收到
 * 粘性广播, 发出去之后,不管有没有人要,都放在那里,只要后面有人注册了,就给你一份,特点,可以先发送,后注册
 */
public class MainActivity extends AppCompatActivity {
    public static final int NOTIID = 1;
    private NotificationManager manager;
    private HongbaoBroadCast hongbaoBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        IntentFilter intentFilter = new IntentFilter("qunzhufahongbao");//创建意图过滤器
        hongbaoBroadCast = new HongbaoBroadCast();
        registerReceiver(hongbaoBroadCast, intentFilter);//动态注册全局广播
//        LocalBroadcastManager.getInstance(this).registerReceiver(new HongbaoBroadCast(), intentFilter);//动态注册
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendbroadcast:
                //发送广播
                Intent intent = new Intent("com.qianfeng.suibianyigeguangbo");
                Bundle bundle = new Bundle();
                bundle.putInt("caizhengbutie", 100000);
                intent.putExtras(bundle);
//                sendBroadcast(intent);//发送无序广播
                sendOrderedBroadcast(intent, "com.qianfeng.zheshisha");
                break;
            case R.id.createnoti:
                Notification.Builder builder = new Notification.Builder(this);//创建一个通知的 builder
                builder.setSmallIcon(R.mipmap.ic_launcher);
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item_noti);//远程布局
                Intent clickCancel = new Intent("quxiaotongzhi");
                clickCancel.putExtra("id", NOTIID);//将想要取消的通知的 id 传过来
                PendingIntent clickCancelpendingIntent = PendingIntent.getBroadcast(this, 200, clickCancel, PendingIntent.FLAG_ONE_SHOT);//创建一个取消通知的远程意图
                remoteViews.setOnClickPendingIntent(R.id.bt, clickCancelpendingIntent);//给某个控件设置点击意图
                builder.setContent(remoteViews);//设置布局
                Intent nidemengxiangshishenme = new Intent(this, Main2Activity.class);//创建意图
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, nidemengxiangshishenme, PendingIntent.FLAG_ONE_SHOT);//创建远程意图
                builder.setContentIntent(pendingIntent);//设置远程意图
                builder.setAutoCancel(true);//
                Notification notification = builder.getNotification();
                manager.notify(NOTIID, notification);
                break;
            case R.id.sendbroadkuachengxu:
                Intent yuanchengIntent = new Intent("qunzhufahongbao");
                yuanchengIntent.putExtra("id", "单身狗1号");
                sendBroadcast(yuanchengIntent);
//                LocalBroadcastManager.getInstance(this).sendBroadcast(yuanchengIntent);//发送本地广播,只能自己程序内部响应
                break;
            case R.id.battery://点击按钮注册电量的广播
                IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);//电量变化的 action
                registerReceiver(new BatteryChangeBroadCastDemo(), intentFilter);//注册电量变化的粘性广播
                break;
            case R.id.sticky:
                Intent stickyIntent = new Intent("aaaa");
                sendStickyBroadcast(stickyIntent);//发送粘性广播
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //注册广播
                        IntentFilter stickyFilter = new IntentFilter("aaaa");
                        Intent data = registerReceiver(null, stickyFilter);
                        if (data.getAction().equals("aaaa")) {//判断注册广播返回的 intent 里面的 action 是不是和我们想要的一样
                            Log.e("自定义标签", "类名==MainActivity" + "方法名==run=====:" + "收到粘性广播了");
                        }
                    }
                }, 20000);
                break;
        }
    }

    /**
     * 如果广播接收者的类是作为内部类存在的,必须是静态的,从内存占用和对象创建几个方面
     */
    public static class MyCustomRecivied extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
//            Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==onReceive=====:" + "内部类收到的消息");
//            Bundle extras = intent.getExtras();
//            int caizhengbutie = extras.getInt("caizhengbutie", -1);
//            Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==onReceive=====:" + caizhengbutie);
            Bundle extras = intent.getExtras();
            int caizhengbutie1 = extras.getInt("caizhengbutie");//获取原始数据
//            Bundle resultExtras = getResultExtras(false);//获取上级传过来的数据
//            int caizhengbutie = resultExtras.getInt("caizhengbutie", -1);
//            Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==onReceive=====:" + caizhengbutie + "----caizhengbutie1" + caizhengbutie1);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(hongbaoBroadCast);
    }
}
