package com.qianfeng.loaderdemo;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private MyOpenHelper myOpenHelper;
    private Uri uri = Uri.parse("content://zheshiwosuibianxiede");
    private ListView listView;
    private SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myOpenHelper = new MyOpenHelper(this);
        listView = (ListView) findViewById(R.id.listview);
        simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, new String[]{"name"}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(simpleCursorAdapter);
        getLoaderManager().initLoader(0, null, this);

    }

    public void onClick(View view) {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        switch (view.getId()) {
            case R.id.add:
                //添加数据到数据库,然后更新界面
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "六级捡了五分钱");
                contentValues.put("age", "1765");
                writableDatabase.insert("person", null, contentValues);//插入数据
                ///顺便通知一下
                getContentResolver().notifyChange(uri,null);// 告诉所有观察 uri 这个地址的人 数据变化了
                break;
        }
        writableDatabase.close();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        simpleCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        simpleCursorAdapter.swapCursor(null);
    }
}
