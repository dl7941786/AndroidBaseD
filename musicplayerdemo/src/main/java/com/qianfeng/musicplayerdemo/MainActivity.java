package com.qianfeng.musicplayerdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;

import com.qianfeng.musicplayerdemo.adapter.MyAdapter;
import com.qianfeng.musicplayerdemo.bean.MusicBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemClickListener {

    private MyServiceConnection myServiceConnection;
    private MusicPlayerService.MyBinder myBinder;
    private SeekBar seekBar;
    private SeekBarChangeRecevice recevier;
    private List<MusicBean> musicBeanList;
    //    private int nextPosition;//下一首歌曲的位置
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100://播放,更新进度条
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==handleMessage=====:" + msg.arg1);
                    seekBar.setMax(msg.arg1);
                    sendEmptyMessageDelayed(101, 200);
                    break;
                case 101:
                    seekBar.setProgress(seekBar.getProgress() + 200);
                    sendEmptyMessageDelayed(101, 200);
                    break;
                case 105://代表播放完成
                    seekBar.setProgress(0);
                    break;
            }

        }
    };
    private ListView musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myServiceConnection = new MyServiceConnection();
        Intent intent = new Intent(this, MusicPlayerService.class);
        bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
        startService(intent);
        IntentFilter intentFilter = new IntentFilter("changeseek");
        recevier = new SeekBarChangeRecevice(handler);//更新进度条的广播
        registerReceiver(recevier, intentFilter);

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        musicBeanList = new ArrayList<>();//存放歌曲信息的集合
        musicList = (ListView) findViewById(R.id.listview);
        //读取歌曲列表
//        findMusic();
        musicList.setOnItemClickListener(this);
    }

//    /**
//     * 搜索歌曲
//     */
//    private void findMusic() {
//        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);//music目录
//        File[] files = file.listFiles();//获取里面所有的文件
//        for (File file1 : files) {
//            if (file1.getName().endsWith("mp3")) {//判断是不是 mp3
//                MusicBean musicBean = new MusicBean();
//                musicBean.setName(file1.getName());
//                musicBean.setFilePath(file1.getAbsolutePath());
//                musicBeanList.add(musicBean);//加到集合中
//            }
//        }
//        //遍历完成,拿到了所有歌曲,显示到 listview 上面
//        MyAdapter myAdapter = new MyAdapter(musicBeanList);
//        musicList.setAdapter(myAdapter);
//    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
//                MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ming);
//                mediaPlayer.start();
                if (myBinder != null) {
                    myBinder.start();
                }
                break;
            case R.id.pause:
                //
                if (myBinder != null) {
                    myBinder.pause();
                }
                break;
        }
    }

    /**
     * 进度变化
     *
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    /**
     * 按到 seekbar的时候
     *
     * @param seekBar
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * 抬起手指的时候
     *
     * @param seekBar
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // handler.removeMessages(101);
        //抬起手后将媒体播放的进度调整到对应位置
        int progress = seekBar.getProgress();
        myBinder.setProgress(progress);
        //设置给媒体播放器
        //handler.sendEmptyMessageDelayed(101, 200);
    }

    /**
     * 条目的点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //获取到当前点击的歌曲的地址
//        MusicBean musicBean = musicBeanList.get(position);
//        String filePath = musicBean.getFilePath();//获取到播放地址
//        myBinder.setMusic(filePath);
        myBinder.setPosition(position);//播放指定位置的歌曲
        handler.removeMessages(101);//去掉进度自动更新
        seekBar.setProgress(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.single://单曲循环
                myBinder.setType(1);
                break;

            case R.id.listplayback://列表
                myBinder.setType(2);
                break;

            case R.id.order://顺序
                myBinder.setType(0);
                break;

            case R.id.random://随机
                myBinder.setType(3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MusicPlayerService.MyBinder) service;
            musicBeanList = myBinder.getMusicList();
            MyAdapter myAdapter = new MyAdapter(musicBeanList);
            musicList.setAdapter(myAdapter);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myServiceConnection);
    }
}
