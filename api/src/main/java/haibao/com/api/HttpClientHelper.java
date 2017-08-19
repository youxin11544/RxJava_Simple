package haibao.com.api;

import android.text.TextUtils;
import android.util.Base64;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import haibao.com.utilscollection.info.DeviceUtils;
import haibao.com.utilscollection.info.NetWorkUtils;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;

import static haibao.com.api.common.CommonUrl.FROM_ANDROID;
import static haibao.com.api.common.CommonUrl.HEADER_AUTHORIZATION;
import static haibao.com.api.common.CommonUrl.HEADER_COOKIE;
import static haibao.com.api.common.CommonUrl.HEADER_HB_API;
import static haibao.com.api.common.CommonUrl.HEADER_USER_AGENT;
import static haibao.com.api.common.CommonUrl.HEADER_X_HB_Client_Type;
import static haibao.com.api.common.HttpCommon.KEY_HBSID;
import static haibao.com.api.common.HttpCommon.KEY_HBUID;
import static haibao.com.api.common.HttpCommon.KEY_SUPPORT_WEBP;


/**
 * 用来管理Api配置的类。
 * 配置的内容如下：
 * 1. 各类Interceptor
 * 2. token
 * Created by Administrator on 2016/10/20 0020.
 */

public class HttpClientHelper {

    /**
     * 生成通用的UseID和TOken的header
     *
     * @param user_id userid
     * @param token   token
     * @return AuthorizationStr
     */
    private static String getAuthorizationStr(String user_id, String token) {
        String str = HEADER_HB_API + Base64.encodeToString((user_id + ":" + token).getBytes(), Base64.DEFAULT);
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", "");
        }
        return str;
    }

    /**
     * 生成通用的UseID和TOken的header
     *
     * @return AuthorizationStr
     */
    public static String getAuthorizationStr() {
        String str = HEADER_HB_API + Base64.encodeToString((Http.getUserId() + ":" + Http.getToken()).getBytes(), Base64.DEFAULT);
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("\n", "");
        }
        return str;
    }

    public static String getUserAgent() {
        String userAgent = System.getProperty("http.agent");
        String netType = NetWorkUtils.getNetTypeString();
        return userAgent + " " + FROM_ANDROID + "/" + Http.getAppVersion() + "  NetType/" + netType;
    }

    /**
     * 配置参数用的Builder
     * 1.缓存的时间。0 为不适用缓存的策略
     * 2.Cookie存放的位置。null 为不存放
     * 3.是否打印自带的HttpLog
     * 4.connectTimeout
     * 5.readTimeout(6, TimeUnit.SECONDS)
     * 6.writeTimeout(6, TimeUnit.SECONDS)
     * 7.当前的Service.class.
     */
    public static class Builder {
        /**
         * 默认的超时时间
         */
        public static final int DEFAULT_TIME_OUT = 60;
        /**
         * 设缓存有效期为两天
         */
        private static final long DEFAULT_CACHE_STALE_SEC = 60 * 60 * 24 * 2;
        /**
         * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
         * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
         */
        private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + DEFAULT_CACHE_STALE_SEC;
        /**
         * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
         * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
         */
        private static final String CACHE_CONTROL_AGE = "max-age=0";
        private static final long DEFAULT_CACHE_SIZE = 10;


        /**
         * 缓存时间保持的时间.-1为默认值。为两天
         */
        long cacheTime;
        /**
         * cache保持的路径
         */
        String cacheSavePath;
        /**
         * cache保持的大小
         */
        int cacheSize;

        /**
         * Cookie保持的路径
         */
        String cookieSavePath;
        /**
         * 是否答应HttpLog
         */
        boolean isHttpLog;
        /**
         * 连接超时
         */
        int connectTimeOut;
        int readTimeOut;
        int writeTimeOut;

        /**
         * TOken过期时重新登录的Name和PWD
         */
        String authenticatorName;
        String authenticatorPwd;
        /**
         * 对应的ApiService
         */
        Class serviceClazz;

        /**
         * loggingInterceptor
         */

        String authorizationStr;
        private int supportedWebP = -1;


        /**
         * 默认选项
         */
        public Builder() {
            this.cacheTime = -1;
            this.cacheSize = -1;
            this.cacheSavePath = null;
            this.cookieSavePath = null;
            this.isHttpLog = true;
            this.connectTimeOut = DEFAULT_TIME_OUT;
            this.readTimeOut = DEFAULT_TIME_OUT;
            this.writeTimeOut = DEFAULT_TIME_OUT;
        }


        public Builder connectTimeOut(int connectTimeOut) {
            this.connectTimeOut = connectTimeOut;
            return this;
        }

        public Builder cacheSavePath(String cacheSavePath) {
            this.cacheSavePath = cacheSavePath;
            return this;
        }

        public Builder cacheSize(int cacheSize) {
            this.cacheSize = cacheSize;
            return this;
        }

        public Builder readTimeOut(int readTimeOut) {
            this.readTimeOut = readTimeOut;
            return this;
        }

        public Builder writeTimeOut(int writeTimeOut) {
            this.writeTimeOut = writeTimeOut;
            return this;
        }

        public Builder cacheTime(long cacheTime) {
            this.cacheTime = cacheTime;
            return this;
        }

        public Builder isHttpLog(boolean isHttpLog) {
            this.isHttpLog = isHttpLog;
            return this;
        }

        public Builder cookieSavePath(String cookieSavePath) {
            this.cookieSavePath = cookieSavePath;
            return this;
        }

        public Builder authenticatorName(String authenticatorName) {
            this.authenticatorName = authenticatorName;
            return this;
        }

        public Builder authenticatorPwd(String authenticatorPwd) {
            this.authenticatorPwd = authenticatorPwd;
            return this;
        }

        /**
         * 生成Authenticator ，在签名失效的时候，再次验证
         *
         * @return 生成Authenticator
         */
        private Authenticator generateAuthenticator() {
            if (!TextUtils.isEmpty(this.authenticatorName) && !TextUtils.isEmpty(this.authenticatorPwd)) {
                return new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        String credential = Credentials.basic(authenticatorName, authenticatorPwd);
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                };
            }

            return null;
        }

        /**
         * 生成用来打印Http请求的log
         *
         * @return 生成的HttpLogInterceptor
         */
        private Interceptor generateHttpLogInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    long t1 = System.nanoTime();
//            KLog.i(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
                    Response response = chain.proceed(request);
                    long t2 = System.nanoTime();
//            KLog.i(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
//                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                    return response;
                }
            };
        }

        /**
         * 用来生成缓存的log
         *
         * @return 生成缓存控制的log
         */
        private Interceptor generateCacheInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!NetWorkUtils.isNetworkActive()) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
//                KLog.d("no network");
                    }
                    Response originalResponse = chain.proceed(request);
                    if (NetWorkUtils.isNetworkActive()) {
                        //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                        String cacheControl = request.cacheControl().toString();
                        return originalResponse.newBuilder()
                                .header("Cache-Control", cacheControl)
                                .removeHeader("Pragma")
                                .build();
                    } else {
                        return originalResponse.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + (cacheTime != -1 ? cacheTime : DEFAULT_CACHE_STALE_SEC))
                                .removeHeader("Pragma")
                                .build();
                    }
                }
            };
        }

        /**
         * App中需要的生成通用的头的Interceptor
         *
         * @return Interceptor带有通用的头的
         */
        private Interceptor generateTokenInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request()
//                            .newBuilder()
//                            .addHeader(HEADER_X_HB_Client_Type, FROM_ANDROID)
//                            .addHeader(HEADER_AUTHORIZATION, authorizationStr)
//                            .addHeader(HEADER_COOKIE, KEY_HBSID + "=" + Http.getToken())
//                            .build();


                    Request.Builder builder = chain.request()
                            .newBuilder()
                            .addHeader(HEADER_X_HB_Client_Type, FROM_ANDROID)
                            .addHeader(HEADER_AUTHORIZATION, authorizationStr);
                    String token = Http.getToken();
                    if (!TextUtils.isEmpty(token) && !"null".equals(token)) {
                        String cookies = KEY_HBSID + "=" + token + "; " + KEY_HBUID + "=" + Http.getUserId() + "; " + KEY_SUPPORT_WEBP + "=" + isSupportedWebP();
                        builder.addHeader(HEADER_COOKIE, cookies);
                    }
                    Request request = builder.build();
                    return chain.proceed(request);
                }
            };
        }

        private int isSupportedWebP() {
            if (supportedWebP == -1) {
                boolean isBiggerThan18 = DeviceUtils.hasJellyBeanMr2();//>18
                supportedWebP = isBiggerThan18 ? 1 : 0;
            }
            return supportedWebP;
        }

        /**
         * 需要的userAgent
         *
         * @return Interceptor带有通用的头的
         */
        private Interceptor generateUserAgentInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder builder = chain.request()
                            .newBuilder()
                            .removeHeader(HEADER_USER_AGENT)
                            .addHeader(HEADER_USER_AGENT, getUserAgent());
//                    "User-Agent", String.format("%s/%s (Linux; Android %s; %s Build/%s)", MY_APP_NAME, MY_APP_VERSION_NAME, Build.VERSION.RELEASE, Build.MANUFACTURER, Build.ID));
                    Request request = builder
                            .build();

                    return chain.proceed(request);
                }
            };
        }

        /**
         * 建造出需要的HttpClient
         *
         * @return OkHttpClient
         */
        public OkHttpClient build() {

            Interceptor cacheInterceptor1 = generateCacheInterceptor();
            Interceptor userAgentInterceptor = generateUserAgentInterceptor();
//            Interceptor logInterceptor = generateHttpLogInterceptor();
//            Authenticator authenticator=generateAuthenticator();
            //默认保存到App下面的缓存目录。默认的大小为10M
            Cache cache = new Cache(new File(cacheSavePath == null ? Http.getContext().getCacheDir().getAbsolutePath() : cacheSavePath, "HttpCache"),
                    1024 * 1024 * (cacheSize == -1 ? DEFAULT_CACHE_SIZE : cacheSize));

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.cache(cache)
                    .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                    .readTimeout(readTimeOut, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeOut, TimeUnit.SECONDS)
                    .addInterceptor(cacheInterceptor1)
                    .addInterceptor(userAgentInterceptor)
                    .addNetworkInterceptor(cacheInterceptor1)
            ;
//                    .addInterceptor(logInterceptor);
            authorizationStr = getAuthorizationStr();

//            if (authorizationStr != null) {
            //暂时用默认的吧
            Interceptor tokenInterceptor = generateTokenInterceptor();
            builder.addInterceptor(tokenInterceptor);
//            }
            if (isHttpLog) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            return builder.build();
        }
    }
}
