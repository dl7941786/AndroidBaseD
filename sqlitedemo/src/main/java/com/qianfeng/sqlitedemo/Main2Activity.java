package com.qianfeng.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase database;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listview);
        myOpenHelper = new MyOpenHelper(this);
    }

    public void onClick(View view) {
        database = myOpenHelper.getWritableDatabase();
        switch (view.getId()) {
            case R.id.query:
                Cursor person = database.query("person", null, null, null, null, null, null);//查询所有的数据
                //需要注意,如果使用CursorAdapter,表里面必须要有_id作为主键
                SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.item, person, new String[]{"name", "age"}, new int[]{R.id.name, R.id.age}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
                listView.setAdapter(simpleCursorAdapter);
//                MyAdapter myAdapter = new MyAdapter(this, person, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//                listView.setAdapter(myAdapter);
                //person.close();//关闭后就没有数据了
                break;
        }
    }
}
