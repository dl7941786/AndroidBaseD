package com.qianfeng.viewpagerwithfragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.viewpagerwithfragmentdemo.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OuterFragment extends Fragment {

    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private MyFragmentAdapter myFragmentAdapter;
    public OuterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_outer, container, false);
        //获取到 viewpager
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);//找到 viewpgaer
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
        myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(myFragmentAdapter);
        return view;
    }

}
