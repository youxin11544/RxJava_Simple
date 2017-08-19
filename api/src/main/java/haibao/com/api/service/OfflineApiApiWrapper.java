package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.param.offline.DeleteOfflinelistBatchRequestParam;
import haibao.com.api.data.param.offline.OfflinelistRequestParam;
import haibao.com.api.data.response.offline.GetOfflinelistLogResponse;
import haibao.com.api.data.response.offline.OfflinelistResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class OfflineApiApiWrapper implements ClearWrapper {
    private static OfflineApiApiWrapper INSTANCE;

    private static OfflineApiService OfflineApiService;

    public static OfflineApiApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OfflineApiApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public OfflineApiService getOfflineApiService() {
        if (OfflineApiService == null) {
            OfflineApiService = BaseApi.getRetrofit(CommonUrl.OfflineApiService_BaseUrl).create(OfflineApiService.class);
        }
        return OfflineApiService;
    }

    public void clearService() {
        OfflineApiService = null;
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteOfflinelistBatch(DeleteOfflinelistBatchRequestParam DeleteOfflinelistBatchRequestParam) {
        return getOfflineApiService().DeleteOfflinelistBatch(DeleteOfflinelistBatchRequestParam).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<OfflinelistResponse>> GetOfflinelist(Integer offline_type) {
        return getOfflineApiService().GetOfflinelist(offline_type).compose(BaseApi.<List<OfflinelistResponse>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<OfflinelistResponse> GetOfflinelistOfflineId(String offline_id) {
        return getOfflineApiService().GetOfflinelistOfflineId(offline_id).compose(BaseApi.<OfflinelistResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetOfflinelistLogResponse> GetOfflinelistLog() {
        return getOfflineApiService().GetOfflinelistLog().compose(BaseApi.<GetOfflinelistLogResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<OfflinelistResponse> PostOfflinelist(OfflinelistRequestParam PostOfflinelistRequestParam) {
        return getOfflineApiService().PostOfflinelist(PostOfflinelistRequestParam).compose(BaseApi.<OfflinelistResponse>defaultSchedulers());
    }
}
