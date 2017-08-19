package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
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
import rx.Observable;

import static haibao.com.api.common.CommonUrl.AccountService_BaseUrl;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class AccountApiWrapper implements ClearWrapper {
    private static AccountApiWrapper INSTANCE;

    private static AccountService AccountService;

    public static AccountApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public AccountService getAccountService() {
        if (AccountService == null) {
            AccountService = BaseApi.getRetrofit(AccountService_BaseUrl).create(AccountService.class);
        }
        return AccountService;
    }

    public void clearService() {
        AccountService = null;
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UserEntity> login(LoginParams params) {
        return getAccountService().login(params).compose(BaseApi.<UserEntity>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<User> getUserInfo() {
        return getAccountService().getUserInfo().compose(BaseApi.<User>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<User> modifyUserInfo(ModifyUserInfoParams params) {
        return getAccountService().modifyUserInfo(params).compose(BaseApi.<User>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CheckThirdAccount> checkThirdAccount(String sns_user_id, String type) {
        return getAccountService().checkThirdAccount(sns_user_id, type).compose(BaseApi.<CheckThirdAccount>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UserEntity> bindThirdAccount(BindUserParams params) {
        return getAccountService().bindThirdAccount(params).compose(BaseApi.<UserEntity>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<BindMobile> bindMobile(bindMobileParams params) {
        return getAccountService().bindMobile(params).compose(BaseApi.<BindMobile>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CheckMobile> checkMobile(String account, int country_code) {
        return getAccountService().checkMobile(account, country_code).compose(BaseApi.<CheckMobile>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UserEntity> register(RegisterParams params) {
        return getAccountService().register(params).compose(BaseApi.<UserEntity>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CheckSnsUsername> checkSnsUsername(String mobile) {
        return getAccountService().checkSnsUsername(mobile).compose(BaseApi.<CheckSnsUsername>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CommonMessage> resetPwd(ResetPwdParams params) {
        return getAccountService().resetPwd(params).compose(BaseApi.<CommonMessage>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CommonMessage> activateAccount(ResetPwdParams params) {
        return getAccountService().activateAccount(params).compose(BaseApi.<CommonMessage>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UploadAvatar> uploadUserAvatar(MultipartBody multipartBody) {
        return getAccountService().uploadUserAvatar(multipartBody).compose(BaseApi.<UploadAvatar>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UploadAvatar> uploadImage(MultipartBody multipartBody) {
        return getAccountService().uploadImage(multipartBody).compose(BaseApi.<UploadAvatar>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<String>> uploadFeedBackImage(MultipartBody multipartBody) {
        return getAccountService().uploadFeedBackImage(multipartBody).compose(BaseApi.<List<String>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<PostAppsHaibaoUserCoversResponse> PostUserCovers(MultipartBody multipartBody) {
        return getAccountService().PostUserCovers(multipartBody).compose(BaseApi.<PostAppsHaibaoUserCoversResponse>defaultSchedulers());
    }


    /**
     * 此方法由apt自动生成
     */
    public Observable<StoreUrlResponse> getUserStoreUrl() {
        return getAccountService().getUserStoreUrl().compose(BaseApi.<StoreUrlResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<CommonMessage> modifyPassword(ModifyPasswordParams params) {
        return getAccountService().modifyPassword(params).compose(BaseApi.<CommonMessage>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<AudioInfo> accessAudioauthentication() {
        return getAccountService().accessAudioauthentication().compose(BaseApi.<AudioInfo>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> uploadErrorLog(ErrorLogParams params) {
        return getAccountService().uploadErrorLog(params).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> uploadConfigurationLog(ConfigurationLogParams params) {
        return getAccountService().uploadConfigurationLog(params).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<UpdateInfo> updataApp() {
        return getAccountService().updataApp().compose(BaseApi.<UpdateInfo>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<HotUpdateInfo> hotUpdataApp(String version) {
        return getAccountService().hotUpdataApp(version).compose(BaseApi.<HotUpdateInfo>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> updataLog(UpdataLogParams params) {
        return getAccountService().updataLog(params).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<String> logout() {
        return getAccountService().logout().compose(BaseApi.<String>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<FeedBackResponse> feedback(FeedBackParams params) {
        return getAccountService().feedback(params).compose(BaseApi.<FeedBackResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<VodVideoInfo> getVodVideoInfo(String file_id) {
        return getAccountService().getVodVideoInfo(file_id).compose(BaseApi.<VodVideoInfo>defaultSchedulers());
    }

    public Observable<UserEntity> phoneLogin(PhoneLoginParams params) {
        return getAccountService().phoneLogin(params).compose(BaseApi.<UserEntity>defaultSchedulers());
    }
}
