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

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by jackiechan on 16/8/26.
 */
public class MyLruCache extends LruCache<String, Bitmap> {
    private static MyLruCache myLruCache = new MyLruCache((int) (Runtime.getRuntime().maxMemory() / 1024 / 8));//内存的1/8作为缓存之

    public static MyLruCache getInstance() {
        return myLruCache;
    }

    /**
     * 缓存的最大空间,取最大空间的1/8,整个程序缓存应该只有一个
     *
     * @param maxSize
     */
    private MyLruCache(int maxSize) {
        super(maxSize);
    }

    /**
     * 返回每个缓存对象的大小
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;//返回大小  KB 单位
    }
}