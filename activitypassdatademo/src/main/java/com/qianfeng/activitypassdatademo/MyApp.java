package com.qianfeng.activitypassdatademo;

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

import android.app.Application;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/5.
 */

/**
 * 这个类是上下文的子类,这是一个全局单例子类,只会初始化一次,在 activity 初始化之前初始化,
 * 要使用,需要在清单文件application标签中增加 name 属性,值赋值为这个类的全限定类型
 * 这个类里面可以初始化什么, 比如okhttclient等全局只需要一个对象的对象,百度地图初始化等
 * 聊天初始化,直播初始化,第三方是最简单的
 */
public class MyApp extends Application {
    public static String aaa;
    @Override
    public void onCreate() {
        Log.e("自定义标签", "类名==MyApp" + "方法名==onCreate=====:" + "");
        super.onCreate();
        aaa = "这是在MyApp中赋值";
    }
}