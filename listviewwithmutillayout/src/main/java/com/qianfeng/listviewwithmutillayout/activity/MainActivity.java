package com.qianfeng.listviewwithmutillayout.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qianfeng.listviewwithmutillayout.ChatBean;
import com.qianfeng.listviewwithmutillayout.R;
import com.qianfeng.listviewwithmutillayout.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<ChatBean> mChatBeanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mChatBeanList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ChatBean chatBean = new ChatBean();
            double random = Math.random();//0-1之间的随机数
            chatBean.setLeft(random>0.5);
            mChatBeanList.add(chatBean);
        }
        MyAdapter myAdapter = new MyAdapter(mChatBeanList);
        mListView.setAdapter(myAdapter);
    }
}
