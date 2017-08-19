package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anzhuo002 on 2016/7/18.
 */
public class CourseMap implements Serializable{
    private String channel_id;
    private String channel_name;
    private String channel_icon;
    private String channel_theory_name;
    private String channel_theory_icon;
    private String background_img;
    private String current_course_id;
    private int current_course_stage;
    private String next_course_id;
    private List<Integer> icon_coordinate;
    private List<NewCourse> courses;

    public int getCurrent_course_stage() {
        return current_course_stage;
    }

    public void setCurrent_course_stage(int current_course_stage) {
        this.current_course_stage = current_course_stage;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getChannel_icon() {
        return channel_icon;
    }

    public void setChannel_icon(String channel_icon) {
        this.channel_icon = channel_icon;
    }

    public String getChannel_theory_name() {
        return channel_theory_name;
    }

    public void setChannel_theory_name(String channel_theory_name) {
        this.channel_theory_name = channel_theory_name;
    }

    public String getChannel_theory_icon() {
        return channel_theory_icon;
    }

    public void setChannel_theory_icon(String channel_theory_icon) {
        this.channel_theory_icon = channel_theory_icon;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public String getCurrent_course_id() {
        return current_course_id;
    }

    public void setCurrent_course_id(String current_course_id) {
        this.current_course_id = current_course_id;
    }

    public String getNext_course_id() {
        return next_course_id;
    }

    public void setNext_course_id(String next_course_id) {
        this.next_course_id = next_course_id;
    }

    public List<Integer> getIcon_coordinate() {
        return icon_coordinate;
    }

    public void setIcon_coordinate(List<Integer> icon_coordinate) {
        this.icon_coordinate = icon_coordinate;
    }

    public List<NewCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<NewCourse> courses) {
        this.courses = courses;
    }
}




