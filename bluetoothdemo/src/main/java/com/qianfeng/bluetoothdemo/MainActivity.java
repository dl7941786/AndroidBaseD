package com.qianfeng.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 怎么用蓝牙
 * 打开蓝牙-->扫描设备-->连接设备-->发送数据
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private int REQUEST_ENABLE_BT = 100;//请求启用蓝牙的请求码
    private BluetoothAdapter mBluetoothAdapter;
    private MyBroadCast myBroadCast;
    private ListView listView;
    private List<BluetoothDevice> list;
    private MyAdapter myAdapter;
    private BluetoothDevice bluetoothDevice;//要建立连接的对象
    private BluetoothSocket socket;
    private OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取默认的蓝牙适配器  密码1518
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {//如果不支持蓝牙,应该停止
            Toast.makeText(this, "请爱护你的手机,不要因为没有蓝牙就摔了,虽然我觉得你最好是摔了", Toast.LENGTH_SHORT).show();
            return;
        }
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listview);//找到 listview
        myAdapter = new MyAdapter(list);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
        //注册广播
        myBroadCast = new MyBroadCast();//监听蓝牙的广播
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);//发现设备
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);//开始扫描
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);//结束扫描
        registerReceiver(myBroadCast, intentFilter);//注册广播了
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ENABLE_BT && resultCode == RESULT_OK) {
            Toast.makeText(this, "蓝牙打开成功", Toast.LENGTH_SHORT).show();
            //继续扫描
            mBluetoothAdapter.startDiscovery();//启动扫描
        } else {
            Toast.makeText(this, "眼瞎?确认都看不见,你就点取消", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void onClick(View view) {
        if (mBluetoothAdapter == null) {//因为如果不支持蓝牙,下面的很多操作都得判断是不是有蓝牙,干脆写在这里,不支持蓝牙就直接退出
            return;
        }
        switch (view.getId()) {
            case R.id.scan://扫描蓝牙/
                list.clear();//为了防止数据重复,每次扫描先清空之前的数据
                //扫描之前确认蓝牙的打开状态
                if (!mBluetoothAdapter.isEnabled()) {//如果蓝牙禁用,应该请求打开
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
                //如果是启用则直接扫描
                mBluetoothAdapter.startDiscovery();//启动扫描
                break;
            case R.id.open://开灯 01 99 01 00 99
                //开启连接,发送指令
                senControl(new byte[]{0x01, (byte) 0x99, 0x01, 0x00, (byte) 0x99});
                break;

            case R.id.close://关灯
                senControl(new byte[]{0x01, (byte) 0x99, 0x01, 0x01, (byte) 0x99});
                break;
            case R.id.diandong:
                senControl(new byte[]{0x01, (byte) 0x99, 0x01, 0x02, (byte) 0x99});
                break;
            case R.id.husuo:
                senControl(new byte[]{0x01, (byte) 0x99, 0x01, 0x03, (byte) 0x99});
                break;
            case R.id.zisuo:
                senControl(new byte[]{0x01, (byte) 0x99, 0x01, 0x04, (byte) 0x99});
                break;
        }
    }

    private void senControl(byte[] bs) {
        try {
            if (socket == null) {
                socket = bluetoothDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                socket.connect();
                outputStream = socket.getOutputStream();//如果没有 socket的情况下,一定没有流
            }
//            byte[] bs = new byte[]{0x01, (byte) 0x99, 0x01, 0x00, (byte) 0x99};
            outputStream.write(bs);
//            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BluetoothDevice bluetoothDevice = list.get(position);
        String name = bluetoothDevice.getName();//获取点击的蓝牙设备的名字
        if (name.contains("BRK")) {//如果是我们想要连接的设备
            this.bluetoothDevice = bluetoothDevice;
        }
    }

    /**
     * 接收蓝牙的广播
     */
    public class MyBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();//获取广播的意图
            switch (action) {
                case BluetoothAdapter.ACTION_DISCOVERY_STARTED://开始扫描
                    Toast.makeText(MainActivity.this, "蓝牙开始扫描了", Toast.LENGTH_SHORT).show();
                    break;

                case BluetoothDevice.ACTION_FOUND://发现设备
                    Toast.makeText(MainActivity.this, "发现设备了", Toast.LENGTH_SHORT).show();
                    //获取到设备
                    BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);//获取设备
                    list.add(bluetoothDevice);
                    myAdapter.notifyDataSetChanged();
                    break;
                case BluetoothAdapter.ACTION_DISCOVERY_FINISHED://扫描结束
                    Toast.makeText(MainActivity.this, "蓝牙扫描结束", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
