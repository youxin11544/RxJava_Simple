package haibao.com.api;


import android.net.ParseException;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.socks.library.KLog;

import org.json.JSONException;

import java.net.SocketTimeoutException;

import haibao.com.api.exception.HttpExceptionBean;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;


/**
 * CommonCallBack 的一个简单实现，onNext（） 方法一定要重写，onCompleted()和onError 更具需要重写
 */

public abstract class BaseCommonCallBack<T> extends Subscriber<T> implements CommonCallBack<T> {
    private final String TAG = "BaseCommonCallBack";

    private CompositeSubscription mCompositeSubscription;

    public BaseCommonCallBack(CompositeSubscription mCompositeSubscription) {
        this.mCompositeSubscription = mCompositeSubscription;
    }

    /**
     * 请求完成
     */
    @Override
    public void onCompleted() {
        onCallCompleted();
    }

    /**
     * 这里是空实现，当子类有需要的时候去实现
     */
    @Override
    public void onCallCompleted() {}
    /**
     * 请求错误 在这里要处理http返回的错误状态码404等等，以及解析json错误
     *
     * @param e 错误Throwable
     */
    @Override
    public void onError(Throwable e) {
        //解析异常
        if (e instanceof JsonSyntaxException
                || e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
//            Log.e(TAG, "解析错误");
            KLog.e(e);
            onCallJsonException(e);
            onCallError((Exception) e);
        } else if (e instanceof HttpException) {
            ResponseBody body = ((HttpException) e).response().errorBody();
            try {
                String json = body.string();
                Gson gson = new Gson();
                HttpExceptionBean mHttpExceptionBean = gson.fromJson(json, HttpExceptionBean.class);
                if (mHttpExceptionBean != null && mHttpExceptionBean.getMessage() != null) {
                    Log.e(TAG, mHttpExceptionBean.getMessage());
                    onCallHttpException(mHttpExceptionBean);
                    onCallError(mHttpExceptionBean);
                } else {
                    onCallError(mHttpExceptionBean);
                }
            } catch (Exception el) {
                KLog.e(e);
                onCallError(null);
                el.printStackTrace();
            }
        } else if (e instanceof SocketTimeoutException) {
            KLog.e(e);
            onCallTimeOutException(e);
            onCallError((Exception) e);
        } else {
            KLog.e(e);
            onCallError((Exception) e);
        }
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        if (!mCompositeSubscription.isUnsubscribed()) {
            onCallNext(t);
        }
    }

    /**
     * 解析错误时候的回调方法
     * @param e 错误的异常
     */
    public abstract void onCallJsonException(Throwable e);

    /**
     * Http异常时的回调
     * @param mHttpExceptionBean httpException
     */
    public abstract void onCallHttpException(HttpExceptionBean mHttpExceptionBean);

    /**
     * 超时处理
     * @param e
     */
    protected abstract void onCallTimeOutException(Throwable e);
}
