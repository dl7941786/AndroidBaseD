package com.qianfeng.broadcastdemo3;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "hwl");
                contentValues.put("age", "100");
                getContentResolver().insert(Uri.parse("content://wohensuibian"), contentValues);
                break;
        }
    }
}
