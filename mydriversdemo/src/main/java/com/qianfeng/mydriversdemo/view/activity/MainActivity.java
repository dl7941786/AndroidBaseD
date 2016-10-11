package com.qianfeng.mydriversdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.adapter.MyFragmentStateAdapter;
import com.qianfeng.mydriversdemo.view.fragment.BaseFragment;
import com.qianfeng.mydriversdemo.view.fragment.CCCFragment;
import com.qianfeng.mydriversdemo.view.fragment.CarFragment;
import com.qianfeng.mydriversdemo.view.fragment.ComputerFragment;
import com.qianfeng.mydriversdemo.view.fragment.GameFragment;
import com.qianfeng.mydriversdemo.view.fragment.ItCricleFragment;
import com.qianfeng.mydriversdemo.view.fragment.MovieFragment;
import com.qianfeng.mydriversdemo.view.fragment.PhoneFragment;
import com.qianfeng.mydriversdemo.view.fragment.RecommentFragment;
import com.qianfeng.mydriversdemo.view.fragment.ScienceFragment;
import com.qianfeng.mydriversdemo.view.fragment.SofeWareFragment;
import com.qianfeng.mydriversdemo.view.fragment.TVFragment;
import com.qianfeng.mydriversdemo.view.fragment.TuiJianFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private String[] titles = {"最新", "推荐", "手机", "IT圈", "汽车", "科学", "游戏", "电脑", "影音", "软件", "数码", "家电", "详情"};
    private List<BaseFragment> fragmentList;
    private MyFragmentStateAdapter myFragmentStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new RecommentFragment());//把最新加进来
        fragmentList.add(new TuiJianFragment());//
        fragmentList.add(new PhoneFragment());//
        fragmentList.add(new ItCricleFragment());//
        fragmentList.add(new CarFragment());//
        fragmentList.add(new ScienceFragment());//
        fragmentList.add(new GameFragment());//
        fragmentList.add(new ComputerFragment());//
        fragmentList.add(new MovieFragment());//
        fragmentList.add(new SofeWareFragment());//
        fragmentList.add(new CCCFragment());//
        fragmentList.add(new TVFragment());//
        myFragmentStateAdapter = new MyFragmentStateAdapter(getSupportFragmentManager(), fragmentList, titles);
        viewPager.setAdapter(myFragmentStateAdapter);
        mTabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mysave:
                //跳转到收藏页面
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("page", "saved");
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
