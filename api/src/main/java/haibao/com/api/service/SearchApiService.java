package haibao.com.api.service;

import haibao.com.api.data.response.content.BindBooks;
import haibao.com.api.data.response.global.BasePageResponse;
import haibao.com.api.data.response.search.GetClassesCoursesResponse;
import haibao.com.api.data.response.search.GetSearchActivitiesResponse;
import haibao.com.api.data.response.search.GetSearchContentsResponse;
import haibao.com.api.data.response.search.GetSearchGoodsResponse;
import haibao.com.api.data.response.search.GetSearchUsersResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 搜索
 * groupDescription=<p>阅读圈内搜索相关接口</p>
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface SearchApiService {

    /**
     * title=搜索阅读日记
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_search_contents"/>
     *
     * @param q        <p>搜索关键词</p>   type= String   isOptional=false
     * @param page     <p>请求的索引页数</p>   type= Integer   isOptional=false
     * @param per_page <p>每页返回的数据条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("search/contents")
    Observable<GetSearchContentsResponse> GetSearchContents(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=搜索商品
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_search_goods"/>
     *
     * @param q        <p>关键词(商品名称|作者名称)，需要urlencode</p>   type= String   isOptional=false
     * @param page     <p>第几页</p>   type= Integer   isOptional=false
     * @param per_page <p>每页显示多少条</p>   type= Integer   isOptional=true
     */
    @GET("search/goods")
    Observable<GetSearchGoodsResponse> GetSearchGoods(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=搜索活动
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_search_activities"/>
     *
     * @param q        <p>搜索关键词</p>   type= String   isOptional=false
     * @param page     <p>请求分页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>请求的每页数据条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("search/activities")
    Observable<GetSearchActivitiesResponse> GetSearchActivities(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=搜索用户
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_search_users"/>
     *
     * @param q        <p>搜索关键词</p>   type= String   isOptional=false
     * @param page     <p>请求分页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>每页返回的数据条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("search/users")
    Observable<GetSearchUsersResponse> GetSearchUsers(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);


    /**
     * title=搜索图书
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_search_books"/>
     *
     * @param q        <p>搜索关键词</p>   type= String   isOptional=false
     * @param page     <p>请求页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>每页返回的条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("search/books")
    Observable<BasePageResponse<BindBooks>> GetSearchBooks(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);


    /**
     * title=搜索课程
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/search/#api-searchGroup-get_classes_courses"/>
     *
     * @param q        <p>搜索关键词</p>   type= String   isOptional=false
     * @param page     <p>请求页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>每页返回的条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("search/courses")
    Observable<GetClassesCoursesResponse> GetClassesCourses(@Query("q") String q, @Query("page") Integer page, @Query("per_page") Integer per_page);


}
