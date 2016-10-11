package com.qianfeng.dialogdemo;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.list://列表对话框
                createListDiaLog();
                break;

            case R.id.single://单选对话
                createSingleDiaLog();
                break;

            case R.id.mutilcheck: //多选对话框
                createMutilDiaLog();
                break;

            case R.id.datedia://日期对话框
                createDataDiaLog();
                break;
            case R.id.timedia://时间对话框
                createTimeDiaLog();
                break;
            case R.id.progressdia://进度条对话框
                createProgressDia();
                break;
        }
    }

    /**
     * 创建进度条对话框
     */
    private void createProgressDia() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setMessage("正在拼命加载中......你信吗?");
        progressDialog.setTitle("加载这么久,肯定都是你的锅");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置为横向
        progressDialog.show();
        progressDialog.setCancelable(false);//加载数据过程中,一般是不允许用户取消这个对话框的
        progressDialog.setProgress(50);//在 show 之后调用
    }

    /**
     * 创建时间选择框
     */
    private void createTimeDiaLog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.e("自定义标签", "onTimeSet() called with: " + "view = [" + view + "], hourOfDay = [" + hourOfDay + "], minute = [" + minute + "]");
            }
        }, 11, 11, true);
        timePickerDialog.show();
    }

    /**
     * 创建日期对话框
     */
    private void createDataDiaLog() {
        /**
         * 构造参数 , 1 上下文, 2 日期选择后的监听, 3 4 5 默认显示的年月日,  月从0开始,其他的正常
         */
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            /**
             *
             * @param view 当前日期选择的 view
             * @param year  当前选择的年
             * @param monthOfYear 当前选择的月,从0开始算
             * @param dayOfMonth,当前选择的日,从1开始算
             */
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.e("自定义标签", "onDateSet() called with: " + "view = [" + view + "], year = [" + year + "], monthOfYear = [" + monthOfYear + "], dayOfMonth = [" + dayOfMonth + "]");
            }
        }, 2016, 7, 15);
        datePickerDialog.show();
    }

    /**
     * 创建多选的对话框
     */
    private void createMutilDiaLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("这是多选对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        //第二个参数 boolean数组, 如果写 null 代表默认全部是非选中, 如果想指定某几个选中,需要创建对应长度的数据,按照位置的顺序,将指定位置设置为 true 即可,  数组长度不能小于数据源的长度,否则会越界,但是可以大于数据源的长度
        builder.setMultiChoiceItems(R.array.listdia, new boolean[]{true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
            /**
             *
             * @param dialog 当前点击的对话框
             * @param which 当前点击的条目
             * @param isChecked 被点击条目的选中状态
             */
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(MainActivity.this, "当前点击的是" + which + " 是否选中" + isChecked,Toast.LENGTH_SHORT).show();
            }
        });
//        builder.setNegativeButton();
//        builder.setPositiveButton();
        builder.show();
    }

    /**
     * 创建单选对话框
     */
    private void createSingleDiaLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("这是单选对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        //构造参数, 1 数据源,2 默认被选中的索引,3 条目的点击事件
        builder.setSingleChoiceItems(R.array.listdia, 2, new DialogInterface.OnClickListener() {
            /**
             *
             * @param dialog 当前的对话框
             * @param which  当前点击的是列表的第几个 item
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击的是" + which, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /**
     * 列表对话框
     */
    private void createListDiaLog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("这是列表对话框");
        builder.setIcon(R.mipmap.ic_launcher);
       // builder.setMessage("这是列表内容");//使用列表方式的时候不能设置 message
        builder.setItems(R.array.listdia, new DialogInterface.OnClickListener() {
            /**
             *
             * @param dialog 当前的对话框
             * @param which  当前点击的是列表的第几个 item
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "点击的是" + which, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);//不允许被某些方式取消,比如按对话框之外的区域或者是返回键
        builder.show();
    }
}
