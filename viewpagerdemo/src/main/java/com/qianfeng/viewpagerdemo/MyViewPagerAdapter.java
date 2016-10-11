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
 * Created by jackiechan on 16/8/23.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imageViewList;
    private List<String> ss;

    public MyViewPagerAdapter(List<ImageView> imageViewList, List<String> ss) {
        this.imageViewList = imageViewList;
        this.ss = ss;
    }

    public MyViewPagerAdapter(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }

    /**
     * 数据源的长度
     *
     * @return
     */
    @Override
    public int getCount() {
//        Log.e("自定义标签", "类名==MyViewPagerAdapter" + "方法名==getCount=====:" + "");
        return imageViewList == null ? 0 : imageViewList.size();
    }

    /**
     * 判断加载进来的 view 和返回的数据是不是同一个数据,只有返回 true 才会显示 add 进来的 view
     * @param view   instantiateItem中 addview 加进来的 view
     * @param object instantiateItem返回的 object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
//        Log.e("自定义标签", "类名==MyViewPagerAdapter" + "方法名==isViewFromObject=====:" + "");
        return view == object;
    }

    /**
     * 装载 item, 要显示的内容加载进来
     *
     * @param container viewpgaer
     * @param position  当前要加载的位置
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViewList.get(position);//获取到要显示的内容
//        Log.e("自定义标签", "类名==MyViewPagerAdapter" + "方法名==instantiateItem=====:" + imageView);
//        TextView textView = new TextView(container.getContext());
//        textView.setText("的说法是放水电费是");
//        container.addView(textView);//添加到 viewpgaer ,这样是不会显示的
        container.addView(imageView);//这里添加的 view和返回的 object会传递到isViewFromObject这个方法作为两个参数
        return imageView;//返回
    }

//    @Override
//    public Object instantiateItem(View container, int position) {
//        return this.instantiateItem(((ViewGroup) container), position);
//    }

    /**
     * 销毁 item
     * @param container  viewpager
     * @param position 当前的位置
     * @param object  将要销毁的对象
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);//从 viewpager中移除指定的条目
//        Log.e("自定义标签", "类名==MyViewPagerAdapter" + "方法名==destroyItem=====:" + object);
    }

//    @Override
//    public void destroyItem(View container, int position, Object object) {
//        this.destroyItem(((ViewGroup) container), position, object);
//    }

    /**
     * 获取当前位置的标题内容
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return ss.get(position);
    }
}
