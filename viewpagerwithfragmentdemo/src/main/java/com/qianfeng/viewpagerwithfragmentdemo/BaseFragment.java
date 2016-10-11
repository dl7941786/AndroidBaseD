package com.qianfeng.viewpagerwithfragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.qianfeng.viewpagerwithfragmentdemo.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {


    private TextView mTextView;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private List<String> list;
    public BaseFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==" + getClass().getSimpleName() + "方法名==onCreateView=====:" + "");
        View view = inflater.inflate(R.layout.fragment_base, container, false);
//        mTextView = ((TextView) view.findViewById(R.id.title));
//        mTextView.setText(getClass().getSimpleName());
        listView = ((ListView) view.findViewById(R.id.listview));
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("这是第" + i);
        }
        listViewAdapter = new ListViewAdapter(list);
        listView.setAdapter(listViewAdapter);
        return view;
    }

    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==" + getClass().getSimpleName() + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }

    public void changeData() {
//        listViewAdapter.setCount(200);
        list = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            list.add("这是新的" + i);
            listViewAdapter.setStringList(list);
        }
    }
}
