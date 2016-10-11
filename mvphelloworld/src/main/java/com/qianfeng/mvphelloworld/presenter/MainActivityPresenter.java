package com.qianfeng.mvphelloworld.presenter;

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

import com.qianfeng.mvphelloworld.model.MainActivityModel;
import com.qianfeng.mvphelloworld.model.MvpModel;
import com.qianfeng.mvphelloworld.view.MvpView;

import java.util.List;

/**
 * Created by jackiechan on 16/8/10.
 */
public class MainActivityPresenter {
    private MvpModel mvpModel;
    private MvpView mvpView;

    public MainActivityPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        mvpModel = new MainActivityModel();
    }

    public void load() {
        mvpModel.getData(new MvpModel.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(List<String> list) {
                //我拿到数据了,稍微处理了下,需要把数据 给view 展示
                mvpView.showView(list);
            }
        });
    }

}
