package com.asdf.myapplication3.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;

import haibao.com.utilscollection.info.NetWorkUtils;
import haibao.com.utilscollection.manager.ActivityPageManager;
import haibao.com.utilscollection.manager.ToastUtils;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;


/**
 * Activity基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends FragmentActivity implements View.OnClickListener {

    protected final String TAG = this.getClass().getSimpleName();

    protected BaseActivity mContext;
    /**
     * 加载对话框
     */
    protected DialogLoading loading;

    protected T presenter;

    /**
     * //     * 是否进行友盟统计 默认是false
     * 是否进行第三方统计页面 默认是false
     */
//    protected boolean is_mobClickAgent = false;
    protected boolean is_report = false;
    /**
     * 页面名字
     */
    protected String pagerName = "";
    /**
     * ButterKnife的解绑对象
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //页面activity 对象
        mContext = this;
        setContentView(onSetLayoutId());
        //绑定 ButterKnife

        //绑定 present
        bindPresenter(onSetPresent());
        //初始化view
        initView();
        //初始化数据
        initData();
        //页面activity 对象
        mContext = this;
        //Activity管理
        ActivityPageManager.getInstance().addActivity(this);
    }



    /**
     * 设置友盟统计页面  在onResume（）调用之前设置才有效果
     *
     * @param pagerName 页面统计完整路径
     */
    private void setReportPageName(String pagerName) {
        if (!TextUtils.isEmpty(pagerName)) {
            is_report = true;
            this.pagerName = pagerName;
        }
    }


    public abstract int onSetLayoutId();


    /**
     * 绑定相应的 presenter.fixme 这里再考虑下用什么方式
     */
    public abstract T onSetPresent();

    public void initView() {
    }

    ;

    public abstract void initData();



    /**
     * 绑定相应的 presenter.fixme 这里再考虑下用什么方式
     */
    public void bindPresenter(T presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }


    public T getPresenter() {
        return presenter;
    }

    /**
     * 将 Fragment添加到Activity
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragment(@NonNull Fragment fragment, int frameId) {
        if (fragment.isAdded()) {
            return;
        }
        checkNotNull(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(frameId, fragment);
        if (isFinishing()) {
            return;
        }
        transaction.commit();
    }

    /**
     * 将 Fragment添加到Activity
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragmentAllowingStateLoss(@NonNull Fragment fragment, int frameId) {
        if (fragment.isAdded()) {
            return;
        }
        checkNotNull(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(frameId, fragment);
        if (isFinishing()) {
            return;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 显示一个Toast信息
     */
    public void showToast(String content) {
        if (content != null) {
            ToastUtils.showShort(content);
        }
    }

    public void showLoadingDialog() {
        if (mContext == null) {
            return;
        }
        if (isFinishing()) {
            return;
        }

        if (loading == null) {
            loading = new DialogLoading(mContext);
        }
        loading.setDialogLabel("....");
        if (!loading.isShowing()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (isFinishing()) {
                        return;
                    }
                    if (loading != null) {
                        loading.show();
                    }
                }
            });
        }
    }

    public void showLoadingDialog(String label) {
        if (isFinishing()) {
            return;
        }
        if (loading == null) {
            loading = new DialogLoading(this);
        }
        if (TextUtils.isEmpty(label)) {
            loading.setDialogLabel("....");
        } else {
            loading.setDialogLabel(label);
        }
        if (!loading.isShowing()) {
            loading.show();
        }
    }

    public void hideLoadingDialog() {
        if (isFinishing()) {
            return;
        }
        try {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (isFinishing()) {
                        return;
                    }
                    if (loading != null) {
                        if (loading.isShowing()) {
                            loading.dismiss();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        //Activity 释放子view资源
        ActivityPageManager.getInstance().removeActivity(this);
        //一旦调用了 CompositeSubscription.unSubscribe()，这个CompositeSubscription对象就不可用了,
        // 如果还想使用CompositeSubscription，就必须在创建一个新的对象了。
        //解绑 presenter
        if (presenter != null) {
            presenter.unSubscribe();
        }
        //ButterKnife
        super.onDestroy();

    }


    /**
     * 设置视图的隐藏和显示
     */
    protected void setViewVisible(int viewVisible, View... views) {
        for (View view : views) {
            view.setVisibility(viewVisible);
        }
    }

    @Override
    public void onClick(View view) {

    }

    public boolean checkHttp() {
        if (!NetWorkUtils.isNetworkActive()) {
            ToastUtils.showShort("失败");
            return false;
        }
        return true;
    }

    /**
     * 跳转页面
     *
     * @param clazz
     */
    @Deprecated
    public void turnToAct(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Deprecated
    public void turnToAct(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Deprecated
    protected void turnToAct(String action, Uri data) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.setData(data);
        startActivity(intent);
    }

    @Deprecated
    protected void turnToAct(Class clazz, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.setFlags(flags);
        startActivity(intent);
    }

    @Deprecated
    protected void turnToAct(Class clazz, Bundle bundle, int flags) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        intent.setFlags(flags);
        startActivity(intent);
    }

    @Deprecated
    protected void turnToActForResult(Class clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    @Deprecated
    public void turnToActForResult(Class clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    @Deprecated
    public void turnToActWithPopAnimation(Class clazz, @Nullable Bundle bundle, int enterAnimResId, int outAnimResId) {
        Intent intent = new Intent(this, clazz);
        if(null!=bundle){
            intent.putExtras(bundle);
        }
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, enterAnimResId, outAnimResId);
        ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    }





}
