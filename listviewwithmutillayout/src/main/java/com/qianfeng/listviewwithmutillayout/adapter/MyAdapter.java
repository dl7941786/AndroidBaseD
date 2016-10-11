package com.qianfeng.listviewwithmutillayout.adapter;

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

import com.qianfeng.listviewwithmutillayout.ChatBean;
import com.qianfeng.listviewwithmutillayout.R;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MyAdapter extends BaseAdapter {
    private List<ChatBean> mChatBeanList;

    public MyAdapter(List<ChatBean> mChatBeanList) {
        this.mChatBeanList = mChatBeanList;
    }

    @Override
    public int getCount() {
        return mChatBeanList == null ? 0 : mChatBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return mChatBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatBean chatBean = mChatBeanList.get(position);
//        Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:" + chatBean.isLeft());
        ViewHolderLeft viewHolderLeft = null;
        ViewHolderRigth viewHolderRigth = null;
        int itemViewType = getItemViewType(position);//获取当前数据的类型
        if (convertView == null) {//没有复用
            //根据数据类型来判断加载什么内容 如果是左侧,就加载左侧布局,如果是右侧就加载右侧布局
            if (itemViewType == 0) {//左边
//                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, null);
//                viewHolderLeft = new ViewHolderLeft();
//                viewHolderLeft.left = (TextView) convertView.findViewById(R.id.left);
//                convertView.setTag(viewHolderLeft);
                convertView = createLeft(parent);
                viewHolderLeft = (ViewHolderLeft) convertView.getTag();
            } else {//这是右边
//                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rigth, null);
//                viewHolderRigth = new ViewHolderRigth();
//                viewHolderRigth.right = (TextView) convertView.findViewById(R.id.right);
//                convertView.setTag(viewHolderRigth);
                convertView = createRight(parent);
                viewHolderRigth = (ViewHolderRigth) convertView.getTag();
            }
        } else {
            ///复用的时候怎么解决,判断可以复用的控件和我想要进来的数据是不是一致,一致就直接用,否则还得创建新的
            if (convertView.getTag() instanceof ViewHolderLeft && itemViewType == 0) {//如果可以复用的是左边,想要也是左边
//                Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:" + "左边复用");
                viewHolderLeft = (ViewHolderLeft) convertView.getTag();
            } else if (convertView.getTag() instanceof ViewHolderRigth && itemViewType == 1) {//如果复用的是右边,想要的也是右边
//                Log.e("自定义标签", "类名==MyAdapter" + "方法名==getView=====:" + "右边复用");
                viewHolderRigth = (ViewHolderRigth) convertView.getTag();
            } else if (itemViewType == 0) {//不能复用,是左边就创建左边
                convertView = createLeft(parent);
                viewHolderLeft = (ViewHolderLeft) convertView.getTag();
            } else {//不能复用,是右边就创建右边
                convertView = createRight(parent);
                viewHolderRigth = (ViewHolderRigth) convertView.getTag();
            }
        }
        if (viewHolderLeft != null) {
            viewHolderLeft.left.setText("这是左边位置是" + position);
        } else {
            viewHolderRigth.right.setText("这是右边边位置是" + position);
        }


        return convertView;
    }

    /**
     * 创建左侧布局
     *
     * @param parent
     * @return
     */
    public View createLeft(ViewGroup parent) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, null);
        ViewHolderLeft viewHolderLeft = new ViewHolderLeft();
        viewHolderLeft.left = (TextView) convertView.findViewById(R.id.left);
        convertView.setTag(viewHolderLeft);
        return convertView;
    }

    /**
     * 创建右侧布局
     *
     * @param parent
     * @return
     */
    public View createRight(ViewGroup parent) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rigth, null);
        ViewHolderRigth viewHolderRigth = new ViewHolderRigth();
        viewHolderRigth.right = (TextView) convertView.findViewById(R.id.right);
        convertView.setTag(viewHolderRigth);
        return convertView;
    }


    static class ViewHolderLeft {
        TextView left;
    }

    static class ViewHolderRigth {
        TextView right;
    }


    /**
     * 返回指定位置的 item 的类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        ChatBean chatBean = mChatBeanList.get(position);
        boolean b = chatBean.isLeft();
        int i = b ? 0 : 1;//如果是左边就返回0,是右边就返回1
        return i;
    }
}
