package com.qianfeng.loaderdemo;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private SimpleCursorAdapter simpleCursorAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, new String[]{"address"}, new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(simpleCursorAdapter);
        Bundle bundle = new Bundle();
        bundle.putString("aaa", "bbb");
        /**
         * 构造方法1 loader的 id, 参数2 额外的参数, 3 回调 ,如果多次创建 load 但是 id 一样,那么就是一个 loader, 如果不一样,你猜
         */
        Loader<Cursor> cursorLoader1 = getLoaderManager().initLoader(0, bundle, this);
        //   Loader<Cursor> cursorLoader = getLoaderManager().initLoader(1, bundle, this);
        Loader<Cursor> cursorLoader = getLoaderManager().restartLoader(0, bundle, this);
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + cursorLoader + "---------" + cursorLoader1);
    }

    /**
     * 创建 loader
     * @param i
     * @param bundle
     * @return
     */
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (bundle != null) {
            String aaa = bundle.getString("aaa");
            Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreateLoader=====:" + aaa);
        }
        return new CursorLoader(this, Uri.parse("content://sms/"), null, null, null, null);
    }

    /**
     * 加载完成
     *
     * @param loader
     * @param cursor
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        simpleCursorAdapter.swapCursor(cursor);
    }

    /**
     * 重置了,清空内容
     *
     * @param loader
     */
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        simpleCursorAdapter.swapCursor(null);
    }
}
