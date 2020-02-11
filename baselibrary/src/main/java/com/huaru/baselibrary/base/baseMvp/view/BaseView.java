package com.huaru.baselibrary.base.baseMvp.view;

/**
 * Created by Mr.Hao on 2018/1/26.
 */

public interface BaseView {
    /**
     * 显示加载动画
     * @param loadingName   加载文字
     */
    void showLoading(String loadingName);

    /**
     * 更新加载Dialog的名字
     * @param updateLoadingName
     */
    void updateLoading(String updateLoadingName);
    /**
     * 取消加载动画
     */
    void dissmissLoading();


    /**
     * 错误提示
     * @param errorName 错误提示内容
     */
    void showError(String errorName);
    /**
     * 警告提示
     * @param warningName 警告提示内容
     */
    void showWarning(String warningName);
    /**
     * 成功提示
     * @param successName   成功提示内容
     */
    void showSuccess(String successName);

    /**
     * 消息提示
     * @param infoName
     */
    void showInfo(String infoName);
}
