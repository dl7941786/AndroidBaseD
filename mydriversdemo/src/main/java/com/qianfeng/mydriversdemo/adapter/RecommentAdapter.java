package com.qianfeng.mydriversdemo.adapter;

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

import android.view.View;
import android.widget.ImageView;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.bean.RecommentBean;

import java.util.List;

/**
 * Created by jackiechan on 16/8/25.
 */
public class RecommentAdapter extends MyBaseAdapter<RecommentBean.DataBean.NewsBean> {
    private List<RecommentBean.DataBean.NewsBean> list;

    public RecommentAdapter(int[] id, List<RecommentBean.DataBean.NewsBean> list) {
        super(id, list);
        this.list = list;
    }

    @Override
    public void fillData(int position, MyHolder myHolder) {
        RecommentBean.DataBean.NewsBean newsBean = list.get(position);//要显示的数据
        int type = getType(position);//当前加载的布局是哪一个
        //因为不管是什么布局的,都有下面这四个空间, id设置的是一样的
        myHolder.setText(R.id.title, newsBean.getTitle());
        myHolder.setText(R.id.author, newsBean.getEditor());
        myHolder.setText(R.id.time, newsBean.getPub_time() + "");
        myHolder.setText(R.id.commentcount, newsBean.getReview_count() + "");
        //只有显示图片的时候是不一样的,有一张的,有三张的,有没有的
        if (type == 0) {//只有一张图片
            myHolder.findView(R.id.pic).setVisibility(View.VISIBLE);//为了防止上次是无图 gone掉,而本次需要显示一张图,所以先显示出来
            //设置图片
            if (newsBean.getShowtype() == 0) {//代表没有图片
                //把图片空间 gone
                myHolder.findView(R.id.pic).setVisibility(View.GONE);
            } else {//显示一张图片
                ((ImageView) myHolder.findView(R.id.pic)).setImageBitmap(null);
                myHolder.setImage(R.id.pic, newsBean.getImgs().get(0));//显示图片
            }
        } else {//显示三张图片
            ((ImageView) myHolder.findView(R.id.first)).setImageBitmap(null);
            ((ImageView) myHolder.findView(R.id.second)).setImageBitmap(null);
            ((ImageView) myHolder.findView(R.id.third)).setImageBitmap(null);
            myHolder.setImage(R.id.first, newsBean.getImgs().get(0));
            myHolder.setImage(R.id.second, newsBean.getImgs().get(1));
            myHolder.setImage(R.id.third, newsBean.getImgs().get(2));
        }

    }

    @Override
    public int getType(int position) {
        RecommentBean.DataBean.NewsBean newsBean = list.get(position);//要显示的数据
        int currentId = 0;//要加载的布局
        switch (newsBean.getShowtype()) {
            case 1:
                currentId = 0;
                break;
            case 3:
                currentId = 1;
                break;
        }
        return currentId;//根据图片的数量决定显示哪个布局
    }
}
