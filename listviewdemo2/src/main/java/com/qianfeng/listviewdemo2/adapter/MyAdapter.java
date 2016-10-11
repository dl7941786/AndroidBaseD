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
import android.widget.TextView;

import com.qianfeng.listviewdemo2.R;

import java.util.List;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> list;

    public MyAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 获取视图的方法
     *
     * @param position    位置
     * @param convertView 可复用的控件,滑出屏幕后就会变成可复用
     * @param parent      listview
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // View view = null;
        //View view = convertView = null;
        ViewHolder holder = null;
        if (convertView == null) {
            //获取视图 view
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_youhua1, null);//一定写 null
            //获取每个控件,并且显示内容
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);//给 tag 这个变量赋值,赋值为一起创建的 holder
        }
        holder= (ViewHolder) convertView.getTag();//获取 tag 这个变量值
        holder.textView.setText(list.get(position));
//        else{
//            view = convertView;
//        }
//
//        TextView textView = (TextView) convertView.findViewById(R.id.tv);
//        textView.setText(list.get(position));
        //   Log.e("自定义标签", "position="+position+"textview" + textView);
//        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:convertView==" + convertView);
        //Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:view==" + convertView);
        return convertView;
    }

    /**
     * 包
     */
    static class ViewHolder{
        TextView textView;
    }
}
