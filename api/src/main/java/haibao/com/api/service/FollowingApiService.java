package haibao.com.api.service;

import haibao.com.api.data.response.following.FollowingResponse;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 关注
 * groupDescription=<p>我的关注和我的粉丝</p>
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface FollowingApiService {

    /**
     * title=关注某人
     * version=1.1.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-followingGroup-put_following__user_id">关注某人</>
     */
    @PUT("following/{user_id}")
    Observable<Void> PutFollowingUserId(@Path("user_id") final String user_id);

    /**
     * title=取消关注某人
     * version=1.1.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-followingGroup-delete_following__user_id">取消关注某人</>
     */
    @DELETE("following/{user_id}")
    Observable<Void> DeleteFollowingUserId(@Path("user_id") final String user_id);


    /**
     * title=获取我的关注列表
     * version=1.1.0
     *
     * @param page     <p>请求索引页</p>   type= Integer
     * @param per_page <p>每页返回条数</p>   type= Integer
     *                 api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-followingGroup-get_following">获取我的关注列表</>
     */
    @GET("following")
    Observable<FollowingResponse> GetFollowing(@Query("page") Integer page,
                                               @Query("per_page") Integer per_page);


    /**
     * title=获取我的粉丝列表
     * version=1.1.0
     *
     * @param page     <p>请求索引页</p>   type= Integer
     * @param per_page <p>每页返回条数</p>   type= Integer
     *                 api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-followingGroup-get_followers">获取我的粉丝列表</>
     */
    @GET("followers")
    Observable<FollowingResponse> GetFollowers(@Query("page") Integer page,
                                               @Query("per_page") Integer per_page);
}
