package com.qianfeng.edittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, TextWatcher {

    private EditText name, psd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        psd = (EditText) findViewById(R.id.psd);
        name.setOnEditorActionListener(this);//设置回车键执行事件的监听
        psd.setOnEditorActionListener(this);//设置回车键执行事件的监听
//        name.getText().toString().trim()
        name.addTextChangedListener(this);//文本变化的监听
    }

    /**
     * 回车键事件监听的方法
     *
     * @param textView 执行事件的控件
     * @param actionid actionid 对事件指定一个标记
     * @param keyEvent 事件类型
     * @return true的时候输入法不会回收关闭, 同时如果有多个 edittext 也不会跳转下一个, false则相反
     */
    @Override
    public boolean onEditorAction(TextView textView, int actionid, KeyEvent keyEvent) {
//        switch (textView.getId()) {
//            case R.id.name:
        //可能会动态设置回车键的属性,在这里再区分下 actionid
        switch (actionid) {//区分 actionid
            case 10:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onEditorAction=====:" + "name的回车被触发了");
                //获取到文本,调用搜索接口
                break;
        }
//                break;
//        }
        return true;
    }

    /**
     * 文本变化前 , 自 start 位置开始 共有 count个字符被 after 个字符替换
     *
     * @param s     变化前的文本
     * @param start 起始的位置(光标)
     * @param count 将要发生变化的数量
     * @param after 用于替换将要发生变化的数量的长度
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Log.e("自定义标签", "beforeTextChanged() called with: " + "s = [" + s + "], start = [" + start + "], count = [" + count + "], after = [" + after + "]");
    }

    /**
     * 文本变化 ,相较于变化前,共有before个字符被count个字符替换
     *
     * @param s      变化后的文本
     * @param start  起始的位置(光标)
     * @param before 相比较于变化前,公有多少个发生变化
     * @param count  公有多少个替换了发生变化的字符
     */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Log.e("自定义标签", "onTextChanged() called with: " + "s = [" + s + "], start = [" + start + "], before = [" + before + "], count = [" + count + "]");
    }

    /**
     * 文本变化后
     *
     * @param s 变化后的文本
     */
    @Override
    public void afterTextChanged(Editable s) {
        Log.e("自定义标签", "afterTextChanged() called with: " + "s = [" + s + "]");
        //获取到最后的文本后执行相应的操作
    }
}
