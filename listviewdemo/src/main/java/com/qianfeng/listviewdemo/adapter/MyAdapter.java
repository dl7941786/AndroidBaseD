package com.qianfeng.listviewdemo.adapter;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.listviewdemo.R;

import java.util.List;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> list;

    public MyAdapter(List<String> list) {
        this.list = list;
    }

    /**
     *返回数据源的长度
     * @return
     */
    @Override
    public int getCount() {
        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getCount=====:" + "");
        return list==null?0:list.size();
    }

    /**
     * 返回指定位置的 item 数据源的对象,这个方法为手动调用,非设置适配器时候调用
     * @param position 指定位置
     * @return
     */
    @Override
    public Object getItem(int position) {
        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getItem=====:" + "");
        return list.get(position);
    }

    /**
     * 返回指定位置的 item的标记 id
     * @param position 指定位置
     * @return
     */
    @Override
    public long getItemId(int position) {
        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getItemId=====:" + "");
        return position;
    }

    /**
     * 工厂方法,设置好模板,返回视图,每个视图是怎么显示出来的, 核心点,怎么产生一个View, View 里面怎么放置对应的内容
     * @param position 当前加载的位置
     * @param convertView
     * @param parent listview
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:" + "");
//        TextView textView = new TextView(parent.getContext());
//        String s = list.get(position);
//        textView.setText(s);
        //布局填充器, root 必须写 null, 否则会崩溃
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base, null);
        //
        //View inflate = View.inflate(parent.getContext(), R.layout.item_base, null);,内部调用的是上面的 from 方法
        //以下才是LayoutInflater的真正创建方式
        //LayoutInflater layoutInflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //findviewbyid 是 activity 中的方法,其他地方要使用需要通过具体的 view来执行
        TextView textView= (TextView) view.findViewById(R.id.tv);
        //设置内容
        textView.setText(list.get(position));
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        imageView.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
}
