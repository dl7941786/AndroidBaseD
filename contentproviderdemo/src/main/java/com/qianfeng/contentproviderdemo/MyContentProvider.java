package com.qianfeng.contentproviderdemo;

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

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

/**
 * Created by jackiechan on 16/8/19.
 */
public class MyContentProvider extends ContentProvider {
    private MyOpenHelper myOpenHelper;
    private static UriMatcher uriMatcher;
    public static final int PERSON = 0;
    public static final int STUDNET = 10;
    public static final int PERSONID = 1;
    public static final int STUDENTNAME = 11;
    public static final String AUTHORITY = "woshizhuji";

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);//创建 uri的匹配工具类,模式为不匹配
        uriMatcher.addURI(AUTHORITY, "person", PERSON);//匹配 content://woshizhuji/person
        uriMatcher.addURI(AUTHORITY, "student", STUDNET);//匹配 content://woshizhuji/student
        uriMatcher.addURI(AUTHORITY, "person/#", PERSONID);//匹配 content://woshizhuji/person/任意长度数字
        uriMatcher.addURI(AUTHORITY, "student/*", STUDENTNAME);//匹配任意字符
    }

    @Override
    public boolean onCreate() {
        myOpenHelper = new MyOpenHelper(getContext());//创建一个帮助类
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        Cursor person = writableDatabase.query("person", projection, selection, selectionArgs, null, null, sortOrder);
//        writableDatabase.close();
        return person;
    }

    /**
     * 这个方法正常来说是用不到的,不重写都没有什么影响
     *
     * @param uri
     * @return
     */
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        int match = uriMatcher.match(uri);
        long row;
        switch (match) {
            case PERSON://代表操作 person 表
                row = writableDatabase.insert("person", null, values);
                break;
            case STUDNET://代表操作学生表
                row = writableDatabase.insert("student", null, values);
                break;
            default:
                throw new NullPointerException("对方不想理你,并向你抛了一个空指针异常");
        }
        //应该通知正在操作这个数据库的调用者,内容更新了
        getContext().getContentResolver().notifyChange(uri,null);
        writableDatabase.close();
        return ContentUris.withAppendedId(uri, row);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        int num = 0;
        switch (uriMatcher.match(uri)) {
            case PERSON:
                num = writableDatabase.delete("person", selection, selectionArgs);
                break;
            case STUDNET:
                num = writableDatabase.delete("student", selection, selectionArgs);
                break;
            case PERSONID:
                long id = ContentUris.parseId(uri);//获取最后的数字
                String where = "_id=" + id;//将传递过来的参数作为条件的一部分
                if (!TextUtils.isEmpty(selection)) {//代表你还额外传递了参数过来
                    where = selection + " and " + where;//将两个参数进行拼接
                }
                num = writableDatabase.delete("person", where, selectionArgs);
                Log.e("自定义标签", "类名==MyContentProvider" + "方法名==delete=====:" + id + "----" + where);
                break;
            default:
                throw new RuntimeException("对方不知道你要删除什么,并向你抛了一个异常");

        }
        writableDatabase.close();
        return num;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase writableDatabase = myOpenHelper.getWritableDatabase();
        int upNum = 0;
        switch (uriMatcher.match(uri)) {//匹配 uri
            case PERSON:

                break;

            case PERSONID:

                break;

            case STUDNET:


                break;

            case STUDENTNAME:
//                Log.e("自定义标签", "类名==MyContentProvider" + "方法名==update=====:" + uri);
                String lastPathSegment = uri.getLastPathSegment();//获取最后一个 path
                List<String> pathSegments = uri.getPathSegments();// 获取所有的 path 以/为分割
                Log.e("自定义标签", "类名==MyContentProvider" + "方法名==update=====:" + "lst=" + lastPathSegment + "---ss==" + pathSegments);
//                writableDatabase.update("student", values, );
                String where = "name=" + lastPathSegment;//默认的查询条件
                if (!TextUtils.isEmpty(selection)) {//如果还有额外的查询条件
                    where = selection + " and " + where;//最终的条件
                }
                upNum = writableDatabase.update("student", values, where, selectionArgs);
                break;
        }
//        int person = writableDatabase.update("person", values, selection, selectionArgs);
        return upNum;
    }
}
