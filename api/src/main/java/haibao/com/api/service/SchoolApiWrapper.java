package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
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
import haibao.com.api.data.response.school.UploadVideoCover;
import okhttp3.MultipartBody;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class SchoolApiWrapper implements ClearWrapper {
  private static SchoolApiWrapper INSTANCE;

  private static SchoolService SchoolService;

  public static SchoolApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new SchoolApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public SchoolService getSchoolService() {
    if (SchoolService==null) {
      SchoolService=BaseApi.getRetrofit(CommonUrl.SchoolService_BaseUrl).create(SchoolService.class);
    }
    return SchoolService;
  }

  public void clearService() {
    SchoolService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<CourseMap> getCurrentCourseMap(int baby_id) {
    return getSchoolService().getCurrentCourseMap(baby_id).compose(BaseApi.<CourseMap>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ChannelTheory> getChannelTheory(int channel_id) {
    return getSchoolService().getChannelTheory(channel_id).compose(BaseApi.<ChannelTheory>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ChannelCourse> getCoursesByChannelId(int channel_id, int page, int per_page) {
    return getSchoolService().getCoursesByChannelId(channel_id,page,per_page).compose(BaseApi.<ChannelCourse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Course> getCourseInfo(int course_id) {
    return getSchoolService().getCourseInfo(course_id).compose(BaseApi.<Course>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<SECTIONS> getSectionsByCourseId(int course_id) {
    return getSchoolService().getSectionsByCourseId(course_id).compose(BaseApi.<SECTIONS>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<RESOURCES> getResourcesBySectionId(int course_id, int section_id,
      int resource_type) {
    return getSchoolService().getResourcesBySectionId(course_id,section_id,resource_type).compose(BaseApi.<RESOURCES>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<EXERCISES> getExercisesBySectionId(int course_id, int section_id) {
    return getSchoolService().getExercisesBySectionId(course_id,section_id).compose(BaseApi.<EXERCISES>defaultSchedulers());
  }


  /**
   * 此方法由apt自动生成 */
  public Observable<Void> updateBabyCourseExercise(int baby_id, int course_id, int section_id,
      int practice_id, UpdateBabyCourseExerciseParams params) {
    return getSchoolService().updateBabyCourseExercise(baby_id,course_id,section_id,practice_id,params).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> updateBabyReadingDuration(int baby_id, int course_id, int section_id,
      int resource_id, UpdateBabyReadingDurationParams params) {
    return getSchoolService().updateBabyReadingDuration(baby_id,course_id,section_id,resource_id,params).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> finishCourseSection(int baby_id, int course_id, int section_id,
      FinishCourseSectionParams params) {
    return getSchoolService().finishCourseSection(baby_id,course_id,section_id,params).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<CourseReport> getCourseReport(int course_id) {
    return getSchoolService().getCourseReport(course_id).compose(BaseApi.<CourseReport>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<List<GoodsName>> getBooksByName(String keywords) {
    return getSchoolService().getBooksByName(keywords).compose(BaseApi.<List<GoodsName>>defaultSchedulers());
  }

//  /**
//   * 此方法由apt自动生成 */
//  public Observable<Content> publishContent(PublishContentParams params) {
//    return getSchoolService().publishContent(params).compose(BaseApi.<Content>defaultSchedulers());
//  }

//  /**
//   * 此方法由apt自动生成 */
//  public Observable<UPLOAD_CONTENT_IMAGE> uploadContentImage(MultipartBody multipartBody) {
//    return getSchoolService().uploadContentImage(multipartBody).compose(BaseApi.<UPLOAD_CONTENT_IMAGE>defaultSchedulers());
//  }


  /**
   * 此方法由apt自动生成 */
  public Observable<UnreadColumnNumber> hasNewZL(String last_timestamp) {
    return getSchoolService().hasNewZL(last_timestamp).compose(BaseApi.<UnreadColumnNumber>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<UnreadCircleNumber> hasNewContent(String last_timestamp) {
    return getSchoolService().hasNewContent(last_timestamp).compose(BaseApi.<UnreadCircleNumber>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<UnreadMessageNumber> hasNewMessage(String lastTimestamp) {
    return getSchoolService().hasNewMessage(lastTimestamp).compose(BaseApi.<UnreadMessageNumber>defaultSchedulers());
  }


  /**
   * 此方法由apt自动生成 */
  public Observable<Void> recordBabyTaskStatus(int baby_id, int course_id, int mission_id) {
    return getSchoolService().recordBabyTaskStatus(baby_id,course_id,mission_id).compose(BaseApi.<Void>defaultSchedulers());
  }




}
