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

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.adapter.RecommentAdapter;
import com.qianfeng.mydriversdemo.bean.RecommentBean;
import com.qianfeng.mydriversdemo.presenter.SavedPrenster;
import com.qianfeng.mydriversdemo.view.RecommmentView;
import com.qianfeng.mydriversdemo.view.activity.DetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackiechan on 16/8/26.
 */
public class SavedFragment extends BaseFragment<SavedPrenster, RecommmentView> implements RecommmentView{
    private List<RecommentBean.DataBean.NewsBean> newsBeanList = new ArrayList<>();
    private RecommentAdapter recommentAdapter;

    @Override
    public void loadMore() {
//如果数据库做分页 可以在这里写

    }

    @Override
    public void loadData() {
            //加载数据
        //根据数据源创建适配器,设置给 listview
        int[] ids = {R.layout.item_recomment_0, R.layout.item_recomment_1};
        newsBeanList.clear();
        //创建一个空数据的适配器
        recommentAdapter = new RecommentAdapter(ids, newsBeanList);
        mListView.setAdapter(recommentAdapter);//设置给 listivew,等数据加载完成后刷新一下即可
        presenter.getData();
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public SavedPrenster createPresenter() {
        return new SavedPrenster();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecommentBean.DataBean.NewsBean newsBean = newsBeanList.get(position);//当前点击的条目
        //跳转到详情页
        int nids = newsBean.getArticle_id();
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("page", "detail");
        intent.putExtra("nids", nids);
        intent.putExtra("position", position);
        startActivityForResult(intent, 100);
    }

    @Override
    public void showView(RecommentBean recommentBean) {
        newsBeanList.addAll(recommentBean.getData().getNews());
        //显示数据
        recommentAdapter.notifyDataSetChanged();
    }
}
