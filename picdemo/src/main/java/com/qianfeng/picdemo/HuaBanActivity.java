package com.qianfeng.picdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class HuaBanActivity extends AppCompatActivity {

    private ImageView huahuaban;
    private int startX, startY;//每次绘制线的初始点
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hua_ban);
        huahuaban = (ImageView) findViewById(R.id.huahuaban);
        final Bitmap bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.RGB_565);//创建一个大小为300x300的空白图
        final Paint paint = new Paint();
        final Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.GREEN);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(9);
        huahuaban.setImageBitmap(bitmap);
        huahuaban.setOnTouchListener(new View.OnTouchListener() {//设置触摸事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: //按下去,记录一个点
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE://滑动的时候

                        int stopX = (int) event.getX();//获取当前移动的x 点
                        int stopY = (int) event.getY();
                        canvas.drawLine(startX, startY, stopX, stopY, paint);//绘制线
                        startX = stopX;//绘制完成后将当前点再设置为起点
                        startY = stopY;
                        huahuaban.setImageBitmap(bitmap);//设置图片
                        break;

                    case MotionEvent.ACTION_UP:

                        break;
                }



                return true;
            }
        });

    }
}
