package com.qianfeng.autocompletetextviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{


    private AutoCompleteTextView auto;
    private String[] ss;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auto = (AutoCompleteTextView) findViewById(R.id.auto);
        ss = getResources().getStringArray(R.array.autoarray);
        arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss);
        auto.setAdapter(arrayAdapter);
        auto.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onItemClick=====:" +  auto.getText().toString());
    }

}
