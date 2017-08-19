package haibao.com.api.service;

import java.util.ArrayList;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
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
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class ContentApiApiWrapper implements ClearWrapper {
  private static ContentApiApiWrapper INSTANCE;

  private static ContentApiService ContentApiService;

  public static ContentApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new ContentApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public ContentApiService getContentApiService() {
    if (ContentApiService==null) {
      ContentApiService=BaseApi.getRetrofit(CommonUrl.ContentApiService_BaseUrl).create(ContentApiService.class);
    }
    return ContentApiService;
  }

  public void clearService() {
    ContentApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteContentsContentId(String content_id) {
    return getContentApiService().DeleteContentsContentId(content_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteContentsContentIdCommentsCommentId(String content_id,
      String comment_id) {
    return getContentApiService().DeleteContentsContentIdCommentsCommentId(content_id,comment_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteContentsContentIdLike(String content_id) {
    return getContentApiService().DeleteContentsContentIdLike(content_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetContentsResponse> GetContents(Integer offset, Integer limit) {
    return getContentApiService().GetContents(offset,limit).compose(BaseApi.<GetContentsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Content> GetContentsContentId(String content_id) {
    return getContentApiService().GetContentsContentId(content_id).compose(BaseApi.<Content>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ContentCommentsResponse> GetContentsContentIdComments(String content_id,
      Integer page, Integer per_page) {
    return getContentApiService().GetContentsContentIdComments(content_id,page,per_page).compose(BaseApi.<ContentCommentsResponse>defaultSchedulers());
  }
  public Observable<BasePageResponse<LastComment>> getSubComments(String content_id,String comment_id,
                                                                                    Integer page, Integer per_page) {
    return getContentApiService().getSubComments(content_id,comment_id,page,per_page).compose(BaseApi.< BasePageResponse<LastComment>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetContentsContentIdLikeUsersResponse> GetContentsContentIdLikeUsers(String content_id,
      Integer offset, Integer limit) {
    return getContentApiService().GetContentsContentIdLikeUsers(content_id,offset,limit).compose(BaseApi.<GetContentsContentIdLikeUsersResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetTopicsTopicIdContentsResponse> GetTopicsTopicIdContents(String topic_id,
      Integer offset, Integer limit) {
    return getContentApiService().GetTopicsTopicIdContents(topic_id,offset,limit).compose(BaseApi.<GetTopicsTopicIdContentsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetUserContentsResponse> GetUserContents(Integer baby_id, String begin_date,
      String end_date, Integer offset, Integer limit) {
    return getContentApiService().GetUserContents(baby_id,begin_date,end_date,offset,limit).compose(BaseApi.<GetUserContentsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetUsersUserIdContentsResponse> GetUsersUserIdContents(String user_id,
      Integer baby_id, Integer offset, Integer limit) {
    return getContentApiService().GetUsersUserIdContents(user_id,baby_id,offset,limit).compose(BaseApi.<GetUsersUserIdContentsResponse>defaultSchedulers());
  }


  /**
   * 此方法由apt自动生成 */
  public Observable<GetContentsResponse> GetBookIsbnIdContents(int isbn_id, Integer offset, Integer limit) {
    return getContentApiService().GetBookIsbnIdContents(isbn_id,offset,limit).compose(BaseApi.<GetContentsResponse>defaultSchedulers());
  }


  /**
   * 此方法由apt自动生成 */
  public Observable<Content> PostContents(PostContentsRequestParam PostContentsRequestParam) {
    return getContentApiService().PostContents(PostContentsRequestParam).compose(BaseApi.<Content>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<LastComment> PostContentsContentIdComments(String content_id,
                                                                                         CommentsRequestParam PostContentsContentIdCommentsRequestParam) {
    return getContentApiService().PostContentsContentIdComments(content_id,PostContentsContentIdCommentsRequestParam).compose(BaseApi.<LastComment>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostContentsImagesResponse> PostContentsImages(MultipartBody multipartBody) {
    return getContentApiService().PostContentsImages(multipartBody).compose(BaseApi.<PostContentsImagesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Content> PutContentsContentId(String content_id,
      PutContentsContentIdRequestParam PutContentsContentIdRequestParam) {
    return getContentApiService().PutContentsContentId(content_id,PutContentsContentIdRequestParam).compose(BaseApi.<Content>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutContentsContentIdLikes(String content_id) {
    return getContentApiService().PutContentsContentIdLikes(content_id).compose(BaseApi.<Void>defaultSchedulers());
  }
  /**
   * 此方法由apt自动生成 */
  public Observable<UploadVideoCover> uploadVideoCover(MultipartBody multipartBody) {
    return getContentApiService().uploadVideoCover(multipartBody).compose(BaseApi.<UploadVideoCover>defaultSchedulers());
  }
}
