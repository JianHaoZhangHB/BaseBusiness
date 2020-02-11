package com.huaru.baselibrary.base.baseMvp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.huaru.baselibrary.base.baseMvp.model.BaseModel;
import com.huaru.baselibrary.base.baseMvp.model.BaseModelImpl;
import com.huaru.baselibrary.base.baseMvp.presenter.BasePresenter;
import com.huaru.baselibrary.base.baseMvp.view.BaseView;
import com.huaru.baselibrary.base.baseUtils.ActivityManager;
import com.huaru.baselibrary.base.baseUtils.DialogUtil;
import com.huaru.baselibrary.base.baseUtils.ToastyUitl;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Mr.Hao on 2018/1/25.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity implements BaseView{

    /**
     * @return activity布局ID
     */
    protected abstract int getContentViewId();

    /**
     * 初始化View相关 第二个初始化
     */
    protected abstract void initView();

    /**
     * 初始化Data数据 第一个初始化
     */
    protected abstract void initData();

    /**
     * @return 初始化Presenter
     */
    public abstract P getPresenter();

    public P presenter;
    private BaseModel model = new BaseModelImpl();
    public Unbinder unbinder;
    public Context context;
    public Activity activity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        ActivityManager.addActivity(this);
        context = this;
        activity = this;
        presenter = getPresenter();

        initView();
        initData();
    }

    @Override
    public void showLoading(String loadingName) {
        DialogUtil.showLoading(BaseActivity.this, loadingName);
    }

    @Override
    public void updateLoading(String updateLoadingName) {
        DialogUtil.updateLoadingName(updateLoadingName);
    }

    @Override
    public void dissmissLoading() {
        DialogUtil.dismissDialog(BaseActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onAttach((V) this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDetch();
        }
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }


    @Override
    public void finish() {
        super.finish();
        ActivityManager.removeActivity(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void showError(String errorName) {
        ToastyUitl.errorToasty(context, errorName);
    }

    @Override
    public void showWarning(String warningName) {
        ToastyUitl.warnToasty(context, warningName);
    }

    @Override
    public void showSuccess(String successName) {
        ToastyUitl.successToasty(context, successName);
    }

    /**
     * 消息提示
     *
     * @param infoName
     */
    @Override
    public void showInfo(String infoName) {
        ToastyUitl.infoToasty(this, infoName);
    }

    /**
     * 跳转界面
     * @param tartgetClass 目标界面
     * @param isFinish  是否杀死原来的界面
     */
    public void startActivity(Class<?> tartgetClass, boolean isFinish) {
        Intent intent = new Intent(this, tartgetClass);
        startActivity(intent);
        if (isFinish) {
            finish();
        }
    }
    /**
     * 跳转界面
     * @param tartgetClass 目标界面
     */
    public void startActivity(Class<?> tartgetClass) {
        startActivity(tartgetClass, false);
    }


}
