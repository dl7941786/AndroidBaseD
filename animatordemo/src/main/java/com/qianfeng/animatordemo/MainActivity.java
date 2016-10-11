package com.qianfeng.animatordemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private TextView tv;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        initAnimator();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv:
                Toast.makeText(this, "这是图片空间", Toast.LENGTH_SHORT).show();
                break;

            case R.id.scale:
                Animator scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scaleanimator);
                scaleAnimator.setTarget(tv);
                scaleAnimator.start();
                break;

            case R.id.trans:
//                Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
//                animation.setFillAfter(true);
//                iv.startAnimation(animation);
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.objectanimator);//从资源文件加载一个属性动画
                animator.setTarget(tv);
                animator.start();
                break;
            case R.id.rotate:

                break;
            case R.id.alpha:

                break;
            case R.id.set:
                Animator set = AnimatorInflater.loadAnimator(this, R.animator.set);
                set.setTarget(tv);
                set.start();
                break;

            case R.id.scalec:
                animatorScalec();
                break;

            case R.id.rotatec:
                animatorRotate();
                break;
            case R.id.transc:
                animatorTranslate();
                break;
            case R.id.alphac:
                animatorAlpha();
                break;
            case R.id.setc:
                animatorSet();
                break;
            case R.id.play:
                animatorSet.start();
                break;
            case R.id.pause:
                animatorSet.pause();//暂停
                break;
            case R.id.cancel:
                animatorSet.cancel();//取消动画,但是效果会停留在取消时候的状态
                break;

            case R.id.stop:
                animatorSet.end();// 取消动画,但是效果会直接跳到最终的结果
                break;
            case R.id.resume:
                animatorSet.resume();//暂停后恢复
                break;
            case R.id.custom:
                MyObject myObject = new MyObject(tv);
                ObjectAnimator width = ObjectAnimator.ofInt(myObject, "width", 10, 100, 200, 300, 400, 1000);
                width.setDuration(5000);
                width.start();
                break;
            case R.id.method2:
                //另外一种写法
                Property property = Property.of(TextView.class, float.class, "textSize");//创建一个属性对象, 宿主类型 Tetxview, 参数值类型float, 参数名textSize
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, property, 10, 20, 30, 40, 50);
                objectAnimator.setDuration(5000);
                objectAnimator.start();
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void initAnimator() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 0.1f, 0.9f, 1.0f, 1f, 0.5f, 0.8f);
        ObjectAnimator textSize = ObjectAnimator.ofFloat(tv, "textSize", 10, 30);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv, "scaleX", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv, "scaleY", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(iv, "translationX", 0, 300f);//位移动画
        animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.playTogether(alpha, textSize, scaleX, scaleY, translationX);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationCancel=====:" + "动画被取消了");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationEnd=====:" + "动画结束了");
            }

            @Override
            public void onAnimationPause(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationPause=====:" + "动画暂停了");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationRepeat=====:" + "动画重复执行");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationResume=====:" + "动画恢复");
            }

            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onAnimationStart=====:" + "动画开始");
            }
        });
    }


    /**
     * 代码创建动画集合
     */
    private void animatorSet() {
//        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.1f, 0.9f, 1.0f, 1f, 0.5f, 0.8f);
//        PropertyValuesHolder textSize = PropertyValuesHolder.ofFloat("textSize", 10, 30);
//        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
//        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
//        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tv, alpha, textSize, scaleX, scaleY);
//        objectAnimator.setDuration(5000);
//        objectAnimator.start();


        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 0.1f, 0.9f, 1.0f, 1f, 0.5f, 0.8f);
        ObjectAnimator textSize = ObjectAnimator.ofFloat(tv, "textSize", 10, 30);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv, "scaleX", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv, "scaleY", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(iv, "translationX", 0, 300f);//位移动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.play(alpha).with(translationX).before(textSize).after(scaleX);//自定义顺序
//        animatorSet.playTogether(alpha,textSize,scaleX,scaleY,translationX);//所有的动画一起播放
//        animatorSet.playSequentially(alpha,textSize,scaleX,scaleY,translationX);//将参数中的所有动画按照顺序一个一个播放
        animatorSet.start();

    }

    /**
     * 代码渐变动画
     */
    private void animatorAlpha() {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 0.1f, 0.9f, 1.0f, 1f, 0.5f, 0.8f);
        alpha.setDuration(5000);
        alpha.start();
    }

    /**
     * 代码创建旋转动画
     */
    private void animatorRotate() {
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(tv, "rotation", 0f, 180f, 360f);
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(tv, "rotationY", 0f, 180f, 360f);
//        ObjectAnimator rotationx = ObjectAnimator.ofFloat(tv, "rotationX", 0f, 180f, 360f);
//        rotation.setDuration(3000);
//        rotationx.setDuration(3000);
//        rotation.start();
//        rotationx.start();

        ObjectAnimator textSize = ObjectAnimator.ofFloat(tv, "textSize", 10, 30);
        textSize.setDuration(3000);
        textSize.start();
    }

    /**
     * 代码创建缩放动画
     */
    private void animatorScalec() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv, "scaleX", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv, "scaleY", 0.2f, 1.0f, 0.5f, 2.0f, 3.8f, 10f, 1.4f);
        scaleX.setDuration(5000);
        scaleY.setDuration(5000);
        scaleX.start();
        scaleY.start();
    }

    /**
     * 代码创建位移属性动画
     */
    private void animatorTranslate() {
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(100f, 300f);//创建一个属性动画,里面的两个参数,代表是动画的属性值
//        valueAnimator.setDuration(2000);
//        valueAnimator.setTarget(iv);//设置动画的目标
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {//设置更新的事件
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                float f = (float) valueAnimator.getAnimatedValue();//获取到当前动画执行到的值
//                   iv.setTranslationX(f);//将值作为位移的参数设置给控件,设置的相对参数
//                iv.setX(f);//设置的是绝对参数
//            }
//        });
//        valueAnimator.start();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(iv, "translationX", 0, 300f);//位移动画
        translationX.setDuration(2000);
        translationX.start();
    }
}
