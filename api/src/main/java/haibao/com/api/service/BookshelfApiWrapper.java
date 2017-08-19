package haibao.com.api.service;

import java.util.ArrayList;
import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.common.CommonUrl;
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
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class BookshelfApiWrapper implements BaseApi.ClearWrapper {
    private static BookshelfApiWrapper INSTANCE;

    private static BookshelfService BookshelfService;

    public static BookshelfApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookshelfApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public BookshelfService getBookshelfService() {
        if (BookshelfService == null) {
            BookshelfService = BaseApi.getRetrofit(CommonUrl.BookshelfService_BaseUrl).create(BookshelfService.class);
        }
        return BookshelfService;
    }

    public void clearService() {
        BookshelfService = null;
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetBookshelfResponse> getBookShelf(Integer page, Integer per_page) {
        return getBookshelfService().getBookShelf(page, per_page).compose(BaseApi.<haibao.com.api.data.response.bookShelfResponse.GetBookshelfResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<BookShelfSearchResponse> searchBookShelfByQKey(String q, Integer page, Integer per_page) {
        return getBookshelfService().searchBookShelfByQKey(q, page, per_page).compose(BaseApi.<haibao.com.api.data.response.bookShelfResponse.BookShelfSearchResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> addToBookShelf(AddBookParam addBookParam) {
        return getBookshelfService().addToBookShelf(addBookParam).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<ArrayList<Book>> scanBookByIsbn(long isbn) {
        return getBookshelfService().scanBookByIsbn(isbn).compose(BaseApi.<ArrayList<Book>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<ArrayList<Book>> scanBookByChannelId(long channel_id) {
        return getBookshelfService().scanBookByChannelId(channel_id).compose(BaseApi.<ArrayList<Book>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<BookInfoResponse> getBookInfoByIsbnId(long isbn_id) {
        return getBookshelfService().getBookInfoByIsbnId(isbn_id).compose(BaseApi.<BookInfoResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<Resource>> getAudiosByBookIsbn(int isbn_id) {
        return getBookshelfService().getAudiosByBookIsbn(isbn_id).compose(BaseApi.<java.util.List<haibao.com.api.data.response.global.Resource>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<Resource>> getVideosByBookIsbn(int isbn_id) {
        return getBookshelfService().getVideosByBookIsbn(isbn_id).compose(BaseApi.<java.util.List<haibao.com.api.data.response.global.Resource>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<BookShelfCourses>> getCoursesByBookIsbn(int isbn_id) {
        return getBookshelfService().getCoursesByBookIsbn(isbn_id).compose(BaseApi.<java.util.List<BookShelfCourses>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteArchivesArchiveId(String archive_id) {
        return getBookshelfService().DeleteArchivesArchiveId(archive_id).compose(BaseApi.<java.lang.Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteArchivesArchiveIdGoodsBatch(String archive_id,
                                                              DeleteArchivesArchiveIdGoodsBatchRequestParam DeleteArchivesArchiveIdGoodsBatchRequestParam) {
        return getBookshelfService().DeleteArchivesArchiveIdGoodsBatch(archive_id, DeleteArchivesArchiveIdGoodsBatchRequestParam).compose(BaseApi.<java.lang.Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<GetArchivesResponse>> GetArchives() {
        return getBookshelfService().GetArchives().compose(BaseApi.<java.util.List<haibao.com.api.data.response.bookShelfResponse.GetArchivesResponse>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<Book>> GetArchivesArchiveIdGoods(String archive_id) {
        return getBookshelfService().GetArchivesArchiveIdGoods(archive_id).compose(BaseApi.<java.util.List<haibao.com.api.data.response.bookShelfResponse.Book>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<PostArchivesResponse> PostArchives(PostArchivesRequestParam PostArchivesRequestParam) {
        return getBookshelfService().PostArchives(PostArchivesRequestParam).compose(BaseApi.<haibao.com.api.data.response.bookShelfResponse.PostArchivesResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> PostArchivesArchiveIdGoods(String archive_id,
                                                       PostArchivesArchiveIdGoodsRequestParam PostArchivesArchiveIdGoodsRequestParam) {
        return getBookshelfService().PostArchivesArchiveIdGoods(archive_id, PostArchivesArchiveIdGoodsRequestParam).compose(BaseApi.<java.lang.Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<PutArchivesArchiveIdResponse> PutArchivesArchiveId(String archive_id,
                                                                         PutArchivesArchiveIdRequestParam PutArchivesArchiveIdRequestParam) {
        return getBookshelfService().PutArchivesArchiveId(archive_id, PutArchivesArchiveIdRequestParam).compose(BaseApi.<haibao.com.api.data.response.bookShelfResponse.PutArchivesArchiveIdResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<ReadShareResponse>> GetBooksIsbnIdContents(String isbn_id) {
        return getBookshelfService().GetBooksIsbnIdContents(isbn_id).compose(BaseApi.<java.util.List<haibao.com.api.data.response.bookShelfResponse.ReadShareResponse>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteGoodsBatch(DeleteGoodsBatchRequestParam DeleteGoodsBatchRequestParam) {
        return getBookshelfService().DeleteGoodsBatch(DeleteGoodsBatchRequestParam).compose(BaseApi.<java.lang.Void>defaultSchedulers());
    }

    public Observable<ArrayList<RecommendedBook>> getRecommended() {
        return getBookshelfService().getRecommended().compose(BaseApi.<ArrayList<RecommendedBook>>defaultSchedulers());
    }
    public Observable<ArrayList<PlayListBean>> getPlayList() {
        return getBookshelfService().getPlayList().compose(BaseApi.<ArrayList<PlayListBean>>defaultSchedulers());
    }
    public Observable<PlayListCoverResponse> updataPlaylistCover(MultipartBody multipartBody) {
        return getBookshelfService().updataPlaylistCover(multipartBody).compose(BaseApi.<PlayListCoverResponse>defaultSchedulers());
    }
    public Observable<PlayListBean> createPlayList(CreateEditPlayListParam param) {
        return getBookshelfService().createPlayList(param).compose(BaseApi.<PlayListBean>defaultSchedulers());
    }
    public Observable<ArrayList<Resource>> addAudioToPlayList(String playlist_id,AddAudioToPlaylistParam param) {
        return getBookshelfService().addAudioToPlayList(playlist_id,param).compose(BaseApi.<ArrayList<Resource>>defaultSchedulers());
    }
    public Observable<PlayListBean> editPlayList( String playlist_id,CreateEditPlayListParam param) {
        return getBookshelfService().editPlayList(playlist_id,param).compose(BaseApi.<PlayListBean>defaultSchedulers());
    }
    public Observable<PlayListBean> getPlayListAudios(String playlist_id) {
        return getBookshelfService().getPlayListAudios(playlist_id).compose(BaseApi.<PlayListBean>defaultSchedulers());
    }
    public Observable<Void> deletePlayList(String playlist_id) {
        return getBookshelfService().deletePlayList(playlist_id).compose(BaseApi.<Void>defaultSchedulers());
    }
    public Observable<List<Resource>> setPlayListOrder(String playlist_id, ArrayList<PlayListOrderParam> listOrderParams) {
        return getBookshelfService().setPlayListOrder(playlist_id,listOrderParams).compose(BaseApi.<List<Resource>>defaultSchedulers());
    }
    public Observable<Void> removeAudioFromPlayList(String playlist_id, RemoveAudioParam param) {
        return getBookshelfService().removeAudioFromPlayList(playlist_id,param).compose(BaseApi.<Void>defaultSchedulers());
    }
    public Observable<ArrayList<TopicsHotBean>> getTopicsHot( String isbn_id) {
        return getBookshelfService().getTopicsHot(isbn_id).compose(BaseApi.<ArrayList<TopicsHotBean>>defaultSchedulers());
    }
    public Observable<Void> emptyPlayList( String playlist_id) {
        return getBookshelfService().emptyPlayList(playlist_id).compose(BaseApi.<Void>defaultSchedulers());
    }

    public Observable<Void> updataRecord(UpdataRecordParam param) {
        return getBookshelfService().updataRecord(param).compose(BaseApi.<Void>defaultSchedulers());
    }




}
