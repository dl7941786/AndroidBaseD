package com.qianfeng.listviewpartrefresh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.qianfeng.listviewpartrefresh.R;
import com.qianfeng.listviewpartrefresh.adpater.MyAdapter;
import com.qianfeng.listviewpartrefresh.bean.MyBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int GETCONTENT = 100;
    private ListView listView;
    private MyAdapter myAdapter;
    private List<MyBean> myBeenlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        myBeenlList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            MyBean myBean = new MyBean();
            myBean.setTv1("tv发顺丰1" + i);
            myBean.setTv2("tv发韵达2" + i);
            myBeenlList.add(myBean);
        }
        myAdapter = new MyAdapter(myBeenlList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }

    private View clickView;//用一个 view 记录住点击的 view,但是有缺点,如果不是通过 item 点击事件执行的操作,就无法执行了

    /**
     * @param parent   listview
     * @param view     当前点击的 item
     * @param position 位置
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        clickView = view;
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("p", position);
        startActivityForResult(intent, GETCONTENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == GETCONTENT) {
            String content = data.getStringExtra("content");
            int position = data.getIntExtra("p", -1);
//            Log.e("自定义标签", "类名==MainActivity" + "方法名==onActivityResult=====:" + content);
//            if (clickView != null) {
//                ((TextView) clickView.findViewById(R.id.tv2)).setText(content);
//                if (position != -1) {
//                    myBeenlList.get(position).setTv2(content);
//                }
//                clickView = null;
//            }
            View viewWithTag = listView.findViewWithTag("xiugai" + position);//通过 tag 找到指定的控件,找的是具体的控件,这封 tag 要求是唯一的,在 adapter中设置
            if (viewWithTag != null) {
                ((TextView) viewWithTag).setText(content);
                // 修改数据源
                myBeenlList.get(position).setTv2(content);
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt:
                ///更改局部内容
                //找到要修改的控件对象
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("p", 9);
                startActivityForResult(intent,GETCONTENT);
                break;
        }
    }
}
