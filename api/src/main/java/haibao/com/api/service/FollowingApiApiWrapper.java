package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.following.FollowingResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class FollowingApiApiWrapper implements ClearWrapper {
  private static FollowingApiApiWrapper INSTANCE;

  private static FollowingApiService FollowingApiService;

  public static FollowingApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new FollowingApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public FollowingApiService getFollowingApiService() {
    if (FollowingApiService==null) {
      FollowingApiService=BaseApi.getRetrofit(CommonUrl.FollowingApiService_BaseUrl).create(FollowingApiService.class);
    }
    return FollowingApiService;
  }

  public void clearService() {
    FollowingApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<FollowingResponse> GetFollowers(Integer page, Integer per_page) {
    return getFollowingApiService().GetFollowers(page,per_page).compose(BaseApi.<FollowingResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<FollowingResponse> GetFollowing(Integer page, Integer per_page) {
    return getFollowingApiService().GetFollowing(page,per_page).compose(BaseApi.<FollowingResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutFollowingUserId(String user_id) {
    return getFollowingApiService().PutFollowingUserId(user_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteFollowingUserId(String user_id) {
    return getFollowingApiService().DeleteFollowingUserId(user_id).compose(BaseApi.<Void>defaultSchedulers());
  }
}
