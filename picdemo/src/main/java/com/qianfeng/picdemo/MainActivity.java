package com.qianfeng.picdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

/**
 * 1 byte 8位  8个0,1   00000000
 */
public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
//        long l = Runtime.getRuntime().totalMemory();
        // getResources().getDisplayMetrics();
        DisplayMetrics displayMetric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetric);//获取屏幕宽高度
        long l1 = Runtime.getRuntime().totalMemory();
        Bitmap bitmap = decodeBitmap(displayMetric.widthPixels, displayMetric.heightPixels, null);//按照屏幕的宽高度进行压缩
        Bitmap bitmap1 = decodeBitmap(displayMetric.widthPixels, displayMetric.heightPixels, null);//按照屏幕的宽高度进行压缩
        Bitmap bitmap3 = decodeBitmap(displayMetric.widthPixels, displayMetric.heightPixels, null);//按照屏幕的宽高度进行压缩
        Bitmap bitmap4 = decodeBitmap(displayMetric.widthPixels, displayMetric.heightPixels, null);//按照屏幕的宽高度进行压缩
        iv.setImageBitmap(bitmap);
        long l2 = Runtime.getRuntime().totalMemory();
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + l1 + "---" + l2);
//        long l1 = Runtime.getRuntime().totalMemory();
//        long l2 = Runtime.getRuntime().freeMemory();
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + l + "-----" + l1 + "------" + l2);


//        Bitmap bitmap789 = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
//        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
//        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.aa);
//        iv.setImageResource(R.mipmap.aa);
//        iv.setImageBitmap(bitmap);
    }

    /**
     * /**
     * 压缩图片
     * @param width  期望的宽度
     * @param height 期望的高度
     * @param bs     原始图片数据
     * @return 压缩后的图
     */
    private Bitmap decodeBitmap(int width, int height, byte[] bs) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;//进入只编码模式,只获取元数据,不真正加载整个图片
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.aa, options);//把图片加载到内存中
        BitmapFactory.decodeByteArray(bs, 0, bs.length, options);//得到元数据
        int outHeight = options.outHeight;//获取到图片的高度
        int outWidth = options.outWidth;//获取到图片的宽度
        //进行压缩,按照宽高度比例压缩
//        int heightScale = (outHeight + height - 1) / height;
//        int widthScale = (outWidth + width - 1) / width;
        //自定义标准,0.4以内视为0  超过0.4视为1
        int heightScale = (int) (outHeight * 1.0 / height + 0.6f);//高度的缩放比例值
        int widthScale = (int) (outWidth * 1.0 / width + 0.6f);//宽度的缩放比例值
        int realScale = heightScale > widthScale ? heightScale : widthScale;//计算出真正的缩放比例
        options.inPreferredConfig = Bitmap.Config.RGB_565;//16位  1个像素点2个 byte,设置图片的质量
        if (realScale > 1) {//如果缩放比例大于1,就缩放
            //
            options.inSampleSize = realScale;//设置缩放比例

        }
        //重新生成图片
        options.inJustDecodeBounds = false;//退出仅编码格式
        Bitmap decodeResource = BitmapFactory.decodeByteArray(bs, 0, bs.length, options);//重新生成图片
        return decodeResource;//返回缩放的图片
//        return null;//如果返回 null 代表不需要缩放
    }
}
