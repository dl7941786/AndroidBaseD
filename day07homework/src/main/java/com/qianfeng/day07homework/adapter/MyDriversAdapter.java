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
import android.widget.TextView;

import com.qianfeng.day07homework.R;
import com.qianfeng.day07homework.bean.DriversBean;
import com.qianfeng.day07homework.callback.MyBitMapCallBack;
import com.qianfeng.day07homework.utils.MyAsyncTask;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MyDriversAdapter extends BaseAdapter {
    private List<DriversBean> driversBeanList;

    public MyDriversAdapter(List<DriversBean> driversBeanList) {
        this.driversBeanList = driversBeanList;
    }

    @Override
    public int getCount() {
        return driversBeanList==null?0:driversBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return driversBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        DriversBean driversBean = driversBeanList.get(i);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_qudong, null);
            viewHolder = new ViewHolder();
            viewHolder.count = (TextView) view.findViewById(R.id.count);
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.desc = (TextView) view.findViewById(R.id.desc);
            viewHolder.editor = (TextView) view.findViewById(R.id.edtor);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.iv);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.count.setText(driversBean.getReviewcount() + "");
        viewHolder.desc.setText(driversBean.getDesc() + "");
        viewHolder.editor.setText(driversBean.getEditor() + "");
        viewHolder.title.setText(driversBean.getTitle() + "");
        viewHolder.imageView.setImageBitmap(null);
        viewHolder.imageView.setTag(driversBean.getIcon());
        new MyAsyncTask(new MyBitMapCallBack(viewHolder.imageView)).execute(driversBean.getIcon());
        return view;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView title,desc,editor, count;
    }
}
