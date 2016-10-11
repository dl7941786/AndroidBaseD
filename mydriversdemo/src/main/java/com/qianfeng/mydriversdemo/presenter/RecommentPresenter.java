package com.qianfeng.mydriversdemo.presenter;

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

import android.util.Log;

import com.google.gson.Gson;
import com.qianfeng.mydriversdemo.bean.RecommentBean;
import com.qianfeng.mydriversdemo.model.RecommentModel;
import com.qianfeng.mydriversdemo.view.RecommmentView;

/**
 * Created by jackiechan on 16/8/25.
 */
public class RecommentPresenter extends BasePresenter<RecommmentView,RecommentModel> {

    @Override
    public RecommentModel createModel() {
        return new RecommentModel();
    }

    public void getData(String path) {
        //让 model 请求数据
        model.getData(path, new RecommentModel.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(byte[] bytes, String path) {
                String json = new String(bytes);
                if (bytes != null) {
                    try {
                        //代表有数据
                        RecommentBean recommentBean = new Gson().fromJson(json, RecommentBean.class);
                        getView().showView(recommentBean);
                    }catch (Exception e){
                        Log.e("自定义标签", "类名==RecommentPresenter" + "方法名==onLoadComplete=====:" +json);
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
