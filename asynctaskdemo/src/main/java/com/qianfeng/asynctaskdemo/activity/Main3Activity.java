package com.qianfeng.asynctaskdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.asynctaskdemo.Bean;
import com.qianfeng.asynctaskdemo.R;
import com.qianfeng.asynctaskdemo.callback.MyGsonCallBack;
import com.qianfeng.asynctaskdemo.task.MyBaseAsyncTask;

import java.util.List;

public class Main3Activity extends AppCompatActivity /*implements MyAsync3.OnLoadCompleteListener ,MyBitMapTask.OnBitMapLoadCompleteListener*/{

    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
//        new MyAsync3(this).execute("http://www.zol.com.cn");
//        new MyBitMapTask(this).execute("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
//        new MyBaseAsyncTask(new MyStringCallBack(tv)).execute("http://www.zol.com.cn");
//        new MyBaseAsyncTask(new MyBitMapCallBack(iv)).execute("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
        new MyBaseAsyncTask(new MyGsonCallBack<List<Bean>>() {

            @Override
            public void showData(List<Bean> been) {
                Log.e("自定义标签", "类名==Main3Activity" + "方法名==showData=====:" + been.size());
            }
        }).execute("http://m.mydrivers.com/app/newslist.aspx?%20tid=0&minId=0&maxId=0&ver=2.2&temp=1464423764091");
    }

//    @Override
//    public void onLoadComplete(String s) {
//        //接收数据
//        tv.setText(s);
//    }
//
//    @Override
//    public void onBitMapLoadComplete(Bitmap bitmap) {
//            iv.setImageBitmap(bitmap);
//    }
}
