package haibao.com.utilscollection.inter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Map;

/**
 * 集成的第三方检查的接口。需要在Application中类集成完成实现这个类.具体的实现类，在init方法中注入。
 * Created by Administrator on 2017/3/3 0003.
 */
public interface Reporter {
    void report();

    void reportError(Context context, Throwable throwable);

    void reportError(Context context, String eMsg);

    /**
     * 在onResume的时候上报页面信息
     *
     * @param pagerName
     */
    void onPageStart(String pagerName);

    /**
     * 在onPause的时候 上报
     *
     * @param pagerName
     */
    void onPageEnd(String pagerName);

    /**
     * 生命周期方法的监控
     *
     * @param activity
     */
    void onResume(Activity activity);

    /**
     * 生命周期方法的监控
     *
     * @param activity
     */
    void onPause(Activity activity);

    void onKillProcess(Application core);

    void onProfileSignIn(String loginTypeQq, String s);//注册友盟统计

    void onEvent(Activity setPwdActivity, String eventUserRegister, Map<String, String> map);

    void umengAccount(int fromWhere, String statisticsValueInputPassword, String s, String currentSNSType);

    void registerSuccess();

    void bindAccount(String statisticsValueRegisterSuccess, String s, String currentSNSType);

    void umengWriteDiary(String mFromWhere, String result, String message);

}
