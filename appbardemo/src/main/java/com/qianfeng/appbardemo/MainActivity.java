package com.qianfeng.appbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Toolbar.OnMenuItemClickListener {
    /**
     *     <!--去掉 actionbar-->
     <item name="android:windowActionBar">false</item>
     <item name="android:windowNoTitle">true</item>
     <item name="windowActionBar">false</item>
     <item name="windowNoTitle">true</item>


     <!--设置状态栏的颜色-->
     <item name="colorPrimaryDark">@color/windowbackground</item>


     <!--程序背景色-->
     <item name="android:windowBackground">@color/windowbackground</item>

     <!--底部操作栏返回 home颜色必须是21版本才会有的功能-->
     <item name="android:navigationBarColor">@color/windowbackground</item>


     <!--状态栏透明 API 19-->
     <item name="android:windowTranslucentStatus">true</item>

     */
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setSubtitle("这是 subtitile");
        mToolbar.setTitle("这是 titile");//默认是程序名字
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //mToolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.liuyifei));
        setSupportActionBar(mToolbar);//设置 toolbar为 actionbar
        mToolbar.setNavigationOnClickListener(this);//这行代码必须放在setSupportActionBar之后才可以生效,给导航图片设置点击事件
        mToolbar.setOnMenuItemClickListener(this);//设置 optionmen 的条目监听事件,必须放在setSupportActionBar之后
    }

    @Override
    public void onClick(View v) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_edit:
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_edit");
//                break;
//            case R.id.action_share:
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_share");
//
//                break;
//
//            case R.id.action_settings:
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_settings");
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_edit");
                break;
            case R.id.action_share:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_share");
                break;
            case R.id.action_settings:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onOptionsItemSelected=====:" + "action_settings");
                break;
        }
        return false;
    }
}
