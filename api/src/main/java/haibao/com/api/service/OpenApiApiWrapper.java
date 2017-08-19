package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.ApiBaseUrlBean;
import haibao.com.api.data.response.mineResponse.City;
import haibao.com.api.data.response.mineResponse.Province;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class OpenApiApiWrapper implements ClearWrapper {
    private static OpenApiApiWrapper INSTANCE;

    private static OpenApiService OpenApiService;

    public static OpenApiApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OpenApiApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public OpenApiService getOpenApiService() {
        if (OpenApiService == null) {
            OpenApiService = BaseApi.getRetrofit(CommonUrl.OpenApiService_BaseUrl).create(OpenApiService.class);
        }
        return OpenApiService;
    }

    public void clearService() {
        OpenApiService = null;
    }



    public Observable<ApiBaseUrlBean> getApiInfo(String client_type, String version) {
        return getOpenApiService().getApiInfo( client_type,  version).compose(BaseApi.<ApiBaseUrlBean>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成 */
    public Observable<List<Province>> getProvinces() {
        return getOpenApiService().getProvinces().compose(BaseApi.<List<Province>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成 */
    public Observable<List<City>> getCities(int province_id) {
        return getOpenApiService().getCities(province_id).compose(BaseApi.<List<City>>defaultSchedulers());
    }


}
