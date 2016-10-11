package com.qianfeng.imageviewdemo;

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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiechan on 16/8/2.
 */
public class Utils {
    public static void getPic(final String path, final handleDataListner handleDataListner) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL u = new URL(path);
                    HttpURLConnection mHttpURLConnection = (HttpURLConnection) u.openConnection();
                    mHttpURLConnection.setConnectTimeout(5000);
                    mHttpURLConnection.setReadTimeout(5000);
                    mHttpURLConnection.setRequestMethod("GET");
                    mHttpURLConnection.connect();
                    if (mHttpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        int totalLength=mHttpURLConnection.getContentLength();//获取文件的总长度
                        InputStream inputStream = mHttpURLConnection.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        int downLoadLength = 0;//下载的进度
                        int len = 0;
                        byte[] bs = new byte[1024 * 8];
                        while ((len = inputStream.read(bs)) != -1) {
                            downLoadLength+=len;//更新下载的进度
                            byteArrayOutputStream.write(bs, 0, len);
                            if (handleDataListner != null) {
                                handleDataListner.onProgressUpdata(totalLength,downLoadLength);
//                                handleDataListner.handleData(byteArrayOutputStream.toByteArray());
                            }

                        }
                        inputStream.close();
                        byte[] newbs = byteArrayOutputStream.toByteArray();//转成字节数组
                        if (handleDataListner != null) {
                            handleDataListner.handleData(newbs);
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

    public interface handleDataListner {
        void handleData(byte[] bs);
        void onProgressUpdata(int totallength,int currnetLenght);
    }
}
