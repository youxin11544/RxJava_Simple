package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.data.response.article.GetArticleResponse;
import rx.Observable;

import static haibao.com.api.common.CommonUrl.ArticleService_BaseUrl;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class ArticleApiWrapper implements ClearWrapper {
    private static ArticleApiWrapper INSTANCE;

    private static ArticleService ArticleService;

    public static ArticleApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ArticleApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public ArticleService getArticleService() {
        if (ArticleService == null) {
            ArticleService = BaseApi.getRetrofit(ArticleService_BaseUrl).create(ArticleService.class);
        }
        return ArticleService;
    }

    public void clearService() {
        ArticleService = null;
    }

    public Observable<GetArticleResponse> GetArticleByType(int type, int offset, int limit) {
        return getArticleService().GetArticleByType(type, offset, limit).compose(BaseApi.<GetArticleResponse>defaultSchedulers());
    }

}
