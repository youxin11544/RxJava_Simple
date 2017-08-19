package haibao.com.api.service;


import haibao.com.api.data.response.article.GetArticleResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API接口方法申明接口类
 * <p>
 * 文章管理包括：大家观点、QA谈等
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface ArticleService {

    /**
     * title = 文章管理 - 获取文章列表
     * version =   1.0.0
     * api url = https://hbapidev.baobaobooks.net/docs/article/#api-articleGroup-get_articles
     *
     * @param type   默认值1，类型：1-大家观点，4-QA谈
     * @param offset 请求的起始索引，默认0
     * @param limit  请求的数据条数，默认10条
     * @return
     */
    @GET("articles")
    Observable<GetArticleResponse> GetArticleByType(@Query("type") int type, @Query("offset") int offset, @Query("limit") int limit);
}
