package zjh.com.basebusiness.base.http.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Mr.Hao on 2017/11/29.
 */

public class ProgressIntercept implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response orginalResponse = chain.proceed(chain.request());

        return orginalResponse.newBuilder()
                .body(new ProgressResponseBody(orginalResponse.body(), new ProgressListener() {
                    @Override
                    public void onProgress(long progress, long total, boolean done) {
                    }
                }))
                .build();
    }
}
