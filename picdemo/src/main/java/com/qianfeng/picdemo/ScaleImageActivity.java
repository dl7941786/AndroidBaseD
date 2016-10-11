package com.qianfeng.picdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ScaleImageActivity extends AppCompatActivity {
    private ImageView iv, iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_image);
        iv = (ImageView) findViewById(R.id.iv);
        iv1 = (ImageView) findViewById(R.id.iv1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ss);
        iv.setImageBitmap(bitmap);
        //创建空白图
        Bitmap copyBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());//创建一张大小质量和 bitmap 一样的空白图
        Paint paint = new Paint();//创建一个画笔
        Canvas canvas = new Canvas(copyBitmap);//创建一个背景图是copyBitmap的画布
        Matrix matrix = new Matrix();//创建一个1:1的矩阵
//        matrix.setScale(2.0f,2.0f);//设置缩放
//        paint.setColor(Color.RED);
//        canvas.drawLine(0,0,100,100,paint);
//        matrix.setTranslate(100, 200);
//        matrix.setRotate(180,bitmap.getWidth()/2,bitmap.getHeight()/2);//旋转

/////////
//        matrix.setScale(-1,1);
//        matrix.postTranslate(bitmap.getWidth(), 0);//镜面效果

        /////////
        matrix.setScale(1, -1);
        matrix.postTranslate(0, bitmap.getHeight());//倒影效果


        canvas.drawBitmap(bitmap, matrix, paint);
        iv1.setImageBitmap(copyBitmap);
    }
}
