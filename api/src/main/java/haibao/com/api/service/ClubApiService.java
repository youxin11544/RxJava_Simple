package haibao.com.api.service;

import java.util.List;

import haibao.com.api.common.ReaderclubCommon;
import haibao.com.api.data.param.club.PostClubsRequestParam;
import haibao.com.api.data.param.club.PutClubsClubIdMessagesUnreadRequestParam;
import haibao.com.api.data.param.club.PutClubsClubIdRequestParam;
import haibao.com.api.data.response.club.GetClubsClubIdMessagesUnreadNumberResponse;
import haibao.com.api.data.response.club.GetClubsClubIdProfileResponse;
import haibao.com.api.data.response.club.GetClubsClubIdResponse;
import haibao.com.api.data.response.club.GetClubsClubIdStatisticsBriefResponse;
import haibao.com.api.data.response.club.GetClubsClubIdUsersResponse;
import haibao.com.api.data.response.club.GetClubsRecommendedResponse;
import haibao.com.api.data.response.club.PostClubsResponse;
import haibao.com.api.data.response.club.PutClubsClubIdMessagesUnreadResponse;
import haibao.com.api.data.response.club.PutClubsClubIdResponse;
import haibao.com.api.data.response.user.GetPromoterResponse;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 圈子信息
 * groupDescription=<p>阅读圈圈子基础信息</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface ClubApiService {
    /**
     * url= /clubs/:club_id/users/:user_id
     * title=申请退出圈子
     * name=delete_clubs__club_id_users__user_id
     * group=clubGroup
     * version=1.0.0
     * description=<p>申请退出圈子</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @DELETE(ReaderclubCommon._BASE + "clubs/{club_id}/users/{user_id}")
    Observable<Void> DeleteClubsClubIdUsersUserId(@Path("club_id") final String club_id,
                                                  @Path("user_id") final String user_id);

    /**
     * url= /clubs/:club_id
     * title=获取圈子信息
     * name=get_clubs__club_id
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取圈子信息，包括圈子的阅读家庭等数据，该接口用于阅读圈首页和圈子信息页，返回的阅读家庭中，第一个始终为圈主，故在首页显示时，若返回的列表超过5个，则从第二个开始取。</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @GET(ReaderclubCommon._BASE + "clubs/{club_id}")
    Observable<GetClubsClubIdResponse> GetClubsClubId(@Path("club_id") final String club_id);

    /**
     * url= /clubs/:club_id/messages/unread/number?last_timestamp=*
     * title=获取用户在圈子的未读消息
     * name=get_clubs__club_id_messages_unread_number
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取用户在圈子的未读消息</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     *
     * @param last_timestamp <p>上次请求的时间戳，Unix时间</p>   type= Integer   isOptional=false
     */
    @GET(ReaderclubCommon._BASE + "clubs/{club_id}/messages/unread/number")
    Observable<GetClubsClubIdMessagesUnreadNumberResponse> GetClubsClubIdMessagesUnreadNumber(@Path("club_id") final String club_id,
                                                                                              @Query("last_timestamp") Integer last_timestamp);

    /**
     * url= /clubs/:club_id/profile
     * title=获取圈子主页
     * name=get_clubs__club_id_profile
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取圈子主页信息，包括圈子的阅读家庭等数据，该接口用于阅读圈首页和圈子信息页，返回的阅读家庭中，第一个始终为圈主，故在首页显示时，若返回的列表超过5个，则从第二个开始取。</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @GET(ReaderclubCommon._BASE + "clubs/{club_id}/profile")
    Observable<GetClubsClubIdProfileResponse> GetClubsClubIdProfile(@Path("club_id") final String club_id);

    /**
     * url= /clubs/:club_id/statistics/brief
     * title=获取圈子简要统计
     * name=get_clubs__club_id_statistics_brief
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取圈子简要统计，包括阅读圈阅读家庭统计和阅读日记统计</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @GET(ReaderclubCommon._BASE + "clubs/{club_id}/statistics/brief")
    Observable<GetClubsClubIdStatisticsBriefResponse> GetClubsClubIdStatisticsBrief(@Path("club_id") final String club_id);


    /**
     * url= /clubs/:club_id/users?q=*&group_id=*&class_id=*&offset=*&limit=*
     * title=获取圈子阅读家庭列表
     * name=get_clubs__club_id_users
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取圈子阅读家庭列表</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     *
     * @param q        <p>查询关键字，用于搜索</p>   type= String   isOptional=true
     * @param group_id <p>群id,用于判断圈子成员是否加入该群</p>   type= Integer   isOptional=true
     * @param class_id <p>班级id,用于判断圈子成员是否加入该班级,班级id和群id互斥,只能传入其中一个,两个同时传入时不做任何处理</p>   type= Integer   isOptional=true
     * @param page     请求分页索引，默认1
     * @param per_page 每页返回的数据条数，默认10
     */
    @GET(ReaderclubCommon._BASE + "clubs/{club_id}/users")
    Observable<GetClubsClubIdUsersResponse> GetClubsClubIdUsers(@Path("club_id") String club_id,
                                                                @Query("q") String q, @Query("group_id") Integer group_id,
                                                                @Query("class_id") Integer class_id, @Query("page") Integer page,
                                                                @Query("per_page") Integer per_page);
// @GET(ReaderclubCommon._BASE+"clubs/{club_id}/users")
//  Observable<GetClubsClubIdUsersResponse> GetClubsClubIdUsers(@Path("club_id") String club_id,
//                                                              @Query("q") String q, @Query("group_id") Integer group_id,
//                                                              @Query("class_id") Integer class_id, @Query("offset") Integer page,
//                                                              @Query("limit") Integer per_page);
//
// @GET(ReaderclubCommon._BASE+"clubs/{club_id}/users")
//  Observable<GetClubsClubIdUsersResponse> GetClubsClubIdUsers(@Path("club_id") String club_id,
//                                                              @Query("q") String q, @Query("group_id") Integer group_id,
//                                                              @Query("class_id") Integer class_id, @Query("offset") Integer page,
//                                                              @Query("limit") Integer per_page);

    /**
     * url= /clubs/recommended
     * title=获取推荐圈子列表
     * name=get_clubs_recommended
     * group=clubGroup
     * version=1.0.0
     * description=<p>获取推荐圈子列表，最多返回15条</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @GET(ReaderclubCommon._BASE + "clubs/recommended")
    Observable<List<GetClubsRecommendedResponse>> GetClubsRecommended();

    /**
     * url= /clubs
     * title=创建圈子
     * name=post_clubs
     * group=clubGroup
     * version=1.0.0
     * description=<p>创建圈子</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     *
     * @param PostClubsRequestParam 自动生成的Body
     */
    @POST(ReaderclubCommon._BASE + "clubs")
    Observable<PostClubsResponse> PostClubs(@Body PostClubsRequestParam PostClubsRequestParam);

    /**
     * url= /clubs/:club_id
     * title=修改圈子信息
     * name=put_clubs__club_id
     * group=clubGroup
     * version=1.0.0
     * description=<p>修改圈子信息</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     *
     * @param PutClubsClubIdRequestParam 自动生成的Body
     */
    @PUT(ReaderclubCommon._BASE + "clubs/{club_id}")
    Observable<PutClubsClubIdResponse> PutClubsClubId(@Path("club_id") final String club_id,
                                                      @Body PutClubsClubIdRequestParam PutClubsClubIdRequestParam);

    /**
     * url= /clubs/:club_id/applications
     * title=申请加入圈子
     * name=put_clubs__club_id_applications
     * group=clubGroup
     * version=1.0.0
     * description=<p>申请加入圈子</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     */
    @PUT(ReaderclubCommon._BASE + "clubs/{club_id}/applications")
    Observable<Void> PutClubsClubIdApplications(@Path("club_id") final String club_id);

    /**
     * url= /clubs/:club_id/messages/unread
     * title=更新用户在圈子的未读消息为已读
     * name=put_clubs__club_id_messages_unread
     * group=clubGroup
     * version=1.0.0
     * description=<p>更新用户在圈子的未读消息为已读，需按模块更新</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/readerclub/v1/club.php
     * groupTitle=圈子信息
     * groupDescription=<p>阅读圈圈子基础信息</p>
     *
     * @param PutClubsClubIdMessagesUnreadRequestParam 自动生成的Body
     */
    @PUT(ReaderclubCommon._BASE + "clubs/{club_id}/messages/unread")
    Observable<PutClubsClubIdMessagesUnreadResponse> PutClubsClubIdMessagesUnread(@Path("club_id") final String club_id,
                                                                                  @Body PutClubsClubIdMessagesUnreadRequestParam PutClubsClubIdMessagesUnreadRequestParam);


    /**
     * url= /promoter
     * title=获取当前用户推广人
     * name=get_promoter
     * group=userGroup
     * version=1.0.0
     * description=<p>获取当前用户的推广人信息，包括推广人的童书馆URL，圈子信息等，原接口http://api.baobaobooks.net/docs/account/#api-accountGroup-getUserStoreUrls即将废弃</p>
     * filename=/alidata/www/dev/baobaobooks/apps/apis/user/v1/user.php
     * groupTitle=用户信息相关
     * groupDescription=<p>用户基础配置信息相关</p>
     */
    @GET("user/v1/user/promoter")
    Observable<GetPromoterResponse> GetPromoter();

}
