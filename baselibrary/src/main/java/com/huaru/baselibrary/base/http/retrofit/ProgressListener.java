package com.huaru.baselibrary.base.http.retrofit;

/**
 * Created by Mr.Hao on 2017/11/29.
 */

public interface ProgressListener {
    /**
     * @param progress  已经下载或上传字节数
     * @param total  总字节数
     * @param done   是否完成
     */
    void onProgress(long progress, long total, boolean done);
}
