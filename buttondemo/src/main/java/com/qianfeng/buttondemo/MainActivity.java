package com.qianfeng.buttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @FindView(R.id.bt1)
    private Button bt1;
    @FindView(R.id.tv2)
    private TextView tv2;
    private MyOnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindViewInject.inject(this);
        bt1.setText("这是通过注解获取控件后设置的内容");
//        bt1.setOnClickListener(v -> Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "lambda表达式"));
//          bt1.setOnClickListener(v -> {
//              int i =0;
//              i++;
//              i+=i;
//              Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "i="+i);
//
//          });
        ///-----------通过代码设置点击事件
       // myOnClickListener = new MyOnClickListener();
       // bt1 = (Button) findViewById(R.id.bt1);//查找控件,再次强调 id 必须是上面 layout 里面的 id
//        //按钮主要功能就是为了点击, 而每个按钮被点击后到底执行什么,系统不知道,需要我们告诉它,通过设置点击事件的监听来执行对应的代码
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {//接口回调,当被点击的时候就会触发这个方法
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "button被点击了");
//            }
//        });
//        boolean clickable = bt1.isClickable();//是否可以被点击
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + clickable);
      //  tv2 = (TextView) findViewById(R.id.tv2);
//        boolean clickable1 = tv2.isClickable();
//        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "textview"+clickable1);
//        tv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "textview被点击了");
//            }
//        });
//            bt1.setOnClickListener(this);//推荐使用 this 方式
//            tv2.setOnClickListener(this);
      //  bt1.setOnClickListener(myOnClickListener);//不推荐,因为 activity 对象已经存在, 直接使用即可,不需要再额外创建这么一个对象
      //  tv2.setOnClickListener(myOnClickListener);
    }
    //-----------------------嘉伟是华丽的分割线,以下是通过布局文件设置点击事件
    /**
     * @param view 谁调用了这个方法,传过来的就是谁
     */
    public void dianJi(View view) {
        //如果都设置同样名字的方法作为点击事件,怎么区分不同的控件
        switch (view.getId()) {
            case R.id.bt1://点击的 button 按钮
                Log.e("自定义标签", "类名==MainActivity" + "方法名==dianJi=====:" + "button 点击了");
                break;//写完 case 第一件事 把 break 打上
            case R.id.tv2://点击的是 textview
                Log.e("自定义标签", "类名==MainActivity" + "方法名==dianJi=====:" + "textview 点击了");
                break;
        }
    }
//    public void textViewDianji(View view){
//        Log.e("自定义标签", "类名==MainActivity()" + "方法名==textViewDianji()");
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1://点击的 button 按钮
                Log.e("自定义标签", "类名==MainActivity" + "方法名==dianJi=====:" + "button 点击了");
                break;//写完 case 第一件事 把 break 打上
            case R.id.tv2://点击的是 textview
                Log.e("自定义标签", "类名==MainActivity" + "方法名==dianJi=====:" + "textview 点击了");
                break;
        }
    }

    public void includOnClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                switch (((ViewGroup) view.getParent()).getId()) {//获取父容器的 id 进行比较
                    case R.id.lin1:
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "lin1bt1被点击了");
                        break;
                    case R.id.lin2:
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "lin2bt1被点击了");
                        break;
                    case R.id.lin3:
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "lin3bt1被点击了");
                        break;
                    case R.id.lin4:
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "lin4bt1被点击了");
                        break;
                }

                break;
            case R.id.bt2:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "bt2被点击了");
                break;
            case R.id.bt3:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "bt3被点击了");
                break;
            case R.id.bt4:
                Log.e("自定义标签", "类名==MainActivity" + "方法名==includOnClick=====:" + "bt4被点击了");
                break;
        }

    }
}
