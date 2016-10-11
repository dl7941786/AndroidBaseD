package com.qianfeng.aidldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * AIDL android interface definition language  作用:进程间通信
 * 进程和线程的区别:
 * <p>
 * 1个进程可以有多个线程
 * 一般情况一个程序只有一个进程
 * 支付宝--->安全支付插件(支付宝安全操作)--->进程间通信--->AIDL
 * 进程间通信的方式:
 * 1 广播
 * 2 网络
 * 3 内容提供者
 * 4 文件
 * 5 共享内存
 * 6 信号量
 * 7 管道(linux)
 * 8 AIDL
 * in传递数据给服务端,服务端可以获取设置的内容
 * out 服务端可以修改参数中的内容,修改后客户端也会跟着更改,但是客户端设置的值 服务端获取不到,
 * inout 服务端可以获取参数内的信息,也可以修改信息,修改后客户端可以获取到修改的内容
 * 9 Messenger(信使)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
