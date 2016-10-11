package com.qianfeng.radiobuttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;

//    private RadioButton male,fmale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        male = (RadioButton) findViewById(R.id.male);
//        fmale = (RadioButton) findViewById(R.id.fmale);
//        male.setOnCheckedChangeListener(this);//设置一个选择状态变化的监听, 不变化不执行
//        fmale.setOnCheckedChangeListener(this);//设置一个选择状态变化的监听, 不变化不执行
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
    }

    /**
     * 状态变化后的回调
     * @param buttonView 当前点击的控件
     * @param isChecked 当前的状态是否为选中
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.e("自定义标签", "onCheckedChanged() called with: " + "buttonView = [" + buttonView + "], isChecked = [" + isChecked + "]");
    }

    /**
     *
     * @param group
     * @param checkedId 当前被选中的 radiobutton  id,通过区分 checkedid 可以知道这个 radiogroup 内部哪个 button 被点击了
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        Log.e("自定义标签", "onCheckedChanged() called with: " + "group = [" + group + "], checkedId = [" + checkedId + "]");
        switch (checkedId) {
            case R.id.malen:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "男被点击了");
                break;
            case R.id.fmalen:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onCheckedChanged=====:" + "女被点击了");
                break;
        }
    }
}
