package com.asdf.myapplication3.base;


import haibao.com.utilscollection.info.NetWorkUtils;
import haibao.com.utilscollection.manager.ToastUtils;
import rx.subscriptions.CompositeSubscription;

/**
 * Presenter基础类
 */
public class BaseCommonPresenter<T extends BaseView> {
    public T view;
    /**
     * 使用CompositeSubscription来持有所有的Subscriptions
     */
    protected CompositeSubscription mCompositeSubscription;

    public BaseCommonPresenter(T view) {
        //创建 CompositeSubscription 对象 使用CompositeSubscription来持有所有的Subscriptions，然后在onDestroy()或者onDestroyView()里取消所有的订阅。
        mCompositeSubscription = new CompositeSubscription();
        this.view = view;
    }

    public BaseCommonPresenter() {

    }

    /**
     * 解绑 CompositeSubscription
     */
    public void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public CompositeSubscription getCompositeSubscription() {
        return mCompositeSubscription;
    }

    public boolean checkHttp() {
        if (!NetWorkUtils.isNetworkActive()) {
            ToastUtils.showShort("没网");
            return false;
        }
        return true;
    }


//    public boolean checkHttpShow() {
//        Application context = UtilsCollection.core;
//        if (!NetWorkUtils.isNetworkActive()) {
//            DialogManager.getInstance().createAlertTitleCancelDialog(context,
//                    context.getString(R.string.check_http_failure_title),
//                    context.getString(R.string.check_http_failure_content),
//                    context.getString(R.string.check_http_failure_btn)).show();
//            return false;
//        }
//        return true;
//    }

}
