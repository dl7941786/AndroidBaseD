package com.qianfeng.xianghaapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianfeng.xianghaapp.R;
import com.qianfeng.xianghaapp.adapter.SplashViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private List<ImageView> imageViewList;
    private int[] ids = {R.mipmap.libingbing, R.mipmap.liuyifei, R.mipmap.s, R.mipmap.ss};
    private LinearLayout indicatorarean;
    private int lastPosition;
    private TextView mTextView;
    private SplashViewPagerAdapter splashViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //如果是第一次启动,执行引导页,否则直接跳转到主页
        boolean isFirst = getSharedPreferences("name", MODE_PRIVATE).getBoolean("isFirst", true);//获取存储的是否首次 boolean. 如果没有则代表是首次启动, 默认是 true 代表没有启动过, fasle 代表启动过了
        if (isFirst) {
            firstOpen();
        } else {
            startActivity();//如果不是第一次启动,直接进入主页
        }
    }

    /**
     * 首次启动执行的代码
     */
    private void firstOpen() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextView = (TextView) findViewById(R.id.button);//点击进入主页的按钮
        imageViewList = new ArrayList<>();
        indicatorarean = (LinearLayout) findViewById(R.id.indicatorarean);//白点指示器区域
        for (int i = 0; i < ids.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ids[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(imageView);
            if (i == ids.length - 1) {//如果是最后一张图片,增加点击进入主页的事件
                imageView.setOnClickListener(this);
            }
            View viwe = new View(this);//创建指示器圆点
            viwe.setBackgroundResource(R.drawable.enable);
            if (i != 0) {
                viwe.setEnabled(false);//默认只有第一个为红色,其他为黑色
            }
            LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(20, 20);
            layoutParam.rightMargin = 10;//设置右边距为10
            indicatorarean.addView(viwe, layoutParam);
        }
        splashViewPagerAdapter = new SplashViewPagerAdapter(imageViewList);
        viewPager.setAdapter(splashViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);//滑动监听
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {//更改指示器的选中位置
        View childAt = indicatorarean.getChildAt(position);//找到在指示器区域的指定索引的点
        childAt.setEnabled(true);//设置为启用,变成红色
        //将上一次的红色变回黑色
        indicatorarean.getChildAt(lastPosition).setEnabled(false);
        lastPosition = position;//将当前位置变为上一次的位置
        if (position == ids.length - 1) {//最后一页出现了
            // splashViewPagerAdapter.getCount()-1 应该用适配器内容的长度-1
            mTextView.setVisibility(View.VISIBLE);//显示出来
        } else {
            mTextView.setVisibility(View.GONE);//如果不是最后一页(到过最后一页,但是又往回滑了)
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
            default:
                startActivity();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                //下次启动就不能再进入引导页了
                getSharedPreferences("name", MODE_PRIVATE).edit().putBoolean("isFirst", false).apply();//存储一下,已经不是第一次了
                break;
        }

    }

    private void startActivity() {
        //点击后进入主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();//引导页不允许从上一页返回,所以必须结束
    }
}
