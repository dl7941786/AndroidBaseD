package com.qianfeng.rattingbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {

    private RatingBar tatting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tatting = (RatingBar) findViewById(R.id.tatting);
        tatting.setOnRatingBarChangeListener(this);
        tatting.setStepSize(0.2f);//每颗心一次动0.2,代表一颗心可以动五次
        tatting.setMax(30);//设置进度的最大值,当前的星数能代表的最大数值,除以星数就是一颗星代表多少分
        tatting.setProgress(13);//当前的进度
    }

    /**
     *
     * @param ratingBar
     * @param rating
     * @param fromUser 是否用户操作,注意,如果是用户手动操作,最终抬起手指后才会执行这个方法
     */
    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Log.e("自定义标签", "onRatingChanged() called with: " + "ratingBar = [" + ratingBar + "], rating = [" + rating + "], fromUser = [" + fromUser + "]");
    }
}
