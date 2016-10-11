package com.qianfeng.filestorewenjiancunchudemo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.content);
        tv = (TextView) findViewById(R.id.contenttv);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.write:
                try {
                    //获取 edittext的内容然后写到文件中
                    File directory = Environment.getExternalStorageDirectory();//获取外置存储的根目录,并不是特指TF卡,手机本身的存储减去分配系统之后剩余的那些
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + directory.getPath());
                    File newFile = new File(directory, "1.txt");
                    FileOutputStream fos = new FileOutputStream(newFile);//创建文件
                    String context = editText.getText().toString();//拿到内容
                    fos.write(context.getBytes());//直接把内容写进去
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.read:
                //读取内容,显示到 textview
                try {
                    String path = Environment.getExternalStorageDirectory() + "/1.txt";
                    FileInputStream fis = new FileInputStream(path);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + line);
                        tv.setText(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.getpath:
                //Environment.getExternalStorageDirectory(); 外部存储的根目录
//                String path=Environment.getExternalStorageDirectory() + "/Download";//外部存储的 download 目录,可以使用下面另外一种方式获取
//                File file = new File(path);
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + file.exists());
//                File publicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);//获取外置存储的公共目录
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + publicDirectory.exists()+"------"+publicDirectory.getPath());
//                File rootDirectory = Environment.getRootDirectory();//系统的根目录,但是没什么用,因为不能进行操作
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + rootDirectory.getPath());
//                File dataDirectory = Environment.getDataDirectory();//这个也没有什么用,因为里面放的是所有用户安装的程序的数据目录
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + dataDirectory.getPath());
//                File downloadCacheDirectory = Environment.getDownloadCacheDirectory();//其实并不是下载的缓存目录,这个是获取的系统级的 cache 目录,真正下载缓存目录是外部存储的 download 目录
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + downloadCacheDirectory.getPath());//
//                String externalStorageState = Environment.getExternalStorageState();//获取外部存储的状态
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + externalStorageState);
//                if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {//判断是不是挂载状态// linux 上面的术语
//                    //如果挂载了 才进行正常的读写
//                }
//                try {
//                    File filesDir = getFilesDir();//,访问这个路径不需要外部存储的读写权限
//                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + filesDir.getPath());//获取当前项目在 data/data 目录下的路径中的 files 文件夹,存放程序私有的文件,最好是不能被外人看到的文件
//                    FileOutputStream fos = new FileOutputStream(new File(filesDir, "111.txt"));
//                    fos.write("这是程序里面的内容".getBytes());
//                    fos.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                File cacheDir = getCacheDir();//程序内部缓存目录
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + cacheDir);//获取的是 data/data/ 程序包名/ cache目录,这个不需要外部存储的读写权限
//                File externalFilesDir = getExternalFilesDir(null);//需要外置存储的读写权限
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + externalFilesDir.getPath());//放在外部存储上面的程序的私有目录,除非是手动拼出别的程序的地址,否则只能访问自己的,比如游戏的数据包,比较大,放不到内部存储
//                File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_MUSIC);////需要外置存储的读写权限,获取外置存储中的程序的私有目录的公共文件夹/storage/emulated/0/Android/data/com.qianfeng.filestorewenjiancunchudemo/files/Music
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + externalFilesDir);
//                File externalCacheDir = getExternalCacheDir();///获取外部存储中程序私有目录的 cache 目录,需要权限,storage/emulated/0/Android/data/com.qianfeng.filestorewenjiancunchudemo/cache
//                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + externalCacheDir);
            //Android 现在禁用了代码中访问TF卡的功能,除非通过反射获取,因为 Android 现在推行的是存储一体,//256G TF 90m/s 30m/s, //闪存--->固态硬盘--EMMC ,//磁盘阵列-->服务器固态硬盘SLC,MLC,TLC
//                try {
//                    FileOutputStream fileOutputStream = openFileOutput("123.txt", MODE_PRIVATE);//这个获取到的是 data 下面的私有的 files 目录,相当于getFilesDir();
//                    fileOutputStream.write("这是个什么鬼".getBytes());
//                    fileOutputStream.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    FileInputStream fileInputStream = openFileInput("123.txt");//读取getFilesDir()下的123.txt 文件
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
                //获取大小
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());//获取指定位置存储状态的类对象
               // int blockCount = statFs.getBlockCount();//获取总的块数
                int blockSize = statFs.getBlockSize();//获取每块的大小
                int availableBlocks = statFs.getAvailableBlocks();
                int freeBlocks = statFs.getFreeBlocks();//同上
                int availableBytes= blockSize * availableBlocks;//剩余可用的 byte 数
                String availableMB = Formatter.formatFileSize(this,availableBytes);//格式化的工具类,可以将字节数算出MB 数
                int freeBlocksBytes = freeBlocks * blockSize;//剩余的总数
                String freeBlocksMB = Formatter.formatFileSize(this, freeBlocksBytes);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + availableMB+"-----"+freeBlocksMB);

               // statFs.getTotalBytes();
                long freeBytes = statFs.getFreeBytes();//直接获取剩余数
                long availableBytes1 = statFs.getAvailableBytes();
                String freeMB = Formatter.formatFileSize(this, freeBytes);
                String availableMB1 = Formatter.formatFileSize(this, availableBytes1);
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + freeMB+"-----"+availableMB1);

                break;
        }
    }
}
