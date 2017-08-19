package haibao.com.api.data.response.bookShelfResponse;


import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Course;

/**
 * 获取书籍下的课程列表
 * {@link }
 * Created by Administrator on 2016/10/26 0026.
 */
public class CoursesResponse implements Serializable{

    /**
     * course_id : 35
     * course_name : Dive in, Ducky第一课
     * introduce : 洗澡书+洞洞书+手偶书三合一
     * course_img_middle : https://osstest.baobaobooks.net/ayb/images/course/201605/146466483095671_middle.jpg
     * course_img_thumb : https://osstest.baobaobooks.net/ayb/images/course/201605/146466483095671_thumb.jpg
     */

    private List<Course> items;

    public List<Course> getItems() {
        return items;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }

}
