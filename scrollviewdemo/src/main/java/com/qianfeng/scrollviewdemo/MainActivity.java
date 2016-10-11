package com.qianfeng.scrollviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        linearLayout = (LinearLayout) findViewById(R.id.lin);
        
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                int scrollHeight = scrollView.getHeight();//获取 scrollview 的高度
                int linHeight1 = linearLayout.getHeight();//获取线性布局的高度
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====: scroll==" + scrollHeight + "---lin==" + linHeight1);
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + scrollView.getScrollY());
//                scrollView.scrollTo(0,1000);//瞬间滚动过去
//                scrollView.smoothScrollTo(0,1000);
               // scrollView.scrollBy(0,100);//偏移量,在当前的位置基础上偏移设置的 数值
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + scrollView.getScrollY());
                break;
        }
    }
}
