package zjh.com.basebusiness.base.http.httpApi;

import retrofit2.http.GET;
import rx.Observable;
import zjh.com.basebusiness.base.http.httpBean.ResultBean;

/**
 * Created by zhangjianhao on 2018/8/16.
 *
 * @author zhangjianhao
 */

public interface BaseAPI {
    @GET("networkconfirm")
    Observable<ResultBean> handShake();

}
