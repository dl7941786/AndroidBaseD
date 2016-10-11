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

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by jackiechan on 16/8/16.
 */
public class MyUtils {
    /**
     * 判断图片是否有缓存
     *
     * @param path
     * @return
     */
    public static boolean isHavaCache(String path, Context context) {
        String name = path.replaceAll("/", "");//替换地址
        //创建File 对象
        File file = new File(context.getExternalCacheDir(), name + ".jpg");
        boolean b = isMount();
        boolean b1 = file.exists();
        return isMount() && file.exists();
    }

    public static boolean isMount() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean isEnoughForCache() {
//        boolean isenough = new StatFs(Environment.getExternalStorageDirectory().getPath()).getFreeBytes() >= 90 * 1024 * 1024;
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        int availableBlocks = statFs.getAvailableBlocks();
        int blockSize = statFs.getBlockSize();
        boolean isenough = availableBlocks * blockSize >= 10 * 1024 * 1024;
        return isenough;
    }

    /**
     * 递归删除目录
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.isDirectory()) {//是个文件夹
            File[] files = file.listFiles();
            for (File file1 : files) {
                deleteFile(file1);
            }
        }else{
            file.delete();
        }
        
    }
}
