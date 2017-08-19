package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Course;

/**
 * 频道下的课程简介列表数据模型
 * Created by Android on 2016-07-21.
 */
public class ChannelCourse implements Serializable {

    private int next_page;
    private int sort_by_stage;
    private List<Course> items;

    public int getSort_by_stage() {
        return sort_by_stage;
    }

    public void setSort_by_stage(int sort_by_stage) {
        this.sort_by_stage = sort_by_stage;
    }

    public int getNext_page() {
        return next_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }

    public List<Course> getItems() {
        return items;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }
}
