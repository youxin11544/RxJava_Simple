package haibao.com.api.service;

import java.util.List;

import haibao.com.api.data.response.ApiBaseUrlBean;
import haibao.com.api.data.response.mineResponse.City;
import haibao.com.api.data.response.mineResponse.Province;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= API基础信息 童书馆下的open
 * groupDescription=<p>孩宝API基础信息</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface OpenApiService {

    /**
     * title=api模块信息
     * version=1.0.0
     * api url =<a href ="https://apidev.baobaobooks.net/docs/open/#api-basicGroup-get_basic_apis"/>
     */
    @GET("basic/apis")
    Observable<ApiBaseUrlBean> getApiInfo(@Query("client_type") String client_type, @Query("version") String version);


    /**
     * title=获取所有省份信息
     * version=1.0.0
     * api url =<a href ="https://apidev.baobaobooks.net/docs/open/#api-regionGroup-get_misc_provinces"/>
     */
    @GET("misc/provinces")
    Observable<List<Province>> getProvinces();

    /**
     * title=获取某个省份下的所有城市信息
     * version=1.0.0
     * api url =<a href ="https://apidev.baobaobooks.net/docs/open/#api-regionGroup-get_misc_provinces__province_id_cities"/>
     */
    @GET("misc/provinces" + "/{province_id}/cities")
    Observable<List<City>> getCities(@Path("province_id") int province_id);


}
