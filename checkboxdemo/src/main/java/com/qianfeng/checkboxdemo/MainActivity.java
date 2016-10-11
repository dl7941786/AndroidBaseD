package com.qianfeng.checkboxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox chouyan, hejiu, tangtou;
    private TextView resultTv;
    private Map<Integer, String> map;//第一种方式
    private List<String> stringList;//也是存放数据的集合,第二种方式
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chouyan = (CheckBox) findViewById(R.id.chouyan);
        hejiu = (CheckBox) findViewById(R.id.hejiu);
        tangtou = (CheckBox) findViewById(R.id.tangtou);
        chouyan.setOnCheckedChangeListener(this);
        hejiu.setOnCheckedChangeListener(this);
        tangtou.setOnCheckedChangeListener(this);
        resultTv = (TextView) findViewById(R.id.result);
        map = new HashMap<>();//创建存储数据的 map
        stringList = new ArrayList<>();
    }

    /**
     *
     * @param buttonView 执行事件的控件
     * @param isChecked 当前控件是否被选中
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.chouyan://0
                if (isChecked) {
                    map.put(0, "抽烟");
                    stringList.add("抽烟");
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "原来你喜欢抽烟");
                } else {
                    map.remove(0);
                    stringList.remove("抽烟");
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "我都知道了,别取消了,真能装");
                }
                break;
            case R.id.hejiu://1
                if (isChecked) {
                    map.put(1, "喝酒");
                    stringList.add("喝酒");
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "酒鬼");
                } else {
                    map.remove(1);
                    stringList.remove("喝酒");
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "我都知道了,别取消了,真能装");
                }
                break;
            case R.id.tangtou://2
                if (isChecked) {
                    map.put(2, "烫头");
                    stringList.add("烫头");
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "这么潮流?");
                } else {
                    stringList.remove("烫头");
                    map.remove(2);
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "我都知道了,别取消了,真能装");
                }
                break;
        }
    }

    public void onClick(View view) {
        //遍历 map
//        StringBuffer buffer = new StringBuffer();
//        for (Integer integer : map.keySet()) {
//            buffer.append(map.get(integer));
//        }
//        resultTv.setText(buffer.toString());
        ///遍历集合
        StringBuffer buffer = new StringBuffer();
        for (String s : stringList) {
            buffer.append(s);
        }
        resultTv.setText(buffer.toString());
    }
}
