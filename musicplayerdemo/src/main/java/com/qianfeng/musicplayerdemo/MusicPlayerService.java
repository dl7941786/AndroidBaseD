package com.qianfeng.musicplayerdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import com.qianfeng.musicplayerdemo.bean.MusicBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayerService extends Service implements MediaPlayer.OnCompletionListener {
    private MediaPlayer mediaPlayer;
    private Intent intent = new Intent("changeseek");
    private List<MusicBean> musicBeanList;
    private int nextPosition;//下一首歌曲的位置
    private int currentPosition;//当前正在播放的位置
    private int playType;// 播放格式,默认是顺序播放
    private Random random = new Random();//随机数生成器

    public MusicPlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    private void startPlay() {
//        if (mediaPlayer == null) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.ming);
//        }
        if (!mediaPlayer.isPlaying()) {//如果不是正在播放就播放
            mediaPlayer.start();
            intent.putExtra("type", 0);
            intent.putExtra("time", mediaPlayer.getDuration());//将时间总长传递出去
            sendBroadcast(intent);
        }
    }

    private void pausePlay() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            intent.putExtra("type", 1);
            sendBroadcast(intent);//发送暂停的广播
        }
    }

    @Override
    public void onCreate() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();//创建播放器
            mediaPlayer.setOnCompletionListener(this);
        }
        musicBeanList = new ArrayList<>();
        findMusic();
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==MusicPlayerService" + "方法名==onDestroy=====:" + "");
        mediaPlayer.stop();
        mediaPlayer = null;
        super.onDestroy();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.e("自定义标签", "类名==MusicPlayerService" + "方法名==onCompletion=====:" + "播放完成");
        Intent intent = new Intent("changeseek");
        intent.putExtra("type", 3);
        sendBroadcast(intent);//发送播放完成的通知
        //根据播放的方式 决定下一首播放谁
        switch (playType) {

            case 1://单曲
                setPosition(currentPosition);
                break;
            case 0://顺序
                currentPosition++;//下一周
                if (currentPosition < musicBeanList.size()) {//判断是不是最后一首
                    setPosition(currentPosition);
                }
                break;
            case 2://列表循环
                currentPosition++;
                if (currentPosition >= musicBeanList.size()) {
                    currentPosition = 0;
                }
                setPosition(currentPosition);
                break;
            case 3://随机
                int randomPostion = random.nextInt(musicBeanList.size());
                if (randomPostion == currentPosition) {//如果随机到原先的那首
                    currentPosition++;
                    currentPosition = currentPosition >= musicBeanList.size() ? 0 : currentPosition;//判断会不会越界
                }else{//如果不一样就设置过去
                    currentPosition = randomPostion;
                }
                setPosition(currentPosition);
                break;
        }
    }


    public void setPosition(int position) {
        //获取当前指定的位置
        currentPosition = position;
        String path = musicBeanList.get(position).getFilePath();
        setMusic(path);
    }

    /**
     * 播放指定歌曲
     */
    private void setMusic(String path) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();//重置
                mediaPlayer.setDataSource(path);//设置播放资源
                mediaPlayer.prepare();
//                    mediaPlayer.seekTo(0);//歌曲 seek到0
                startPlay();//播放
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public class MyBinder extends Binder {
        public void start() {
            startPlay();//播放
        }

        public void pause() {
            pausePlay();// 暂停
        }

        public void setProgress(int progress) {//设置进度
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(progress);
            }
        }

        /**
         * 设置播放类型
         *
         * @param type
         */
        public void setType(int type) {
            playType = type;
            if (playType < 0 || playType > 3) {//防止乱传,0是顺序 1是单曲 2是列表循环 3是随机
                playType = 0;
            }
        }


        /**
         * 播放指定歌曲
         */
        private void setMusic(String path) {
//            if (mediaPlayer != null) {
//                try {
//                    mediaPlayer.reset();//重置
//                    mediaPlayer.setDataSource(path);//设置播放资源
//                    mediaPlayer.prepare();
////                    mediaPlayer.seekTo(0);//歌曲 seek到0
//                    startPlay();//播放
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
            MusicPlayerService.this.setMusic(path);
        }

        /**
         * 播放指定位置的歌曲
         *
         * @param position
         */
        public void setPosition(int position) {
            MusicPlayerService.this.setPosition(position);
        }

        /**
         * 获取播放列表
         *
         * @return
         */
        public List<MusicBean> getMusicList() {
            return musicBeanList;
        }
    }


    /**
     * 搜索歌曲
     */
    private void findMusic() {
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);//music目录
        File[] files = file.listFiles();//获取里面所有的文件
        for (File file1 : files) {
            if (file1.getName().endsWith("mp3")) {//判断是不是 mp3
                MusicBean musicBean = new MusicBean();
                musicBean.setName(file1.getName());
                musicBean.setFilePath(file1.getAbsolutePath());
                musicBeanList.add(musicBean);//加到集合中
            }
        }
    }
}
