package com.qianfeng.startactivityforrsultdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//生命周期必须调用 super, 因为我们在生命周期中只是初始化我们界面需要的内容,而 activity 初始化需要的数据是在父类里面完成的
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
    }

    public void onClick(View view) {
        String n1 = num1.getText().toString().trim();
        int in1 = Integer.parseInt(n1);
        String n2 = num2.getText().toString().trim();
        int in2 = Integer.parseInt(n2);
        Intent intent = new Intent(this, Main2Activity.class);//创建意图
        intent.putExtra("n1", in1);//放数据
        intent.putExtra("n2", in2);
//        startActivity(intent);
        startActivityForResult(intent, 100);
    }

    /**
     * 当请求的页面返回结果的时候进行的回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);//super 可以注释掉
        if (requestCode == 100 && resultCode == RESULT_OK) {
            int sum = data.getIntExtra("result", -1);
            result.setText(""+ sum);
        }
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//    }
}
