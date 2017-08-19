package haibao.com.api.service;


import haibao.com.api.data.response.HBApiBaseUrlBean;
import haibao.com.api.data.response.basic.GetBasicAppsHaibaoInitiationResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= API基础信息 孩宝小镇的open
 * groupDescription=<p>孩宝API基础信息</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface HBOpenApiService {

    /**
     * title=api模块信息
     *  version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/open/#api-basicGroup-get_basic_apis"/>
     */
    @GET("basic/apis")
    Observable<HBApiBaseUrlBean> getHBApiInfo(@Query("client_type") String client_type, @Query("version") String version);

    /**
     * title=获取孩宝App配置
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/open/#api-basicGroup-get_basic_apps_haibao_initialization"/>
     */
    @GET("basic/apps/haibao/initialization")
    Observable<GetBasicAppsHaibaoInitiationResponse> GetBasicAppsHaibaoInitiation();

}
