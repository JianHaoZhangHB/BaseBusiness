package com.huaru.baselibrary.base.http;

import android.util.Log;

import com.huaru.baselibrary.base.baseMvp.view.BaseView;
import com.huaru.baselibrary.base.http.httpBean.ResultBean;

import rx.Subscriber;

/**
 * Created by zhangjianhao on 2018/6/12.
 */

public abstract class AbstractHttpSubscriber<T> extends Subscriber<ResultBean<T>> {
    ResultBean resultBean;
    BaseView view;

    @Override
    public void onCompleted() {
        try {
//            completed(resultBean);
            if (Integer.valueOf(resultBean.getBizCode()) == HttpConfig.RESULT_OK) {
                success(resultBean);
            } else {
                if (view != null) {
                    fail(resultBean.getMeg());
                } else {
                    fail(resultBean);
                }

            }
            dissmiss();
        } catch (Exception e) {
            onError(e);
        }
    }

    @Override
    public void onError(Throwable e) {
        dissmiss();
        Log.e("AbstractHttpSubscriber:", e.getMessage() + "");
        if (view != null) {
            onCanceled(e.getMessage());
        } else {
            onCanceled();
        }
    }

    @Override
    public void onNext(ResultBean<T> tResultBean) {
        try {
            this.resultBean = tResultBean;
        } catch (Exception e) {
            onError(e);
        }
    }

    public void onCanceled(String error) {
        view.showError(error);
    }

    public void fail(String fail) {
        view.showError(fail);
    }


    public abstract void success(ResultBean<T> completeT);

    public abstract void fail(ResultBean<T> completeT);

    public abstract void onCanceled();


    public AbstractHttpSubscriber(BaseView view) {
        this.view = view;
    }

    public AbstractHttpSubscriber() {
    }

    public void dissmiss() {
//        view.dissmissLoading();
    }
}
