package com.qianfeng.permissiondemoquanxian;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 动态申请的权限也必须在清单文件中申请一次(申请的原因就是安装程序的时候以及在程序列表中可以显式的看到你需要的所有的权限),否则直接拒绝
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.call:

                //方法介绍,如果上一次拒绝了这个权限,就返回 true,当用户选择了不再提示的时候,也返回 false
                boolean b = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE);
                if (b) {
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "");
                }


//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
                int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);//检查是否有权限
                if (i == PackageManager.PERMISSION_DENIED) {//如果没有权限
                    //申请权限
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);//申请权限
                } else {//PackageManager.PERMISSION_GRANTED 有权限
                    call();
                }
                break;
            case R.id.read:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//只有6.0以上才需要动态申请

                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission_group.STORAGE)) {//是否需要显示给用户说明权限
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);//申请权限
                    } else {
                        Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "其他情况");
                    }

                    //如果是没有权限
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission_group.STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //申请权限
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
                    } else {
                        readFile();
                    }
                }else{//6.0以下直接执行
                    readFile();
                }

                break;
        }

    }

    private void readFile() {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "1.apk");
            FileInputStream fis = new FileInputStream(file);
            byte[] bs = new byte[4096 * 8];
            while (fis.read(bs) != -1) {
                Log.e("自定义标签", "类名==MainActivity" + "方法名==onClick=====:" + "读取文件");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 申请权限的回调
     *
     * @param requestCode
     * @param permissions  申请的权限
     * @param grantResults 每个权限的结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 100:
                int grantResult = grantResults[0];
                if (grantResult == PackageManager.PERMISSION_GRANTED) {//代表同意权限了
                    call();
                } else {//grantResult == PackageManager.PERMISSION_DENIED 用户拒绝了
                    //停止相应操作,如果强制执行就崩溃了
                }

                break;
            case 200:
                int grantResult1 = grantResults[0];
                if (grantResult1 == PackageManager.PERMISSION_GRANTED) {//代表同意权限了
                    readFile();
                } else {//grantResult == PackageManager.PERMISSION_DENIED 用户拒绝了
                    Log.e("自定义标签", "类名==MainActivity" + "方法名==onRequestPermissionsResult=====:" + "你面子不够大");
                }

                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }
}
