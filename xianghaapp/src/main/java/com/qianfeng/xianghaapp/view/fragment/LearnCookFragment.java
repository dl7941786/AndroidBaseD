package com.qianfeng.xianghaapp.view.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.xianghaapp.R;
import com.qianfeng.xianghaapp.adapter.LeanCookViewPagerAdapter;
import com.qianfeng.xianghaapp.adapter.LearnCookAdapter;
import com.qianfeng.xianghaapp.bean.BaseData;
import com.qianfeng.xianghaapp.bean.Main_JingCai;
import com.qianfeng.xianghaapp.callback.MyBitMapCallBack;
import com.qianfeng.xianghaapp.presenter.LearCookPresenter;
import com.qianfeng.xianghaapp.utils.GlobalInterface;
import com.qianfeng.xianghaapp.utils.MyAsyncTask;
import com.qianfeng.xianghaapp.view.IViewFirst;
import com.qianfeng.xianghaapp.view.IViewSecond;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LearnCookFragment extends Fragment implements IViewFirst<BaseData>, IViewSecond<Main_JingCai>, View.OnClickListener, ViewPager.OnPageChangeListener {
    private ListView mListView;
    private LearnCookAdapter learnCookAdapter;
    private GridView gridView;
    private boolean ischange;
    private AlertDialog alertDialog;
    //    private List<ImageView> imageViewList;
    private List<View> imageViewList;
    //用于存储简单数据的类对象,第一个参数就是文件的名字,可以一直往一个文件里面增加内容
    private SharedPreferences name;
    private ViewPager viewPager;
    private LinearLayout indicatorarean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//设置 fragment有选项菜单
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        name = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_learn_cook, container, false);
        mListView = ((ListView) view.findViewById(R.id.listview));
        gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setVisibility(View.GONE);
        View header = inflater.inflate(R.layout.learncook_header, null);
        indicatorarean = (LinearLayout) header.findViewById(R.id.indicatorarean);//指示器区域
        viewPager = (ViewPager) header.findViewById(R.id.viewpager);//首页的轮播图
        mListView.addHeaderView(header);
        learnCookAdapter = new LearnCookAdapter(null);
        mListView.setAdapter(learnCookAdapter);
        gridView.setAdapter(learnCookAdapter);
        new LearCookPresenter(this).setTag(0).load(GlobalInterface.SHOUYE_QITASHUJU);
        new LearCookPresenter(this).setTag(1).load(GlobalInterface.SHOUYE_JINGCAISHENGHUO);
//        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.e("自定义标签", "类名==LearnCookFragment" + "方法名==onItemLongClick=====:" + "被长按了");
//
//                return false;
//            }
//        });
        registerForContextMenu(mListView);//给 listview 添加菜单
        return view;
    }

    @Override
    public void showView(BaseData baseData) {
//        Log.e("自定义标签", "类名==LearnCookFragment" + "方法名==showView=====:" + "");
        //显示轮播图的数据
        List<BaseData.DataBean.RecommendBean> recommend = baseData.getData().getRecommend();//轮播图的数据
        //创建图片集合,设置适配器
        imageViewList = new ArrayList<>();//创建图片集合
        for (int i = 0; i < recommend.size(); i++) {
            BaseData.DataBean.RecommendBean recommendBean = recommend.get(i);//轮播的封装对象
            String img = recommendBean.getImg();//图片地址
//            ImageView imageView = new ImageView(getActivity());
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView.setTag(img);//为了能成功加载图片,设置一个 tag
//            new MyAsyncTask(new MyBitMapCallBack(imageView)).execute(img);//异步上网请求图片
//            //把图片控件放到集合
//            imageViewList.add(imageView);
            View viewpagrView = createViewPagerView(img);
            new MyAsyncTask(new MyBitMapCallBack((ImageView) viewpagrView.findViewById(R.id.ele))).execute(img);//异步上网请求图片
            //设置文字
            TextView textView = (TextView) viewpagrView.findViewById(R.id.time);
            String date = recommendBean.getDate();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < date.length(); j++) {
                char c = date.charAt(j);
                stringBuilder.append(c);
                if (j != date.length() - 1) {
                    stringBuilder.append("\n");//如果不是最后一个字符就添加换行符
                }
            }
            textView.setText(stringBuilder);
            imageViewList.add(viewpagrView);
            //设置早午晚餐的图片
            ImageView zaowuwan = (ImageView) viewpagrView.findViewById(R.id.zaowuwan);
            //设置图片
            int type = recommendBean.getType();//图片的类型 是早餐还是午餐还是晚餐
            switch (type) {
                case 1:
                    zaowuwan.setImageResource(R.mipmap.i_ico_homepage_sancan_zao);
                    break;
                case 2:
                    zaowuwan.setImageResource(R.mipmap.i_ico_homepage_sancan_zhong);
                    break;
                case 3:
                    zaowuwan.setImageResource(R.mipmap.i_ico_homepage_sancan_wan);
                    break;
            }
            //创建指示器

            View viwe = new View(getActivity());//创建指示器圆点
            viwe.setBackgroundResource(R.drawable.enable);
            if (i != 0) {
                viwe.setEnabled(false);//默认只有第一个为红色,其他为黑色
            }
            LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(20, 20);
            layoutParam.rightMargin = 10;//设置右边距为10

            indicatorarean.addView(viwe, layoutParam);
        }
//        //如果数据源少于等三张,需要加倍数据源
//        if (imageViewList.size() <= 3) {
//            for (int i = 0; i < recommend.size(); i++) {
//                String img = recommend.get(i).getImg();
//                View viewpagrView = createViewPagerView(img);
//                new MyAsyncTask(new MyBitMapCallBack((ImageView) viewpagrView.findViewById(R.id.ele))).execute(img);//异步上网请求图片
//                imageViewList.add(viewpagrView);
//            }
//        }
        LeanCookViewPagerAdapter leanCookViewPagerAdapter = new LeanCookViewPagerAdapter(imageViewList);
        viewPager.setAdapter(leanCookViewPagerAdapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % imageViewList.size());
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void showViewSecond(Main_JingCai main_jingCai) {
        List<Main_JingCai.DataBean> data = main_jingCai.getData();
//        learnCookAdapter = new LearnCookAdapter(data);
//        mListView.setAdapter(learnCookAdapter);
        //更新数据
        if (learnCookAdapter.getDataBeanList() == null) {
            learnCookAdapter.setDataBeanList(data);
        } else {
            learnCookAdapter.getDataBeanList().addAll(data);
        }
        learnCookAdapter.notifyDataSetChanged();
    }

    public void change() {
        if (!ischange) {
            mListView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
//            gridView.setAdapter(learnCookAdapter);
        } else {
            gridView.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
        }
        ischange = !ischange;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.optionmenu, menu);
        inflater.inflate(R.menu.zhengchangdemenu, menu);
        //根据保存的状态,更新某些菜单选项的值
        MenuItem item = menu.findItem(R.id.nopic);
        //更新 item的选择状态,更新为存储的状态
        boolean isnopic = name.getBoolean("isnopic", false);//获取指定的存储值,如果没有,默认为 false
        item.setChecked(isnopic);//更新状态
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.change:
                change();
                break;
            case R.id.nopic:
                item.setChecked(!item.isChecked());//更改选择状态,将新的选择状态保存起来,下次启动程序的时候加载

                name.edit().putBoolean("isnopic", item.isChecked()).apply();//apply是异步的,commit是同步的,如果操作的数据比较多比较大,会阻塞线程
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete:
                //获取 menu的信息, 强转为 adapterview的,注意,这个地方只有 给adapterview注册的 contextmenu 才可以这么做
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                final int position = adapterContextMenuInfo.position;// 拿到一个点击 的位置
                if (learnCookAdapter != null && position >= 1) {
//                    createDialog(position);
                    cerateMyDialog(position);
                }
//                Toast.makeText(getActivity(), "删除第"+position, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * 自定义的对话框, 没有设置 icon 没有设置 title  没有设置 message,只需要设置一个 叫 setview
     *
     * @param position
     */
    private void cerateMyDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_my, null);//加载自定义布局
        Button bt1 = (Button) view.findViewById(R.id.bt1);
        Button bt2 = (Button) view.findViewById(R.id.bt2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        builder.setView(view);//将自己定义的布局作为对话框的视图 设置进去
        alertDialog = builder.create();
        alertDialog.show();
    }


    /**
     * 弹出对话框确认删除
     *
     * @param position
     */
    private void createDialog(final int position) {
        //在这里应该让用户确认是否删除,对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("车神,你制杖吗?");
        builder.setMessage("车神,你要是不制杖,怎么会点删除");
        builder.setIcon(R.mipmap.ic_launcher);
//                    builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {//设置单个按钮
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            learnCookAdapter.getDataBeanList().remove(position - 1);//删除数据
//                            learnCookAdapter.notifyDataSetChanged();//移除内容
//                        }
//                    });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                learnCookAdapter.getDataBeanList().remove(position - 1);//删除数据
                learnCookAdapter.notifyDataSetChanged();//移除内容
            }
        });
        builder.create().show();//可以用builder.show();
    }

    @Override
    public void onClick(View v) {
        if (alertDialog != null) {
            alertDialog.dismiss();//关闭对话框
        }
        switch (v.getId()) {
            case R.id.bt1:
                Toast.makeText(getContext(), "点我了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt2:
                Toast.makeText(getContext(), "点车神了", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public View createViewPagerView(String img) {
        View viewpagrView = LayoutInflater.from(getActivity()).inflate(R.layout.header_viewpager_item, null);
        //设置内容
        ImageView imageView = (ImageView) viewpagrView.findViewById(R.id.ele);
        imageView.setTag(img);//为了能成功加载图片,设置一个 tag
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return viewpagrView;
    }
    private int lastPosition;//最后一次被选中的小白点
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            //更新小白点
        indicatorarean.getChildAt(position % indicatorarean.getChildCount()).setEnabled(true);//因为白点数量是3个,而图片数量是6个
        indicatorarean.getChildAt(lastPosition % indicatorarean.getChildCount()).setEnabled(false);
        lastPosition = position;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
