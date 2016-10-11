package com.qianfeng.activitydemo;

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

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/4.
 */
public class MyActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onCreate=====:" + "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_myactivity);

    }

    @Override
    protected void onStart() {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onStart=====:" + "");
        super.onStart();
        // The activity is about to become visible.
    }

    @Override
    protected void onResume() {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onResume=====:" + "");
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onPause=====:" + "");
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onStop=====:" + "");
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
        // The activity is about to be destroyed.
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onConfigurationChanged=====:" + "");
        super.onConfigurationChanged(newConfig);
        Log.e("自定义标签", "类名==MyActivity" + "方法名==onConfigurationChanged=====:" + newConfig.screenHeightDp + "---" + newConfig.screenWidthDp + "====");
        //可以给控件重新设置宽高度
//        setContentView(R.layout.activity_main);//可以给程序重新设置布局,但是你需要保存原始数据, 重新在这里展示,这种方式 一般只操作与平板设备
    }
}
