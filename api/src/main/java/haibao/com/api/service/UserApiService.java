package haibao.com.api.service;

import haibao.com.api.data.response.user.GetSharingAppResponse;
import haibao.com.api.data.response.user.GetSharingUserResponse;
import haibao.com.api.data.response.user.GetUsersUserIdResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 用户信息相关
 * groupDescription=<p>用户基础配置信息相关</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface UserApiService {
//
//    /**
//     * title=获取用户背景图
//     * version =  1.0.0
//     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/user/#api-userGroup-get_apps_haibao_user_covers">获取用户背景图</>
//     */
//    @GET( "apps/haibao/user/covers")
//    Observable<GetAppsHaibaoUserCoversResponse> GetAppsHaibaoUserCovers();

    /**
     * title=获取其他用户信息
     * version =   1.1.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/user/#api-userGroup-get_users__user_id">获取其他用户信息</>
     */
    @GET("users/{user_id}")
    Observable<GetUsersUserIdResponse> GetUsersUserId(@Path("user_id") final String user_id);


    /**
     * title=分享app
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/user/#api-userGroup-get_apps__client_type_sharing">分享app</>
     */
    @GET( "apps/{client_type}/sharing")
    Observable<GetSharingAppResponse> GetSharingApp(@Path("client_type") String client_type);

    /**
     * title=分享用户主页
     * version =  1.0.0
     * api url =<a href ="https://hbapidev.baobaobooks.net/docs/user/#api-userGroup-get_user_sharing">分享用户主页</>
     */
    @GET("user/sharing")
    Observable<GetSharingUserResponse> GetSharingUser(@Query("baby_id") Integer baby_id);
}
