package haibao.com.api.service;

import java.util.ArrayList;

import haibao.com.api.data.response.activity.ActivitiesActivityResponse;
import haibao.com.api.data.response.activity.GetActivitiesActivityIdContentsResponse;
import haibao.com.api.data.response.activity.GetClubsClubIdActivitiesInactiveResponse;
import haibao.com.api.data.response.activity.GetClubsClubIdActivitiesResponse;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 阅读活动
 * groupDescription=<p>阅读圈内活动相关</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)

public interface ActivityApiService {
    /**
     * U 站用
     * title=创建活动
     */

    /**
     * U 站用
     * title=修改活动
     */

    /**
     * U 站用
     * title=上传活动海报图
     */

    /**
     *  U 站用
     * title=删除活动
     */

    /**
     * title=获取活动列表
     * version=1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-delete_activities__activity_id
     *
     * @param page     <p>请求分页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>请求的每页数据条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("activities")
    Observable<GetClubsClubIdActivitiesResponse> GetClubsClubIdActivities(@Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=活动 - 获取活跃的活动
     * version=  1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-get_activities_active
     */
    @GET("activities/active")
    Observable<ArrayList<ActivitiesActivityResponse>> GetClubsClubIdActivitiesActive();

    /**
     * title=获取历史活动
     * version=  1.1.0
     * api url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-get_activities_inactive
     *
     * @param page     <p>请求分页索引，默认1</p>   type= Integer   isOptional=false
     * @param per_page <p>请求的每页数据条数，默认10</p>   type= Integer   isOptional=true
     */
    @GET("activities/inactive")
    Observable<GetClubsClubIdActivitiesInactiveResponse> GetClubsClubIdActivitiesInactive(
            @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=获取我参与的活动列表
     * version=1.0.0
     * api url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-get_user_activities
     */
    @GET("user/activities")
    Observable<GetClubsClubIdActivitiesInactiveResponse> GetUserActivities(@Query("page") Integer page,
                                                                           @Query("per_page") Integer per_page);

    /**
     * title=获取活动详情
     * version=1.1.0
     * url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-get_activities__activity_id
     */
    @GET("activities/{activity_id}")
    Observable<ActivitiesActivityResponse> GetActivitiesActivityId(@Path("activity_id") final String activity_id);

    /**
     * U 站用
     * title=获取报名用户列表
     */

    /**
     * U 站用
     * title=获取活动打卡动态
     */

    /**
     * title=获取活动打卡动态
     * version=1.0.0
     * api url= https://hbapidev.baobaobooks.net/docs/activity/#api-activityGroup-get_activities__activity_id_contents
     *
     * @param offset  <p>请求的起始索引，默认0</p>   type= Integer   isOptional=false
     * @param limit  <p>请求的数据条数，默认10条</p>   type= Integer   isOptional=true
     */
    @GET("activities/{activity_id}/contents")
    Observable<GetActivitiesActivityIdContentsResponse> GetActivitiesActivityIdContents(@Path("activity_id") final String activity_id,
                                                                                        @Query("offset") Integer offset, @Query("limit") Integer limit);

    /**

    /**
     * title=申请参加活动
     * version=1.0.0
     * api url= /activities/:activity_id/applications
     */
    @PUT("activities/{activity_id}/applications")
    Observable<Void> PubActivitiesActivityIdApplications(@Path("activity_id") final String activity_id);

    /**
     * U 站用
     * title=获取活动统计
     */


}
