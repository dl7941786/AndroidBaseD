package com.qianfeng.xianghaapp.utils;

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
import android.os.AsyncTask;

import com.qianfeng.xianghaapp.model.MvpModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiechan on 16/8/12.
 */
public class MyAsyncTask extends AsyncTask<String,Integer,byte[]> {
    private String path;
    private MvpModel.OnLoadCompleteListener onLoadCompleteListener;
    private ProgressDialog progressDialog;
    private int maxLength;
    private int tag;
    public MyAsyncTask(MvpModel.OnLoadCompleteListener onLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener;
    }
    public MyAsyncTask(MvpModel.OnLoadCompleteListener onLoadCompleteListener, ProgressDialog progressDialog) {
        this.onLoadCompleteListener = onLoadCompleteListener;
        this.progressDialog = progressDialog;
    }

    public MyAsyncTask(ProgressDialog progressDialog, MvpModel.OnLoadCompleteListener onLoadCompleteListener, int tag) {
        this.progressDialog = progressDialog;
        this.onLoadCompleteListener = onLoadCompleteListener;
        this.tag = tag;
    }

    /**
     * 可以在这里弹出对话框
     */
    @Override
    protected void onPreExecute() {
        if (progressDialog != null) {
            progressDialog.show();
        }
        super.onPreExecute();
    }

    @Override
    protected byte[] doInBackground(String... params) {
        //请求数据
        try {
            path = params[0];
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (tag == 1) {
                httpURLConnection.setRequestProperty("Cookie", "device=and#Galaxy Nexus#5.1.1#4.2.4#720#1184#developer.huawei#wifi#282#com.xiangha#1#82078609832;xhCode=bd894c82a8ac86fc28868490e128e4cf;geo=;USERID=hfpm755qftvipm5jrc1fr9om40");
            }
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK&&!isCancelled()) {//判断是200并且没有取消任务
                maxLength = httpURLConnection.getContentLength();
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len = 0;
                int currentProgress = 0;
                byte[] bs = new byte[1024 * 8];
                while ((len = inputStream.read(bs)) != -1 && !isCancelled()) {
                    currentProgress += len;
                    publishProgress(currentProgress);
                    bos.write(bs, 0, len);
                }
                inputStream.close();
                return bos.toByteArray();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        if (progressDialog != null) {
            if (progressDialog.getMax() ==0) {
                progressDialog.setMax(maxLength);
            }
            progressDialog.setProgress(values[0]);
        }
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(path,bytes);
        }
    }
}
