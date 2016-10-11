package com.qianfeng.mycontentprovidertest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ContentResolver contentResolver;
    private String uri = "content://woshizhuji";
    private String uriPerson = "content://woshizhuji/person";
    private String uriStudnet = "content://woshizhuji/student";
    private MyObserver myObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();//内容解析者
        myObserver = new MyObserver(new Handler());
        contentResolver.registerContentObserver(Uri.parse(uriStudnet),false,myObserver);
        contentResolver.registerContentObserver(Uri.parse(uriPerson),false,myObserver);
//        contentResolver.registerContentObserver(Uri.parse(uriStudnet), false, new ContentObserver(new Handler()) {
//            @Override
//            public boolean deliverSelfNotifications() {
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==deliverSelfNotifications=====:" + "");
//                return super.deliverSelfNotifications();
//            }
//
//            @Override
//            public void onChange(boolean selfChange) {
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onChange=====:" + selfChange);
//                super.onChange(selfChange);
//            }
//
//            /**
//             *
//             * @param selfChange
//             * @param uri  变化的 uri是哪个
//             */
//            @Override
//            public void onChange(boolean selfChange, Uri uri) {
//                Log.e("自定义标签", "onChange() called with: " + "selfChange = [" + selfChange + "], uri = [" + uri + "]");
//                super.onChange(selfChange, uri);
//            }
//        });
//      Intent intent = new Intent("safsadfsdafsad", Uri.parse("content://woshizhuji"));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "六级");
                contentValues.put("age", "24");
                Uri insert = contentResolver.insert(Uri.parse(uriStudnet), contentValues);

                contentResolver.insert(Uri.parse(uriPerson), contentValues);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + insert);
                break;
            case R.id.delete:
//                contentResolver.delete(Uri.parse(uri), "name=?", new String[]{"五分钱,你过六级了吗"});
                int delete = contentResolver.delete(Uri.parse(uriPerson + "/12"), null, null);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "删除了"+delete+"条数据");
                break;

            case R.id.update:
                ContentValues con = new ContentValues();
                con.put("name","没过");
                con.put("age","25");
                int update = contentResolver.update(Uri.parse(uriStudnet + "/六级"), con, null, null);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "更新了" + update);
                break;

            case R.id.query:

                break;
        }
    }
}
