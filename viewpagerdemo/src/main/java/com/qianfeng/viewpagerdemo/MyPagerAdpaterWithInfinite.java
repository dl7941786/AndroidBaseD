package com.qianfeng.viewpagerdemo;

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

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * 无限轮播的适配器
 * Created by jackiechan on 16/8/23.
 */
public class MyPagerAdpaterWithInfinite extends PagerAdapter {
    private List<ImageView> imageViewList;
    private boolean isBack = false;// 是否是往回滑这种先添加后移除的特殊情况

    public MyPagerAdpaterWithInfinite(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        //因为要一直滑动,所以不应该返回数据源的长度,应该返回一个很大的值,所以干脆返回一个 int 最大值
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 装载数据
     *
     * @param container viewpgaer
     * @param position  装载的位置
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        Log.e("自定义标签", "类名==MyPagerAdpaterWithInfinite" + "方法名==instantiateItem=====:" + "加载");
        int newPosition = position % imageViewList.size();//计算实际应该加在数据源中的第几个条目
        ImageView imageView = imageViewList.get(newPosition);//小心越界
//        if (imageView.getParent() != null) {//判断有没有父容器,有的话就移除
//            ((ViewGroup) imageView.getParent()).removeView(imageView);
//        }
        if (imageView.getParent() == null) {
            container.addView(imageView);
        }else{
            isBack = true;//标记为先添加后移除
        }
        return imageView;
    }

    /**
     * 销毁
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        Log.e("自定义标签", "类名==MyPagerAdpaterWithInfinite" + "方法名==destroyItem=====:" + "移除");
        if (!isBack) {//如果是正常的从右往左滑的情况才执行这行代码
            container.removeView((View) object);
        }
        isBack = false;//不管什么情况,最后这个值都得设置为 false
    }
}
