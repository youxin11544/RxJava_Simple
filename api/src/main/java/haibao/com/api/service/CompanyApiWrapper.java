package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.data.response.company.CompanyInfoResponse;
import haibao.com.api.data.response.company.GetLectureResponse;
import haibao.com.api.data.response.company.GetQaTalkResponse;
import rx.Observable;

import static haibao.com.api.common.CommonUrl.AccompanyService_BaseUrl;

/**
 * @ API包装类 此类由apt自动生成 */
public final class CompanyApiWrapper implements ClearWrapper {
  private static CompanyApiWrapper INSTANCE;

  private static CompanyService CompanyService;

  public static CompanyApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new CompanyApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public CompanyService getAccompanyService() {
    if (CompanyService ==null) {
      CompanyService =BaseApi.getRetrofit(AccompanyService_BaseUrl).create(CompanyService.class);
    }
    return CompanyService;
  }

  public void clearService() {
    CompanyService =null;
  }

  public Observable<CompanyInfoResponse> getAccmpanyInfo( ) {
    return getAccompanyService().getAccmpanyInfo().compose(BaseApi.<CompanyInfoResponse>defaultSchedulers());
  }

    public Observable<GetQaTalkResponse> GetQaTalk() {
        return getAccompanyService().GetQaTalk().compose(BaseApi.<GetQaTalkResponse>defaultSchedulers());
    }

    public Observable<GetLectureResponse> GetLecture() {
        return getAccompanyService().GetLecture().compose(BaseApi.<GetLectureResponse>defaultSchedulers());
    }


}
