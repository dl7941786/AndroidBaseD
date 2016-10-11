package com.qianfeng.loaderdemo;

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

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by jackiechan on 16/8/20.
 */
public class MyLoader extends AsyncTaskLoader<Cursor> {
    private MyOpenHelper myOpenHelper;
    private ForceLoadContentObserver forceLoadContentObserver = new ForceLoadContentObserver();//观察者
    public MyLoader(Context context) {
        super(context);
        myOpenHelper = new MyOpenHelper(context);
    }

    /**
     * 后台查询数据
     * @return
     */
    @Override
    public Cursor loadInBackground() {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        Cursor person = writableDatabase.query("person", null, null, null, null, null, null);
        person.registerContentObserver(forceLoadContentObserver);//注册一个观察者
        person.setNotificationUri(getContext().getContentResolver(), Uri.parse("content://zheshiwosuibianxiede"));//注册通知的 uri
        return person;
    }

    /**
     * 自定义必须重写这个方法
     */
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();//必须手动调用这行代码
    }
}
