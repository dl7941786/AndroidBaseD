package com.qianfeng.xianghaapp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.qianfeng.xianghaapp.R;
import com.qianfeng.xianghaapp.app.MyApp;
import com.qianfeng.xianghaapp.view.fragment.BBSFragment;
import com.qianfeng.xianghaapp.view.fragment.LearnCookFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private LearnCookFragment learnCook;
    private BBSFragment bbsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApp.context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(this);
        bbsFragment = new BBSFragment();
        learnCook = new LearnCookFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, bbsFragment).commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.container, learnCook).commit();//加载默认的学做菜页面
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {

            case R.id.xuezuocai:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, learnCook).commit();
                break;

            case R.id.market:


                break;
            case R.id.bbs:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, bbsFragment).commit();
                break;

            case R.id.message:


                break;

            case R.id.mine:

                break;
        }
    }

//    /**
//     * 创建选项菜单
//     * @param menu
//     * @return
//     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //把菜单加载进来
//        getMenuInflater().inflate(R.menu.optionmenu, menu);
////        menu.add("这是代码增加的");
////        menu.add(Menu.NONE, R.id.addmenubycode, 1, "这是代码增加的,我抢了五分钱");//代码增加 menu
////        menu.findItem(R.id.addmenubycode).setEnabled(false);//menu.findItem 查找某个 menu item
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    /**
//     * 当 optionmenu被选中的时候执行
//     * @param item
//     * @return
//     */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //区分点击的是哪个
//        switch (item.getItemId()) {
//            case R.id.change:
//                Toast.makeText(this,"在这里,可以切换界面显示",Toast.LENGTH_SHORT).show();
//                //怎么切换, 应该把 listview 隐藏,然后将数据显示到 gridview 上面
//                List<Fragment> fragments = getSupportFragmentManager().getFragments();//获取当前 activity的 manager 管理的所有的 fragment
//                for (Fragment fragment : fragments) {
//                    if (fragment instanceof LearnCookFragment) {//是不是想要切换内容的页面
//                        ((LearnCookFragment) fragment).change();//切换界面
//                    }
//                }
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.context,menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.delete:
//                List<Fragment> fragments = getSupportFragmentManager().getFragments();//获取当前 activity的 manager 管理的所有的 fragment
//                for (Fragment fragment : fragments) {
//                    if (fragment instanceof LearnCookFragment) {//是不是想要切换内容的页面
//                        ((LearnCookFragment) fragment).change();//切换界面
//                    }
//                }
//                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onContextItemSelected(item);
//    }
}
