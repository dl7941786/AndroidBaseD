package com.qianfeng.listviewdemo3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.qianfeng.listviewdemo3.R;
import com.qianfeng.listviewdemo3.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {

    private ListView listView;
    private MyAdapter myAdapter;
    private boolean isCanLoadMore = false;
    private boolean isLoading = false;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("这是第" + i + "条数据");
        }
        myAdapter = new MyAdapter(list);
        listView.setAdapter(myAdapter);
//        myAdapter.notifyDataSetChanged();//刷新数据,如果集合对象本身发生变化, 会从头到尾刷新数据,如果是集合内部的是数据长度发生变化,从最后一条开是刷新数据,如果是对象发生变化,需要重新设置适配器
        listView.setOnItemClickListener(this);//设置条目的点击事件
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + listView);
        listView.setOnScrollListener(this);//设置滑动
    }
    /**
     * 当条目被点击的时候
     * @param parent  当前点的条目所在的listview
     * @param view 当前点击的 item
     * @param position 当前点击的是第几条
     * @param id 当前 item的 id ,就是 adapter 中 getid 返回的值
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Log.e("自定义标签", "onItemClick() called with: " + "parent = [" + parent + "], view = [" + view + "], position = [" + position + "], id = [" + id + "]");
        // 在这里通过数据源获取对应位置的数据,然后做具体操作,比如跳转啊 或者是其他操作
        Toast.makeText(this,"当前点击的是第"+position+"条数据",Toast.LENGTH_SHORT).show();
    }

    /**
     * 滑动状态变化
     * @param view
     * @param scrollState 1 SCROLL_STATE_TOUCH_SCROLL是拖动   2 SCROLL_STATE_FLING是惯性滑动  0SCROLL_STATE_IDLE是停止 , 只有当在不同状态间切换的时候才会执行
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
       // Log.e("自定义标签", "onScrollStateChanged() called with: " + "view = [" + view + "], scrollState = [" + scrollState + "]");
        if (isCanLoadMore && scrollState == SCROLL_STATE_IDLE) {
            Toast.makeText(this, "正在拼命加载中.....", Toast.LENGTH_SHORT).show();
            isLoading = true;//应该在网络请求结束(包括异常)后 修改为 false
            isCanLoadMore = false;
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                list1.add("这是新" + i);
            }
            list1.addAll(0, list);//将老的数据源加载新的数据源
            myAdapter.setStringList(list1);//设置新数据源
//            list.addAll(list1);
            myAdapter.notifyDataSetChanged();//刷新界面
            isLoading = false;
        }
    }

    /**
     *
     * @param view listview
     * @param firstVisibleItem 第一个可见的 item 的索引
     * @param visibleItemCount 可以显示的 item的条数
     * @param totalItemCount 总共有多少个 item
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount) {//代表最后一条出来了,仅仅是代表出来了,需要判断最后一条距离父控件顶部的距离
            View childAt = view.getChildAt(visibleItemCount - 1);//getchildat 只获取屏幕内可见的 item
//            Log.e("自定义标签", "类名==MainActivity" + "方法名==onScroll=====:" + childAt);
            if (!isLoading&&childAt != null && childAt.getBottom() <= view.getHeight()) {//如果最后一条的底部距离 listview的顶部 小于等于 listview 高度,代表最后一条完全出现在 listview 内部
                isCanLoadMore = true;//可以加载了
            }
        }
//        Log.e("自定义标签", "onScroll() called with: " + "view = [" + view + "], firstVisibleItem = [" + firstVisibleItem + "], visibleItemCount = [" + visibleItemCount + "], totalItemCount = [" + totalItemCount + "]");
    }
    //分页
}
