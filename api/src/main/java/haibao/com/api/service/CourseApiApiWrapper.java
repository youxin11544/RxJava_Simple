package haibao.com.api.service;

import java.util.List;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
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
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成
 */
public final class CourseApiApiWrapper implements ClearWrapper {
    private static CourseApiApiWrapper INSTANCE;

    private static CourseApiService CourseApiService;

    public static CourseApiApiWrapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CourseApiApiWrapper();
            BaseApi.addToBaseApi(INSTANCE);
        }
        return INSTANCE;
    }

    public CourseApiService getCourseApiService() {
        if (CourseApiService == null) {
            CourseApiService = BaseApi.getRetrofit(CommonUrl.CourseApiService_BaseUrl).create(CourseApiService.class);
        }
        return CourseApiService;
    }

    public void clearService() {
        CourseApiService = null;
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteCoursesCourseIdCoursewareCoursewareId(String course_id,
                                                                        String courseware_id) {
        return getCourseApiService().DeleteCoursesCourseIdCoursewareCoursewareId(course_id, courseware_id).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> DeleteSubscriptionCoursesCourseId(String course_id) {
        return getCourseApiService().DeleteSubscriptionCoursesCourseId(course_id).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetClubsClubIdCoursesResponse> GetClubsClubIdCourses(Integer page, Integer per_page) {
        return getCourseApiService().GetClubsClubIdCourses(page, per_page).compose(BaseApi.<GetClubsClubIdCoursesResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetCoursesCourseIdResponse> GetCoursesCourseId(String course_id) {
        return getCourseApiService().GetCoursesCourseId(course_id).compose(BaseApi.<GetCoursesCourseIdResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<GetCoursesCourseIdCoursewareResponse> GetCoursesCourseIdCourseware(String course_id) {
        return getCourseApiService().GetCoursesCourseIdCourseware(course_id).compose(BaseApi.<GetCoursesCourseIdCoursewareResponse>defaultSchedulers());
    }


    /**
     * 此方法由apt自动生成
     */
    public Observable<PostCoursesCourseIdCoursewareResponse> PostCoursesCourseIdCourseware(String course_id, String section_id,
                                                                                           PostCoursesCourseIdCoursewareRequestParam PostCoursesCourseIdCoursewareRequestParam) {
        return getCourseApiService().PostCoursesCourseIdCourseware(course_id, section_id, PostCoursesCourseIdCoursewareRequestParam).compose(BaseApi.<PostCoursesCourseIdCoursewareResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<PostCoursesImagesResponse> PostCoursesImages(MultipartBody multipartBody) {
        return getCourseApiService().PostCoursesImages(multipartBody).compose(BaseApi.<PostCoursesImagesResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<PutCoursesCourseIdResponse> PutCoursesCourseId(String course_id,
                                                                     PutCoursesCourseIdRequestParam PutCoursesCourseIdRequestParam) {
        return getCourseApiService().PutCoursesCourseId(course_id, PutCoursesCourseIdRequestParam).compose(BaseApi.<PutCoursesCourseIdResponse>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<List<PutCoursesCourseIdCoursewareBatchResponse>> PutCoursesCourseIdCoursewareBatch(String course_id, String section_id,
                                                                                                         List<PutCoursesCourseIdCoursewareBatchRequestParam> requestParamList) {
        return getCourseApiService().PutCoursesCourseIdCoursewareBatch(course_id, section_id, requestParamList).compose(BaseApi.<List<PutCoursesCourseIdCoursewareBatchResponse>>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> PutCoursesCourseIdLearned(String course_id) {
        return getCourseApiService().PutCoursesCourseIdLearned(course_id).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> PutCoursesCourseIdLive(String course_id,
                                                   PutCoursesCourseIdLiveRequestParam PutCoursesCourseIdLiveRequestParam) {
        return getCourseApiService().PutCoursesCourseIdLive(course_id, PutCoursesCourseIdLiveRequestParam).compose(BaseApi.<Void>defaultSchedulers());
    }

    /**
     * 此方法由apt自动生成
     */
    public Observable<Void> PutSubscriptionCoursesCourseId(String course_id) {
        return getCourseApiService().PutSubscriptionCoursesCourseId(course_id).compose(BaseApi.<Void>defaultSchedulers());
    }

    public Observable<Void> PutCoursesCourseIdVideo(final String course_id,
                                                    PutCoursesCourseIdVideoRequestParam putCoursesCourseIdVideoRequestParam) {
        return getCourseApiService().PutCoursesCourseIdVideo(course_id, putCoursesCourseIdVideoRequestParam).compose(BaseApi.<Void>defaultSchedulers());
    }

    public Observable<List<ChannelBean>> GetChannels() {
        return getCourseApiService().GetChannels().compose(BaseApi.<List<ChannelBean>>defaultSchedulers());
    }

    public Observable<Void> PostCoursesCourseIdCommands(final String course_id, final String section_id,
                                                        PostCoursesCourseIdCommandsParam param) {
        return getCourseApiService().PostCoursesCourseIdCommands(course_id, section_id, param).compose(BaseApi.<Void>defaultSchedulers());
    }

    public Observable<Void> GetCoursesCourseIdPaid(final String course_id) {
        return getCourseApiService().GetCoursesCourseIdPaid(course_id).compose(BaseApi.<Void>defaultSchedulers());
    }
}
