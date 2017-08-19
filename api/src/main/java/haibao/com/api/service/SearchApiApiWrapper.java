package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.content.BindBooks;
import haibao.com.api.data.response.global.BasePageResponse;
import haibao.com.api.data.response.search.GetClassesCoursesResponse;
import haibao.com.api.data.response.search.GetSearchActivitiesResponse;
import haibao.com.api.data.response.search.GetSearchContentsResponse;
import haibao.com.api.data.response.search.GetSearchGoodsResponse;
import haibao.com.api.data.response.search.GetSearchUsersResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class SearchApiApiWrapper implements ClearWrapper {
  private static SearchApiApiWrapper INSTANCE;

  private static SearchApiService SearchApiService;

  public static SearchApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new SearchApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public SearchApiService getSearchApiService() {
    if (SearchApiService==null) {
      SearchApiService=BaseApi.getRetrofit(CommonUrl.SearchApiService_BaseUrl).create(SearchApiService.class);
    }
    return SearchApiService;
  }

  public void clearService() {
    SearchApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClassesCoursesResponse> GetClassesCourses( String q,
      Integer page, Integer per_page) {
    return getSearchApiService().GetClassesCourses(q,page,per_page).compose(BaseApi.<GetClassesCoursesResponse>defaultSchedulers());
  }
  public Observable<BasePageResponse<BindBooks>> GetSearchBooks(String q,
                                                               Integer page, Integer per_page) {
    return getSearchApiService().GetSearchBooks(q,page,per_page).compose(BaseApi.<BasePageResponse<BindBooks>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSearchActivitiesResponse> GetSearchActivities( String q,
      Integer page, Integer per_page) {
    return getSearchApiService().GetSearchActivities(q,page,per_page).compose(BaseApi.<GetSearchActivitiesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSearchContentsResponse> GetSearchContents( String q,
      Integer page, Integer per_page) {
    return getSearchApiService().GetSearchContents(q,page,per_page).compose(BaseApi.<GetSearchContentsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSearchGoodsResponse> GetSearchGoods(String q, Integer page,
      Integer per_page) {
    return getSearchApiService().GetSearchGoods(q,page,per_page).compose(BaseApi.<GetSearchGoodsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetSearchUsersResponse> GetSearchUsers( String q, Integer page,
      Integer per_page) {
    return getSearchApiService().GetSearchUsers(q,page,per_page).compose(BaseApi.<GetSearchUsersResponse>defaultSchedulers());
  }
}
