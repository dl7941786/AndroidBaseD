package com.qianfeng.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<ImageView> imageViewList;
    private int[] ids = {R.mipmap.liuyifei, R.mipmap.libingbing, R.mipmap.s};
    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        imageViewList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {//根据数据源的长度创建对应的图片控件并将图片设置到控件上面
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ids[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(imageView);
        }
        myViewPagerAdapter = new MyViewPagerAdapter(imageViewList);
        viewPager.setAdapter(myViewPagerAdapter);
    }
}
