package haibao.com.api.service;


import java.util.List;

import haibao.com.api.common.HttpCommon;
import haibao.com.api.data.param.account.BindUserParams;
import haibao.com.api.data.param.account.LoginParams;
import haibao.com.api.data.param.account.ModifyPasswordParams;
import haibao.com.api.data.param.account.ModifyUserInfoParams;
import haibao.com.api.data.param.account.PhoneLoginParams;
import haibao.com.api.data.param.account.RegisterParams;
import haibao.com.api.data.param.account.ResetPwdParams;
import haibao.com.api.data.param.account.UpdateInfo;
import haibao.com.api.data.param.account.UploadAvatar;
import haibao.com.api.data.param.account.bindMobileParams;
import haibao.com.api.data.param.mine.FeedBackParams;
import haibao.com.api.data.param.school.ConfigurationLogParams;
import haibao.com.api.data.param.school.ErrorLogParams;
import haibao.com.api.data.param.school.UpdataLogParams;
import haibao.com.api.data.response.account.BindMobile;
import haibao.com.api.data.response.account.CheckMobile;
import haibao.com.api.data.response.account.CheckSnsUsername;
import haibao.com.api.data.response.account.CheckThirdAccount;
import haibao.com.api.data.response.account.CommonMessage;
import haibao.com.api.data.response.account.StoreUrlResponse;
import haibao.com.api.data.response.account.User;
import haibao.com.api.data.response.account.UserEntity;
import haibao.com.api.data.response.hot.HotUpdateInfo;
import haibao.com.api.data.response.mineResponse.FeedBackResponse;
import haibao.com.api.data.response.school.AudioInfo;
import haibao.com.api.data.response.school.VodVideoInfo;
import haibao.com.api.data.response.user.PostAppsHaibaoUserCoversResponse;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API接口方法申明接口类
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface AccountService {

    /**
     * title=用户注册
     * version =  1.1.0
     * api url=<a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_register">用户注册</>
     */
    @POST("register")
    Observable<UserEntity> register(@Body RegisterParams params);

    /**
     * title=用户登录(验证用户的帐号)
     * version =  1.1.0
     * api url=<a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_login">用户登录</>
     */
    @POST("login")
    Observable<UserEntity> login(@Body LoginParams params);

    /**
     * title= 通过手机号验证码登录
     * version =  1.1.0
     * api url=<a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_login_by_mobile">通过手机号验证码登录</>
     */
    @POST("login_by_mobile")
    Observable<UserEntity> phoneLogin(@Body PhoneLoginParams params);

    /**
     * title=  验证用户帐号是否存在(检查该手机号码时候是有效的手机号码)
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-get_account_exist">验证用户帐号是否存在</>
     */
    @GET("account_exist")
    Observable<CheckMobile> checkMobile(@Query("account") String account, @Query("mobile_country_code") int country_code);


    /**
     * title= 验证是否来自第三方平台(如果是则需要激活)
     * version =  1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-get_is_sns_account">验证是否来自第三方平台</>
     */
    @GET("is_sns_account")
    Observable<CheckSnsUsername> checkSnsUsername(@Query("mobile") String mobile);


    /**
     * title=用户登出(退出登陆)
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_logout">用户登出</>
     */
    @POST("logout")
    Observable<String> logout();

    //省略 是否已签到和签到2个接口

    /**
     * title=修改密码(用户需要输入旧密码和新密码)
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_update_password">修改密码</>
     */
    @POST("update_password")
    Observable<CommonMessage> modifyPassword(@Body ModifyPasswordParams params);


    /**
     * title= 绑定手机号/更换手机号绑定
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_bind_mobile">绑定手机号</>
     */
    @POST("bind_mobile")
    Observable<BindMobile> bindMobile(@Body bindMobileParams params);


    //省略找回密码-验证手机号是否绑定<a href="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-get_mobile_binded">"</>

    /**
     * title= 找回密码-重置密码
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_reset_password">找回密码</>
     */
    @POST("reset_password")
    Observable<CommonMessage> resetPwd(@Body ResetPwdParams params);

    /**
     * title= 激活帐号
     * version =  1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_activate_account">激活帐号</>
     */
    @POST("activate_account")
    Observable<CommonMessage> activateAccount(@Body ResetPwdParams params);

    /**
     * title= 验证第三方帐号是否绑定
     *
     * @param sns_user_id 第三方用户识别码
     * @param type        第三方账号类型
     *                    version =  1.1.0
     *                    api url=  <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_oauth_account">验证第三方帐号是否绑定</>
     */
    @GET("oauth_account")
    Observable<CheckThirdAccount> checkThirdAccount(@Query("sns_user_id") String sns_user_id, @Query("type") String type);

    /**
     * title= 绑定第三方帐号
     * version = 1.3.0
     * api url=  <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_oauth_account">绑定第三方帐号</>
     */
    @POST("oauth_account")
    Observable<UserEntity> bindThirdAccount(@Body BindUserParams params);

    /**
     * title= 获取用户信息
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-get_user">获取用户信息</>
     */
    @GET("user")
    Observable<User> getUserInfo();

    /**
     * title=修改用户信息
     * version = 1.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-put_user">修改用户信息</>
     */
    @PUT("user")
    Observable<User> modifyUserInfo(@Body ModifyUserInfoParams params);

    /**
     * title= 上传用户头像
     * version = 1.0.1
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_users_avatars">上传用户图像</>
     */
    @POST("users/avatars")
    Observable<UploadAvatar> uploadUserAvatar(@Body MultipartBody multipartBody);

    /**
     * title=  上传清晰大图
     * version = 1.0.1
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_users_imageupload">上传清晰大图</>
     */
    @POST("users/imageupload")
    Observable<UploadAvatar> uploadImage(@Body MultipartBody multipartBody);


    /**
     * title=  上传用户反馈图片
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_user_feedback_images">上传用户反馈图片</>
     */
    @POST("user/feedback/images")
    Observable<List<String>> uploadFeedBackImage(@Body MultipartBody multipartBody);

    /**
     * title=上传用户背景图
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/user/#api-userGroup-post_apps_haibao_user_covers">上传用户背景图</>
     */
    @POST("user/covers")
    Observable<PostAppsHaibaoUserCoversResponse> PostUserCovers(@Body MultipartBody multipartBody);


    /**
     * title= 意见反馈
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_user_feedback">意见反馈</>
     */
    @POST("user/feedback")
    Observable<FeedBackResponse> feedback(@Body FeedBackParams params);

    //省略 帐号相关 - 获取用于触发单点登录的信息(地址和session_id)<a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-get_sso_notification_info">意见反馈"</>


    /**
     * title=记录APP报错信息
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_statistics_buglog">记录APP报错信息</>
     */
    @POST("statistics/buglog")
    Observable<Void> uploadErrorLog(@Body ErrorLogParams params);

    /**
     * title=记录用户手机基本配置信息
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-accountGroup-post_statistics_clientlog">记录用户手机基本配置信息</>
     */
    @POST("statistics/clientlog")
    Observable<Void> uploadConfigurationLog(@Body ConfigurationLogParams params);

    //省略 云服务授权 - 获取腾讯云微视频配置及签名 <a href ="https://apidev.baobaobooks.net/docs/account/#api-csauthGroup-get_signs_qcmvs">获取腾讯云微视频配置及签名</>


    /**
     * title= 获取OSS短期访问权限(音频)
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-csauthGroup-get_aliyunstss_ossv">获取OSS短期访问权限</>
     */
    @GET("aliyunstss/ossv")
    Observable<AudioInfo> accessAudioauthentication();


    /**
     * title= 云服务授权 - 腾讯云API的wrapper
     * version = 1.1.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-csauthGroup-get_qcapi_wrapper__service__api_name">云服务授权 - 腾讯云API的wrapper</>
     */
    @GET("qcapi/wrapper/vod/DescribeVodPlayUrls")
    Observable<VodVideoInfo> getVodVideoInfo(@Query(HttpCommon.KEY_SNS_USER_ID) String file_id);


    /**
     * title=APP热更新
     * version =2.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-versionGroup-get_app_versions_update">APP热更新</>
     */
    @GET("app/versions/update")
    Observable<HotUpdateInfo> hotUpdataApp(@Query("version") String version);


    /**
     * APP版本更新
     * version =2.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-versionGroup-get_app_versions">APP版本更新</>
     */
    @GET("app/versions")
    Observable<UpdateInfo> updataApp();


    /**
     * APP版本更新记录
     * version =2.0.0
     * api url= <a href ="https://apidev.baobaobooks.net/docs/account/#api-versionGroup-post_app_versions_log">APP版本更新记录</>
     */
    @POST("app/versions/log")
    Observable<Void> updataLog(@Body UpdataLogParams params);


//    去掉了选书的webView现在废弃了

    /**
     * 用户童书馆信息 - 获取用户的童书馆url
     * 获取用户的访问的童书馆url,如果用户是推广人则访问的是自己的童书馆,以及管理童书馆的地址
     *
     * @return
     */
    @GET("user/urls")
    Observable<StoreUrlResponse> getUserStoreUrl();


}
