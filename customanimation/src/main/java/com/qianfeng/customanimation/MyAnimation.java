package com.qianfeng.customanimation;

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

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by jackiechan on 16/8/29.
 */
public class MyAnimation extends Animation {
    private View view;
    private int change;//控件高度的变化值,
    private int yuanshiHeight;//控件原始高度
    private int lastHeight;//目标高度

    //    public MyAnimation(View view,int change) {
//        this.view = view;
//        this.change = change;
//        yuanshiHeight = view.getMeasuredHeight();
//    }
    public MyAnimation(View view, int lastHeight) {
        this.view = view;
        this.lastHeight = lastHeight;
        yuanshiHeight = view.getMeasuredHeight();
    }

    public MyAnimation() {
    }

    public MyAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param interpolatedTime 动画的完成度 一般介于0-1之间,动画指定多久执行完成,当前已经完成了多少时间,算出来的值
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        //假如说 变化200
        //0-200之间
        //原始高度是100
       // view.getLayoutParams().height = (int) (yuanshiHeight + (change * interpolatedTime));
        view.getLayoutParams().height= (int) (yuanshiHeight+(lastHeight - yuanshiHeight) * interpolatedTime);
        //想要生效
        view.requestLayout();//重绘界面
    }
}
