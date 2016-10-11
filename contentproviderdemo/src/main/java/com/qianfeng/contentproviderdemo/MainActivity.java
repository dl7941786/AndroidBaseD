package com.qianfeng.contentproviderdemo;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();//获取一个内容解析者
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.readsms:
                Uri uri = Uri.parse("content://sms/");//短信的内容提供者的地址
                Cursor query = contentResolver.query(uri, null, null, null, null);//内容提供者访问数据,内容解析者解析数据,需要一个 uri, 这个 uri是指定的内容提供者在操作系统中注册的地址
                //Uri   scheme://host/path  http://www.baidu.com
                //内容提供者的Uri 格式  必须是content:// 开头, 中间是自己定义的地址
                while (query.moveToNext()) {//如果还有下一条
//                    String[] columnNames = query.getColumnNames();
//                    for (String columnName : columnNames) {
//                        String values = query.getString(query.getColumnIndex(columnName));
//                        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "列名是=== " + columnName + "---值是" + values);
//                    }
                String address = query.getString(query.getColumnIndex("address"));
                String body = query.getString(query.getColumnIndex("body"));
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + address + "----" + body);
            }
                break;
        }
    }
}
