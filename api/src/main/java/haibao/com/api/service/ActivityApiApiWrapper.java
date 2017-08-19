package haibao.com.api.service;

import java.util.ArrayList;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.data.response.activity.ActivitiesActivityResponse;
import haibao.com.api.data.response.activity.GetActivitiesActivityIdContentsResponse;
import haibao.com.api.data.response.activity.GetClubsClubIdActivitiesInactiveResponse;
import haibao.com.api.data.response.activity.GetClubsClubIdActivitiesResponse;
import rx.Observable;

import static haibao.com.api.common.CommonUrl.ActivityApiService_BaseUrl;

/**
 * @ API包装类 此类由apt自动生成 */
public final class ActivityApiApiWrapper implements ClearWrapper {
  private static ActivityApiApiWrapper INSTANCE;

  private static ActivityApiService ActivityApiService;

  public static ActivityApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new ActivityApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public ActivityApiService getActivityApiService() {
    if (ActivityApiService==null) {
      ActivityApiService=BaseApi.getRetrofit(ActivityApiService_BaseUrl).create(ActivityApiService.class);
    }
    return ActivityApiService;
  }

  public void clearService() {
    ActivityApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ActivitiesActivityResponse> GetActivitiesActivityId(String activity_id) {
    return getActivityApiService().GetActivitiesActivityId(activity_id).compose(BaseApi.<ActivitiesActivityResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdActivitiesResponse> GetClubsClubIdActivities(
      Integer page, Integer per_page) {
    return getActivityApiService().GetClubsClubIdActivities(page,per_page).compose(BaseApi.<GetClubsClubIdActivitiesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ArrayList<ActivitiesActivityResponse>> GetClubsClubIdActivitiesActive() {
    return getActivityApiService().GetClubsClubIdActivitiesActive().compose(BaseApi.<ArrayList<ActivitiesActivityResponse>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdActivitiesInactiveResponse> GetClubsClubIdActivitiesInactive(
      Integer page, Integer per_page) {
    return getActivityApiService().GetClubsClubIdActivitiesInactive(page,per_page).compose(BaseApi.<GetClubsClubIdActivitiesInactiveResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdActivitiesInactiveResponse> GetUserActivities(Integer page,
      Integer per_page) {
    return getActivityApiService().GetUserActivities(page,per_page).compose(BaseApi.<GetClubsClubIdActivitiesInactiveResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PubActivitiesActivityIdApplications(String activity_id) {
    return getActivityApiService().PubActivitiesActivityIdApplications(activity_id).compose(BaseApi.<Void>defaultSchedulers());
  }
  /**
   * 此方法由apt自动生成 */
  public Observable<GetActivitiesActivityIdContentsResponse> GetActivitiesActivityIdContents(String activity_id,
                                                                                             Integer offset, Integer limit) {
    return getActivityApiService().GetActivitiesActivityIdContents(activity_id,offset,limit).compose(BaseApi.<GetActivitiesActivityIdContentsResponse>defaultSchedulers());
  }

}
