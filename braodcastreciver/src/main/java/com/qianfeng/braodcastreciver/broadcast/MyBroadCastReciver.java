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
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/29.
 */
public class MyBroadCastReciver extends BroadcastReceiver {

    private static String incomingNumber;

    /**
     * 收到广播时候的回调,只要接收一次广播,对象就会创建一次
     * 观察者模式
     * @param context
     * @param intent  这里面携带着数据
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:" + this);
        String action = intent.getAction();//意图
        switch (action) {//判断区分到底是哪个意图的数据
            case "android.intent.action.NEW_OUTGOING_CALL":
                //获取到电话号码
                Bundle bundle = intent.getExtras();
                String number = bundle.getString(Intent.EXTRA_PHONE_NUMBER);//获取当前打的电话号码
                Log.e("自定义标签", "类名==MyBroadCastReciver" + "打电话给" + number);
                break;
            case "android.intent.action.PHONE_STATE"://接听来电或者是挂断电话
//                Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:" + "接听电话");
                //获取通话的事件
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                int callState = telephonyManager.getCallState();//获取通话状态 0是挂断,1是响铃,2是接听
                Bundle bundle1 = intent.getExtras();
//                Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:" + incomingNumber);
                switch (callState) {//区分状态
                    case TelephonyManager.CALL_STATE_IDLE://挂断
//                        String incomingNumberGuaDuan = bundle1.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);//获取来电号码
                        Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:挂断了" + incomingNumber + "这孙子的电话");
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK://接听
//                        String incomingNumberJieTing = bundle1.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);//获取来电号码
                        Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:接听了" + incomingNumber + "这孙子的电话");
                        break;
                    case TelephonyManager.CALL_STATE_RINGING://响铃
                        //获取来电号码,
                        incomingNumber = bundle1.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                        Log.e("自定义标签", "类名==MyBroadCastReciver" + "方法名==onReceive=====:" + incomingNumber + "这孙子又给您来电话了");
                        break;
                }
                break;
        }

    }
}
