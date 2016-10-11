package com.qianfeng.listviewwithbuttoncheckbox.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qianfeng.listviewwithbuttoncheckbox.R;
import com.qianfeng.listviewwithbuttoncheckbox.adapter.MyAdapter;
import com.qianfeng.listviewwithbuttoncheckbox.adapter.MyAdapterWithCheckBox;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private MyAdapter myAdapter;
    private MyAdapterWithCheckBox myAdapterWithCheckBox;
    private List<String> stringList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add("tiffany=" + i);
        }
//        myAdapter = new MyAdapter(stringList);
//        listView.setAdapter(myAdapter);
        myAdapterWithCheckBox = new MyAdapterWithCheckBox(stringList);
        listView.setAdapter(myAdapterWithCheckBox);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onItemClick=====:" + i);
    }
}
