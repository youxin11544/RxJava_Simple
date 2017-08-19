//package haibao.com.api.service;
//
//import java.util.List;
//
//import haibao.com.api.BaseApi;
//import haibao.com.api.BaseApi.ClearWrapper;
//import haibao.com.api.common.CommonUrl;
//import haibao.com.api.data.param.mine.FeedBackParams;
//import haibao.com.api.data.response.content.GetUserContentsResponse;
//import haibao.com.api.data.response.global.Share;
//import haibao.com.api.data.response.mineResponse.ATTENTIONS;
//import haibao.com.api.data.response.mineResponse.CONTENTS;
//import haibao.com.api.data.response.mineResponse.City;
//import haibao.com.api.data.response.mineResponse.FANS;
//import haibao.com.api.data.response.mineResponse.Feedback;
//import haibao.com.api.data.response.mineResponse.HomapageResponse;
//import haibao.com.api.data.response.mineResponse.Province;
//import rx.Observable;
//
///**   这个类 没用了，暂时注释掉
// * @ API包装类 此类由apt自动生成 */
//public final class MineApiWrapper implements ClearWrapper {
//  private static MineApiWrapper INSTANCE;
//
//  private static MineService MineService;
//
//  public static MineApiWrapper getInstance() {
//    if (INSTANCE==null) {
//      INSTANCE=new MineApiWrapper();
//      BaseApi.addToBaseApi(INSTANCE);
//    }
//    return INSTANCE;
//  }
//
//  public MineService getMineService() {
//    if (MineService==null) {
//      MineService=BaseApi.getRetrofit(CommonUrl.MineService_BaseUrl).create(MineService.class);
//    }
//    return MineService;
//  }
//
//  public void clearService() {
//    MineService=null;
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getCurrentUserBabyRecords(int baby_id, String offset) {
//    return getMineService().getCurrentUserBabyRecords(baby_id,offset).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getCurrentUserBabyRecords(int baby_id) {
//    return getMineService().getCurrentUserBabyRecords(baby_id).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<Share> getShareAppUrl() {
//    return getMineService().getShareAppUrl().compose(BaseApi.<Share>defaultSchedulers());
//  }
//
//
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<Share> getShareUserOrBabyArticles(String baby_id) {
//    return getMineService().getShareUserOrBabyArticles(baby_id).compose(BaseApi.<Share>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<Share> getShareUserOrBabyArticles() {
//    return getMineService().getShareUserOrBabyArticles().compose(BaseApi.<Share>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<GetUserContentsResponse> getCurrentUserArticles(String offset) {
//    return getMineService().getCurrentUserArticles(offset).compose(BaseApi.<GetUserContentsResponse>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getCurrentUserArticles() {
//    return getMineService().getCurrentUserArticles().compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<Void> attention(String friend_user_id) {
//    return getMineService().attention(friend_user_id).compose(BaseApi.<Void>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<String> cancelAttention(String friend_user_id) {
//    return getMineService().cancelAttention(friend_user_id).compose(BaseApi.<String>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<ATTENTIONS> getAttentions(String offset) {
//    return getMineService().getAttentions(offset).compose(BaseApi.<ATTENTIONS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<ATTENTIONS> getAttentions() {
//    return getMineService().getAttentions().compose(BaseApi.<ATTENTIONS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<ATTENTIONS> getOtherAttentions(String user_id, String offset) {
//    return getMineService().getOtherAttentions(user_id,offset).compose(BaseApi.<ATTENTIONS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<ATTENTIONS> getOtherAttentions(String user_id) {
//    return getMineService().getOtherAttentions(user_id).compose(BaseApi.<ATTENTIONS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<HomapageResponse> getUserHomepage(int home_user_id) {
//    return getMineService().getUserHomepage(home_user_id).compose(BaseApi.<HomapageResponse>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<FANS> getFans(String offset) {
//    return getMineService().getFans(offset).compose(BaseApi.<FANS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<FANS> getFans() {
//    return getMineService().getFans().compose(BaseApi.<FANS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getOtherUserBabyRecords(int user_id, int baby_id, String offset) {
//    return getMineService().getOtherUserBabyRecords(user_id,baby_id,offset).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getOtherUserBabyRecords(int user_id, int baby_id) {
//    return getMineService().getOtherUserBabyRecords(user_id,baby_id).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getOtherUserArticles(int user_id, String offset) {
//    return getMineService().getOtherUserArticles(user_id,offset).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//
//  /**
//   * 此方法由apt自动生成 */
//  public Observable<CONTENTS> getOtherUserArticles(int user_id) {
//    return getMineService().getOtherUserArticles(user_id).compose(BaseApi.<CONTENTS>defaultSchedulers());
//  }
//}
