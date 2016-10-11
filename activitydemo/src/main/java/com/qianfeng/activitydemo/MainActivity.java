package com.qianfeng.activitydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;

    /**
     * activity 的第一个生周期,创建一些视图对象等等(不是创建 activity 对象),初始化控件,加载数据等等所有的操作都在这里执行
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//调用这个方法后就会将指定的布局通过填充器加载成 view 然后显示出来,异步耗时操作,在 oncreat 给控件设置内容等操作都属于挂起操作,等待 onresume后唤醒执行
//        TextView textView = new TextView(this);//通过代码创建一个文本控件
//        textView.setTextSize(30);
//        textView.setText("这是代码创建的");
//        setContentView(textView);
//        Intent intent = new Intent(this, MyActivity.class);
//        startActivity(intent);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("这是在 oncreate 方法中设置的内容");
    }

    /**
     * 程序进入可见状态,不能交互的,在这里可以初始化一些 非严格必须的东西,比如可以在这里注册广播接收者等,当然也可以在 oncreat 注册,
     * 这个方法可以不重写
     */
    @Override
    protected void onStart() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onStart=====:" + "");
        super.onStart();
    }

    /**
     * 进入焦点状态,可以交互,在这里你能看到最终的效果 ,这个方法基本上也不会重写,除非你需要在这个状态的时候提示一些内容或者做一些其他的事情
     */
    @Override
    protected void onResume() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onResume=====:" + "");
        super.onResume();
        Toast.makeText(this, "页面终于可见了", Toast.LENGTH_SHORT).show();
    }

    /**
     * 可见不可交互状态,代表有其他的窗口遮挡住这个 activity, 在这里,可以暂停动画等界面效果
     */
    @Override
    protected void onPause() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onPause=====:" + "");
        super.onPause();
    }

    /**
     * 不可见了,在这里,应该保存数据,停止一些消耗资源的事件,防止在不可见状态下被回收
     */
    @Override
    protected void onStop() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onStop=====:" + "");
        super.onStop();
    }

    /**
     * 销毁视图,在这里应该释放一切占用的资源,比如 停止播放,网络请求等所有操作,只是销毁视图,不是销毁 activity 对象,
     * activity 对象,能不能回收是垃圾回收决定,所以在这里要释放一切资源,防止无法被回收,导致内存泄露,最终内存溢出
     */
    @Override
    protected void onDestroy() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
        //比较诡异的人 c/c++ ,习惯手动释放,比较爱用指针, java 比较爱用返回值
        tv1 = null;//置为 null,让回收机制尽快回收对象,通过保证当前 activity 对象没有引用指向它,也保证 activity 尽快回收,释放内存
    }

    /**
     * activity重新回来的回调,比如被其他 activity 遮挡后,遮挡的activity被销毁了,我重见天日
     */
    @Override
    protected void onRestart() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onRestart=====:" + "");
        super.onRestart();

    }
}
