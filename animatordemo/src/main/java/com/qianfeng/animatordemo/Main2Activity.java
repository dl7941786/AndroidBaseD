package com.qianfeng.animatordemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ImageView left, right, top, bottom;
    private AnimatorSet animatorSet;
    private boolean isClosed = true;//是否是关闭状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.rigth);
        top = (ImageView) findViewById(R.id.top);
        bottom = (ImageView) findViewById(R.id.bottom);
        animatorSet = new AnimatorSet();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main://主按钮,点击后显示或者隐藏其他四个图片控件
                if (!animatorSet.isRunning() && isClosed) {
                    allAnimator(400);
                    isClosed = false;//开始执行动画后设置为非关闭状态
//                    showView();
                } else if (!animatorSet.isRunning() && !isClosed) {
                    allAnimator(400);
                    isClosed = true;//变为关闭状态
//                    closeView();
                }
                break;
            case R.id.left:
                Toast.makeText(this, "左", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rigth:
                Toast.makeText(this, "右", Toast.LENGTH_SHORT).show();
                break;

            case R.id.top:
                Toast.makeText(this, "上", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bottom:
                Toast.makeText(this, "下", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public void allAnimator(float start) {
        animatorSet.removeAllListeners();
        ObjectAnimator leftAnimator = ObjectAnimator.ofFloat(left, "translationX", isClosed ? 0 : -start, isClosed ? -start : 0);//往左走的控件
        ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(right, "translationX", isClosed ? 0 : start, isClosed ? start : 0);//往左走的控件
        ObjectAnimator topAnimator = ObjectAnimator.ofFloat(top, "translationY", isClosed ? 0 : -start, isClosed ? -start : 0);//往左走的控件
        ObjectAnimator bottomAnimator = ObjectAnimator.ofFloat(bottom, "translationY", isClosed ? 0 : start, isClosed ? start : 0);//往左走的控件
        animatorSet.setDuration(1000);
        animatorSet.playTogether(leftAnimator, rightAnimator, topAnimator, bottomAnimator);
        animatorSet.start();
        if (!isClosed) {//如果是打开状态
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    setVisiable(View.GONE);
                }
            });
        } else {
            setVisiable(View.VISIBLE);
        }
    }

    /**
     * 关闭控件
     */
    private void closeView() {
        ObjectAnimator leftAnimator = ObjectAnimator.ofFloat(left, "translationX", -400, 0);//往左走的控件
        ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(right, "translationX", 400, 0);//往左走的控件
        ObjectAnimator topAnimator = ObjectAnimator.ofFloat(top, "translationY", -400, 0);//往左走的控件
        ObjectAnimator bottomAnimator = ObjectAnimator.ofFloat(bottom, "translationY", 400, 0);//往左走的控件
        animatorSet.setDuration(1000);
        animatorSet.playTogether(leftAnimator, rightAnimator, topAnimator, bottomAnimator);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setVisiable(View.GONE);
            }
        });
    }


    /**
     * 显示控件
     */
    private void showView() {
        animatorSet.removeAllListeners();
        ObjectAnimator leftAnimator = ObjectAnimator.ofFloat(left, "translationX", 0, -400);//往左走的控件
        ObjectAnimator rightAnimator = ObjectAnimator.ofFloat(right, "translationX", 0, 400);//往左走的控件
        ObjectAnimator topAnimator = ObjectAnimator.ofFloat(top, "translationY", 0, -400);//往左走的控件
        ObjectAnimator bottomAnimator = ObjectAnimator.ofFloat(bottom, "translationY", 0, 400);//往左走的控件
        animatorSet.setDuration(1000);
//        animatorSet.play(topAnimator).before(bottomAnimator);
//        animatorSet.play(rightAnimator).before(topAnimator);
//        animatorSet.play(leftAnimator).before(rightAnimator);
        animatorSet.playTogether(leftAnimator, rightAnimator, topAnimator, bottomAnimator);
        setVisiable(View.VISIBLE);
        animatorSet.start();
    }

    private void setVisiable(int visiable) {
        left.setVisibility(visiable);
        right.setVisibility(visiable);
        top.setVisibility(visiable);
        bottom.setVisibility(visiable);
    }
}
