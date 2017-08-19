package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
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
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class ClassApiApiWrapper implements ClearWrapper {
  private static ClassApiApiWrapper INSTANCE;

  private static ClassApiService ClassApiService;

  public static ClassApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new ClassApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public ClassApiService getClassApiService() {
    if (ClassApiService==null) {
      ClassApiService=BaseApi.getRetrofit(CommonUrl.ClassApiService_BaseUrl).create(ClassApiService.class);
    }
    return ClassApiService;
  }

  public void clearService() {
    ClassApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteClubsClubIdClassesClassId(String club_id, String class_id) {
    return getClassApiService().DeleteClubsClubIdClassesClassId(club_id,class_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteClubsClubIdClassesClassIdCoursesCourseId(String club_id,
      String class_id, String course_id) {
    return getClassApiService().DeleteClubsClubIdClassesClassIdCoursesCourseId(club_id,class_id,course_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteClubsClubIdClassesClassIdUsersUserId(String club_id,
      String class_id, String user_id) {
    return getClassApiService().DeleteClubsClubIdClassesClassIdUsersUserId(club_id,class_id,user_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<AllClassesResponse> GetClubsClubIdClasses(String club_id, Integer page,
      Integer per_page) {
    return getClassApiService().GetClubsClubIdClasses(club_id,page,per_page).compose(BaseApi.<AllClassesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdClassesClassIdResponse> GetClubsClubIdClassesClassId(String club_id,
      String class_id) {
    return getClassApiService().GetClubsClubIdClassesClassId(club_id,class_id).compose(BaseApi.<GetClubsClubIdClassesClassIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdCoursesResponse> GetClubsClubIdClassesClassIdCourses(String club_id,
                                                                                       String class_id, Integer page, Integer per_page) {
    return getClassApiService().GetClubsClubIdClassesClassIdCourses(club_id, class_id, page, per_page).compose(BaseApi.<GetClubsClubIdCoursesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetClubsClubIdUsersResponse> GetClubsClubIdClassesClassIdUsers(String club_id,
      String class_id, String q, Integer page, Integer per_page) {
    return getClassApiService().GetClubsClubIdClassesClassIdUsers(club_id,class_id,q,page,per_page).compose(BaseApi.<GetClubsClubIdUsersResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetUserClubsClubIdClassesResponse> GetUserClubsClubIdClasses(String club_id) {
    return getClassApiService().GetUserClubsClubIdClasses(club_id).compose(BaseApi.<GetUserClubsClubIdClassesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostClubsClubIdClassesResponse> PostClubsClubIdClasses(String club_id,
      PostClubsClubIdClassesRequestParam PostClubsClubIdClassesRequestParam) {
    return getClassApiService().PostClubsClubIdClasses(club_id,PostClubsClubIdClassesRequestParam).compose(BaseApi.<PostClubsClubIdClassesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PostClubsClubIdClassesClassIdCourses(String club_id, String class_id,
      PostClubsClubIdClassesClassIdCoursesRequestParam PostClubsClubIdClassesClassIdCoursesRequestParam) {
    return getClassApiService().PostClubsClubIdClassesClassIdCourses(club_id,class_id,PostClubsClubIdClassesClassIdCoursesRequestParam).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PostClubsClubIdClassesImages(String club_id) {
    return getClassApiService().PostClubsClubIdClassesImages(club_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PutClubsClubIdClassesClassIdResponse> PutClubsClubIdClassesClassId(String club_id,
      String class_id,
      PutClubsClubIdClassesClassIdRequestParam PutClubsClubIdClassesClassIdRequestParam) {
    return getClassApiService().PutClubsClubIdClassesClassId(club_id,class_id,PutClubsClubIdClassesClassIdRequestParam).compose(BaseApi.<PutClubsClubIdClassesClassIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutClubsClubIdClassesClassIdUsersUserId(String club_id, String class_id,
      String user_id, JoinClassParam param) {
    return getClassApiService().PutClubsClubIdClassesClassIdUsersUserId(club_id,class_id,user_id,param).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutClubsClubIdClassesClassIdUsersUserId(String club_id, String class_id,
      String user_id) {
    return getClassApiService().PutClubsClubIdClassesClassIdUsersUserId(club_id,class_id,user_id).compose(BaseApi.<Void>defaultSchedulers());
  }
}
