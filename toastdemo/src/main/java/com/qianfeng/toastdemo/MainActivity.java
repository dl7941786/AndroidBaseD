package com.qianfeng.toastdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toast:
                //上下文,内容,时间
                Toast.makeText(this,"我不是吐司面包",Toast.LENGTH_SHORT).show();//必须要 show 出来
                break;
        }
    }
}
