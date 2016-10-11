package com.qianfeng.listviewpartrefresh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.qianfeng.listviewpartrefresh.R;

public class Main2Activity extends AppCompatActivity {

    private EditText editText;
    private int posiiton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText) findViewById(R.id.et);
        Intent intent = getIntent();
        posiiton = intent.getIntExtra("p", -1);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                //获取 edittext的内容,返回给上一个页面,然后由上一个页面处理
                String trim = editText.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("content", trim);
                intent.putExtra("p", posiiton);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
