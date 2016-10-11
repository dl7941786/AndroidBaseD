package com.qianfeng.mydriversdemo.utils;

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

import android.os.Handler;
import android.os.Looper;

import com.qianfeng.mydriversdemo.model.RecommentModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jackiechan on 16/8/25.
 */
public class HttpUtils {
    public static OkHttpClient okHttpClient = new OkHttpClient();
    private static Handler handler = new Handler(Looper.getMainLooper());
    /**
     * get 请求的方法
     * @param path 请求地址
     * @param onLoadCompleteListener 回调处理数据
     */
    public  static void loadDataGet(final String path, final RecommentModel.OnLoadCompleteListener onLoadCompleteListener){
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(path).get().build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
               final byte[] bs= response.body().bytes();//先获取数据,因为这个方法是网络获取数据,需要在子线程
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //调用回调里面的方法
                            onLoadCompleteListener.onLoadComplete(bs,path);

                    }
                });
            }
        });
    }
}
