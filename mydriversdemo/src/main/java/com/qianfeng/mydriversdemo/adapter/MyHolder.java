package com.qianfeng.mydriversdemo.adapter;

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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.mydriversdemo.model.RecommentModel;
import com.qianfeng.mydriversdemo.utils.HttpUtils;
import com.qianfeng.mydriversdemo.utils.MyLruCache;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jackiechan on 16/8/25.
 */
public class MyHolder {
    private View convertView;
    private int id;
    private Context mContext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private SparseArray<View> sparseArray = new SparseArray<>();

    public MyHolder(Context context, @LayoutRes int id) {
        mContext = context;
        //创建convertView
        convertView = LayoutInflater.from(context).inflate(id, null);
        this.id = id;//创建本次视图时候的 id
        convertView.setTag(this);
    }

    public static MyHolder getHolder(View convertView, Context context, @LayoutRes int id) {
        MyHolder myHolder = null;
        if (convertView == null) {
            myHolder = new MyHolder(context, id);//创建 holder和布局
        } else {
            myHolder = (MyHolder) convertView.getTag();//通过布局获取到 holder
            if (myHolder.id != id) {//当前复用 view 所属的布局和传递过来的布局是否一样.一样代表可以复用
                Log.e("自定义标签", "类名==MyHolder" + "方法名==getHolder=====:" + "创建新布局");
                myHolder = new MyHolder(context, id);
            }
        }
        return myHolder;

    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * 查找控件
     *
     * @param id
     * @return
     */
    public View findView(@IdRes int id) {
        View view = sparseArray.get(id);//先从缓存中拿
        if (view == null) {//缓存中没有
            view = convertView.findViewById(id);//从控件身上拿
            sparseArray.put(id, view);//添加到缓存集合
        }
        return view;
    }

    /**
     * 设置文本内容
     *
     * @param id
     * @param text
     */
    public void setText(@IdRes int id, String text) {
        ((TextView) findView(id)).setText(text);
    }

    public void setImage(@IdRes final int id, String path) {
        final ImageView imageView = (ImageView) findView(id);//拿到图片控件
        imageView.setTag(path);//设置想要的地址为当前这个地址
        Bitmap bitmap = MyLruCache.getInstance().get(path);//获内存缓存的图片
        if (bitmap == null) {//如果没有缓存,先找本地文件,如果还没有,再去请求网络
            //从文件中找
            bitmap = BitmapFactory.decodeFile(mContext.getExternalCacheDir() +"/"+ path.replaceAll("/", "") + ".jpg");
            if (bitmap != null) {//如果本地有了,就直接读取
                imageView.setImageBitmap(bitmap);
                MyLruCache.getInstance().put(path, bitmap);//再放到内存缓存中
            } else {//本地也没有才最终请求网络
                //请求图片
                HttpUtils.loadDataGet(path, new RecommentModel.OnLoadCompleteListener() {
                    @Override
                    public void onLoadComplete(byte[] bytes, final String path) {
                        String tag = (String) imageView.getTag();
                        final Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        MyLruCache.getInstance().put(path, bitmap);//放到内存缓存
                        //顺便放到本地文件
                        new Thread() {
                            @Override
                            public void run() {
                                //子线程写文件
                                try {
                                    FileOutputStream fos = new FileOutputStream(mContext.getExternalCacheDir() +"/"+path.replaceAll("/", "") + ".jpg");
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                    fos.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();


                        if (path.equals(tag) && bytes != null) {//如果请求的地址与想要的地址一样
                            imageView.setImageBitmap(bitmap);
                        }
                    }
                });
            }

        } else {//有缓存
            imageView.setImageBitmap(bitmap);
        }


    }
}
