package com.qianfeng.listviewwithbuttoncheckbox.adapter;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qianfeng.listviewwithbuttoncheckbox.R;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MyAdapter extends BaseAdapter implements View.OnClickListener {
    private List<String> list;

    public MyAdapter(List<String> list) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.text);
            viewHolder.button = (Button) view.findViewById(R.id.add);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.textView.setText(list.get(i));
//        viewHolder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("自定义标签", "类名==MyAdapter" + "方法名==onClick=====:" + i);
//            }
//        });
     //   viewHolder.button.setTag(i);
        viewHolder.textView.setTag(R.id.imageclick1, i);//设置 tag 方式二
        viewHolder.textView.setOnClickListener(this);//点击事件一定得这么写
        viewHolder.button.setTag(R.id.imageclick,i);//java.lang.IllegalArgumentException: The key must be an application-specific resource id.
//        viewHolder.button.setTag(R.id.imageclick1,i);//java.lang.IllegalArgumentException: The key must be an application-specific resource id.
//        viewHolder.button.setTag(R.id.imageclick2,i);//java.lang.IllegalArgumentException: The key must be an application-specific resource id.
        viewHolder.button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
//        switch ((int)view.getTag()) {
//
//        }
        switch (view.getId()) {
            case R.id.add:
                int i = (int) view.getTag(R.id.imageclick);
                Log.e("自定义标签", "类名==MyAdapter" + "方法名==onClick=====:" + i);
                break;
            case R.id.text:
                int o = (int) view.getTag(R.id.imageclick1);
                Log.e("自定义标签", "类名==MyAdapter" + "方法名==onClick=====:" + o);
                break;
        }
//        int i = (int) view.getTag(R.id.imageclick);//获取 tag,就是点击的第几条
////        int o = (int) view.getTag(R.id.imageclick1);//获取 tag,就是点击的第几条
////        int p = (int) view.getTag(R.id.imageclick2);//获取 tag,就是点击的第几条
//        Log.e("自定义标签", "类名==MyAdapter" + "方法名==onClick=====:" + i);
    }

    static  class ViewHolder{
        TextView textView;
        Button button;
    }
}
