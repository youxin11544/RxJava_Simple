package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.user.GetSharingAppResponse;
import haibao.com.api.data.response.user.GetSharingUserResponse;
import haibao.com.api.data.response.user.GetUsersUserIdResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class UserApiApiWrapper implements ClearWrapper {
  private static UserApiApiWrapper INSTANCE;

  private static UserApiService UserApiService;

  public static UserApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new UserApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public UserApiService getUserApiService() {
    if (UserApiService==null) {
      UserApiService=BaseApi.getRetrofit(CommonUrl.UserApiService_BaseUrl).create(UserApiService.class);
    }
    return UserApiService;
  }

  public void clearService() {
    UserApiService=null;
  }


//  /**
//   * 此方法由apt自动生成 */
//  public Observable<GetAppsHaibaoUserCoversResponse> GetAppsHaibaoUserCovers() {
//    return getUserApiService().GetAppsHaibaoUserCovers().compose(BaseApi.<GetAppsHaibaoUserCoversResponse>defaultSchedulers());
//  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSharingAppResponse> GetSharingApp(String client_type) {
    return getUserApiService().GetSharingApp(client_type).compose(BaseApi.<GetSharingAppResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSharingUserResponse> GetSharingUser(Integer baby_id) {
    return getUserApiService().GetSharingUser(baby_id).compose(BaseApi.<GetSharingUserResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetUsersUserIdResponse> GetUsersUserId(String user_id) {
    return getUserApiService().GetUsersUserId(user_id).compose(BaseApi.<GetUsersUserIdResponse>defaultSchedulers());
  }
}
