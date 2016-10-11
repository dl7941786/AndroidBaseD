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
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.qianfeng.listviewwithbuttoncheckbox.R;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MyAdapterWithCheckBox extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private List<String> list;
    private SparseArray<Boolean> sparseArray = new SparseArray<>();
//    private MyBean mybean;

    public MyAdapterWithCheckBox(List<String> list) {
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

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
//        mybean = new MyBean();
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_checkbox, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.text);
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.checkbox);
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.checkBox.setTag(R.id.checkboxcheck, i);//设置 tag,把位置作为 tag
        viewHolder.textView.setText(list.get(i));
       // boolean checked = mybean.isChecked();
        Boolean aBoolean = sparseArray.get(i, false);//从存储的记录中取当前位置是否是选中
        viewHolder.checkBox.setChecked(aBoolean);//设置为指定状态
        viewHolder.checkBox.setOnCheckedChangeListener(this);//设置监听
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.e("自定义标签", "类名==MyAdapterWithCheckBox" + "方法名==onCheckedChanged=====:" + "");
        int position = (int) buttonView.getTag(R.id.checkboxcheck);//点击的是第几个
        //或者是, 数据源中有一个 boolean值来记录这个状态,点击后,根据位置直接更改数据源里面的值
//        mybean.setChecked(isChecked);
        sparseArray.put(position, isChecked);
    }

    static class ViewHolder {
        TextView textView;
        CheckBox checkBox;
    }
}
