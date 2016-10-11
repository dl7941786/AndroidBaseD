package com.qianfeng.asynctaskdemo;

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

import com.qianfeng.asynctaskdemo.task.MyBaseAsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiechan on 16/8/8.
 */
public class Utils {
//    private OnCompleteLoadingListener onCompleteLoadingListener;
//
//    public Utils(OnCompleteLoadingListener onCompleteLoadingListener) {
//        this.onCompleteLoadingListener = onCompleteLoadingListener;
//    }

    public static void getData(final String path, final OnCompleteLoadingListener onCompleteLoadingListener) {
      new Thread(){
          @Override
          public void run() {
              try {
                  URL url = new URL(path);
                  HttpURLConnection urlConnectio = (HttpURLConnection) url.openConnection();
                  urlConnectio.setConnectTimeout(5000);
                  urlConnectio.setReadTimeout(5000);
                  urlConnectio.setRequestMethod("GET");
                  urlConnectio.connect();
                  if (urlConnectio.getResponseCode() == HttpURLConnection.HTTP_OK) {
                      InputStream inputStream = urlConnectio.getInputStream();
                      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                      String line = null;
                      StringBuffer buffer = new StringBuffer();
                      while ((line = bufferedReader.readLine()) != null) {
                        //  Log.e("自定义标签", "类名==Utils" + "方法名==getData=====:" + line);
                          buffer.append(line);
                      }
                      String s=buffer.toString();
                      if (onCompleteLoadingListener != null) {
                          onCompleteLoadingListener.onCompleteLoading(s);
                      }
                  }
              } catch (MalformedURLException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }.start();

    }

    public interface  OnCompleteLoadingListener{
        void onCompleteLoading(String s);//完成通知
    }

    public static void getDataaaa(String path, MyBaseAsyncTask.OnLoadCompleteListener onLoadCompleteListener){
        new MyBaseAsyncTask(onLoadCompleteListener).execute(path);
    }

}
