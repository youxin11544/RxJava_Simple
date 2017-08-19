package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.param.club.PostClubsRequestParam;
import haibao.com.api.data.param.club.PutClubsClubIdMessagesUnreadRequestParam;
import haibao.com.api.data.param.club.PutClubsClubIdRequestParam;
import haibao.com.api.data.response.club.GetClubsClubIdMessagesUnreadNumberResponse;
import haibao.com.api.data.response.club.GetClubsClubIdProfileResponse;
import haibao.com.api.data.response.club.GetClubsClubIdResponse;
import haibao.com.api.data.response.club.GetClubsClubIdStatisticsBriefResponse;
import haibao.com.api.data.response.club.GetClubsClubIdUsersResponse;
import haibao.com.api.data.response.club.GetClubsRecommendedResponse;
import haibao.com.api.data.response.club.PostClubsResponse;
import haibao.com.api.data.response.club.PutClubsClubIdMessagesUnreadResponse;
import haibao.com.api.data.response.club.PutClubsClubIdResponse;
import haibao.com.api.data.response.user.GetPromoterResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class ClubApiApiWrapper implements ClearWrapper {
  private static ClubApiApiWrapper INSTANCE;

  private static ClubApiService ClubApiService;

  public static ClubApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new ClubApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public ClubApiService getClubApiService() {
    if (ClubApiService==null) {
      ClubApiService=BaseApi.getRetrofit(CommonUrl.ClubApiService_BaseUrl).create(ClubApiService.class);
    }
    return ClubApiService;
  }

  public void clearService() {
    ClubApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteClubsClubIdUsersUserId(String club_id, String user_id) {
    return getClubApiService().DeleteClubsClubIdUsersUserId(club_id,user_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdResponse> GetClubsClubId(String club_id) {
    return getClubApiService().GetClubsClubId(club_id).compose(BaseApi.<GetClubsClubIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdMessagesUnreadNumberResponse> GetClubsClubIdMessagesUnreadNumber(String club_id,
      Integer last_timestamp) {
    return getClubApiService().GetClubsClubIdMessagesUnreadNumber(club_id,last_timestamp).compose(BaseApi.<GetClubsClubIdMessagesUnreadNumberResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdProfileResponse> GetClubsClubIdProfile(String club_id) {
    return getClubApiService().GetClubsClubIdProfile(club_id).compose(BaseApi.<GetClubsClubIdProfileResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdStatisticsBriefResponse> GetClubsClubIdStatisticsBrief(String club_id) {
    return getClubApiService().GetClubsClubIdStatisticsBrief(club_id).compose(BaseApi.<GetClubsClubIdStatisticsBriefResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdUsersResponse> GetClubsClubIdUsers(String club_id, String q,
      Integer group_id, Integer class_id, Integer page, Integer per_page) {
    return getClubApiService().GetClubsClubIdUsers(club_id,q,group_id,class_id,page,per_page).compose(BaseApi.<GetClubsClubIdUsersResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<List<GetClubsRecommendedResponse>> GetClubsRecommended() {
    return getClubApiService().GetClubsRecommended().compose(BaseApi.<List<GetClubsRecommendedResponse>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostClubsResponse> PostClubs(PostClubsRequestParam PostClubsRequestParam) {
    return getClubApiService().PostClubs(PostClubsRequestParam).compose(BaseApi.<PostClubsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PutClubsClubIdResponse> PutClubsClubId(String club_id,
      PutClubsClubIdRequestParam PutClubsClubIdRequestParam) {
    return getClubApiService().PutClubsClubId(club_id,PutClubsClubIdRequestParam).compose(BaseApi.<PutClubsClubIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutClubsClubIdApplications(String club_id) {
    return getClubApiService().PutClubsClubIdApplications(club_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PutClubsClubIdMessagesUnreadResponse> PutClubsClubIdMessagesUnread(String club_id,
      PutClubsClubIdMessagesUnreadRequestParam PutClubsClubIdMessagesUnreadRequestParam) {
    return getClubApiService().PutClubsClubIdMessagesUnread(club_id,PutClubsClubIdMessagesUnreadRequestParam).compose(BaseApi.<PutClubsClubIdMessagesUnreadResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成
   */
  public Observable<GetPromoterResponse> GetPromoter() {
    return getClubApiService().GetPromoter().compose(BaseApi.<GetPromoterResponse>defaultSchedulers());
  }

}
