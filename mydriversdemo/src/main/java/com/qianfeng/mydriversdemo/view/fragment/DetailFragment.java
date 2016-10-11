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
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.bean.DetailBean;
import com.qianfeng.mydriversdemo.presenter.DeatilPresenter;
import com.qianfeng.mydriversdemo.utils.GloableInerface;
import com.qianfeng.mydriversdemo.view.DetailView;

/**
 * Created by jackiechan on 16/8/26.
 */
public class DetailFragment extends MySuperBaseFragment<DeatilPresenter,DetailView> implements DetailView {

    private WebView webView;
    private int postion = -1;//收藏的位置
    private boolean isSave;//是否已经收藏
    private ImageView save;
    private int nids;//哪个条目的详情页
//    private DeatilPresenter deatilPresenter;

    public void setNids(int nids) {
        this.nids = nids;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);
        save = (ImageView) view.findViewById(R.id.save);
        Bundle arguments = getArguments();
        if (arguments != null) {//如果传递数据过来
            nids = arguments.getInt("nids", -1);
            postion = arguments.getInt("position", -1);
        }
//        Intent intent = getIntent();
//        //获取到条目的 id
//        nids = intent.getIntExtra("nids", -1);
//        postion = intent.getIntExtra("position", -1);
        //查询数据库看看是否已经收藏
        String path = String.format(GloableInerface.DETAILURL, nids);//详情地址
        Cursor query = getActivity().getContentResolver().query(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), null, "article_id=?", new String[]{nids + ""}, null);
        isSave = (query != null && query.getCount() > 0);//判断是否已经收藏
        if (isSave) {//如果收藏了就变成已经收藏的图标
            save.setImageResource(R.mipmap.bottom_saved_press);
        }
        webView = (WebView) view.findViewById(R.id.webview);
        webView.getSettings().setUseWideViewPort(true);//开启缩放显示
        webView.getSettings().setLoadWithOverviewMode(true);//
//        deatilPresenter = new DeatilPresenter();//手动创建对象
//        deatilPresenter.attach(this);//手动依赖
//        deatilPresenter.getData(path);
        presenter.getData(path);
        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                getFragmentManager().popBackStack();
                break;
            case R.id.comment://评论

                break;

            case R.id.share:

                break;

            case R.id.save:
                Intent intent = null;
                if (!isSave) {//没有收藏
                    intent = new Intent();
                    //收藏
                    intent.putExtra("save", postion);
                    save.setImageResource(R.mipmap.bottom_saved_press);
                } else {
                    save.setImageResource(R.mipmap.bottom_saved_normal);
                    //需要从数据库中删掉
                    getActivity().getContentResolver().delete(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), "article_id=?", new String[]{nids + ""});
                }
                isSave = !isSave;
                getActivity().setResult(Activity.RESULT_OK, intent);
                break;
        }
    }


    @Override
    public void showView(DetailBean detailBean) {
        String article_content = detailBean.getData().getNews().get(0).getArticle_content();//内容
        webView.loadData(article_content, "text/html;charset=utf-8", null);
    }
//
//    @Override
//    public void onDestroy() {
//        deatilPresenter.detach();
//        super.onDestroy();
//    }

    @Override
    public DeatilPresenter createPresenter() {
        return new DeatilPresenter();
    }
}
