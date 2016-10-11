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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.listviewdemo.R;
import com.qianfeng.listviewdemo.asynctask.MyAsyncTask;
import com.qianfeng.listviewdemo.bean.NewsBean;

import java.util.List;

/**
 * Created by jackiechan on 16/8/9.
 */
public class MyAdapter2 extends BaseAdapter {
    private List<NewsBean> list;

    public MyAdapter2(List<NewsBean> list) {
        this.list = list;
    }

    /**
     * 返回数据源的长度, 显示多少条数据
     *
     * @return
     */
    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 返回指定位置的item的对应数据源对象,可以不写
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /**
     * 返回标记,唯一的
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        NewsBean newsBean = list.get(position);
        //布局填充器,填充布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qudong, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.iv);//图片控件
        new MyAsyncTask(new MyAsyncTask.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(byte[] bytes) {
                if (bytes != null) {
                    //得到图片了
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    imageView.setImageBitmap(bitmap);
                }else{
                    Toast.makeText(parent.getContext(),"什么破网",Toast.LENGTH_SHORT).show();
                }

            }
        }).execute(newsBean.getIcon());
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        TextView edtor = (TextView) view.findViewById(R.id.edtor);
        TextView count = (TextView) view.findViewById(R.id.count);
        title.setText(newsBean.getTitle());
        desc.setText(newsBean.getDesc());
        edtor.setText(newsBean.getEditor());
        count.setText(newsBean.getReviewcount()+"");
        return view;
    }
}
