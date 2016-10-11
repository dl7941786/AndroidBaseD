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

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyHolder {
    private View mConverView;
    private SparseArray<View> sparseArray = new SparseArray<>();

    public MyHolder(Context context, @LayoutRes int id) {
        mConverView = LayoutInflater.from(context).inflate(id, null);//加载布局
        mConverView.setTag(this);//设置 tag 为 this
    }

    public static MyHolder getHolder(View convertView, Context context, @LayoutRes int id) {

        //获取 holder 对象
        MyHolder myHolder = null;
        if (convertView == null) {
            myHolder = new MyHolder(context, id);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        return myHolder;
    }

    public View findView(@IdRes int id) {
        View view = sparseArray.get(id);
        if (view == null) {
            view = mConverView.findViewById(id);
            sparseArray.put(id, view);
        }
        return view;
    }

    public void setText(String text, int id) {
        TextView textView = (TextView) findView(id);
        textView.setText(text);
    }

    public View getmConverView() {
        return mConverView;
    }
}
