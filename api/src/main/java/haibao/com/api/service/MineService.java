//package haibao.com.api.service;
//
//
//
//import haibao.com.api.common.HttpCommon;
//import haibao.com.api.data.response.content.GetUserContentsResponse;
//import haibao.com.api.data.response.global.Share;
//import haibao.com.api.data.response.mineResponse.ATTENTIONS;
//import haibao.com.api.data.response.mineResponse.CONTENTS;
//import haibao.com.api.data.response.mineResponse.FANS;
//import haibao.com.api.data.response.mineResponse.HomapageResponse;
//import retrofit2.http.DELETE;
//import retrofit2.http.GET;
//import retrofit2.http.PUT;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//import rx.Observable;
//
//import static haibao.com.api.common.CommonUrl.AYB_BASE;
//import static haibao.com.api.common.CommonUrl.PATH_SHARE_URL;
//import static haibao.com.api.common.CommonUrl.PATH_USER_BABIES;
//import static haibao.com.api.common.CommonUrl.P_BABIES;
//import static haibao.com.api.common.CommonUrl.P_CONTENTS;
//import static haibao.com.api.common.CommonUrl.P_PROFILE_USER_INFO;
//
//
///**
// * API接口方法申明接口类  这个类 没用了，暂时注释掉
// */
//
////@ApiFactory(
////        packageName = "haibao.com.api"
////)
//public interface MineService {
//
//    /**
//     * 获取当前用户宝宝的学习记录
//     * String url = AYB_USER_BABIES + "/" + baby_id + "/" + P_CONTENTS;
//     */
//    @GET(AYB_BASE + PATH_USER_BABIES + "/{baby_id}/" + P_CONTENTS)
//    Observable<CONTENTS> getCurrentUserBabyRecords(@Path("baby_id") int baby_id, @Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + PATH_USER_BABIES + "/{baby_id}/" + P_CONTENTS)
//    Observable<CONTENTS> getCurrentUserBabyRecords(@Path("baby_id") int baby_id);
//
//
//    /**
//     * 获取分享的shareUrl
//     * String url = AYB_BASE + "sharing/app";;
//     */
//    @GET(AYB_BASE + PATH_SHARE_URL)
//    Observable<Share> getShareAppUrl();
//
//
//
//    /**
//     * 获取分享用户或者用户宝宝的日记或者文章数据
//     * String AYB_SHARING_USER = AYB_BASE + "sharing/user";
//     */
//    @GET(AYB_BASE + "sharing/user")
//    Observable<Share> getShareUserOrBabyArticles(@Query(HttpCommon.KEY_BABY_ID) String baby_id);
//
//    @GET(AYB_BASE + "sharing/user")
//    Observable<Share> getShareUserOrBabyArticles();
//
//
//    /**
//     * 获取当前用户的文章或日记
//     * String AYB_USER_CONTENTS = AYB_BASE + "user/contents";
//     */
//    @GET(AYB_BASE + "user/contents")
//    Observable<GetUserContentsResponse> getCurrentUserArticles(@Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "user/contents")
//    Observable<CONTENTS> getCurrentUserArticles();
//
//
//    /**
//     * 添加关注
//     *  String url = AYB_BASE + "user/following" + "/" + friend_user_id;
//     */
//    @PUT(AYB_BASE +"user/following" + "/{friend_user_id}")
//    Observable<Void> attention(@Path("friend_user_id") String friend_user_id);
//
//
//    /**
//     * 取消关注
//     * String url = AYB_BASE + "user/following" + "/" + friend_user_id;
//     */
//    @DELETE(AYB_BASE + "user/following" + "/{friend_user_id}/")
//    Observable<String> cancelAttention(@Path("friend_user_id") String friend_user_id);
//
//
//    /**
//     * * 获取所有我关注的人
//     * String AYB_USER_FOLLOWING = AYB_BASE + "user/following";
//     */
//    @GET(AYB_BASE + "user/following")
//    Observable<ATTENTIONS> getAttentions(@Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "user/following")
//    Observable<ATTENTIONS> getAttentions();
//
//    /**
//     * * 获取其他人的关注
//     */
//    @GET(AYB_BASE + "users" + "/{user_id}/" + "following")
//    Observable<ATTENTIONS> getOtherAttentions(@Path("user_id") String user_id, @Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "users" + "/{user_id}/" + "following")
//    Observable<ATTENTIONS> getOtherAttentions(@Path("user_id") String user_id);
//
//
//    /**
//     * * 获取其他用户的主页信息
//     * String url = AYB_BASE + "users" + "/" + home_user_id + "/" + P_PROFILE_USER_INFO;
//     */
//    @GET(AYB_BASE + "users" + "/{home_user_id}/" + P_PROFILE_USER_INFO)
//    Observable<HomapageResponse> getUserHomepage(@Path("home_user_id") int home_user_id);
//
//
//    /**
//     * * 获取粉丝
//     *  String AYB_USER_FOLLOWERS = AYB_BASE + "user/followers";
//     */
//    @GET(AYB_BASE + "user/followers")
//    Observable<FANS> getFans(@Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "user/followers")
//    Observable<FANS> getFans();
//
//
//    /**
//     * 获取其他用户宝宝的学习记录（异步）
//     *users/:user_id/babies/:baby_id/contents
//     */
//    @GET(AYB_BASE + "users"+"/{user_id}/"+P_BABIES+"/{baby_id}/"+P_CONTENTS)
//    Observable<CONTENTS> getOtherUserBabyRecords(@Path("user_id") int user_id, @Path("baby_id") int baby_id, @Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "users"+"/{user_id}/"+P_BABIES+"/{baby_id}/"+P_CONTENTS)
//    Observable<CONTENTS> getOtherUserBabyRecords(@Path("user_id") int user_id, @Path("baby_id") int baby_id);
//
//
//    /**
//     * 获取其他用户的所有日记或者文章
//     * users/:user_id/contents
//     */
//    @GET(AYB_BASE + "users"+"/{user_id}/"+P_CONTENTS)
//    Observable<CONTENTS> getOtherUserArticles(@Path("user_id") int user_id, @Query(HttpCommon.KEY_OFFSET) String offset);
//
//    @GET(AYB_BASE + "users"+"/{user_id}/"+P_CONTENTS)
//    Observable<CONTENTS> getOtherUserArticles(@Path("user_id") int user_id);
//
//
//}
