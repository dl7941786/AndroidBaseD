package com.qianfeng.asynctaskdemo.task;

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

import android.os.AsyncTask;
import android.util.Log;

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
public class MyAsynTask extends AsyncTask<String, String, String> {
    /**
     * 在UI 线程,建议在此之前显示进度条等操作
     */
    @Override
    protected void onPreExecute() {
        //Log.e("自定义标签", "类名==MyAsynTask" + "方法名==onPreExecute=====:" + Thread.currentThread().getName());
        super.onPreExecute();
    }

    /**
     * 在后台操作
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(String... params) {

        // Log.e("自定义标签", "类名==MyAsynTask" + "方法名==doInBackground=====:" + Thread.currentThread().getName() + "参数为" + params[0]);
        //请求网络
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                    publishProgress("推送的进度为"+(i++));
                }
                bufferedReader.close();
                return stringBuffer.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在UI 线程执行,获得返回的结果
     *
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        Log.e("自定义标签", "类名==MyAsynTask" + "方法名==onPostExecute=====:" + Thread.currentThread().getName() + "结果等于-----" + s);
        super.onPostExecute(s);
    }

    /**
     * 进度更新
     *
     * @param values
     */
    @Override
    protected void onProgressUpdate(String... values) {
        Log.e("自定义标签", "类名==MyAsynTask" + "方法名==onProgressUpdate=====:" + values[0]);
        super.onProgressUpdate(values);
    }
}
