package com.asdf.myapplication3.base;

import haibao.com.api.BaseCommonCallBack;
import haibao.com.api.exception.HttpExceptionBean;
import haibao.com.utilscollection.UtilsCollection;
import haibao.com.utilscollection.manager.ToastUtils;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by anzhuo002 on 2016/10/20.
 */

public abstract class SimpleCommonCallBack<T> extends BaseCommonCallBack<T> {

    public SimpleCommonCallBack(CompositeSubscription mCompositeSubscription) {
        super(mCompositeSubscription);
    }

    @Override
    public void onCallJsonException(Throwable e) {
        ToastUtils.showShort("解析json错误");
    }

    @Override
    public void onCallHttpException(HttpExceptionBean mHttpExceptionBean) {
        //{"code":"InvalidToken","message":"\u672a\u767b\u5f55\u6216\u6388\u6743\u8fc7\u671f\uff0c\u8bf7\u767b\u5f55","body":""}
        if (mHttpExceptionBean == null) return;
        if (mHttpExceptionBean.getCode().equals("InvalidToken")) {
//            EventBus.getDefault().post(new GoLoginEvent());//重新登录
            if (UtilsCollection.mGoLoginListener != null) {
                UtilsCollection.mGoLoginListener.goLogin();
            }
            return;
        } else if (mHttpExceptionBean.getCode().equals("UpgradeRequired")) {    //全局捕获
            ToastUtils.showShort("您未购买课程，请升级到最新版本完成购买");
        }
        ToastUtils.showShort(mHttpExceptionBean.getMessage());
    }

    @Override
    protected void onCallTimeOutException(Throwable e) {
        ToastUtils.showShort("网络连接超时，请稍后再试");
    }


}
