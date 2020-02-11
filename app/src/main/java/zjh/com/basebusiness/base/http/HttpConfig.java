package zjh.com.basebusiness.base.http;

import android.os.Environment;

/**
 * Created by Mr.Hao on 2017/11/1.
 */

public class HttpConfig {
    /*BaseUrl*/
    public static boolean DEBUG = false;
    private final static String RELEASE_URL = "http://26.29.179.81:8091/xbdzs/rest/studentInfo/";
    private final static String DEBUG_URL = "http://26.29.179.81:8091/xbdzs/rest/studentInfo/";
    public final static String BASE_URL= DEBUG?DEBUG_URL:RELEASE_URL;
    /*BaseUrl*/
    /*请求结果判断*/
    public final static int RESULT_OK = 200;
    /*请求结果判断*/
    /*缓存设置*/
    public static final int DEFAULT_CACHE_SIZE = 150 * 1024 * 1024;
    public static final String CACHE_PATH = Environment.getExternalStorageDirectory() + "/EBookReader/okcaches";
    /*有网情况下的本地缓存时间默认60秒*/
    public static final int DEFAULT_COOKIE_NETWORK_TIME = 0;
    /*无网络的情况下本地缓存时间默认30天*/
    public static final int DEFAULT_COOKIE_NO_NETWORK_TIME = 24 * 60 * 60 * 30;
    /*缓存设置*/
    /*Http请求设置*/
    public static final int DEFAULT_CONNECT_TIMEOUT = 3000;
    public static final int DEFAULT_READ_TIMEOUT = 3000;
    public static final int DEFAULT_WRITE_TIMEOUT = 3000;
    /*Http请求设置*/
}
