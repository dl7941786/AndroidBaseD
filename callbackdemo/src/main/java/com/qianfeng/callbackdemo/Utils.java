package com.qianfeng.callbackdemo;

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

import java.io.InputStream;

/**
 * Created by jackiechan on 16/8/4.
 */
public class Utils {
    private handleData handleData;

    public Utils(Utils.handleData handleData) {
        this.handleData = handleData;
    }

    //    public static void getData() {
//        //请求网络
//        InputStream inputStream;
//    }
//    public static void getDataString() {
//        //请求网络
//        InputStream inputStream;
//        String s = new String("将流转换成字符串");
//    }
//    public static void getDataBitmap() {
//        //请求网络
//        InputStream inputStream = null;
//        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//    }
    public void getData(String path) {
        //请求网络
        InputStream inputStream;
        byte[] bs = new byte[0];//将流转成 byte[]
        handleData.handleData(bs);
    }

    public interface handleData {
        void handleData(byte[] bs);
    }
}
