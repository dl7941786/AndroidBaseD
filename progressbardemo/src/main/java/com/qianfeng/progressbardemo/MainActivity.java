package com.qianfeng.progressbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private ProgressBar progressbar;
    private SeekBar seekBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        Utils.getDaa("http://skycnxz2.wy119.com//2/wifiwannengyaoshi.apk",progressbar);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setMax(10000);//设置最大值为10000
        seekBar.setOnSeekBarChangeListener(this);
        resultTextView = (TextView) findViewById(R.id.tv);
    }

    /**
     * @param seekBar 拖动的是哪个 seekbar
     * @param progress 当前的进度
     * @param fromUser 是否用户手动拖动执行
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onProgressChanged=====:" + "");
        if (fromUser) {//用户拖动的
            resultTextView.setText("当前歌曲移动到了"+progress+"的位置");
            //真正播放歌曲的话 需要在这里将歌曲快进或者快退到某个位置
        }
    }

    /**
     * 触摸到 seekbar的时候回调
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Log.e("自定义标签", "类名==MainActivity()" + "方法名==onStartTrackingTouch()");
    }

    /**
     * 从 seekbar 上面抬起手指的时候回调
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.e("自定义标签", "类名==MainActivity()" + "方法名==onStopTrackingTouch()");

    }
    int i=0;
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.move:
                seekBar.setProgress(i+=100);
                break;
        }
    }
}
