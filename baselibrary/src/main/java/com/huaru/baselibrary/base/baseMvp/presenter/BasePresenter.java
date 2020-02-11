package com.huaru.baselibrary.base.baseMvp.presenter;


import com.huaru.baselibrary.base.baseMvp.view.BaseView;

/**
 * Created by Mr.Hao on 2018/1/26.
 */

public abstract class BasePresenter<V extends BaseView> {
    // 获取 view 的view 实例
    public V view;
    public void onAttach(V view){
        this.view = view;
    }

    // 解绑 view 层
    public void onDetch(){
        this.view = null;
    }
    // view 数据的开始，一般再 oncreate 或者 onresume 中
    // void start();
}
