package haibao.com.api.service;


import java.util.List;

import haibao.com.api.common.CommonUrl;
import haibao.com.api.common.HttpCommon;
import haibao.com.api.data.param.school.FinishCourseSectionParams;
import haibao.com.api.data.param.school.UpdateBabyCourseExerciseParams;
import haibao.com.api.data.param.school.UpdateBabyReadingDurationParams;
import haibao.com.api.data.response.global.Course;
import haibao.com.api.data.response.school.ChannelCourse;
import haibao.com.api.data.response.school.ChannelTheory;
import haibao.com.api.data.response.school.CourseMap;
import haibao.com.api.data.response.school.CourseReport;
import haibao.com.api.data.response.school.EXERCISES;
import haibao.com.api.data.response.school.GoodsName;
import haibao.com.api.data.response.school.RESOURCES;
import haibao.com.api.data.response.school.SECTIONS;
import haibao.com.api.data.response.school.UnreadCircleNumber;
import haibao.com.api.data.response.school.UnreadColumnNumber;
import haibao.com.api.data.response.school.UnreadMessageNumber;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static haibao.com.api.common.CommonUrl.P_COURSES;
import static haibao.com.api.common.CommonUrl.P_REPORTS;
import static haibao.com.api.common.CommonUrl.P_SECTIONS;


/**
 * API接口方法申明接口类
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface SchoolService {

    /**
     * 修改某个宝宝的信息    String url = AYB_BABIES + "/" + baby_id + "/" + P_COURSEMAP;
     *  课堂 - 获取当前宝宝的课程路线
     * https://api.baobaobooks.net/ayb/v2/babies/1437/coursemap
     *
     */
    @GET( "babies/{baby_id}/coursemap")
    Observable<CourseMap> getCurrentCourseMap(@Path("baby_id") int baby_id);


    /**
     * 获取频道理论
     * @param channel_id 频道ID
     */

    @GET( "channels/{channel_id}/theory")
    Observable<ChannelTheory> getChannelTheory(@Path("channel_id") int channel_id);

    /**
     * 获取频道下的课程简介信息列表  int page
     * @param channel_id 频道ID
     */
    @GET( "channels/{channel_id}/courses")
    Observable<ChannelCourse> getCoursesByChannelId(@Path("channel_id") int channel_id, @Query("page") int page, @Query("per_page") int per_page);

    /**
     * 获取课程信息
     * @param course_id 课程ID
     */
    @GET( "course/{course_id}")
    Observable<Course> getCourseInfo(@Path("course_id") int course_id);

    /**
     * 根据课程ID获取对应的章节列表
     * @param course_id 课程ID
     */
    @GET( "courses/{course_id}/sections")
    Observable<SECTIONS> getSectionsByCourseId(@Path("course_id") int course_id);

    /**
     * 根据课程ID和章节ID来获取对应类型的资源
     * @param course_id     课程ID
     * @param section_id    章节ID
     * @param resource_type 资源类型
     *
     * String url = AYB_COURSES + "/" + course_id + "/" + P_SECTIONS + "/" + section_id + "/" + P_RESOURCES + "/" + resource_type;
     */
    @GET( "courses/{course_id}/sections/{section_id}/resources/{resource_type}")
    Observable<RESOURCES> getResourcesBySectionId(@Path("course_id") int course_id, @Path("section_id") int section_id, @Path("resource_type") int resource_type);


    /**
     * 根据课程ID和章节ID来获取对应类型的资源
     * @param course_id     课程ID
     * @param section_id    章节ID
     *
     *  String url = AYB_COURSES + "/" + course_id + "/" + P_SECTIONS + "/" + section_id + "/" + P_PRACTICES;
     */
    @GET( "courses/{course_id}/sections/{section_id}/practices")
    Observable<EXERCISES> getExercisesBySectionId(@Path("course_id") int course_id, @Path("section_id") int section_id);




    /**
     * 更新宝宝的课程练习完成信息
     * @param baby_id     宝宝ID
     * @param course_id   课程ID
     * @param section_id  小节ID
     * @param practice_id 练习ID
     * @param params       练习得分
     *
     */
    @PUT( "babies/{baby_id}/"+ P_COURSES+"/{course_id}/"+ P_SECTIONS+"/{section_id}/"+ CommonUrl.P_PRACTICES+"/{practice_id}")
    Observable<Void> updateBabyCourseExercise(
            @Path("baby_id") int baby_id,
            @Path("course_id") int course_id,
            @Path("section_id") int section_id,
            @Path("practice_id") int practice_id,
            @Body UpdateBabyCourseExerciseParams params);


    /**
     * 记录宝宝的资源阅读时长
     * @param baby_id     宝宝ID
     * @param course_id   课程ID
     * @param section_id  小节ID
     * @param resource_id 资源ID
     * @param params    时长，以秒为单位
     */
    @PUT( "babies/{baby_id}/"+ P_COURSES+"/{course_id}/"+ P_SECTIONS+"/{section_id}/"+CommonUrl.P_RESOURCES+"/{resource_id}")
    Observable<Void> updateBabyReadingDuration(
            @Path("baby_id") int baby_id,
            @Path("course_id") int course_id,
            @Path("section_id") int section_id,
            @Path("resource_id") int resource_id,
            @Body UpdateBabyReadingDurationParams params);


    /**
     * 设置宝宝的课程小节完成状态
     *
     * @param course_id  课程ID
     * @param baby_id    宝宝ID
     * @param section_id 文章ID
     * @param params       请求来源，课程为course，书架为bookshelf
     */
    @PUT( "babies/{baby_id}/"+ P_COURSES+"/{course_id}/"+ P_SECTIONS+"/{section_id}")
    Observable<Void> finishCourseSection(
            @Path("baby_id") int baby_id,
            @Path("course_id") int course_id,
            @Path("section_id") int section_id,
            @Body FinishCourseSectionParams params);


    /**
     * 获取课程报告
     *
     * @param course_id 课程ID

     */
    @GET( "courses/{course_id}/"+ P_REPORTS)
    Observable<CourseReport> getCourseReport(@Path("course_id") int course_id);

    /**
    * 通过关键字获取商品（书籍）名称
    *
    * @param keywords 查询关键字
    */
    @GET( "search/books")
    Observable<List<GoodsName>> getBooksByName(@Query("q") String keywords);

    /**
     * 判断专栏是否有新的文章
     *
     * @param last_timestamp 最后一次刷新的时间，值为时间戳
     */
    @GET("column/contents/unread/number")
    Observable<UnreadColumnNumber> hasNewZL(@Query(HttpCommon.KEY_LAST_TIMESTAMP) String last_timestamp);


    /**
     * 判断是否有新的未读的日记
     * @param last_timestamp 最后一次刷新的时间，值为时间戳
     */
    @GET( "circle/contents/unread/number")
    Observable<UnreadCircleNumber> hasNewContent(@Query(HttpCommon.KEY_LAST_TIMESTAMP) String last_timestamp);


    /**
     * 判断是否有新的未读的消息
     * @param lastTimestamp 最后一次刷新的时间，值为时间戳
     */
    @GET("user/messages/unread/number")
    Observable<UnreadMessageNumber> hasNewMessage(@Query(HttpCommon.KEY_LAST_TIMESTAMP) String lastTimestamp);



    /**
     * 课堂 - 记录宝宝的任务完成状态  /babies/:baby_id/courses/:course_id/missions/:mission_id
     */
    @PUT("babies/{baby_id}/courses/{course_id}/missions/{mission_id}")
    Observable<Void> recordBabyTaskStatus(@Path("baby_id") int baby_id, @Path("course_id") int course_id, @Path("mission_id") int mission_id);





}
