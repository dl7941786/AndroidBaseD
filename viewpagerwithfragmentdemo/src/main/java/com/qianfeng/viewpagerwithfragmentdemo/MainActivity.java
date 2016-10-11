package com.qianfeng.viewpagerwithfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qianfeng.viewpagerwithfragmentdemo.adapter.MyFragmentAdapter;
import com.qianfeng.viewpagerwithfragmentdemo.adapter.MyFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private MyFragmentStatePagerAdapter myFragmentStatePagerAdapte;
    private MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);//找到 viewpgaer
        //将 fragment 添加到 viewpager中
        fragmentList = new ArrayList<>();
        //1 创建 fragment 对象创建出来
        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();
        FragmentC fragmentC = new FragmentC();
        FragmentD fragmentD = new FragmentD();
        FragmentE fragmentE = new FragmentE();
        FragmentF fragmentF = new FragmentF();
        fragmentList.add(fragmentA);
        fragmentList.add(fragmentB);
        fragmentList.add(fragmentC);//加到集合中
        fragmentList.add(fragmentD);//加到集合中
        fragmentList.add(fragmentE);//加到集合中
        fragmentList.add(fragmentF);//加到集合中
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        myFragmentStatePagerAdapte = new MyFragmentStatePagerAdapter(getSupportFragmentManager(), fragmentList);
        //viewPager.setOffscreenPageLimit(3);//设置预加载的数量,默认是1 ,当前显示的页面左右各再加载3个出来
        viewPager.setAdapter(myFragmentAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change:
                myFragmentStatePagerAdapte.notifyDataSetChanged();
                break;
            case R.id.change1:
                myFragmentAdapter.notifyDataSetChanged();
                ((BaseFragment) fragmentList.get(0)).changeData();
                break;
        }
    }
}
