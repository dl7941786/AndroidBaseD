package com.qianfeng.viewpagerwithfragmentdemo.adapter;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？  

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.qianfeng.viewpagerwithfragmentdemo.FragmentA;

import java.util.List;

/**
 * 这个适配 保存的是 fragment 对象,这个适合页面较少或者数据量较少的时候用
 * Created by jackiechan on 16/8/24.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;//fragment 集合
    public MyFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    /**
     * 返回要显示的 fragment
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        Log.e("自定义标签", "类名==MyFragmentAdapter" + "方法名==getItem=====:" + "");
        return fragmentList.get(position);
    }

    /**
     * 数据源长度,有多少个 fragment
     * @return
     */
    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e("自定义标签", "类名==MyFragmentAdapter" + "方法名==destroyItem=====:" + "");
        super.destroyItem(container, position, object);
    }

    /**
     * 返回一个标记位,用于区分是否在刷新适配器的情况,重新加载 fragmen的生命周期,默认是不重新加载
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        if (object instanceof FragmentA) {
            return POSITION_NONE;//重新加载
        }else{
            return POSITION_UNCHANGED;//数据没有发生变化,不用重新加载
        }
    }
}
