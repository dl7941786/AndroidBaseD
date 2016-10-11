package com.qianfeng.servicedemo;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？  

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/31.
 */
public class MyService extends Service {

//    private String s;

//    public void setS(String s) {
////        this.s = s;
//    }

    /**
     * 通过绑定模式绑定服务的时候执行的回调
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("自定义标签", "类名==MyService" + "方法名==onBind=====:" + "");
        return new MyBinder();
    }

    /**
     * 服务创建后初始化内部数据的方法(不是初始化对象)
     */
    @Override
    public void onCreate() {
        Log.e("自定义标签", "类名==MyService" + "方法名==onCreate=====:");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("自定义标签", "类名==MyService" + "方法名==onStartCommand=====:" + "");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e("自定义标签", "类名==MyService" + "方法名==onStart=====:" + "");
        super.onStart(intent, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("自定义标签", "类名==MyService" + "方法名==onUnbind=====:" + "");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        handler.removeMessages(1);
        Log.e("自定义标签", "类名==MyService" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }

    /**
     * 服务里面有一个方法
     */
    public void bbbb() {
        Log.e("自定义标签", "类名==MyService" + "方法名==bbbb=====:" + "");
        // handler.sendEmptyMessageDelayed(1, 2000);
//        new Thread(){
//            @Override
//            public void run() {
//            }
//        }.start();
        Intent intent = new Intent("aaaa");
        intent.putExtra("key", "value");
        sendBroadcast(intent);
    }


    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }

//        public void setS(String s) {
//            MyService.this.setS(s);
//        }


//        public void aaaa() {
//            Log.e("自定义标签", "类名==MyBinder" + "方法名==aaaa=====:" + "");
//        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e("自定义标签", "类名==MyService" + "方法名==handleMessage=====:" + "处理消息了");
            sendEmptyMessageDelayed(1, 2000);
        }
    };
}
