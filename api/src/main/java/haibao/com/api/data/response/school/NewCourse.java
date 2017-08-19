package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.account.Attachment;

/**
 * Created by anzhuo002 on 2016/7/20.
 */

public class NewCourse implements Serializable {
    private String course_id;
    private int is_open;
    private int course_number;
    private String course_name;
    private String section_count;
    private String background_img;
    private int completed_section_count;
    private String course_icon;
    private List<Integer> icon_coordinate;
    private List<Mission> missions;
    private List<Attachment> attachments;

    public NewCourse() {
    }



    public NewCourse(String course_id, int course_number, String course_name, String section_count, String background_img, int completed_section_count, String course_icon, List<Integer> icon_coordinate, List<Mission> missions, List<Attachment> attachments) {
        this.course_id = course_id;
        this.course_number = course_number;
        this.course_name = course_name;
        this.section_count = section_count;
        this.background_img = background_img;
        this.completed_section_count = completed_section_count;
        this.course_icon = course_icon;
        this.icon_coordinate = icon_coordinate;
        this.missions = missions;
        this.attachments = attachments;
    }


    public int getIs_open() {
        return is_open;
    }

    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }

    public int getCourse_number() {
        return course_number;
    }

    public void setCourse_number(int course_number) {
        this.course_number = course_number;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getSection_count() {
        return section_count;
    }

    public void setSection_count(String section_count) {
        this.section_count = section_count;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public int getCompleted_section_count() {
        return completed_section_count;
    }

    public void setCompleted_section_count(int completed_section_count) {
        this.completed_section_count = completed_section_count;
    }

    public String getCourse_icon() {
        return course_icon;
    }

    public void setCourse_icon(String course_icon) {
        this.course_icon = course_icon;
    }

    public List<Integer> getIcon_coordinate() {
        return icon_coordinate;
    }

    public void setIcon_coordinate(List<Integer> icon_coordinate) {
        this.icon_coordinate = icon_coordinate;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
