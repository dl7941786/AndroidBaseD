package com.qianfeng.aidldemo;

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
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jackiechan on 16/9/1.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends MyAidle.Stub {

        @Override
        public void test() throws RemoteException {
            Log.e("自定义标签", "类名==MyBinder" + "方法名==test=====:" + "远程服务的方法");
        }

        @Override
        public int getSum(int i, int j) throws RemoteException {
            return i + j;
        }

        @Override
        public Bundle getData() throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putInt("aa", 5566);
            return bundle;
        }

        @Override
        public void setData(String[] ss) throws RemoteException {
            Log.e("自定义标签", "类名==MyBinder" + "方法名==setData=====:" + ss[0]);
        }

        @Override
        public void setData1(String[] ss) throws RemoteException {
            Log.e("自定义标签", "类名==MyBinder" + "方法名==setData1=====:" + ss[0]);
            ss[0] = "姚川六分钱";
        }

        @Override
        public void setData2(String[] ss) throws RemoteException {
            Log.e("自定义标签", "类名==MyBinder" + "方法名==setData2=====:" + ss[0]);
            ss[0] = "姚川六分钱";
        }
    }

}
