package com.qianfeng.day07homework.view.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.qianfeng.day07homework.R;
import com.qianfeng.day07homework.adapter.MyAdapter;
import com.qianfeng.day07homework.bean.ReCaiBean;
import com.qianfeng.day07homework.presenter.MainActivityPresenter;
import com.qianfeng.day07homework.view.mvpview.MvpView;

import java.util.List;

public class MainActivity extends BaseActivity<MvpView,MainActivityPresenter> implements MvpView<List<ReCaiBean.ObjBean.DataBean>> {
    private String path = "http://api102.meishi.cc/v5/class_list1.php?lon=&source=android&cid=6&vk=2417a0052eac5cd81d5dce4d168a3973&sort_sc=asc&sort=default&lat=&page=%d&bcid=13&format=json";
    private ListView listView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
//        new MainActivityPresenter(this).setMvpModel(1).load(String.format(path,1));
        basePresenter.setMvpModel(1).load(null);
    }

    @Override
    public MainActivityPresenter getBasePresenter() {
        return new MainActivityPresenter();
    }

    /**
     * 显示界面的回调
     * @param list
     */
    @Override
    public void showView(List<ReCaiBean.ObjBean.DataBean> list) {
        myAdapter = new MyAdapter(list);
        listView.setAdapter(myAdapter);
    }
}
