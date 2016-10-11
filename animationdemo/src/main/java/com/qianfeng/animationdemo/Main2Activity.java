package com.qianfeng.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    private ImageView iv1, iv2;
    private RelativeLayout relativeLayout;
    private ScaleAnimation big;
    private ScaleAnimation small;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        relativeLayout = (RelativeLayout) findViewById(R.id.root);
        relativeLayout.setOnClickListener(this);
        showView1();
        initAnimation();
    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        small = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        small.setDuration(1000);
        big = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        big.setDuration(1000);
        small.setAnimationListener(this);//只给其中一个设置监听,否则会导致动画出现错误 无限执行
    }

    private void showView1() {
        iv1.setVisibility(View.VISIBLE);
        iv2.setVisibility(View.INVISIBLE);
    }

    private void showView2() {
        iv2.setVisibility(View.VISIBLE);
        iv1.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (iv1.getVisibility() == View.VISIBLE) {//说明IV1可见,Iv1隐藏然后执行小的动画
            iv1.startAnimation(small);
        } else {//IV2可见, iv2执行小动画隐藏
            iv2.startAnimation(small);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    /**
     * 缩小的动画结束的时候判断应该显示谁
     *
     * @param animation
     */
    @Override
    public void onAnimationEnd(Animation animation) {
        //切换动画
        if (iv1.getVisibility() == View.VISIBLE) {//说明IV1可见,Iv1隐藏, iv2执行大的动画,显示
            showView2();
            iv2.startAnimation(big);
        } else {//IV2可见, iv2隐藏, iv1执行大动画显示
            showView1();
            iv1.startAnimation(big);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    /**
     * 按键按下去的时候回调
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//判断按下去的是不是返回按钮
            finish();//关闭
            overridePendingTransition(R.anim.rightenter, R.anim.rightexit);//执行动画
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
