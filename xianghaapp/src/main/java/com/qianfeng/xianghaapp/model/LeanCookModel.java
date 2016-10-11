package com.qianfeng.xianghaapp.model;

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

import android.app.ProgressDialog;

import com.qianfeng.xianghaapp.app.MyApp;
import com.qianfeng.xianghaapp.utils.MyAsyncTask;

/**
 * Created by jackiechan on 16/8/12.
 */
public class LeanCookModel implements MvpModel {
    @Override
    public void getData(OnLoadCompleteListener onLoadCompleteListener,String path) {
        //请求数据,数据最终通过接口回去传递回去
        ProgressDialog progressDialog = new ProgressDialog(MyApp.context);
        progressDialog.setTitle("加载中.....");
        progressDialog.setMessage("正在悠闲加载中,取决于你的网络(钱)");
        progressDialog.setCancelable(false);
        new MyAsyncTask(onLoadCompleteListener,null).execute(path);
    }
}
