package haibao.com.api.service;

import java.util.List;

import haibao.com.api.data.param.offline.DeleteOfflinelistBatchRequestParam;
import haibao.com.api.data.param.offline.OfflinelistRequestParam;
import haibao.com.api.data.response.offline.GetOfflinelistLogResponse;
import haibao.com.api.data.response.offline.OfflinelistResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 离线
 * groupDescription=<p>我的离线相关</p>
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface OfflineApiService {

    /**
     * title=新增离线
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-offlineGroup-post_offlinelist">新增离线</>
     */
    @POST("offlinelist")
    Observable<OfflinelistResponse> PostOfflinelist(@Body OfflinelistRequestParam PostOfflinelistRequestParam);


    /**
     * title=删除离线
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-offlineGroup-delete_offlinelist_batch">删除离线</>
     */
    @HTTP(method = "DELETE", path =  "offlinelist/batch", hasBody = true)
    Observable<Void> DeleteOfflinelistBatch(@Body DeleteOfflinelistBatchRequestParam DeleteOfflinelistBatchRequestParam);



    /**
     * title=同步离线列表
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-offlineGroup-get_offlinelist">同步离线列表</>
     */
    @GET( "offlinelist")
    Observable<List<OfflinelistResponse>> GetOfflinelist(@Query("offline_type") Integer offline_type);


    /**
     * title=获取离线信息
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-offlineGroup-get_offlinelist__offline_id">获取离线信息</>
     */
    @GET( "offlinelist/{offline_id}")
    Observable<OfflinelistResponse> GetOfflinelistOfflineId(@Path("offline_id") final String offline_id);


    /**
     * title=获取离线列表的最后更新时间
     * version=1.1.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-offlineGroup-get_offlinelist_log">获取离线列表的最后更新时间</>
     */
    @GET("offlinelist/latest_update_time")
    Observable<GetOfflinelistLogResponse> GetOfflinelistLog();

}
