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

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.listviewdemo2.callback.MyBitMapCallBack;
import com.qianfeng.listviewdemo2.R;
import com.qianfeng.listviewdemo2.asynctask.MyAsyncTask;
import com.qianfeng.listviewdemo2.bean.NewsBean;

import java.util.List;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyAdapter2 extends BaseAdapter {
    private List<NewsBean> list;

    public MyAdapter2(List<NewsBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        NewsBean newsBean = list.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qudong, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            viewHolder.editor = (TextView) convertView.findViewById(R.id.edtor);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            viewHolder.count = (TextView) convertView.findViewById(R.id.count);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();//可以写在 else 里面 也可以不写
        viewHolder.count.setText(newsBean.getReviewcount() + "");
        viewHolder.editor.setText(newsBean.getEditor());
        viewHolder.desc.setText(newsBean.getDesc());
        //图片错乱,网络请求的延迟不确定性,导致会不一定什么时候返回什么照片,以及来回多次请求,返回多张照片,显示在一个控件上面
        //每次请求的地址是唯一的
        viewHolder.imageView.setTag(newsBean.getIcon());
        viewHolder.imageView.setImageBitmap(null);
        MyBitMapCallBack myBitMapCallBack = new MyBitMapCallBack(viewHolder.imageView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(myBitMapCallBack);
        myAsyncTask.execute(newsBean.getIcon());
        return convertView;
    }


    static class ViewHolder {
        ImageView imageView;
        TextView desc, editor, count;
    }
}
