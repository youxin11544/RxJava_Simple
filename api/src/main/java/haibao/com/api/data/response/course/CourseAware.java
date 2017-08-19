package haibao.com.api.data.response.course;

import java.io.Serializable;

/**
 * 课件的模型
 * Created by Administrator on 2017/3/8 0008.
 */
public class CourseAware implements Serializable, Comparable<CourseAware> {
    public Integer course_id;

    public Integer courseware_id;

    public Integer order_num = 0;

    public Integer type;

    public String url;
    public String video_cover;


    @Override
    public int compareTo(CourseAware o) {
        return this.order_num - o.order_num;
    }
}
