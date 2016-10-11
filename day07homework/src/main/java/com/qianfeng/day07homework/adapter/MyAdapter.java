package com.qianfeng.day07homework.adapter;

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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qianfeng.day07homework.R;
import com.qianfeng.day07homework.bean.ReCaiBean;
import com.qianfeng.day07homework.callback.MyBitMapCallBack;
import com.qianfeng.day07homework.utils.MyAsyncTask;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MyAdapter extends BaseAdapter {
    private List<ReCaiBean.ObjBean.DataBean> list;

    public MyAdapter(List<ReCaiBean.ObjBean.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ReCaiBean.ObjBean.DataBean dataBean = list.get(i);
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_listview, null);
            viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.time = (TextView) view.findViewById(R.id.time);
            viewHolder.kouwei = (TextView) view.findViewById(R.id.kouwei);
            viewHolder.ratingBar = (RatingBar) view.findViewById(R.id.rating);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.time.setText(dataBean.getStep()+"/"+dataBean.getMt());
        viewHolder.kouwei.setText(dataBean.getKouwei()+"/"+dataBean.getGongyi());
        viewHolder.icon.setTag(dataBean.getTitlepic());
        viewHolder.icon.setImageBitmap(null);
        String rate = dataBean.getRate();
        viewHolder.ratingBar.setRating(Float.parseFloat(rate));
        new MyAsyncTask(new MyBitMapCallBack(viewHolder.icon)).execute(dataBean.getTitlepic());
        return view;
    }

    static class ViewHolder{
        ImageView icon;
        TextView title;
        RatingBar ratingBar;
        TextView time;
        TextView kouwei;

    }
}
