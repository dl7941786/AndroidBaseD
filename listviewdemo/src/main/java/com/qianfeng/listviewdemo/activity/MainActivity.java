package com.qianfeng.listviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.qianfeng.listviewdemo.R;
import com.qianfeng.listviewdemo.adapter.MyAdapter2;
import com.qianfeng.listviewdemo.asynctask.MyAsyncTask;
import com.qianfeng.listviewdemo.bean.NewsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<NewsBean> newsBeanList;
    private List<String> list;
    private String path = "http://m.mydrivers.com/app/newslist.aspx?%20tid=0&minId=0&maxId=0&ver=2.2&temp=1464423764091";
    private MyAdapter2 myAdapter2;

    //    private List<HashMap<String, String>> mapList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        listView = (ListView) findViewById(R.id.listview);
        //搞定数据源
//        list = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            list.add("这是第" + i + "个单身狗");
//        }
        //适配器
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
//        listView.setAdapter(arrayAdapter);

        //数据源
//        mapList = new ArrayList<>();
//        for (int i = 0; i < 49; i++) {
//            HashMap<String, String> hashMap = new HashMap<>();
//            hashMap.put("name", "单身狗" + i);
//            hashMap.put("age", (20 + i)+"");
//            mapList.add(hashMap);
//        }
        //1.上下文,2.数据源.3布局资源.4,数据源的哪一部分数据,5显示到布局中哪些控件上面
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mapList, R.layout.item_simple, new String[]{"name", "age"}, new int[]{R.id.name, R.id.age});
//        listView.setAdapter(simpleAdapter);
        newsBeanList = new ArrayList<>();
        new MyAsyncTask(new MyAsyncTask.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(byte[] bytes) {
                if (bytes != null) {
                    try {
                        //得到数据源了
                        JSONArray jsonArray = new JSONArray(new String(bytes));//创建Json对象
                        for (int i = 0;i<jsonArray.length();i++) {
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
                        myAdapter2 = new MyAdapter2(newsBeanList);
                        listView.setAdapter(myAdapter2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"什么破手机,怪不得单身狗",Toast.LENGTH_SHORT).show();
                }


            }
        }).execute(path);
    }
}
