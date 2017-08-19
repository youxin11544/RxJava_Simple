package haibao.com.api.service;


import haibao.com.api.BaseApi;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.HBApiBaseUrlBean;
import haibao.com.api.data.response.basic.GetBasicAppsHaibaoInitiationResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class HBOpenApiApiWrapper implements BaseApi.ClearWrapper {
    private static HBOpenApiApiWrapper INSTANCE;

    private static HBOpenApiService HBOpenApiService;

    public static HBOpenApiApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HBOpenApiApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public HBOpenApiService getHBOpenApiService() {
        if (HBOpenApiService == null) {
            HBOpenApiService = BaseApi.getRetrofit(CommonUrl.HBOpenApiService_BaseUrl).create(HBOpenApiService.class);
        }
        return HBOpenApiService;
    }

    public void clearService() {
        HBOpenApiService = null;
    }


    public Observable<HBApiBaseUrlBean> getHBApiInfo(String client_type, String version) {
        return getHBOpenApiService().getHBApiInfo(client_type, version).compose(BaseApi.<HBApiBaseUrlBean>defaultSchedulers());
    }
    /**
     * 此方法由apt自动生成
     */
    public Observable<GetBasicAppsHaibaoInitiationResponse> GetBasicAppsHaibaoInitiation() {
        return getHBOpenApiService().GetBasicAppsHaibaoInitiation().compose(BaseApi.<GetBasicAppsHaibaoInitiationResponse>defaultSchedulers());
    }

}
