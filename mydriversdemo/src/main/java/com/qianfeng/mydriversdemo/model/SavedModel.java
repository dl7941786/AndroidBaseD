package com.qianfeng.mydriversdemo.model;

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

import android.database.Cursor;
import android.net.Uri;

import com.google.gson.Gson;
import com.qianfeng.mydriversdemo.app.MyApp;
import com.qianfeng.mydriversdemo.bean.RecommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackiechan on 16/8/26.
 */
public class SavedModel extends BaseModel {
    public void getData(OnQueryCompleteListener onQueryCompleteListener) {
            //查询数据库,然后修改为相应的数据,然后返回
        RecommentBean recommentBean = new RecommentBean();
            //中间需要赋值
        RecommentBean.DataBean dataBean = new RecommentBean.DataBean();
        recommentBean.setData(dataBean);
        List<RecommentBean.DataBean.NewsBean> newsBeanList = new ArrayList<>();//创建最终对象集合
        dataBean.setNews(newsBeanList);//将集合加到dataBean里面

        //查询数据库
        Cursor query = MyApp.mContext.getContentResolver().query(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), null, null, null, null);
        while (query.moveToNext()) {//代表有下一条数据
            String content = query.getString(query.getColumnIndex("content"));
            RecommentBean.DataBean.NewsBean newsBean = new Gson().fromJson(content, RecommentBean.DataBean.NewsBean.class);
            newsBeanList.add(newsBean);
        }
        query.close();
        onQueryCompleteListener.onQueryComplete(recommentBean);
    }
    public interface  OnQueryCompleteListener{
        void onQueryComplete(RecommentBean recommentBean);
    }
}
