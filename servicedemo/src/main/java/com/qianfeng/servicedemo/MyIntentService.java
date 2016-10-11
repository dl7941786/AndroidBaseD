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

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 可以执行耗时操作的服务,一次执行完成(所有的意图)后就销毁了
 * Created by jackiechan on 16/8/31.
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    public MyIntentService() {
        super("workThread");
    }

    /**
     * 处理意图,此方法不在主线程,在子线程中,可以执行耗时操作,会从队列中依次取出意图,然后进行处理,如果全部处理完成后,就结束自己
     * 同时执行的任务只有一个
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onHandleIntent=====:" + intent.getIntExtra("aa", -1));
//        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onHandleIntent=====:" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onBind=====:" + "");
        return super.onBind(intent);
    }

    @Override
    public void onCreate() {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onCreate=====:" + "");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onStart=====:" + "");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("自定义标签", "类名==MyIntentService" + "方法名==onStartCommand=====:" + "");
        return super.onStartCommand(intent, flags, startId);
    }
}
