package com.qianfeng.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.qianfeng.fragmentdemo.fragment.First;
import com.qianfeng.fragmentdemo.fragment.Fourth;
import com.qianfeng.fragmentdemo.fragment.Second;
import com.qianfeng.fragmentdemo.fragment.Third;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private First first = new First();
    private Second second = new Second();
    private Third third = new Third();
    private Fourth fourth = new Fourth();
    private Fragment fragment;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + "");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyFragment myFragment = new MyFragment();//创建 fragment 对象
//        //加到 activity
//        //首先来一个 fragmentmanager
//        FragmentManager supportFragmentManager = getSupportFragmentManager();//V4的
//        //开启一个事物
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        //添加 fragment
//        fragmentTransaction.add(R.id.container, myFragment);
//        //事物都得提交
//        fragmentTransaction.commit();
//        Bundle bundle = new Bundle();
//        bundle.putString("name", first.getClass().getSimpleName());
//        first.setArguments(bundle);//设置数据
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, first).commit();//默认加载的不能放到回退站
        changeFragment(first);
        lastFragment = first;
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onStart() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onStart=====:" + "");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onResume=====:" + "");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onPause=====:" + "");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onStop=====:" + "");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onDestroy=====:" + "");
        super.onDestroy();

    }

    /**
     * 判断谁被选择了
     *
     * @param group
     * @param checkedId 被选择的控件 id
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            // Fragment already added 异常
            case R.id.first:
                //把第一个加载进来
//                getSupportFragmentManager().beginTransaction().add(R.id.container, first).commit();
                fragment = first;
                //changeFragment(first);
                break;
            case R.id.second://第二个
//                getSupportFragmentManager().beginTransaction().add(R.id.container, second).commit();
                // changeFragment(second);
                fragment = second;
                break;
            case R.id.third://第三个
//                getSupportFragmentManager().beginTransaction().add(R.id.container, third).commit();
                // changeFragment(third);
                fragment = third;
                break;
            case R.id.fourth://第四个
                // changeFragment(fourth);
                fragment = fourth;
                break;
        }
        changeFragment(fragment);

    }


    private void changeFragment(Fragment fragment) {
        if (fragment.getArguments() == null) {//如果没有设置过参数,就设置参数
            Bundle bundle = new Bundle();
            bundle.putString("name", fragment.getClass().getSimpleName());
            fragment.setArguments(bundle);//设置数据,一个fragment对象只能设置一次
        }
//        if (!fragment.isAdded()) {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            if (lastFragment != null) {
//                fragmentTransaction.remove(lastFragment);//remove后再次进来会重走生命周期
//            }
//            fragmentTransaction.add(R.id.container, fragment).commit();//记住 commit,一个事物只能被提交一次
//            lastFragment = fragment;
//        }
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        if (!fragment.isAdded()) {
//            if (lastFragment != null) {
//                fragmentTransaction.hide(lastFragment);
//            }
//            fragmentTransaction.add(R.id.container,fragment).commit();
//        }else{
//            fragmentTransaction.hide(lastFragment).show(fragment).commit();
//        }
//        lastFragment = fragment;
        getSupportFragmentManager().beginTransaction().addToBackStack(fragment.getClass().getSimpleName()).replace(R.id.container, fragment).commit();
    }

    public void onClick(View view) {
        //弹栈,相当于按了返回按钮
        switch (view.getId()) {
            case R.id.bt:
                //getSupportFragmentManager().popBackStack(); 将栈顶的 fragment弹出
//                getSupportFragmentManager().popBackStack(second.getClass().getSimpleName(), 1);//指定的名字, 0 代表弹到自己为止,1代表把自己也弹掉
//                getSupportFragmentManager().popBackStackImmediate();//和popBackStack是一样的
//                getSupportFragmentManager().popBackStackImmediate(second.getClass().getSimpleName(), 1);//和popBackStack中参数一样的是一样的
//                getSupportFragmentManager().popBackStack(2, 1);//2代表的是添加顺序的索引,从0开始, 比如1 ,代表的就是第二个添加的 fragment 后面的数字和上面的数字一样,是不是把自己弹出,0不弹,1弹
//                int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();//获取回退栈中 fragment的数量
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + backStackEntryCount);
//                List<Fragment> fragments = getSupportFragmentManager().getFragments();//当前 activity的FragmentManager中 所有的fragment
//                for (Fragment fragment1 : fragments) {
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + fragment1.getClass().getSimpleName());
//                }

                break;

        }
    }

}
