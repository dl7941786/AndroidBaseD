package com.qianfeng.picdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class SiYiFuActivity extends AppCompatActivity {

    private ImageView ivafter,ivbefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_yi_fu);
        ivafter = (ImageView) findViewById(R.id.ivafter);
        ivbefore = (ImageView) findViewById(R.id.ivbefore);
        ivafter.setImageResource(R.mipmap.after19);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pre19);//获取原始图片,不能修改的
        final Bitmap copy = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());//创建一个以原始图的宽高为宽高,属性为属性的可以修改的图片
        Paint paint = new Paint();
        Canvas canvas = new Canvas(copy);//以复制的图片为背景创建画布
        Matrix matrix = new Matrix();
        canvas.drawBitmap(bitmap, matrix, paint);//绘制图片
        ivbefore.setImageBitmap(copy);//设置图片
        ivbefore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN://按下手指

                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        float x = event.getX();//获取到当前滑动到的X点
                        float y = event.getY();
                        for (int i =-8;i<9;i++) {
                            for (int j =-8;j<9;j++) {
                                if ((i * i + j * j) <= 64) {
                                    copy.setPixel((int)x+i, (int)y+j, Color.TRANSPARENT);//设置像素点的颜色
                                    ivbefore.setImageBitmap(copy);
                                }
                            }
                        }


                        break;
                    case MotionEvent.ACTION_UP://抬起

                        break;
                }


                return true;//消费事件,事件终止传递
            }
        });

    }
}
