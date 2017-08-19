package haibao.com.api.data.response.global;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.account.Attachment;
import haibao.com.api.data.response.school.Mission;

/**
 * 当前课程
 * Created by Android on 2016-03-16.
 */
public class Course implements Serializable {
    private int completed_section_count;
    private int course_id = -100;
    private int course_number;
    private int course_stage;
    private int is_next_channel;
    private int isbn_id = -100;
    private int next_channel_id = -100;
    private int next_course_interval;
    private int section_count;
    private String bookname;
    private String course_img_middle;
    private String course_img_thumb;
    private String course_name;
    private String introduce;
    private String introduce_img;
    private String next_course_time;
    private String share_url;
    private String shop_url;

    //  v2.3.4  新增的字段  strat--------------------------------------
    private List<Mission> missions;
    private List<Attachment> attachment;
    //  v2.3.4  新增的字段  end--------------------------------------


    public int getCourse_number() {
        return course_number;
    }

    public void setCourse_number(int course_number) {
        this.course_number = course_number;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public int getCourse_stage() {
        return course_stage;
    }

    public void setCourse_stage(int course_stage) {
        this.course_stage = course_stage;
    }

    public String getIntroduce_img() {
        return introduce_img;
    }

    public void setIntroduce_img(String introduce_img) {
        this.introduce_img = introduce_img;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getIs_next_channel() {
        return is_next_channel;
    }

    public void setIs_next_channel(int is_next_channel) {
        this.is_next_channel = is_next_channel;
    }

    public int getNext_channel_id() {
        return next_channel_id;
    }

    public void setNext_channel_id(int next_channel_id) {
        this.next_channel_id = next_channel_id;
    }

    public int getNext_course_interval() {
        return next_course_interval;
    }

    public void setNext_course_interval(int next_course_interval) {
        this.next_course_interval = next_course_interval;
    }

    public String getNext_course_time() {
        return next_course_time;
    }

    public void setNext_course_time(String next_course_time) {
        this.next_course_time = next_course_time;
    }

    public int getCompleted_section_count() {
        return completed_section_count;
    }

    public void setCompleted_section_count(int completed_section_count) {
        this.completed_section_count = completed_section_count;
    }

    public int getSection_count() {
        return section_count;
    }

    public void setSection_count(int section_count) {
        this.section_count = section_count;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(int isbn_id) {
        this.isbn_id = isbn_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCourse_img_middle() {
        return course_img_middle;
    }

    public void setCourse_img_middle(String course_img_middle) {
        this.course_img_middle = course_img_middle;
    }

    public String getCourse_img_thumb() {
        return course_img_thumb;
    }

    public void setCourse_img_thumb(String course_img_thumb) {
        this.course_img_thumb = course_img_thumb;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Course) {
            return ((Course) o).getCourse_id() == this.course_id;
        }
        return super.equals(o);
    }
}
