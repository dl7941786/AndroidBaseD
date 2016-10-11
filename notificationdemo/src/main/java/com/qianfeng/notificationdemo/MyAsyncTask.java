package com.qianfeng.notificationdemo;

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

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.RemoteViews;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiechan on 16/8/29.
 */
public class MyAsyncTask extends AsyncTask<String,Integer,byte[]> {
    private Context mContext;
    private int contentLength;
    private NotificationManager manager;

    public MyAsyncTask(NotificationManager manager, Context mContext) {
        this.manager = manager;
        this.mContext = mContext;
    }

    @Override
    protected byte[] doInBackground(String... params) {
        //下载文件
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(8000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK&&!isCancelled()) {
                //首先获取数据的总长度
                contentLength = urlConnection.getContentLength();
                //更新一次进度,通知一次
                publishProgress(0);
                //读取数据
                int sum = 0;
                int len;
                byte[] bs = new byte[2048 * 8];
                InputStream inputStream = urlConnection.getInputStream();
                while ((len = inputStream.read(bs)) != -1) {
                    sum += len;
                    //在这里就不写文件了
                    publishProgress(sum);
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {


        }

        return null;
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int current = values[0];
        Notification.Builder builder = new Notification.Builder(mContext);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        RemoteViews remoteView = new RemoteViews(mContext.getPackageName(), R.layout.notifacation_custom);
        if (current == 0) {//刚开始,推出正在下载的通知
            remoteView.setTextViewText(R.id.tv1,"正在下载,当前进度是0%");
        }else if (current<contentLength){
            remoteView.setTextViewText(R.id.tv1,"已经下载"+ current*100/contentLength+"%");
        }else{
            remoteView.setTextViewText(R.id.tv1,"好像是下载完成了");
        }
        remoteView.setProgressBar(R.id.progress, contentLength, current,false);
        builder.setContent(remoteView);
        Notification notification = builder.getNotification();
        manager.notify(100, notification);
    }
}
