package com.qianfeng.asynctaskdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.qianfeng.asynctaskdemo.task.MyDownLoadTask;
import com.qianfeng.asynctaskdemo.R;

public class Main2Activity extends AppCompatActivity {

    private ProgressBar probar;
    private MyDownLoadTask myDownLoadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        new MyAsynTask().execute("http://www.zol.com.cn");
        probar = (ProgressBar) findViewById(R.id.pro);
        myDownLoadTask = new MyDownLoadTask(probar);
//        myDownLoadTask.execute("http://skycnxz2.wy119.com/QQMusic_Setup.zip");
        myDownLoadTask.execute("http://skycnxz3.wy119.com/fgcs_Setup.zip");

        // myDownLoadTask.execute("http://skycnxz2.wy119.com/QQMusic_Setup.zip");//只能执行一次

    }

    public void onClcik(View view) {
        switch (view.getId()) {
            case R.id.cancel:
                myDownLoadTask.cancel(true);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDownLoadTask.cancel(true);//取消任务
        myDownLoadTask = null;//置为 null
    }
}
