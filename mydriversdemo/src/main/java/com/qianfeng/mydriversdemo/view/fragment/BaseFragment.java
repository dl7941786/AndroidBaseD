package com.qianfeng.mydriversdemo.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.presenter.BasePresenter;
import com.qianfeng.mydriversdemo.utils.GloableInerface;
import com.qianfeng.mydriversdemo.view.MvpView;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment<T extends BasePresenter, V extends MvpView> extends MySuperBaseFragment<T,V> implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    public ListView mListView;
//    public T presenter;
    public String myUrl;//第一页的数据
    public String loadMore;//分页地址
    private boolean isCanRefresh;//是否可以分页
    private boolean isLoading;//是不是正在分页
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        mListView = (ListView) view.findViewById(R.id.listview);
//        presenter = createPresenter();//创建 presenter
//        presenter.attach((V) this);
        myUrl = String.format(GloableInerface.DATAURL, getType());//拼接地址
        mListView.setOnScrollListener(this);
        mListView.setOnItemClickListener(this);
        loadData();
        return view;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
            //在这里当停下的时候加载数据
        if (scrollState == SCROLL_STATE_IDLE&&isCanRefresh) {//停下并且是可以加载数据
            isCanRefresh = false;
            isLoading = true;
            //加载数据
            loadMore();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount&&!isLoading) {//最后一条出现,同时没有正在加载数据
            View childAt = view.getChildAt(visibleItemCount - 1);//获取屏幕内的最后一条 item
            if (childAt != null && childAt.getBottom() == view.getHeight()) {//最后一条完整出现
                isCanRefresh = true;//可以刷新了
            }
        }
    }

    public void setCanNotLoadMore() {
        isLoading = true;//特殊情况不允许分页
    }
    /**
     * 加载完成
     */
    public void loadCompleted() {
        isLoading = false;
    }

    /**
     * 加载分页的方法
     */
    public abstract void loadMore();
    /**
     * 加载数据的方法,子类去实现即可
     */
    public abstract void loadData();

    public abstract int getType();//每页的类型

//    public abstract T createPresenter();//创建 presenter
}
