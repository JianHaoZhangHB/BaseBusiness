package com.huaru.baselibrary.base.http.retrofit;

import android.content.Context;
import android.util.Log;

import com.huaru.baselibrary.base.http.HttpConfig;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mr.Hao on 2017/11/1.
 */

public class Http {
    //服务器地址
    private static Retrofit retrofit;

    public static Retrofit getInstance(Context context) {
        if (retrofit != null) {
            return retrofit;
        } else {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    try {
                        String text = URLDecoder.decode(message, "utf-8");
                        Log.e("Http--inter", text);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                }
            });
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            Cache cache = new Cache(new File(HttpConfig.CACHE_PATH), HttpConfig.DEFAULT_CACHE_SIZE);//15M缓存

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient client = builder
                    .retryOnConnectionFailure(true)
                    .connectTimeout(HttpConfig.DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(HttpConfig.DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(HttpConfig.DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .cache(cache)
                    .addNetworkInterceptor(new ProgressIntercept())
                    .addInterceptor(new CacheInterceptor(context))
                    .addInterceptor(logInterceptor)
                    .build();
//
//             .addInterceptor(new HeaderInterceptor())
            String baseUrl = HttpConfig.BASE_URL;
            retrofit = new Retrofit.Builder()
                    //增加返回值为Gson的支持(以实体类返回)
                    .addConverterFactory(GsonConverterFactory.create())
                    //增加返回值为Oservable<T>的支持
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
//                    .baseUrl(HttpConfig.BASE_URL)
                    .baseUrl(baseUrl)
                    .build();
            return retrofit;
        }

    }

    public static <T> T create(Context context, Class<T> t) {
        return getInstance(context)
                .create(t);

    }

}
