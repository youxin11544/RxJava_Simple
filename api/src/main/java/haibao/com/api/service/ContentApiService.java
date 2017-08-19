package haibao.com.api.service;

import haibao.com.api.data.param.content.CommentsRequestParam;
import haibao.com.api.data.param.content.PostContentsRequestParam;
import haibao.com.api.data.param.content.PutContentsContentIdRequestParam;
import haibao.com.api.data.response.content.ContentCommentsResponse;
import haibao.com.api.data.response.content.GetContentsContentIdLikeUsersResponse;
import haibao.com.api.data.response.content.GetContentsResponse;
import haibao.com.api.data.response.content.GetTopicsTopicIdContentsResponse;
import haibao.com.api.data.response.content.GetUserContentsResponse;
import haibao.com.api.data.response.content.GetUsersUserIdContentsResponse;
import haibao.com.api.data.response.content.PostContentsImagesResponse;
import haibao.com.api.data.response.global.BasePageResponse;
import haibao.com.api.data.response.global.Content;
import haibao.com.api.data.response.school.LastComment;
import haibao.com.api.data.response.school.UploadVideoCover;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 阅读日记
 * groupDescription=<p>日记内容相关,包括点赞、评论等</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface ContentApiService {

    /**
     * title=阅读日记 - 获取阅读日记动态
     * version= 1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_contents>获取阅读日记动态</>
     *
     * @param offset <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit  <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("contents")
    Observable<GetContentsResponse> GetContents(@Query("offset") Integer offset,
                                                @Query("limit") Integer limit);


    /**
     * title=阅读日记 - 获取某话题的日记列表
     * version= 1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_topics__topic_id_contents>获取某话题的日记列表</>
     *
     * @param offset <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit  <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("topics/{topic_id}/contents")
    Observable<GetTopicsTopicIdContentsResponse> GetTopicsTopicIdContents(@Path("topic_id") final String topic_id,
                                                                          @Query("offset") Integer offset, @Query("limit") Integer limit);


    /**
     * title=contentGroup - 获取某个用户的公开日记
     * version=1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_users__user_id_contents>获取某个用户的公开日记</>
     *
     * @param baby_id <p>用户的宝宝id</p>   type= Integer   isOptional=true
     * @param offset  <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit   <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("users/{user_id}/contents")
    Observable<GetUsersUserIdContentsResponse> GetUsersUserIdContents(@Path("user_id") String user_id,
                                                                      @Query("baby_id") Integer baby_id, @Query("offset") Integer offset,
                                                                      @Query("limit") Integer limit);

    /**
     * title=contentGroup - 获取某书籍阅读日记(新增接口2017.7.20)
     * version= 1.0.0
     * api url = <a href ="https://apidev.haibaotown.net/docs/content/#api-contentGroup-get_books__isbn_id_contents>获取某个用户的公开日记</>
     */
    @GET("books/{isbn_id}/contents")
    Observable<GetContentsResponse> GetBookIsbnIdContents(@Path("isbn_id") int isbn_id, @Query("offset") Integer offset,
                                                                      @Query("limit") Integer limit);


    /**
     * title=contentGroup - 获取我的日记
     * version= 1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_user_contents>获取我的日记</>
     *
     * @param baby_id    <p>用户的宝宝id，即获取某个宝宝下的日记时传入</p>   type= Integer   isOptional=true
     * @param begin_date <p>查询开始日期</p>   type= String   isOptional=true
     * @param end_date   <p>查询结束日期，结束日期必须大于开始日期，只传入一个时，默认为查询该日期的日记</p>   type= String   isOptional=true
     * @param offset     <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit      <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("user/contents")
    Observable<GetUserContentsResponse> GetUserContents(@Query("baby_id") Integer baby_id,
                                                        @Query("begin_date") String begin_date, @Query("end_date") String end_date,
                                                        @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**
     * title=contentGroup - 发表日记
     * version=1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-post_contents>发表日记</>
     *
     * @param PostContentsRequestParam 自动生成的Body
     */
    @POST("contents")
    Observable<Content> PostContents(@Body PostContentsRequestParam PostContentsRequestParam);

    /**
     * title=阅读日记 - 上传日记图片
     * version=1.0.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-post_contents_images">上传日记图片</>
     */
    @POST("contents/images")
    Observable<PostContentsImagesResponse> PostContentsImages(@Body MultipartBody multipartBody);


    /**
     * title=阅读日记 - 上传日记封面图
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-post_contents_cover">上传日记封面图</>
     */
    @POST("contents/cover")
    Observable<UploadVideoCover> uploadVideoCover(@Body MultipartBody multipartBody);

    /**
     * title=修改日记
     * version=1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-put_contents__content_id">修改日记</>
     *
     * @param PutContentsContentIdRequestParam 自动生成的Body
     */
    @PUT("contents/{content_id}")
    Observable<Content> PutContentsContentId(@Path("content_id") final String content_id,
                                             @Body PutContentsContentIdRequestParam PutContentsContentIdRequestParam);

    /**
     * title=阅读日记 - 删除日记
     * version=     1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-delete_contents__content_id">删除日记</>
     */
    @DELETE("contents/{content_id}")
    Observable<Void> DeleteContentsContentId(@Path("content_id") final String content_id);


    /**
     * title=contentGroup - 获取日记详情
     * version= 1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_contents__content_id">获取日记详情</>
     */
    @GET("contents/{content_id}")
    Observable<Content> GetContentsContentId(@Path("content_id") final String content_id);

    /**
     * title=阅读日记 - 获取点赞用户列表
     * version=1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_contents__content_id_like_users">获取点赞用户列表</>
     *
     * @param offset <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit  <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("contents/{content_id}/likes/users")
    Observable<GetContentsContentIdLikeUsersResponse> GetContentsContentIdLikeUsers(@Path("content_id") final String content_id,
                                                                                    @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**
     * title=阅读日记 - 点赞日记
     * version=   1.0.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-put_contents__content_id_likes">点赞日记</>
     */
    @PUT("contents/{content_id}/likes")
    Observable<Void> PutContentsContentIdLikes(@Path("content_id") final String content_id);

    /**
     * title=阅读日记 - 取消点赞
     * version=  1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-delete_contents__content_id_like">取消点赞</>
     */
    @DELETE("contents/{content_id}/likes")
    Observable<Void> DeleteContentsContentIdLike(@Path("content_id") final String content_id);


    /**
     * title=阅读日记 - 获取评论列表
     * version=1.0.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_contents__content_id_comments">获取评论列表</>
     * <p>
     * <p>
     * 请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * 请求的数据条数，默认10条</p>   type= Integer   isOptional=true   Integer page, Integer per_page
     */
    @GET("contents/{content_id}/comments")
    Observable<ContentCommentsResponse> GetContentsContentIdComments(@Path("content_id") final String content_id,
                                                                     @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=阅读日记 - 评论日记
     * version=1.0.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-post_contents__content_id_comments">评论日记</>
     *
     * @param PostContentsContentIdCommentsRequestParam 自动生成的Body
     */
    @POST("contents/{content_id}/comments")
    Observable<LastComment> PostContentsContentIdComments(@Path("content_id") final String content_id,
                                                          @Body CommentsRequestParam PostContentsContentIdCommentsRequestParam);

    /**
     * title=阅读日记 - 删除评论
     * version=1.0.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-delete_contents__content_id_comments__comment_id">删除评论</>
     */
    @DELETE("contents/{content_id}/comments/{comment_id}")
    Observable<Void> DeleteContentsContentIdCommentsCommentId(@Path("content_id") final String content_id,
                                                              @Path("comment_id") final String comment_id);


    /**
     * title=阅读日记 - 获取子评论列表
     * version=1.1.0
     * api url = <a href ="https://hbapidev.baobaobooks.net/docs/content/#api-contentGroup-get_contents__content_id_subcomments__comment_id">获取子评论列表</>
     *
     * @param content_id
     * @param comment_id
     * @param page
     * @param per_page
     * @return
     */
    @GET("contents/{content_id}/comments/{comment_id}/subcomments")
    Observable<BasePageResponse<LastComment>> getSubComments(@Path("content_id") final String content_id,
                                                                 @Path("comment_id") final String comment_id,
                                                                 @Query("page") Integer page, @Query("per_page") Integer per_page);


}
