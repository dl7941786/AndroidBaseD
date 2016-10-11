package com.qianfeng.animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * 帧动画,补间动画,属性动画
 * 帧动画 一帧一帧的图片连续播放就是一个帧动画,主要用于重复显示某些画面
 * 补间动画, 位移,旋转,缩放,渐变 四种动画,四种动画可以单独使用,也可以结合起来使用
 */
public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView iv;
    private AnimationDrawable animationDrawable;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
//        iv.setVisibility(View.INVISIBLE);
//        frameAnimation();
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv:
//                animationDrawable.start();//启动帧动画
//                handler.sendEmptyMessageDelayed(100, sum + 5);//延迟动画的播放时间发送消息
                break;
            case R.id.scale:
                scaleAnimation();
                break;

            case R.id.trans:
                translateAnimation();
                break;
            case R.id.rotate:
                rotateAnimation();
                break;
            case R.id.alpha:
                alphaAnimation();
                break;
            case R.id.set://动画集合
                setAnimation();
                break;

            case R.id.scalec://通过代码创建动画
                scaleAnimationC();
                break;

            case R.id.rotatec:
                rotatecAnimationC();
                break;

            case R.id.transc:
                translateAnimationC();
                break;

            case R.id.alphac:
                alphaAnimationC();
                break;

            case R.id.setc:
                setAnimationC();
                break;
            case R.id.startactivity:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.rightenter, R.anim.rightexit);//要在 startactivity 之后或者是 finish 之后调用
                break;
        }
    }

    /**
     * 代码创建动画集合
     */
    private void setAnimationC() {
        AnimationSet animationSet = new AnimationSet(true);//创建动画集合
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 0.8f);//创建渐变动画
        alphaAnimation.setDuration(2000);
        //创建位移动画
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.4F, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 1.4f);
        translateAnimation.setDuration(2000);
        //创建旋转动画
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
        rotateAnimation.setDuration(3000);//设置持续时间

        animationSet.addAnimation(alphaAnimation);//将动画加到集合中
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        iv.startAnimation(animationSet);
        iv.clearAnimation();//清除动画
    }

    /**
     * 代码创建渐变动画
     */
    private void alphaAnimationC() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 0.8f);
        alphaAnimation.setDuration(2000);
        iv.startAnimation(alphaAnimation);
    }

    /**
     * 位移动画
     */
    private void translateAnimationC() {
        /**
         * 参照物是以父容器的款高度为基准
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.4F, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.4f);
        translateAnimation.setDuration(2000);
        iv.startAnimation(translateAnimation);
    }

    /**
     * 代码创建旋转动画
     */
    private void rotatecAnimationC() {
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        rotateAnimation.setDuration(3000);//设置持续时间
        iv.startAnimation(rotateAnimation);
    }

    /**
     * 通过代码创建缩放动画
     */
    private void scaleAnimationC() {
        //创建动画Animation.RELATIVE_TO_PARENT 以父容器为参照物 Animation.RELATIVE_TO_SELF 以自己为参照物, 如果以父容器为参照物会导致控件移动
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2.0f, 2.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setRepeatMode(Animation.REVERSE);//重复方式会逆序
        scaleAnimation.setRepeatCount(2);//重复次数
        iv.startAnimation(scaleAnimation);
    }

    /**
     * 动画集合
     */
    private void setAnimation() {
        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
        iv.startAnimation(setAnimation);
    }

    /**
     * 渐变动画
     */
    private void alphaAnimation() {
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        iv.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(this);
    }

    /**
     * 旋转动画
     */
    private void rotateAnimation() {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        iv.startAnimation(rotateAnimation);
//        rotateAnimation.setZAdjustment(Animation.ZORDER_BOTTOM);
        rotateAnimation.setAnimationListener(this);
    }

    /**
     * 位移动画
     */
    private void translateAnimation() {
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);//获取到动画
        iv.startAnimation(translateAnimation);//启动动画
        iv.setVisibility(View.VISIBLE);
        translateAnimation.setAnimationListener(this);

    }


    /**
     * 缩放动画
     */
    private void scaleAnimation() {
        // 执行缩放动画
        //1 拿到缩放动画
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        scaleAnimation.setFillAfter(true);//保持在动画完成时候的效果
        //2将动画设置给指定的控件
        // iv.setAnimation(scaleAnimation);
        //3启动动画
//        scaleAnimation.start();
        iv.startAnimation(scaleAnimation);//通过控件.startAnimation方式启动动画
        scaleAnimation.setAnimationListener(this);
    }


    /**
     * 帧动画的使用方式
     */
    private void frameAnimation() {
        iv.setBackgroundResource(R.drawable.gif);//设置帧动画的列表文件给图片控件
        //需要让动画动起来
        //获取到背景图,强制转换为帧动画背景
        animationDrawable = (AnimationDrawable) iv.getBackground();

        int numberOfFrames = animationDrawable.getNumberOfFrames();//获取到所有的朕
        for (int i = 0; i < numberOfFrames; i++) {
            int duration = animationDrawable.getDuration(i);//获取指定帧数的时间
            sum += duration;
        }
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onCreate=====:" + sum);
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    animationDrawable.stop();//停止动画
                    break;
            }
        }
    };

    @Override
    public void onAnimationStart(Animation animation) {
        Log.e("自定义标签", "onAnimationStart() called with: " + "animation = [" + animation + "]");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.e("自定义标签", "onAnimationEnd() called with: " + "animation = [" + animation + "]");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.e("自定义标签", "onAnimationRepeat() called with: " + "animation = [" + animation + "]");
    }
}
