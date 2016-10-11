package com.qianfeng.mydriversdemo.view.fragment;

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

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.adapter.RecommentAdapter;
import com.qianfeng.mydriversdemo.bean.RecommentBean;
import com.qianfeng.mydriversdemo.presenter.RecommentPresenter;
import com.qianfeng.mydriversdemo.utils.GloableInerface;
import com.qianfeng.mydriversdemo.view.RecommmentView;
import com.qianfeng.mydriversdemo.view.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 最新
 * Created by jackiechan on 16/8/25.
 */
public class RecommentFragment extends BaseFragment<RecommentPresenter, RecommmentView> implements RecommmentView {
    public List<RecommentBean.DataBean.NewsBean> list = new ArrayList<>();//数据源集合
    private RecommentAdapter recommentAdapter;

    @Override
    public void loadData() {
        //根据数据源创建适配器,设置给 listview
        int[] ids = {R.layout.item_recomment_0, R.layout.item_recomment_1};
        list.clear();
        //创建一个空数据的适配器
        recommentAdapter = new RecommentAdapter(ids, list);
        mListView.setAdapter(recommentAdapter);//设置给 listivew,等数据加载完成后刷新一下即可
        presenter.getData(myUrl);
    }

    @Override
    public RecommentPresenter createPresenter() {
        return new RecommentPresenter();
    }

    /**
     * 分页加载数据
     */
    @Override
    public void loadMore() {
        presenter.getData(loadMore);
    }

    @Override
    public int getType() {
        return -2;
    }

    /**
     * 展示数据
     *
     * @param recommentBean
     */
    @Override
    public void showView(RecommentBean recommentBean) {
        loadCompleted();//调用加载完成的方法,将分页的关键参数修改为 false
        if (recommentBean.getData().getNews().size() <= 3) {
            //把 isLoading 变成 true
            setCanNotLoadMore();
        }
        //获取到数据后顺便把下一页的地址拼接好
        int type = getType();
        loadMore = String.format(GloableInerface.MOREPAGE, type, recommentBean.getData().getNext_show_time());
//        Log.e("自定义标签", "类名==RecommentFragment" + "方法名==showView=====:" + recommentBean);
        list.addAll(recommentBean.getData().getNews());//增加了数据
        recommentAdapter.notifyDataSetChanged();//刷新界面
    }

    /**
     * 条目的点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommentBean.DataBean.NewsBean newsBean = list.get(position);//当前点击的条目
        //跳转到详情页
        int nids = newsBean.getArticle_id();
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("page", "detail");
        intent.putExtra("nids", nids);
        intent.putExtra("position", position);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //根据是否有返回结果来决定是否收藏数据
        if (requestCode==100&&resultCode== Activity.RESULT_OK&&data != null) {//说明有数据返回
            int save = data.getIntExtra("save", -1);//获取应该保存的位置
            RecommentBean.DataBean.NewsBean newsBean = list.get(save);//需要保存的数据
            String json = new Gson().toJson(newsBean);
            ContentValues contentValues = new ContentValues();
            contentValues.put("article_id",newsBean.getArticle_id());
            contentValues.put("content",json);
            //以数据的article_id为主键, json 内容为内容,存到数据库中
            getActivity().getContentResolver().insert(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), contentValues);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
