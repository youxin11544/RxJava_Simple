package haibao.com.api.service;


import java.util.ArrayList;
import java.util.List;

import haibao.com.api.data.param.bookshelf.AddAudioToPlaylistParam;
import haibao.com.api.data.param.bookshelf.AddBookParam;
import haibao.com.api.data.param.bookshelf.CreateEditPlayListParam;
import haibao.com.api.data.param.bookshelf.DeleteArchivesArchiveIdGoodsBatchRequestParam;
import haibao.com.api.data.param.bookshelf.DeleteGoodsBatchRequestParam;
import haibao.com.api.data.param.bookshelf.PlayListOrderParam;
import haibao.com.api.data.param.bookshelf.PostArchivesArchiveIdGoodsRequestParam;
import haibao.com.api.data.param.bookshelf.PostArchivesRequestParam;
import haibao.com.api.data.param.bookshelf.PutArchivesArchiveIdRequestParam;
import haibao.com.api.data.param.bookshelf.RemoveAudioParam;
import haibao.com.api.data.param.bookshelf.UpdataRecordParam;
import haibao.com.api.data.response.bookShelfResponse.Book;
import haibao.com.api.data.response.bookShelfResponse.BookInfoResponse;
import haibao.com.api.data.response.bookShelfResponse.BookShelfCourses;
import haibao.com.api.data.response.bookShelfResponse.BookShelfSearchResponse;
import haibao.com.api.data.response.bookShelfResponse.GetArchivesResponse;
import haibao.com.api.data.response.bookShelfResponse.GetBookshelfResponse;
import haibao.com.api.data.response.bookShelfResponse.PlayListBean;
import haibao.com.api.data.response.bookShelfResponse.PlayListCoverResponse;
import haibao.com.api.data.response.bookShelfResponse.PostArchivesResponse;
import haibao.com.api.data.response.bookShelfResponse.PutArchivesArchiveIdResponse;
import haibao.com.api.data.response.bookShelfResponse.ReadShareResponse;
import haibao.com.api.data.response.bookShelfResponse.RecommendedBook;
import haibao.com.api.data.response.bookShelfResponse.TopicsHotBean;
import haibao.com.api.data.response.global.Resource;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * API接口方法申明接口类
 * 具体的使用请见ApiWrapper
 * {@link }
 */

//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface BookshelfService {


    /**
     * title=扫码请求（扫描成功后的信息）书架 - 扫码请求
     * version =  1.1.0
     * api url= <a href="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_scan"></>
     */
    @GET("scan")
    Observable<ArrayList<Book>> scanBookByIsbn(@Query("isbn") long isbn);


    /**
     * title=扫码请求（扫描成功后的信息）
     * version =  1.1.0
     * api url= <a href="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_scan"></>
     *
     * @param channel_id 扫码成功后由客户端获取(可选)
     */
    @GET("scan")
    Observable<ArrayList<Book>> scanBookByChannelId(@Query("channel_id") long channel_id);


    /**
     * title= 添加到书架
     * version =  1.0.0
     *
     * @param addBookParam 添加的goodsId
     *                     api url=https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-post_goods
     */
    @POST("goods")
    Observable<Void> addToBookShelf(@Body AddBookParam addBookParam);


    /**
     * title=从书架移除
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-delete_goods_batch">从书架移除</>
     */
    @HTTP(method = "DELETE", path = "goods/batch", hasBody = true)
    Observable<Void> DeleteGoodsBatch(@Body DeleteGoodsBatchRequestParam DeleteGoodsBatchRequestParam);


    /**
     * title=新增分组
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-post_archives">新增分组</>
     */
    @POST("archives")
    Observable<PostArchivesResponse> PostArchives(@Body PostArchivesRequestParam PostArchivesRequestParam);


    /**
     * title=编辑分组
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-put_archives__archive_id">编辑分组</>
     */
    @PUT("archives/{archive_id}")
    Observable<PutArchivesArchiveIdResponse> PutArchivesArchiveId(@Path("archive_id") final String archive_id,
                                                                  @Body PutArchivesArchiveIdRequestParam PutArchivesArchiveIdRequestParam);


    /**
     * title=删除分组
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-delete_archives__archive_id">删除分组</>
     */
    @DELETE("archives/{archive_id}")
    Observable<Void> DeleteArchivesArchiveId(@Path("archive_id") final String archive_id);


    /**
     * title=移入分组
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-post_archives__archive_id_goods">移入分组</>
     */
    @POST("archives/{archive_id}/goods")
    Observable<Void> PostArchivesArchiveIdGoods(@Path("archive_id") final String archive_id,
                                                @Body PostArchivesArchiveIdGoodsRequestParam PostArchivesArchiveIdGoodsRequestParam);


    /**
     * title=移出分组
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-delete_archives__archive_id_goods_batch">移出分组</>
     */
    @HTTP(method = "DELETE", path = "archives/{archive_id}/goods/batch", hasBody = true)
    Observable<Void> DeleteArchivesArchiveIdGoodsBatch(@Path("archive_id") final String archive_id,
                                                       @Body DeleteArchivesArchiveIdGoodsBatchRequestParam DeleteArchivesArchiveIdGoodsBatchRequestParam);

    /**
     * title=获取所有分组
     * version =  1.1.0
     * api url =<a href ="https://https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_archives">获取所有分组</>
     */
    @GET("archives")
    Observable<List<GetArchivesResponse>> GetArchives();

    /**
     * title=书架 - 获取分组内图书
     * version =    1.1.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_archives__archive_id_goods">获取分组内图书</>
     */
    @GET("archives/{archive_id}/goods")
    Observable<List<Book>> GetArchivesArchiveIdGoods(@Path("archive_id") final String archive_id);

    /**
     * title=书架 - 获取书架图书列表
     * version =  1.1.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_bookshelf">获取书架图书列表</>
     */
    @GET("bookshelf")
    Observable<GetBookshelfResponse> getBookShelf(@Query("page") Integer page, @Query("per_page") Integer per_page);


    /**
     * title=书架 - 书架搜索
     * version =   1.1.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_search_bookshelf">书架搜索</>
     */
    @GET("search/bookshelf")
    Observable<BookShelfSearchResponse> searchBookShelfByQKey(@Query("q") String q, @Query("page") Integer page,
                                                              @Query("per_page") Integer per_page);

    /**
     * title=书架 - 获取图书详情
     * version =  1.1.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_books__isbn_id">获取图书详情</>
     */
    @GET("books" + "/{isbn}")
    Observable<BookInfoResponse> getBookInfoByIsbnId(@Path("isbn") long isbn_id);

    /**
     * title=获取图书的读者分享
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_books__isbn_id_contents">获取图书的读者分享</>
     */
    @GET("books/{isbn_id}/contents")
    Observable<List<ReadShareResponse>> GetBooksIsbnIdContents(@Path("isbn_id") final String isbn_id);

    /**
     * title= 获取图书的音频资源列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_books__isbn_id_audios">获取图书的音频资源列表</>
     */
    @GET("books" + "/{isbn}/audios")
    Observable<List<Resource>> getAudiosByBookIsbn(@Path("isbn") int isbn_id);


    /**
     * title=  获取图书的视频资源列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_books__isbn_id_videos">获取图书的音频资源列表</>
     */
    @GET("books" + "/{isbn}/videos")
    Observable<List<Resource>> getVideosByBookIsbn(@Path("isbn") int isbn_id);


    /**
     * title=获取图书的课程列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-get_books__isbn_id_courses">获取图书的课程列表</>
     */
    @GET("books" + "/{isbn}/courses")
    Observable<List<BookShelfCourses>> getCoursesByBookIsbn(@Path("isbn") int isbn_id);

    /**
     * title= 获取推荐阅读书籍列表
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-bookshelfGroup-get_books_recommended">获取推荐阅读书籍列表</>
     */
    @GET("books/recommended")
    Observable<ArrayList<RecommendedBook>> getRecommended();

    /**
     * title=  获取图书热门话题列表
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-bookGroup-get_books__isbn_id_topics_hot">获取图书热门话题列表</>
     */
    @GET("books/{isbn_id}/topics/hot")
    Observable<ArrayList<TopicsHotBean>> getTopicsHot(@Path("isbn_id") final String isbn_id);

    /**
     * title= 播放列表 - 获取我的播放列表
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-get_playlists">获取我的播放列表</>
     */
    @GET("playlists")
    Observable<ArrayList<PlayListBean>> getPlayList();

    /**
     * title= 上传播放列表cover
     * version=1.0.0
     * api url = <a href="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-post_playlists_cover">上传播放列表cover</>
     */
    @POST("playlists/cover")
    Observable<PlayListCoverResponse> updataPlaylistCover(@Body MultipartBody multipartBody);

    /**
     * title=新增播放列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-put_archives__archive_id">新增播放列表</>
     */
    @POST("playlists")
    Observable<PlayListBean> createPlayList(@Body CreateEditPlayListParam param);
    /**
     * title=音频加入播放列表
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-post_playlists__playlist_id_audios">音频加入播放列表</>
     */
    @POST("playlists/{playlist_id}/audios")
    Observable<ArrayList<Resource>> addAudioToPlayList(@Path("playlist_id")  String playlist_id, @Body AddAudioToPlaylistParam param);
    /**
     * title=编辑播放列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-put_archives__archive_id">编辑播放列表</>
     */
    @PUT("playlists/{playlist_id}")
    Observable<PlayListBean> editPlayList(@Path("playlist_id")  String playlist_id,@Body CreateEditPlayListParam param);

    /**
     * title=获取播放列表音频列表
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/bookshelf/#api-bookshelfGroup-put_archives__archive_id">新增播放列表</>
     */
    @GET("playlists/{playlist_id}/audios")
    Observable<PlayListBean> getPlayListAudios(@Path("playlist_id") String playlist_id);

    /**
     * title= 删除播放列表
     * version=1.0.0
     * api url = <a href="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-delete_playlists__playlist_id">删除播放列表
     * </>
     */
    @DELETE("playlists/{playlist_id}")
    Observable<Void> deletePlayList(@Path("playlist_id") final String playlist_id);

    /**
     * title=设置播放列表音频排序
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-put_playlists__playlist_id_audios">设置播放列表音频排序
     * </>
     */
    @PUT("playlists/{playlist_id}/audios")
    Observable<List<Resource>> setPlayListOrder(@Path("playlist_id") final String playlist_id, @Body ArrayList<PlayListOrderParam> listOrderParams);

    /**
     * title=从播放列表中移除音频
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-put_playlists__playlist_id_audios">从播放列表中移除音频
     * </>
     */
    @HTTP(method = "DELETE", path = "playlists/{playlist_id}/audios/batch", hasBody = true)
    Observable<Void> removeAudioFromPlayList(@Path("playlist_id") final String playlist_id, @Body RemoveAudioParam param);

    /**
     * title=清空播放列表
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-playlistGroup-put_playlists__playlist_id_audios">清空播放列表
     * </>
     */
    @DELETE("playlists/{playlist_id}/audios")
    Observable<Void> emptyPlayList(@Path("playlist_id") final String playlist_id);

    /**
     * title=更新阅读记录
     * version =  1.0.0
     * api url =<a href ="https://apidev.haibaotown.net/docs/bookshelf/#api-bookGroup-put_books_record">更新阅读记录
     * </>
     */
    @PUT("books/record")
    Observable<Void> updataRecord(@Body UpdataRecordParam param);
}
