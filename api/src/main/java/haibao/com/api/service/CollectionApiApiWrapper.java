package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.param.collection.DeleteCollectionsBatchRequestParam;
import haibao.com.api.data.param.collection.PostCollectionsRequestParam;
import haibao.com.api.data.response.collection.GetCollectionsContentsResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class CollectionApiApiWrapper implements ClearWrapper {
    private static CollectionApiApiWrapper INSTANCE;

    private static CollectionApiService CollectionApiService;

    public static CollectionApiApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CollectionApiApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public CollectionApiService getCollectionApiService() {
        if (CollectionApiService == null) {
            CollectionApiService = BaseApi.getRetrofit(CommonUrl.CollectionApi_BaseUrl).create(CollectionApiService.class);
        }
        return CollectionApiService;
    }

    public void clearService() {
        CollectionApiService = null;
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteCollectionsBatch(DeleteCollectionsBatchRequestParam DeleteCollectionsBatchRequestParam) {
        return getCollectionApiService().DeleteCollectionsBatch(DeleteCollectionsBatchRequestParam).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetCollectionsContentsResponse> GetCollectionsContents(String q, Integer page,
                                                                             Integer per_page) {
        return getCollectionApiService().GetCollectionsContents(q, page, per_page).compose(BaseApi.<GetCollectionsContentsResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> PostCollections(PostCollectionsRequestParam PostCollectionsRequestParam) {
        return getCollectionApiService().PostCollections(PostCollectionsRequestParam).compose(BaseApi.<Void>defaultSchedulers());
    }
}
