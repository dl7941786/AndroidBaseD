package com.qianfeng.braodcastreciver.broadcast;

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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/29.
 */
public class MyCustomRecivied extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==run=====:" + "");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();
        Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==onReceive=====:" + Thread.currentThread().getName());
        int caizhengbutie = intent.getIntExtra("caizhengbutie", -1);
        Log.e("自定义标签", "类名==MyCustomRecivied" + "方法名==onReceive=====:" + caizhengbutie);
        Bundle bundle = new Bundle();
        bundle.putInt("caizhengbutie", 1);
        setResultExtras(bundle);//设置结果
        /// abortBroadcast();//中断有序广播
    }
}
