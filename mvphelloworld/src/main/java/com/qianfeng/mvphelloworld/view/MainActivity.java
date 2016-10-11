package com.qianfeng.mvphelloworld.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qianfeng.mvphelloworld.R;
import com.qianfeng.mvphelloworld.presenter.MainActivityPresenter;

import java.util.List;

/**
 * MVP 方式
 * Activity  是 view 只管显示数据,不负责获取数据,怎么得到数据, 交给Presenter中间人,我想要数据的时候告诉Presenter一声(调用Presenter的方法),
 * 然后Presenter 去想办法获取数据, 获取的方式:交给 model 获取, model 获取完之后怎么把数据传回来,接口回调,接口回调由Presenter创建,传递给 model, 这样最终数据
 * 会传递到Presenter中, 然后由Presenter再想办法告诉 activity, 告诉的方式 ,在Presenter内部声明一个 view 接口对象,创建Presenter的时候将 activity 传给进来,然后通过调用对应的接口方法把数据传给 actiivty
 */
public class MainActivity extends AppCompatActivity implements MvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Activity 现在已经不能去获取数据了,只能展示数据,所以需要一个中间人,由中间人帮忙去获取数据
        new MainActivityPresenter(this).load();
    }

    /**
     * 数据给你弄回来了 只要更新界面即可
     *
     * @param list
     */
    @Override
    public void showView(List<String> list) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==showView=====:" + "收到数据,展示数据即可");
    }
}
