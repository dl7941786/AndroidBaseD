package com.qianfeng.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);//获取SharedPreferences
        SharedPreferences.Editor edit = name.edit();//如果要写内容,需要用 edit 获取到编辑器
        //  edit.clear();//清空存储的内容
        //edit.remove("");//移除指定的数据
        edit.putString("name", "五分钱");
        edit.putBoolean("boolen", false);//如果一个 key放了两个值,不管类型是否一致,以后操作为准,前面的操作会被覆盖,包括类型
        edit.apply();//最后记住需要提交

        //如果是要获取内容 就直接 get
//        String stringName = name.getString("name", "默认值");
//        boolean booleanName = name.getBoolean("boolen", true);
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + stringName + "----" + booleanName);
//        Map<String, ?> all = name.getAll();//获取所有的值
//        Set<String> strings = all.keySet();
//        for (String string : strings) {
//            Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====string===:" + string + "值====" + all.get(string));
//        }
        ///name.contains("");判断是否有这个键
        //内容发生变化的监听
        name.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            /**
             *
             * @param sharedPreferences 发生变化的对象
             * @param key  变化的 key 比如是新增的 key 或者 是删除或者是修改的
             */
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Log.e("自定义标签", "onSharedPreferenceChanged() called with: " + "sharedPreferences = [" + sharedPreferences + "], key = [" + key + "]");
            }
        });

        name.edit().putBoolean("zengjia", false).apply();
    }
}
