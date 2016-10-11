package com.qianfeng.spinnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spinner2;
    private ArrayAdapter<String> stringArrayAdapter;//泛型指的是数据源类型//BaseAdapter
    private String[] ss;
    private List<String> stringList;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner2 = (Spinner) findViewById(R.id.spinner2);//拿到一个 spinner 对象
        resultText = (TextView) findViewById(R.id.tv);
        ss = getResources().getStringArray(R.array.spinnerarray);//获取 array 资源数组
        stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add("这是第几" + i + "我就不改,你咬我啊");
        }
        stringList.add(0, "");
        //参数介绍 1.上下文,2Textview的资源文件,3数据源(数组类型)
//        stringArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss);//创建适配器
//        stringArrayAdapter=new ArrayAdapter<String>(this,R.layout.myspinneritem,ss);//创建适配器
//        stringArrayAdapter=new ArrayAdapter<String>(this,R.layout.myspinneritem2,ss);//创建适配器,因为根标签不是 textview ,会出现类型转换异常并且崩溃
        // 1.上下文,2布局文件 3布局文件中要显示文字的 textview的 id,4 数据源
//        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.myspinneritem2, R.id.tv, ss);
        stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.myspinneritem, stringList);//垂直整合
        spinner2.setAdapter(stringArrayAdapter);
        spinner2.setOnItemSelectedListener(this);//设置条目被选择的监听

    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt:
                stringArrayAdapter.clear();//清空数据,并且刷新界面 notifyDataSetChanged;通知适配器数据源发生变化了,需要重新加载
                break;
        }
    }

    /**
     * 当条目被选中了
     *
     * @param parent   当前被点击的 spinner
     * @param view     当前被点击的具体的 item
     * @param position 点击的位置,根据点击的位置处理部分事情
     * @param id       条目的 id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.e("自定义标签", "onItemSelected() called with: " + "parent = [" + parent + "], view = [" + view + "], position = [" + position + "], id = [" + id + "]");
        //把选择的内容显示到 textview 上面
        resultText.setText(stringList.get(position));
    }

    /**
     * 当数据被清空,没有任何数据被选中的时候执行,前提条件,数据源必须集合,不能是数组
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.e("自定义标签", "onNothingSelected() called with: " + "parent = [" + parent + "]");
        resultText.setText(null);
    }


    /**
     * 注意 spinner 不能用这个监听
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("自定义标签", "onItemClick() called with: " + "parent = [" + parent + "], view = [" + view + "], position = [" + position + "], id = [" + id + "]");
    }

}
