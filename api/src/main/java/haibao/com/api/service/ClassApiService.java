package haibao.com.api.service;


import haibao.com.api.common.ReaderclubCommon;
import haibao.com.api.data.param.myclass.JoinClassParam;
import haibao.com.api.data.param.myclass.PostClubsClubIdClassesClassIdCoursesRequestParam;
import haibao.com.api.data.param.myclass.PostClubsClubIdClassesRequestParam;
import haibao.com.api.data.param.myclass.PutClubsClubIdClassesClassIdRequestParam;
import haibao.com.api.data.response.club.GetClubsClubIdUsersResponse;
import haibao.com.api.data.response.course.GetClubsClubIdCoursesResponse;
import haibao.com.api.data.response.myclass.AllClassesResponse;
import haibao.com.api.data.response.myclass.GetClubsClubIdClassesClassIdResponse;
import haibao.com.api.data.response.myclass.GetUserClubsClubIdClassesResponse;
import haibao.com.api.data.response.myclass.PostClubsClubIdClassesResponse;
import haibao.com.api.data.response.myclass.PutClubsClubIdClassesClassIdResponse;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * groupTitle= 班级
 * groupDescription=<p>阅读圈内班级相关接口</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface ClassApiService {
  /**
   *
   * url= /clubs/:club_id/classes/:class_id
   * title=删除班级
   * name=delete_clubs__club_id_classes__class_id
   * group=class
   * version=1.0.0
   * description=<p>删除班级</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @DELETE(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}")
  Observable<Void> DeleteClubsClubIdClassesClassId(@Path("club_id") final String club_id,
                                                   @Path("class_id") final String class_id);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/courses/:course_id
   * title=删除班级课程
   * name=delete_clubs__club_id_classes__class_id_courses__course_id
   * group=class
   * version=1.0.0
   * description=<p>删除班级课程，U站班级管理时，删除班级课程列表中的课程</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @DELETE(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/courses/{course_id}")
  Observable<Void> DeleteClubsClubIdClassesClassIdCoursesCourseId(@Path("club_id") final String club_id,
                                                                  @Path("class_id") final String class_id, @Path("course_id") final String course_id);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/users/:user_id
   * title=申请退出班级
   * name=delete_clubs__club_id_classes__class_id_users__user_id
   * group=class
   * version=1.0.0
   * description=<p>申请退出班级，推广人在创建的班级，可以选择自己圈子中的用户退出班级，其他人只能申请自己退出班级</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @DELETE(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/users/{user_id}")
  Observable<Void> DeleteClubsClubIdClassesClassIdUsersUserId(@Path("club_id") final String club_id,
                                                              @Path("class_id") final String class_id, @Path("user_id") final String user_id);

  /**
   *
   * url= /clubs/:club_id/classes?page=*&per_page=*
   * title=获取圈子内班级列表
   * name=get_clubs__club_id_classes
   * group=class
   * version=1.0.0
   * description=<p>获取圈子内的班级列表</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param page  <p>请求的索引页数</p>   type= Integer   isOptional=false
   * @param per_page  <p>每页返回的数据条数，默认10</p>   type= Integer   isOptional=true
   */
  @GET(ReaderclubCommon._BASE+"clubs/{club_id}/classes")
  Observable<AllClassesResponse> GetClubsClubIdClasses(@Path("club_id") final String club_id,
                                                       @Query("page") Integer page, @Query("per_page") Integer per_page);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id
   * title=获取班级信息
   * name=get_clubs__club_id_classes__class_id
   * group=class
   * version=1.0.0
   * description=<p>获取班级信息</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @GET(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}")
  Observable<GetClubsClubIdClassesClassIdResponse> GetClubsClubIdClassesClassId(@Path("club_id") final String club_id,
                                                                                @Path("class_id") final String class_id);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/courses?page=*&per_page=*
   * title=获取班级的课程
   * name=get_clubs__club_id_classes__class_id_courses
   * group=class
   * version=1.0.0
   * description=<p>获取班级内的课程列表，未开始直播和正在直播的优先排序，已结束直播的课程，会返回课程视频相关的参数</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param page  <p>请求页索引，默认1</p>   type= Integer   isOptional=false
   * @param per_page  <p>每页返回的条数，默认10</p>   type= Integer   isOptional=true
   */
  @GET(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/courses")
  Observable<GetClubsClubIdCoursesResponse> GetClubsClubIdClassesClassIdCourses(@Path("club_id") final String club_id,
                                                                                @Path("class_id") final String class_id, @Query("page") Integer page,
                                                                                @Query("per_page") Integer per_page);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/users?q=*&page=*&per_page=*
   * title=获取班级阅读家庭列表
   * name=get_clubs__club_id_classes__class_id_users
   * group=class
   * version=1.0.0
   * description=<p>获取班级阅读家庭列表</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param q  <p>查询关键字，用于搜索阅读家庭</p>   type= String   isOptional=true
   * @param page  <p>请求的索引页数</p>   type= Integer   isOptional=false
   * @param per_page  <p>每页返回的数据条数，默认10</p>   type= Integer   isOptional=true
   */
  @GET(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/users")
  Observable<GetClubsClubIdUsersResponse> GetClubsClubIdClassesClassIdUsers(@Path("club_id") final String club_id,
                                                                            @Path("class_id") final String class_id, @Query("q") String q, @Query("page") Integer page,
                                                                            @Query("per_page") Integer per_page);

  /**
   *
   * url= /user/clubs/:club_id/classes
   * title=获取我的班级列表
   * name=get_user_clubs__club_id_classes
   * group=class
   * version=1.0.0
   * description=<p>获取我加入的班级列表</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @GET(ReaderclubCommon._BASE+"user/clubs/{club_id}/classes")
  Observable<GetUserClubsClubIdClassesResponse> GetUserClubsClubIdClasses(@Path("club_id") final String club_id);

  /**
   *
   * url= /clubs/:club_id/classes
   * title=创建班级
   * name=post_clubs__club_id_classes
   * group=class
   * version=1.0.0
   * description=<p>创建班级，用于在U站创建新班级</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param PostClubsClubIdClassesRequestParam 自动生成的Body */
  @POST(ReaderclubCommon._BASE+"clubs/{club_id}/classes")
  Observable<PostClubsClubIdClassesResponse> PostClubsClubIdClasses(@Path("club_id") final String club_id,
                                                                    @Body PostClubsClubIdClassesRequestParam PostClubsClubIdClassesRequestParam);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/courses
   * title=添加班级课程
   * name=post_clubs__club_id_classes__class_id_courses
   * group=class
   * version=1.0.0
   * description=<p>添加班级课程，U站班级管理时，新增班级课程</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param PostClubsClubIdClassesClassIdCoursesRequestParam 自动生成的Body */
  @POST(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/courses")
  Observable<Void> PostClubsClubIdClassesClassIdCourses(@Path("club_id") final String club_id,
                                                        @Path("class_id") final String class_id,
                                                        @Body PostClubsClubIdClassesClassIdCoursesRequestParam PostClubsClubIdClassesClassIdCoursesRequestParam);

  /**
   *
   * url= /clubs/:club_id/classes/images
   * title=上传班级内图片
   * name=post_clubs__club_id_classes_images
   * group=class
   * version=1.0.0
   * description=<p>单张图片文件大小不能超过2M</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @POST(ReaderclubCommon._BASE+"clubs/{club_id}/classes/images")
  Observable<Void> PostClubsClubIdClassesImages(@Path("club_id") final String club_id);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id
   * title=编辑班级
   * name=put_clubs__club_id_classes__class_id
   * group=class
   * version=1.0.0
   * description=<p>编辑班级，用于在U站编辑班级</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   * @param PutClubsClubIdClassesClassIdRequestParam 自动生成的Body */
  @PUT(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}")
  Observable<PutClubsClubIdClassesClassIdResponse> PutClubsClubIdClassesClassId(@Path("club_id") final String club_id,
                                                                                @Path("class_id") final String class_id,
                                                                                @Body PutClubsClubIdClassesClassIdRequestParam PutClubsClubIdClassesClassIdRequestParam);

  /**
   *
   * url= /clubs/:club_id/classes/:class_id/users/:user_id
   * title=申请加入班级
   * name=put_clubs__club_id_classes__class_id_users__user_id
   * group=class
   * version=1.0.0
   * description=<p>申请加入班级，推广人在创建班级后，可以选择自己圈子中的用户加入班级，其他人只能申请自己加入班级</p>
   * filename=readerclub/v1/class.php
   * groupTitle=班级
   * groupDescription=<p>阅读圈内班级相关接口</p>
   *
   */
  @PUT(ReaderclubCommon._BASE+"clubs/{club_id}/classes/{class_id}/users/{user_id}")
  Observable<Void> PutClubsClubIdClassesClassIdUsersUserId(@Path("club_id") final String club_id,
                                                           @Path("class_id") final String class_id,
                                                           @Path("user_id") String user_id,
                                                           @Body JoinClassParam param);

  @PUT(ReaderclubCommon._BASE + "clubs/{club_id}/classes/{class_id}/users/{user_id}")
  Observable<Void> PutClubsClubIdClassesClassIdUsersUserId(@Path("club_id") final String club_id,
                                                           @Path("class_id") final String class_id,
                                                           @Path("user_id") String user_id);
}
