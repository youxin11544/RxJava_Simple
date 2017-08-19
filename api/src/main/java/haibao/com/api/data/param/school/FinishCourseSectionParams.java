package haibao.com.api.data.param.school;

/**
 * 记录课程小节的完成状态请求参数模型
 * Created by Android on 2016-07-11.
 */
public class FinishCourseSectionParams {

    public String course_from;


    public FinishCourseSectionParams() {

    }

    public FinishCourseSectionParams(String course_from) {
        this.course_from = course_from;
    }

    public String getCourse_from() {
        return course_from;
    }

    public void setCourse_from(String course_from) {
        this.course_from = course_from;
    }
}
