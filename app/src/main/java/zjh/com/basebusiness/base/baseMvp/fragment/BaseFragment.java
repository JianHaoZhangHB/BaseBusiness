package zjh.com.basebusiness.base.baseMvp.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.OrientationHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;
import zjh.com.basebusiness.base.baseMvp.presenter.BasePresenter;
import zjh.com.basebusiness.base.baseMvp.view.BaseView;
import zjh.com.basebusiness.base.baseUtils.DialogUtil;
import zjh.com.basebusiness.base.baseUtils.ToastyUitl;

/**
 * Created by zhangjianhao on 2018/5/8.
 */

public abstract class BaseFragment<P extends BasePresenter<V>,V extends BaseView> extends ViewpageFragment implements BaseView{
    private View rootView;
    protected P presenter;
    /**
     * 初始化布局
     */
    protected abstract int getLayoutRes();
    protected abstract P getPresenter();
    protected abstract void initData(View view);
    protected abstract void initListener();


    protected Context context;
    protected Activity activity;
    Unbinder binder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), container, false);
        rootView = view;
        // 初始化View注入
        binder = ButterKnife.bind(this, view);
        context = getContext();
        activity = getActivity();
        presenter = getPresenter();
        initListener();
        initData(view);
        return view;
    }

    public View getRootView(){
        return rootView;
    }

    @Override
    public void showLoading(String loadingName) {
        DialogUtil.showLoading(context,loadingName);
    }

    @Override
    public void updateLoading(String updateLoadingName) {
        DialogUtil.updateLoadingName(updateLoadingName);
    }
    @Override
    public void dissmissLoading() {
        DialogUtil.dismissDialog(context);
    }



    @Override
    public void showError(String errorName) {
        ToastyUitl.errorToasty(context,errorName);
    }

    @Override
    public void showWarning(String warningName) {
        ToastyUitl.warnToasty(context,warningName);
    }

    @Override
    public void showSuccess(String successName) {
        ToastyUitl.successToasty(context,successName);
    }

    @Override
    public void showInfo(String infoName) {
        ToastyUitl.infoToasty(context,infoName);
    }

    public void startActivity(Class<?> tartgetClass, boolean isFinish) {
        Intent intent = new Intent(context, tartgetClass);
        startActivity(intent);
        if (isFinish) {
            getActivity().finish();
        }
    }

    public void startActivity(Class<?> tartgetClass) {
        startActivity(tartgetClass, false);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binder!=null) {
            binder.unbind();
        }
    }

}
