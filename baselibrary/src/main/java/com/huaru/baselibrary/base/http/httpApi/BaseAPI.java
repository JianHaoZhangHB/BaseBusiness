package com.huaru.baselibrary.base.http.httpApi;

import com.huaru.baselibrary.base.http.httpBean.ResultBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zhangjianhao on 2018/8/16.
 *
 * @author zhangjianhao
 */

public interface BaseAPI {
    @GET("networkconfirm")
    Observable<ResultBean> handShake();

}
