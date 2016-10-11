package com.qianfeng.day02demo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mRelativeLayout;
    private TextView tv1;
    private TextView touxiang;
    private TextView tv2;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_relative);//是将里面所有的控件解析出来后存放起来 类似于 map
//        mRelativeLayout = (RelativeLayout) findViewById(R.id.relat);//找到指定的控件了,需要注意!!!!!!!!!! 这里的 id 一定得在上面的 layout 资源文件中
        // mRelativeLayout.setBackgroundColor(Color.RED);//设置背景色为红色
        //mRelativeLayout.setPadding(100,200,300,400);//设置内边距
        //tv1 = (TextView) findViewById(R.id.tv1);//查找控件
//        tv1.setVisibility(View.GONE);//设置不可见
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tv1.getLayoutParams();//获取当前控件身上父容器的参数(我在父容器里面是什么位置啊 有没有什么 margin 之类的属性)
//        layoutParams.leftMargin=200;//设置左边距
        // tv1.setGravity(Gravity.CENTER);//设置内容的重心为居中
//        touxiang = (TextView) findViewById(R.id.touxiang);// 需要注意 会出现空指针, 因为touxiang这个 id 并不在layout_relative这个资源文件中
//        touxiang.getText();


        ///-----------------------------------------------------------以下是 textview 控件相关的代码
        setContentView(R.layout.layout_textview);
        tv2 = (TextView) findViewById(R.id.tv2);
        String tv2text = tv2.getText().toString();//获取文本上面的内容
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + tv2text);
//        tv2.setText("这是我通过代码设置的内容");//设置文本
//        tv2.setText(R.string.app_name);
//        tv2.setText(new A().getAge());//android.content.res.Resources$NotFoundException: String resource ID #0x3e8
        //上面的异常, 设置文本的时候指定了一个 int 类型的变量,系统会去R 文件找与这个 int数对应的String 类型的字符串资源,找不到就抛异常
        // tv2.setTextSize(50);//设置文字的大小,这里的单位是 sp
        // Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====文字的大小:" + tv2.getTextSize());// 获取文字的大小,返回的 px
        tv2.setTextColor(Color.parseColor("#00ff00"));//设置肢体的颜色
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + tv2.getTextColors().getDefaultColor());//获取文字的颜色
        Drawable drawable =getResources().getDrawable(R.mipmap.ic_launcher);//获取一个 drawable
//        tv2.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher,null,null,null);
        tv2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable,null,null,null);//设置文字周围的图片
      //  tv2.setCompoundDrawables(drawable,null,drawable,null);
        tv2.setMaxLines(2);
        tv2.setText(tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text+tv2text);
        tv2.setSingleLine(true);//设置单行显示
        tv2.setHeight(500);//设置高度
    }
}
