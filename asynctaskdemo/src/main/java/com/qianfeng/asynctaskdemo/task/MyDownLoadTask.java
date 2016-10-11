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
import android.os.Environment;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiechan on 16/8/8.
 */
public class MyDownLoadTask extends AsyncTask<String, Integer, Void> {
    private ProgressBar progressBar;
    private int current = 0;
    private int max;

    public MyDownLoadTask(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        //展示一个进度条
        Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==onPreExecute=====:" + "我就伪装一下,显示进度条");
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK&&!isCancelled()) {
                int contentLength = httpURLConnection.getContentLength();//长度
                //publishProgress(contentLength);
                max = contentLength;
//                Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==doInBackground=====:" + contentLength);
                InputStream inputStream = httpURLConnection.getInputStream();
                FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "feige.zip");
                int len = 0;
                byte[] bs = new byte[1024 * 8];
                while ((len = inputStream.read(bs)) != -1&&!isCancelled()) {
                    fos.write(bs, 0, len);
                    current += len;
                    publishProgress(current);
//                    Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==doInBackground=====:" + "写文件");
                }
                Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==doInBackground=====:" + "被我手动取消了");
                inputStream.close();
                fos.close();
                current = 0;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        //通知下完成
        Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==onPostExecute=====:" + "下载完成");
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        if (current == 0) {
//            progressBar.setMax(values[0]);
//        } else {
//            progressBar.setProgress(values[0]);
//        }
        progressBar.setMax(max);//每次都设置一下最大值
        progressBar.setProgress(values[0]);//更新进度
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Void aVoid) {
        Log.e("自定义标签", "类名==MyDownLoadTask" + "方法名==onCancelled=====:" + "取消完成");
        super.onCancelled(aVoid);
    }
}
