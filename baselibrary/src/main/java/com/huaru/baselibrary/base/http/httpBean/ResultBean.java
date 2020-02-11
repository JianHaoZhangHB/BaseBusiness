package com.huaru.baselibrary.base.http.httpBean;

/**
 * Created by zhangjianhao on 2018/5/2.
 */

public class ResultBean<T> {
    String bizCode;
    String meg;
    T data;

    public ResultBean(String bizCode, String meg, T data) {
        this.bizCode = bizCode;
        this.meg = meg;
        this.data = data;
    }

    public String getBizCode() {
        return bizCode == null ? "" : bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getMeg() {
        return meg == null ? "" : meg;
    }

    public void setMeg(String meg) {
        this.meg = meg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
