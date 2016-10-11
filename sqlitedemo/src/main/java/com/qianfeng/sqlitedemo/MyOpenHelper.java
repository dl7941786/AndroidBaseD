package com.qianfeng.sqlitedemo;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？  

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jackiechan on 16/8/17.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";//数据库文件的名字
    private static final int VERSION = 2;//当前数据库的版本号

    public MyOpenHelper(Context context) {
        //如果没有这个文件,就创建,如果有就不创建,但是只创建了文件,没有表
        super(context, DB_NAME, null, VERSION);
    }

    /**
     * 创建表的回调,只有在没有表的情况下才会执行,执行过一次后 不会再次执行
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表,语句如果拼错了  就会崩溃
        Log.e("自定义标签", "类名==MyOpenHelper" + "方法名==onCreate=====:" + "");
        db.execSQL("create table person (_id integer primary key autoincrement,name text,age integer,gender text check(gender ='男' or gender ='女'));");
    }

    /**
     * 当数据库版提升的时候,会走这个回调
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("自定义标签", "类名==MyOpenHelper" + "方法名==onUpgrade=====:" + "");
        //在这里应该根据实际需求去操作表
    }

    /**
     * 降级的时候回调,比如升级后发现重大bug,导致必须得降回去
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
