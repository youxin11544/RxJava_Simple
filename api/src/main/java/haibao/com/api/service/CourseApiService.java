package haibao.com.api.service;

import java.util.List;

import haibao.com.api.data.param.course.PostCoursesCourseIdCommandsParam;
import haibao.com.api.data.param.course.PostCoursesCourseIdCoursewareRequestParam;
import haibao.com.api.data.param.course.PutCoursesCourseIdCoursewareBatchRequestParam;
import haibao.com.api.data.param.course.PutCoursesCourseIdLiveRequestParam;
import haibao.com.api.data.param.course.PutCoursesCourseIdRequestParam;
import haibao.com.api.data.param.course.PutCoursesCourseIdVideoRequestParam;
import haibao.com.api.data.response.course.ChannelBean;
import haibao.com.api.data.response.course.GetClubsClubIdCoursesResponse;
import haibao.com.api.data.response.course.GetCoursesCourseIdCoursewareResponse;
import haibao.com.api.data.response.course.GetCoursesCourseIdResponse;
import haibao.com.api.data.response.course.PostCoursesCourseIdCoursewareResponse;
import haibao.com.api.data.response.course.PostCoursesImagesResponse;
import haibao.com.api.data.response.course.PutCoursesCourseIdCoursewareBatchResponse;
import haibao.com.api.data.response.course.PutCoursesCourseIdResponse;
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
 * groupTitle= 课程
 * groupDescription=<p>阅读圈内的课程相关</p>
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface CourseApiService {

    /**
     * title=频道 - 获取所有课程频道
     * version=1.0.0
     * api_url =https://hbapi.baobaobooks.net/docs/course/#api-channelGroup-get_channels
     */
    @GET("channels")
    Observable<List<ChannelBean>> GetChannels();

    /**
     * title=公开课 - 获取所有课程
     * version= 1.2.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-lectureGroup-get_courses
     */
    @GET("lecture/courses")
    Observable<GetClubsClubIdCoursesResponse> GetClubsClubIdCourses(
            @Query("page") Integer page,
            @Query("per_page") Integer per_page);

    /**
     * title=公开课 - 获取课程信息
     * version= 1.2.0
     * api url =https://hbapi.baobaobooks.net/docs/course/#api-lectureGroup-get_courses__course_id
     */
    @GET("lecture/courses/{course_id}")
    Observable<GetCoursesCourseIdResponse> GetCoursesCourseId(@Path("course_id") final String course_id);


    //省略课堂模块下的接口
    //省略课程模块下 创建课程。删除课程。2个接口

    /**
     * title=修改课程
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-put_courses__course_id
     *
     * @param PutCoursesCourseIdRequestParam 自动生成的Body
     */
    @PUT("courses/{course_id}")
    Observable<PutCoursesCourseIdResponse> PutCoursesCourseId(@Path("course_id") final String course_id,
                                                              @Body PutCoursesCourseIdRequestParam PutCoursesCourseIdRequestParam);


    /**
     * title=课程 - 上传课程图片
     * version=1.0.0
     * api url =https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-post_courses_images
     */
    @POST("courses/images")
    Observable<PostCoursesImagesResponse> PostCoursesImages(@Body MultipartBody multipartBody);

    /**
     * title=添加课件素材
     * group=courseGroup
     * version=1.2.0
     * <p>
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-post_courses__course_id_courseware
     */
    @POST("courses/{course_id}/sections/{section_id}/courseware")
    Observable<PostCoursesCourseIdCoursewareResponse> PostCoursesCourseIdCourseware(@Path("course_id") final String course_id, @Path("section_id") final String section_id,
                                                                                    @Body PostCoursesCourseIdCoursewareRequestParam PostCoursesCourseIdCoursewareRequestParam);

    /**
     * title=更新课件素材
     * version=1.2.0
     * api url = https://apidev.haibaotown.net/docs/course/#api-courseGroup-put_courses__course_id_sections__section_id_courseware_batch
     */
    @PUT("courses/{course_id}/sections/{section_id}/courseware/batch")
    Observable<List<PutCoursesCourseIdCoursewareBatchResponse>> PutCoursesCourseIdCoursewareBatch(@Path("course_id") final String course_id, @Path("section_id") final String section_id,
                                                                                                  @Body List<PutCoursesCourseIdCoursewareBatchRequestParam> requestParamList);

    /**
     * title=删除课件素材
     * version=1.0.0
     * api url =  https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-delete_courses__course_id_courseware__courseware_id
     */
    @DELETE("courses/{course_id}/courseware/{courseware_id}")
    Observable<Void> DeleteCoursesCourseIdCoursewareCoursewareId(@Path("course_id") final String course_id,
                                                                 @Path("courseware_id") final String courseware_id);


    /**
     * title=获取全部课件
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-get_courses__course_id_courseware
     */
    @GET("courses/{course_id}/courseware")
    Observable<GetCoursesCourseIdCoursewareResponse> GetCoursesCourseIdCourseware(@Path("course_id") final String course_id);


    /**
     * title=预约课程
     * group=courseGroup
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-put_user_subscription_courses__course_id
     */
    @PUT("user/subscription/courses/{course_id}")
    Observable<Void> PutSubscriptionCoursesCourseId(@Path("course_id") final String course_id);


    /**
     * title=取消预约课程
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-delete_user_subscription_courses__course_id
     */
    @DELETE("user/subscription/courses/{course_id}")
    Observable<Void> DeleteSubscriptionCoursesCourseId(@Path("course_id") final String course_id);

    /**
     * title=更新课程已学习
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-put_courses__course_id_learned
     */
    @PUT("courses/{course_id}/learned")
    Observable<Void> PutCoursesCourseIdLearned(@Path("course_id") final String course_id);


    /**
     * title=更新课程直播状态
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-put_courses__course_id_live
     */
    @PUT("courses/{course_id}/live")
    Observable<Void> PutCoursesCourseIdLive(@Path("course_id") final String course_id,
                                            @Body PutCoursesCourseIdLiveRequestParam PutCoursesCourseIdLiveRequestParam);

    /**
     * title=课程 - 更新课程视频信息
     * version=1.0.0
     * api url = https://hbapi.baobaobooks.net/docs/course/#api-courseGroup-put_courses__course_id_live
     */
    @PUT("courses/{course_id}/video")
    Observable<Void> PutCoursesCourseIdVideo(@Path("course_id") final String course_id,
                                             @Body PutCoursesCourseIdVideoRequestParam PutCoursesCourseIdLiveRequestParam);

    /**
     * title=课程 - 上传课件操作指令
     * version= 1.0.0
     * api url = <a href="https://apidev.haibaotown.net/docs/course/#api-courseGroup-post_courses__course_id_commands">https://apidev.haibaotown.net/docs/course/#api-courseGroup-post_courses__course_id_commands</>
     */
    @POST("/courses/{course_id}/sections/{section_id}/commands")
    Observable<Void> PostCoursesCourseIdCommands(@Path("course_id") final String course_id, @Path("section_id") final String section_id,
                                                 @Body PostCoursesCourseIdCommandsParam param);

    /**
     * title=课程 - 验证用户观看权限
     * 验证用户是否有权限收看直播或录播，返回200说明有权限，其他状态码则给出相应提示
     * <p>
     * version=1.0.0
     * api url = <a href="https://apidev.haibaotown.net/docs/course/#api-courseGroup-get_courses__course_id_paid">https://apidev.haibaotown.net/docs/course/#api-courseGroup-get_courses__course_id_paid</>
     */
    @GET("courses/{course_id}/paid")
    Observable<Void> GetCoursesCourseIdPaid(@Path("course_id") final String course_id);


}
