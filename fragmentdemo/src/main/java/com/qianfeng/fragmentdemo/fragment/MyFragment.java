package com.qianfeng.fragmentdemo.fragment;

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
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qianfeng.fragmentdemo.R;

/**
 * Created by jackiechan on 16/8/12.
 */
public class MyFragment extends Fragment {
    private TextView textView;
    private String name;
    /**
     * 依赖到 activity
     * @param activity
     */
    @Override
    public void onAttach(Activity activity) {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onAttach=====:" + "");
        super.onAttach(activity);
    }

    /**
     * 依赖到 activity,这个方法用于替换上面那个方法
     * @param context  activity 对象
     */
    @Override
    public void onAttach(Context context) {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onAttach=====:" + "");
        super.onAttach(context);
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onCreate=====:" + "");
        Bundle arguments = getArguments();
        if (arguments != null) {
            name = arguments.getString("name", "默认值");
        }
        super.onCreate(savedInstanceState);
    }

    private View view;

    /**
     * 创建视图,正常来说只写这一个方法就行,将 fragment 需要的视图创建好然后返回,将控件的事件也在这里设置好
     *
     * @param inflater           布局填充器
     * @param container          容器
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            return view;
        }
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onCreateView=====:" + "");
//        View view= inflater.inflate(R.layout.fragment_my, null);
        View view = inflater.inflate(R.layout.fragment_my, container, false);//不添加到父容器,然后用父容器的宽高等参数
        //操作视图了
        textView = (TextView) view.findViewById(R.id.tv);
//        textView.setText(getClass().getSimpleName());
        textView.setText(name);
        return view;
    }

    /**
     * 当 activity 创建后
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onActivityCreated=====:" + "");
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 启动了
     */
    @Override
    public void onStart() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onStart=====:" + "");
        super.onStart();
    }

    /**
     * 可见了
     */
    @Override
    public void onResume() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onResume=====:" + "");
        super.onResume();
    }

    /**
     * 暂停了
     */
    @Override
    public void onPause() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onPause=====:" + "");
        super.onPause();
    }

    /**
     * 停止不可见了
     */
    @Override
    public void onStop() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onStop=====:" + "");
        view = getView();
        super.onStop();
    }

    /**
     * 销毁视图
     */
    @Override
    public void onDestroyView() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onDestroyView=====:" + "");
        super.onDestroyView();
    }

    /**
     * 销毁
     */
    @Override
    public void onDestroy() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onDestroy=====:" + "");
        super.onDestroy();
    }

    /**
     * 与 activity 解绑
     */
    @Override
    public void onDetach() {
        Log.e("自定义标签", "类名==MyFragment" + "方法名==onDetach=====:" + "");
        super.onDetach();
    }








}

