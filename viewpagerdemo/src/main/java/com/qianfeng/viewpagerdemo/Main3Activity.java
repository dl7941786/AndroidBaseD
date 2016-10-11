package com.qianfeng.viewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<ImageView> imageViewList;
    private int[] ids = {R.mipmap.liuyifei, R.mipmap.libingbing, R.mipmap.s};
    private String[] ss = {"好纠结啊", "纠结啥啊", "不知道啊", "不知却道"};
    private List<String> stringList = new ArrayList<>();
    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        imageViewList = new ArrayList<>();
//        createImageview();
        for (int i = 0; i < 4; i++) {//弄出12个图来
            createImageview();
        }
//        tabLayout.addTab(tabLayout.newTab().setText("好纠结啊"));
//        tabLayout.addTab(tabLayout.newTab().setText("纠结啥啊"));
//        tabLayout.addTab(tabLayout.newTab().setText("不知道啊"));
//        tabLayout.addTab(tabLayout.newTab().setText("不知却道"));
        tabLayout.addOnTabSelectedListener(this);
        for (int i = 0; i < 3; i++) {//弄出12个字符串
            for (int j = 0; j < ss.length; j++) {
                TabLayout.Tab tab = tabLayout.newTab();
                tab.setTag((i * ss.length + j));
                tabLayout.addTab(tab);//设置标题
                stringList.add(ss[j]);//加载字符串集合
            }
        }
        myViewPagerAdapter = new MyViewPagerAdapter(imageViewList, stringList);
        tabLayout.setupWithViewPager(viewPager);//与哪个 viewpager 保持联动, 这行代码会导致所有的 tab被删除然后重新添加,所以上面的属性都会被回收
        viewPager.setAdapter(myViewPagerAdapter);
        for (int i = 0; i < 3; i++) {//必须放在最后
            for (int j = 0; j < ss.length; j++) {
                tabLayout.getTabAt(i * ss.length + j).setTag(i * ss.length + j);//重新 settag
            }
        }

    }

    /**
     * 创建图片控件
     */
    private void createImageview() {
        for (int i = 0; i < ids.length; i++) {//根据数据源的长度创建对应的图片控件并将图片设置到控件上面
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ids[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViewList.add(imageView);
            imageView.setOnClickListener(this);//给条目设置点击事件
        }
    }

    /**
     * 当前被选中的标签
     *
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
//        int position = tab.getPosition();
//        Log.e("自定义标签", "onTabSelected() called with: " + "tab = [" + tab + "]");
        // int tag = ((int) tab.getTag());
//        switch (tag) {
//            case 0:
//                Log.e("自定义标签", "类名==Main3Activity" + "方法名==onTabSelected=====:" + "当前点击的是"+tag);
//                break;
//        }
        Log.e("自定义标签", "类名==Main3Activity" + "方法名==onTabSelected=====:" + tab.getTag());

    }

    /**
     * 由选中变为未选中状态的标签
     *
     * @param tab
     */
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
//        Log.e("自定义标签", "onTabUnselected() called with: " + "tab = [" + tab + "]");
    }

    /**
     * 当前处于选中状态的时候 再次点击 重复选中
     *
     * @param tab
     */
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
//        Log.e("自定义标签", "onTabReselected() called with: " + "tab = [" + tab + "]");
    }

    @Override
    public void onClick(View view) {
        Log.e("自定义标签", "类名==Main3Activity" + "方法名==onClick=====:" + "");
    }
}
