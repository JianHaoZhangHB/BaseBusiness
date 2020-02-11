package com.huaru.baselibrary.base.http.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Mr.Hao on 2017/11/1.
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
        //处理业务逻辑，可以对header统一处理，涉及到header加密的也在此处理
        //......

//        request = builder.build();
//        return chain.proceed(request);
//    }
}
