package haibao.com.api.service;

import haibao.com.api.data.param.collection.DeleteCollectionsBatchRequestParam;
import haibao.com.api.data.param.collection.PostCollectionsRequestParam;
import haibao.com.api.data.response.collection.GetCollectionsContentsResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 收藏  
 * groupDescription=<p>我的收藏相关</p>  
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface CollectionApiService {

  /**
   * title=获取日记收藏列表
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-collectionGroup-get_collections_contents">获取日记收藏列表</>
   */
  @GET("collections/contents")
  Observable<GetCollectionsContentsResponse> GetCollectionsContents(@Query("q") String q,
                                                                    @Query("page") Integer page, @Query("per_page") Integer per_page);



  /**
   * title=新增收藏
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-collectionGroup-post_collections">新增收藏</>
   */
  @POST("collections")
  Observable<Void> PostCollections(@Body PostCollectionsRequestParam PostCollectionsRequestParam);


  /**
   * title=删除收藏
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-collectionGroup-delete_collections_batch">删除收藏</>
   */
  @HTTP(method = "DELETE", path = "collections/batch", hasBody = true)
  Observable<Void> DeleteCollectionsBatch(@Body DeleteCollectionsBatchRequestParam DeleteCollectionsBatchRequestParam);

}
