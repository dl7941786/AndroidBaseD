package com.qianfeng.listviewdemo2.adapter;

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

import android.widget.ImageView;

import com.qianfeng.listviewdemo2.callback.MyBitMapCallBack;
import com.qianfeng.listviewdemo2.R;
import com.qianfeng.listviewdemo2.asynctask.MyAsyncTask;
import com.qianfeng.listviewdemo2.bean.NewsBean;

import java.util.List;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyAdapter4 extends MyBaseAdapterSuper {
    private List<NewsBean> list;
    public MyAdapter4(int id, List list) {
        super(id, list);
        this.list = list;
    }

    @Override
    public void fillData(MyHolder myHolder, int position) {
        NewsBean newsBean = list.get(position);
        //填充数据
        myHolder.setText(newsBean.getReviewcount() + "", R.id.count);
        myHolder.setText(newsBean.getEditor() + "", R.id.edtor);
        myHolder.setText(newsBean.getDesc() + "", R.id.desc);
        ImageView imageView = (ImageView) myHolder.findView(R.id.iv);
        imageView.setImageBitmap(null);
        imageView.setTag(newsBean.getIcon());
        MyBitMapCallBack myBitMapCallBack = new MyBitMapCallBack(imageView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(myBitMapCallBack);
        myAsyncTask.execute(newsBean.getIcon());
    }
}
