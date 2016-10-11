package com.qianfeng.contentproviderdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackiechan on 16/8/20 上午10:38.
 * 版本: 1
 * 公司:北京千锋互联科技有限公司
 * RxJava -->系列的
 */
public class Bei {
    private List<MyObserver> myObservers = new ArrayList<>();
    private String name;
    public void setName(String name) {
        this.name = name;
        //通知所有想要数据的人
        for (MyObserver myObserver : myObservers) {
            myObserver.onChange(name);
        }
    }
    interface MyObserver{
        void onChange(String name);
    }

    public void addToObserver(MyObserver myObserver) {
        myObservers.add(myObserver);
    }

    public void removeObserver(MyObserver myObserver) {
        myObservers.remove(myObserver);
    }
}
