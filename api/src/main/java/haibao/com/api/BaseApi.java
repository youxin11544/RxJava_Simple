package haibao.com.api;


import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static haibao.com.api.common.CommonUrl.BASE_URL;

/**
 * API基础类 这个类维护着所有的请求service
 */
public class BaseApi {
    protected static Retrofit retrofit;
    public static List<ClearWrapper> clearServiceList;

    //初始化的时候，都会添加到这个集合
    public static void addToBaseApi(ClearWrapper clearService) {
        if (clearServiceList == null) {
            clearServiceList = new ArrayList<>();
        }
        clearServiceList.add(clearService);
    }

    /**
     * 清空所有请求service 当登录成功拿到 useid 和 token 是这些参数需清空重新
     */
    public static void clearData() {
        retrofit = null;
        if (clearServiceList != null) {
            for (ClearWrapper clearWrapper : clearServiceList) {
                clearWrapper.clearService();
            }
        }
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient client = new HttpClientHelper.Builder().build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofit(String baseUrl) {
        OkHttpClient client = new HttpClientHelper.Builder().build();
        Retrofit  mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return mRetrofit;
    }

    public static Retrofit getRetrofit(OkHttpClient client) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


    /**
     * 对 Observable<T> 做统一的处理，处理了线程调度、分割返回结果等操作组合了起来
     */
    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public interface ClearWrapper {
        void clearService();
    }

}
