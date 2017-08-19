package haibao.com.api.common;

import android.text.TextUtils;

import haibao.com.utilscollection.io.SharedPreferencesUtils;

/**
 * Created by Administrator on 2016/10/20 0020.
 */

public class CommonUrl {

    public static final String URL_USER_PROTOCOL = "http://zl.baobaobooks.com/ayb/protocol";
    public static final String HEADER_X_HB_Client_Type = "X-HB-Client-Type";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_COOKIE = "Cookie";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_HB_API = "HBAPI ";
    // 请求公共部分f
    public static final String FROM_ANDROID = "haibao-android";

    public static final String P_COURSES = "courses";
    public static final String P_PRACTICES = "practices";
    public static final String P_REPORTS = "reports";
    public static final String P_RESOURCES = "resources";
    public static final String P_SECTIONS = "sections";
    public static final String API_BASE_URL_BEAN = "ApiBaseUrlBean";
    public static final String HB_API_BASE_URL_BEAN = "HBApiBaseUrlBean";

    //net是测试环境。com是生成环境
    public static String com_or_net =  "com";
    public static final String URL_ABOUT_US = "http://zl.baobaobooks." + com_or_net + "/ayb/about?v=";
    public static final String URL_BRIDGE = "http://zl.baobaobooks." + com_or_net + "/app/bridge";
    public static final String URL_BRIDGE2 = "https://zl.baobaobooks." + com_or_net + "/app/bridge";
    // 服务器地址
    public static String BASE_URL = getBaseUrl();
    //    public static   String BASE_URL = "https://apidev.baobaobooks." + com_or_net + "/";
//    public static String Domain = ".baobaobooks." + com_or_net;
    public static String Domain = "net".equals(com_or_net) ? ".haibaotown.net" : ".hbtown.com";
    public static String DomainNet1 = ".haibaotown.net";
    public static String DomainNet2 = ".baobaobooks.net";
    public static String DomainCom1 = ".hbtown.com";
    public static String DomainCom2 = ".baobaobooks.com";
    // 这些值由 baseAPIHelper 来初始化
    /**
     * 开发测试域名：https://wwwdev.haibaotown.net
     * 预发布域名：https://www.haibaotown.net
     * 生产域名：https://www.hbtown.com
     * 只有这个Open的接口需要需求
     */
    // 生产 api.baobaobooks.com  api.hbtown.com    测试 api.baobaobooks.net api.haibaotown.net

//    public static String OpenApiService_BaseUrl = "https://api.baobaobooks." + com_or_net + "/" + "open/";//这个不需要网络请求获取url  open模块
//    public static String HBOpenApiService_BaseUrl = "https://api.hbtown." + com_or_net + "/open/";//这个不需要网络请求获取url  Hbopen模块
//    public static String OpenApiService_BaseUrl = "https://api.baobaobooks.net/open/";//这个不需要网络请求获取url  open模块
//    public static String HBOpenApiService_BaseUrl = "https://api.haibaotown.net/open/";//这个不需要网络请求获取url  Hbopen模块

    public static String OpenApiService_BaseUrl = getOpenApiBaseUrl();
    public static String HBOpenApiService_BaseUrl = getHBOpenApiBaseUrl();

    public static String AccountService_BaseUrl;
    public static String SmsService_BaseUrl;
    public static String ActivityApiService_BaseUrl;
    public static String BabyApiService_BaseUrl;
    public static String BookshelfService_BaseUrl = "https://api.haibaotown.net/bookshelf/v1/";
    public static String ChatApiService_BaseUrl;
    public static String ClassApiService_BaseUrl = "https://api.baobaobooks.net/";  // 准备废除
    public static String ClubApiService_BaseUrl = "https://api.baobaobooks.net/";  // 准备废除
    public static String CollectionApi_BaseUrl;
    public static String ContentApiService_BaseUrl = "https://api.haibaotown.net/content/v1/";
    public static String CourseApiService_BaseUrl;
    public static String FollowingApiService_BaseUrl;
    public static String MessageApiService_BaseUrl;
    //    public static String MineService_BaseUrl;// 已经废除
    public static String OfflineApiService_BaseUrl;
    public static String SchoolService_BaseUrl;
    public static String SearchApiService_BaseUrl;
    public static String UserApiService_BaseUrl;

    public static String AccompanyService_BaseUrl;
    public static String ArticleService_BaseUrl = "https://hbapi.baobaobooks.net/article/v1/";

    public static String getBaseUrl() {
        String base_url = SharedPreferencesUtils.getStringValue("base_url");
        if (TextUtils.isEmpty(base_url)) {
            base_url = "https://api.baobaobooks." + com_or_net + "/";
        }
        SharedPreferencesUtils.setString("base_url", base_url);
        return base_url;
    }

    public static String getOpenApiBaseUrl() {
        String base_url = SharedPreferencesUtils.getStringValue("OpenApiBaseUrl");
        if (TextUtils.isEmpty(base_url)) {  //默认是
            base_url = "https://api.baobaobooks." + com_or_net + "/" + "open/";
        }
        SharedPreferencesUtils.setString("OpenApiBaseUrl", base_url);
        return base_url;
    }

    public static String getHBOpenApiBaseUrl() {
        String base_url = SharedPreferencesUtils.getStringValue("HBOpenApiBase");
        if (TextUtils.isEmpty(base_url)) {
            if (com_or_net.equals("com")) {
                base_url = "https://api.hbtown.com/open/";
            } else {
                base_url = "https://api.haibaotown.net/open/";
            }
        }
        SharedPreferencesUtils.setString("HBOpenApiBase", base_url);
        return base_url;
    }

    public interface DEFAULT_PARAM {
        int PER_PAGE = 10;
    }

}
