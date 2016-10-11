package com.qianfeng.xianghaapp.adapter;

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
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.xianghaapp.R;
import com.qianfeng.xianghaapp.bean.Main_JingCai;
import com.qianfeng.xianghaapp.callback.MyBitMapCallBack;
import com.qianfeng.xianghaapp.utils.MyAsyncTask;
import com.qianfeng.xianghaapp.utils.MyUtils;

import java.util.List;

/**
 * Created by jackiechan on 16/8/12.
 */
public class LearnCookAdapter extends BaseAdapter {
    private List<Main_JingCai.DataBean> dataBeanList;
    private Context context;
    private SharedPreferences name;
    private boolean isnopic;

    public List<Main_JingCai.DataBean> getDataBeanList() {
        return dataBeanList;
    }

    public void setDataBeanList(List<Main_JingCai.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    public LearnCookAdapter(List<Main_JingCai.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
    }

    @Override
    public int getCount() {
        return dataBeanList==null?0:dataBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        if (name == null) {
            name = context.getSharedPreferences("name", Context.MODE_PRIVATE);
        }
        isnopic = name.getBoolean("isnopic", false);
//        Log.e("自定义标签", "类名==LearnCookAdapter" + "方法名==getView=====:" + isnopic);
        Main_JingCai.DataBean dataBean = dataBeanList.get(position);
        ViewHolder viewHolder =null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jingcaishenghuoquanlistview, null);
            viewHolder.userpic = (ImageView) convertView.findViewById(R.id.userpic);
            viewHolder.first = (ImageView) convertView.findViewById(R.id.first);
            viewHolder.second = (ImageView) convertView.findViewById(R.id.second);
            viewHolder.third = (ImageView) convertView.findViewById(R.id.third);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.username);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc);
            viewHolder.time = (TextView) convertView.findViewById(R.id.timeandcategory);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.userName.setText(dataBean.getCustomer().getNickName());
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.desc.setText(dataBean.getContent());
        viewHolder.time.setText(dataBean.getTimeShow()+" - "+dataBean.getCName());
        viewHolder.userpic.setTag(dataBean.getCustomer().getImg());
//        Log.e("自定义标签", "类名==LearnCookAdapter" + "方法名==getView=====:" + dataBean.getImgs().size());
        viewHolder.first.setTag(dataBean.getImgs().get(0));
        viewHolder.second.setTag(dataBean.getImgs().get(1));
        int i= dataBean.getImgs().size() > 2 ? 2 : 1;//根据数据源的长度来把最后一张图片确定一下,如果是3张图就取2,是两张图就取1
        viewHolder.third.setTag(dataBean.getImgs().get(i));
        viewHolder.userpic.setImageBitmap(null);
        viewHolder.first.setImageBitmap(null);
        viewHolder.second.setImageBitmap(null);
        viewHolder.third.setImageBitmap(null);
//        if (!MyUtils.isHavaCache(dataBean.getCustomer().getImg(), context)) {
//            new MyAsyncTask(new MyBitMapCallBack(viewHolder.userpic)).execute(dataBean.getCustomer().getImg());
//        }else{
//            //从本地取
//            Bitmap bitmap = BitmapFactory.decodeFile(context.getExternalCacheDir() + "/" + dataBean.getCustomer().getImg().replaceAll("/", "") + ".jpg");
//            viewHolder.userpic.setImageBitmap(bitmap);
//        }
//        if (!MyUtils.isHavaCache(dataBean.getImgs().get(0), context)) {
//            new MyAsyncTask(new MyBitMapCallBack(viewHolder.first)).execute(dataBean.getImgs().get(0));
//        }else{
//
//        }
//        if (!MyUtils.isHavaCache(dataBean.getImgs().get(1), context)) {
//            new MyAsyncTask(new MyBitMapCallBack(viewHolder.second)).execute(dataBean.getImgs().get(1));
//        }else{
//
//        }
//        if (!MyUtils.isHavaCache(dataBean.getImgs().get(i), context)) {
//            new MyAsyncTask(new MyBitMapCallBack(viewHolder.third)).execute(dataBean.getImgs().get(i));
//        }else{
//
//        }


        if (!isnopic) {//如果没有开启无图模式 就加载图片
            loadPic(viewHolder.userpic,dataBean.getCustomer().getImg());
            loadPic(viewHolder.first,dataBean.getImgs().get(0));
            loadPic(viewHolder.second,dataBean.getImgs().get(1));
            loadPic(viewHolder.third,dataBean.getImgs().get(i));
        }

//        new MyBitMapAsync(new MyBitMapCallBack(viewHolder.userpic), parent.getContext()).execute(dataBean.getCustomer().getImg());
//        new MyBitMapAsync(new MyBitMapCallBack(viewHolder.first), parent.getContext()).execute(dataBean.getImgs().get(0));
//        new MyBitMapAsync(new MyBitMapCallBack(viewHolder.second), parent.getContext()).execute(dataBean.getImgs().get(1));
//        new MyBitMapAsync(new MyBitMapCallBack(viewHolder.third), parent.getContext()).execute(dataBean.getImgs().get(i));
        return convertView;
    }

    private void loadPic(ImageView imageView, String path) {
        if (!MyUtils.isHavaCache(path, context)) {//如果文件不存在
            new MyAsyncTask(new MyBitMapCallBack(imageView)).execute(path);
        }else {//如果文件存在就直接读取
            Bitmap bitmap = BitmapFactory.decodeFile(context.getExternalCacheDir() + "/" + path.replaceAll("/", "") + ".jpg");
            imageView.setImageBitmap(bitmap);
        }
    }


    static class ViewHolder{
        ImageView userpic,first,second, third;
        TextView userName,title,desc, time;


    }
}
