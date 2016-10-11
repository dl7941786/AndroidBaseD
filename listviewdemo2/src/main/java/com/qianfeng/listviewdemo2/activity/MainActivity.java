package com.qianfeng.listviewdemo2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.listviewdemo2.R;
import com.qianfeng.listviewdemo2.adapter.MyAdapter2;
import com.qianfeng.listviewdemo2.adapter.MyAdapter3;
import com.qianfeng.listviewdemo2.adapter.MyAdapter4;
import com.qianfeng.listviewdemo2.asynctask.MyAsyncTask;
import com.qianfeng.listviewdemo2.bean.NewsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener, View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> list;
    private List<NewsBean> newsBeanList;
    private MyAdapter2 myAdapter2;
    private MyAdapter3 myAdapter3;
    private MyAdapter4 myAdapter4;
    private String path = "http://m.mydrivers.com/app/newslist.aspx?%20tid=0&minId=0&maxId=0&ver=2.2&temp=1464423764091";
    private boolean isCanLoadMore;//是否可以加载更多
    private boolean isLoading;//正在加载更多
    private TextView footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        //数据源
        list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add("第" + i + "次虐汪");
//        }
//
//        //适配器创建
//        MyAdapter myAdapter = new MyAdapter(list);
//        //设置适配器
//        listView.setAdapter(myAdapter);
//        TextView textView = new TextView(this);
//        textView.setText("是第三方士大夫撒发放");
//        textView.setTextSize(50);
//        ((ViewGroup) listView.getParent()).addView(textView);//要把它作为 listview的兄弟控件
//        listView.setEmptyView(textView);//在数据没有显示前 显示一点其他的东西

        footerView = new TextView(this);
        footerView.setText("点击加载更多");
        footerView.setTextSize(50);
       // footerView.setVisibility(View.GONE);
//        listView.addHeaderView(footerView);//headerview会影响点击事件的位置,需要减掉相应的数量,因为 headerview和 footerview可以添加多次
//        listView.addHeaderView(footerView);//headerview会影响点击事件的位置,需要减掉相应的数量,因为 headerview和 footerview可以添加多次
//        listView.addHeaderView(footerView);//headerview会影响点击事件的位置,需要减掉相应的数量,因为 headerview和 footerview可以添加多次
//        listView.addHeaderView(footerView);//headerview会影响点击事件的位置,需要减掉相应的数量,因为 headerview和 footerview可以添加多次
//        listView.addFooterView(footerView);
//        footerView.setId(R.id.footerview);
        listView.setOnItemClickListener(this);
        footerView.setOnClickListener(this);

        new MyAsyncTask(new MyAsyncTask.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(byte[] bytes, String path) {
                if (bytes != null) {
                    try {
                        //得到数据源了
                        JSONArray jsonArray = new JSONArray(new String(bytes));//创建Json对象
                        newsBeanList = new ArrayList<NewsBean>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.optJSONObject(i);
                            NewsBean newsBean = new NewsBean();
                            int id = jsonObject.getInt("id");
                            newsBean.setId(id);
                            newsBean.setContent(jsonObject.getInt("Content"));
                            newsBean.setDesc(jsonObject.getString("desc"));
                            newsBean.setEditor(jsonObject.getString("editor"));
                            newsBean.setIcon(jsonObject.getString("icon"));
                            newsBean.setPostdate(jsonObject.getString("postdate"));
                            newsBean.setTitle(jsonObject.getString("title"));
                            newsBean.setReviewcount(jsonObject.getInt("reviewcount"));
                            newsBeanList.add(newsBean);
                        }

                        //完全获取数据源
//                        myAdapter2 = new MyAdapter2(newsBeanList);
//                        myAdapter3 = new MyAdapter3(newsBeanList);
                        myAdapter4 = new MyAdapter4(R.layout.item_qudong, newsBeanList);
                        listView.setAdapter(myAdapter4);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "什么破手机,怪不得单身狗", Toast.LENGTH_SHORT).show();
                }
            }
        }).execute(path);


        listView.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && isCanLoadMore) {
            isCanLoadMore = false;
           // isLoading = true;
            footerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem + visibleItemCount == totalItemCount&&!isLoading) {
            View childAt = view.getChildAt(visibleItemCount - 1);
            if (childAt != null && childAt.getBottom() <= view.getHeight()) {
                isCanLoadMore = true;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.footerview:
                isLoading = true;
                Toast.makeText(this, "正在加载更多的数据", Toast.LENGTH_SHORT).show();
              //  footerView.setVisibility(View.GONE);//加载完成后隐藏
                isLoading = false;
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("自定义标签", "类名==MainActivity" + "方法名==onItemClick=====:" + position);
    }
}
