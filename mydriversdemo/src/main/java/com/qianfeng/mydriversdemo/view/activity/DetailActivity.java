package com.qianfeng.mydriversdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qianfeng.mydriversdemo.R;
import com.qianfeng.mydriversdemo.view.fragment.DetailFragment;
import com.qianfeng.mydriversdemo.view.fragment.SavedFragment;

public class DetailActivity extends AppCompatActivity {

    //    private WebView webView;
    private int postion = -1;//收藏的位置
    //    private boolean isSave;//是否已经收藏
//    private ImageView save;
    private int nids;//哪个条目的详情页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
//        save = (ImageView) findViewById(R.id.save);
        Intent intent = getIntent();
        String page = intent.getStringExtra("page");//获取想要加载的页面
        switch (page) {
            case "saved"://跳转到收藏夹
                SavedFragment savedFragment = new SavedFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, savedFragment, savedFragment.getClass().getSimpleName()).commit();
                break;
            case "detail"://代表详情页
                //获取到条目的 id
                nids = intent.getIntExtra("nids", -1);
                postion = intent.getIntExtra("position", -1);
                DetailFragment detailFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("nids", nids);
                bundle.putInt("position", postion);
                detailFragment.setArguments(bundle);
                //加载 fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.container, detailFragment, detailFragment.getClass().getSimpleName()).commit();
                break;

        }

        //查询数据库看看是否已经收藏
//        Cursor query = getContentResolver().query(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), null, "article_id=?", new String[]{nids + ""}, null);
//        isSave = (query != null && query.getCount() > 0);//判断是否已经收藏
//        if (isSave) {//如果收藏了就变成已经收藏的图标
//            save.setImageResource(R.mipmap.bottom_saved_press);
//        }
//        String path = String.format(GloableInerface.DETAILURL, nids);//详情地址
//        DeatilPresenter deatilPresenter = new DeatilPresenter();
//        deatilPresenter.attach(this);//添加依赖关系
//        deatilPresenter.getData(path);//请求数据
//
//        webView = (WebView) findViewById(R.id.webview);
//        webView.getSettings().setUseWideViewPort(true);//开启缩放显示
//        webView.getSettings().setLoadWithOverviewMode(true);//
    }


    public void onClick(View view) {
        Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(DetailFragment.class.getSimpleName());
        if (fragmentByTag != null && fragmentByTag instanceof DetailFragment) {
            ((DetailFragment) fragmentByTag).onClick(view);
        }

    }


//    @Override
//    public void showView(DetailBean detailBean) {
//        //显示内容到 wevbiew 上面
//        String article_content = detailBean.getData().getNews().get(0).getArticle_content();//内容
//        webView.loadData(article_content, "text/html;charset=utf-8", null);
//    }


//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.back:
//                finish();
//                break;
//            case R.id.comment://评论
//
//                break;
//
//            case R.id.share:
//
//
//                break;
//
//            case R.id.save:
//                Intent intent = null;
//                if (!isSave) {//没有收藏
//                    intent = new Intent();
//                    //收藏
//                    intent.putExtra("save", postion);
//                    save.setImageResource(R.mipmap.bottom_saved_press);
//                } else {
//                    save.setImageResource(R.mipmap.bottom_saved_normal);
//                    //需要从数据库中删掉
//                    getContentResolver().delete(Uri.parse("content://fjdhjkfdsfgsdfgsfdg"), "article_id=?", new String[]{nids + ""});
//                }
//                isSave = !isSave;
//                setResult(RESULT_OK, intent);
//                break;
//        }
//    }
}
