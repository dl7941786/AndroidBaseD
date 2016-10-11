package com.qianfeng.viewpagerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnTouchListener, ViewPager.OnPageChangeListener, View.OnClickListener {
    /**
     * 无限轮播崩溃的原因,是从右往左滑的时候是先移除后加载,而往回滑的时候是先加载后移除
     */
    private int[] ids = {R.mipmap.liuyifei, R.mipmap.libingbing, R.mipmap.s, R.mipmap.ss};
    private ArrayList<ImageView> imageViewList;
    private ViewPager viewPager;
    private LinearLayout yuandiancontainer;//用于存放小白点的容器
    private int lastPosition;//上次为红点的下标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        yuandiancontainer = (LinearLayout) findViewById(R.id.yuandiancontainer);
        imageViewList = new ArrayList<>();
        createImageView(false);
        if (imageViewList.size() <= 3) {//如果长度小于等3 就复制一份原始数据
            createImageView(true);
        }
        MyPagerAdpaterWithInfinite myPagerAdpaterWithInfinite = new MyPagerAdpaterWithInfinite(imageViewList);
        viewPager.setAdapter(myPagerAdpaterWithInfinite);
//        viewPager.setAdapter(new MyAdapterOther(ids));
        //设置到中间,这也可以左右滑动,而且显示的还刚好是第一张
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % imageViewList.size());//设置中间显示的条目的索引
        handler.sendEmptyMessageDelayed(100, 2000);//启动自动轮播
        viewPager.setOnTouchListener(this);//添加触摸的监听,在监听中移除自动轮播
        viewPager.addOnPageChangeListener(this);
    }

    private void createImageView(boolean isCopy) {
        for (int i = 0; i < ids.length; i++) {//根据数据源的长度创建对应的图片控件并将图片设置到控件上面
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ids[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(imageView);
            if (!isCopy) {//如果是复制数据的情况下,不创建小白点
                //创建小白点
                View view = new View(this);//创建一个 view
                view.setBackgroundResource(R.drawable.enable);// 设置背景色
                if (i == 0) {
                    view.setEnabled(false);//如果是第一个就禁用
                }
                view.setTag(i);
                view.setOnClickListener(this);//给小白点增加点击事件
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);//创建一个参数对象,大小为20px
                layoutParams.rightMargin = 10;//设置右边距为10
                yuandiancontainer.addView(view, layoutParams);//添加到线性布局
            }
        }

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    sendEmptyMessageDelayed(100, 2000);
                    break;
            }


        }
    };

    /**
     * 触摸的事件监听
     *
     * @param view        触摸的 view
     * @param motionEvent 事件类型
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {//区分事件类型
            case MotionEvent.ACTION_DOWN:
                handler.removeMessages(100);//按下去就停止
                break;
            case MotionEvent.ACTION_UP:
                handler.sendEmptyMessageDelayed(100, 2000);//抬起来就重新发
                break;
        }
        return false;
    }

    /**
     * 当页面滑动的时候
     *
     * @param position             当前正在滑动的那一页下标
     * @param positionOffset       滑动的偏移量 百分比 已经滑动了多少了
     * @param positionOffsetPixels 滑动的偏移量(像素),当前总共滑动了多少像素
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Log.e("自定义标签", "onPageScrolled() called with: " + "position = [" + position + "], positionOffset = [" + positionOffset + "], positionOffsetPixels = [" + positionOffsetPixels + "]");
    }

    /**
     * 页面被选中的时候,代表最后显示的页面,这个方法只有和上次页面不一致的时候才会执行(换页)
     *
     * @param position 最终选中的页面
     */
    @Override
    public void onPageSelected(int position) {
        Log.e("自定义标签", "onPageSelected() called with: " + "position = [" + position + "]");
        //更新小白点
        int redPosition = position % ids.length;//当前应该变红的小点的下标
        //找到那个点
        yuandiancontainer.getChildAt(redPosition).setEnabled(false);
        //原来的红点得变为白点
        yuandiancontainer.getChildAt(lastPosition).setEnabled(true);
        lastPosition = redPosition;//更新最后的记录
    }

    /**
     * 页面滑动的状态发生变化的时候
     *
     * @param state 包含拖动1 SCROLL_STATE_DRAGGING, 惯性滚动2 SCROLL_STATE_SETTLING, 停止0SCROLL_STATE_IDLE
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("自定义标签", "onPageScrollStateChanged() called with: " + "state = [" + state + "]");
    }

    /**
     * 用于小白点的点击事件,此页面只有这些点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        //点击后移动对应的偏移量
        int viewPosition = (int) view.getTag();//小白点的相对位置
        int sub = viewPosition - lastPosition;//当前点击的和最后所在位置的偏移量
        viewPager.setCurrentItem(viewPager.getCurrentItem()+sub);//重新设置新的位置
    }

    /**
     * 暂停的生命周期
     */
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(100);//移除掉自动轮播
    }

    @Override
    protected void onResume() {
        super.onResume();
        //
        handler.removeMessages(100);//为了防止 oncreate和 onresume的事件同时触发,移除掉 oncreate
        handler.sendEmptyMessageDelayed(100, 2000);
    }
}
