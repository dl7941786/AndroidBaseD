package com.qianfeng.day07homework.view.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.qianfeng.day07homework.R;
import com.qianfeng.day07homework.adapter.MyDriversAdapter;
import com.qianfeng.day07homework.bean.DriversBean;
import com.qianfeng.day07homework.presenter.Main2Presenter;
import com.qianfeng.day07homework.view.mvpview.MvpView;

import java.util.List;

public class Main2ActivityDrivers extends BaseActivity<MvpView,Main2Presenter> implements MvpView<List<DriversBean>>{
    private String path = "http://m.mydrivers.com/app/newslist.aspx?%20tid=0&minId=0&maxId=0&ver=2.2&temp=1464423764091";
    private ListView listView;
    private MyDriversAdapter myDriversAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activity_drivers);
        listView = (ListView) findViewById(R.id.listview);
        //请求数据
        basePresenter.Load(path);
    }



    @Override
    public Main2Presenter getBasePresenter() {
        return new Main2Presenter();
    }

    @Override
    public void showView(List<DriversBean> driversBeen) {
        myDriversAdapter = new MyDriversAdapter(driversBeen);
        listView.setAdapter(myDriversAdapter);
    }
}
