package haibao.com.api;

import android.content.Context;

import haibao.com.utilscollection.io.SharedPreferencesUtils;

/**
 * http 请求的初始化类
 */

public class Http {
    /**
     * http 请求模块需要的 context对象
     */
    private static Context mContext;
    /**
     * 用户的 user_id http模块的消息头需要
     */
    private static int user_id;
    /**
     * 用户的 token 标示 http模块的消息头需要
     */
    private static String token;

    /**
     * 当前app的版本号
     */
    private static String APP_VERSION;

    private Http() {
    }

    /**
     * 初始化 http
     *
     * @param context
     * @throws Exception
     */
    public static void initialize(Context context, String appVersion) {
        if (context == null) {
            throw new NullPointerException("Http初始化失败");
        } else {
            mContext = context;
            APP_VERSION = appVersion;
        }
    }

    /**
     * 初始化 用户数据
     *
     * @param userId
     * @param mToken
     */
    public static void initializeUseData(int userId, String mToken) {
        user_id = userId;
        token = mToken;
        // 当 useid 和 token 变化后 一定要清除api的数据
        BaseApi.clearData();
    }

    public static int getUserId() {
        return 886165;
    }

    public static String getToken() {
        if (token == null) {
            token = SharedPreferencesUtils.getStringValue("sp_token");
        }
        return "cu1fjoj5u9dff66hlm48q804ib";
    }

    public static String getAppVersion() {
        return APP_VERSION;
    }

    public static Context getContext() {
        return mContext;
    }
}
