package com.qianfeng.xianghaapp.presenter;

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

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.qianfeng.xianghaapp.app.MyApp;
import com.qianfeng.xianghaapp.bean.BaseData;
import com.qianfeng.xianghaapp.bean.Main_JingCai;
import com.qianfeng.xianghaapp.model.LeanCookModel;
import com.qianfeng.xianghaapp.model.MvpModel;
import com.qianfeng.xianghaapp.utils.GlobalInterface;
import com.qianfeng.xianghaapp.view.IViewFirst;
import com.qianfeng.xianghaapp.view.IViewSecond;
import com.qianfeng.xianghaapp.view.MvpView;

/**
 * Created by jackiechan on 16/8/12.
 */
public class LearCookPresenter {
    private MvpView mvpView;
    private MvpModel mvpModel;
    private int tag = 0;

    public LearCookPresenter setTag(int tag) {
        this.tag = tag;
        return this;
    }

    public LearCookPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        mvpModel = new LeanCookModel();
    }

    /**
     * 缓存思路, 为了防止断网情况下没有数据,应该每次请求后将最新的数据缓存到数据,下次如果断网了就从数据库中拿
     * // 因为页面比较多,接口比较多,可能会插入比较多的行,但是每次同样的接口应该是更新数据
     *
     * @param path
     */
    public void load(String path) {
        mvpModel.getData(new MvpModel.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(String path, byte[] bytes) {

                if (bytes == null) {//没有数据,从数据库看看有没有缓存
                  new Thread(){
                      @Override
                      public void run() {
                          SQLiteDatabase database = MyApp.mySqliteOpenHelper.getWritableDatabase();
                          Cursor cache = database.query("cache", null, "page=?", new String[]{tag == 0 ? GlobalInterface.XUEZUOCAI_QITASHUJU : GlobalInterface.XUEZUOCAI_JINGCAISHENGHUO}, null, null, null);
                          if (cache.moveToFirst()) {//因为最多只有一条数据
                              String content = cache.getString(cache.getColumnIndex("content"));//获取缓存的内容
                              convertData(content, null);//转换数据,并更新界面
                          }
                          database.close();
                          cache.close();
                      }
                  }.start();
                    return;
                }
                String json = new String(bytes);//获取到 json
                //将 json 存起来,下次没有网络的情况下直接从存储的地方取出来 展示
                final ContentValues contentValues = new ContentValues();
                convertData(json, contentValues);//转换数据
                contentValues.put("content", json);
                new Thread(){
                    @Override
                    public void run() {
                        SQLiteDatabase writableDatabase = MyApp.mySqliteOpenHelper.getWritableDatabase();
                        long cache = writableDatabase.insert("cache", null, contentValues);
//                Log.e("自定义标签", "类名==LearCookPresenter" + "方法名==onLoadComplete=====插入了:" + cache);
                        if (cache == -1) {//带有数据库里面已经有缓存了,应该更新
                            int updateNum = writableDatabase.update("cache", contentValues, "page=?", new String[]{tag == 0 ? GlobalInterface.XUEZUOCAI_QITASHUJU : GlobalInterface.XUEZUOCAI_JINGCAISHENGHUO});
//                    Log.e("自定义标签", "类名==LearCookPresenter" + "方法名==onLoadComplete=====更新了:" + updateNum);
                        }
                        writableDatabase.close();
                    }
                }.start();
            }
        }, path);
    }

    private void convertData(String json, ContentValues contentValues) {
        if (tag == 0) {
            if (contentValues != null) {//如果需要存到数据库
                contentValues.put("page", GlobalInterface.XUEZUOCAI_QITASHUJU);
            }
            BaseData baseData = new Gson().fromJson(json, BaseData.class);//解析数据
            ((IViewFirst) mvpView).showView(baseData);//显示数据
        } else {
            if (contentValues != null) {//如果需要存到数据库
                contentValues.put("page", GlobalInterface.XUEZUOCAI_JINGCAISHENGHUO);
            }
            Main_JingCai main_jingCai = new Gson().fromJson(json, Main_JingCai.class);//解析数据
            ((IViewSecond) mvpView).showViewSecond(main_jingCai);//显示数据
        }
    }
}
