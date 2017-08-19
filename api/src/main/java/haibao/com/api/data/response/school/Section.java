package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.ArrayList;

import haibao.com.api.data.response.global.MvsVideoInfo;

/**
 * 章节数据模型
 * Created by Android on 2016-05-14.
 */
public class Section implements Serializable {

    private int is_audio;
    private int is_completed;
    private int is_practice;
    private int is_video;
    private int is_visible;
    private int resource_id;
    private int section_id;
    private MvsVideoInfo mvs_video_info;
    private String cover;
    private String section_name;
    private String vid;

    private ArrayList<String> resource_sort;

    public ArrayList<String> getResource_sort() {
        return resource_sort;
    }

    public void setResource_sort(ArrayList<String> resource_sort) {
        this.resource_sort = resource_sort;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(int is_visible) {
        this.is_visible = is_visible;
    }

    public int getIs_audio() {
        return is_audio;
    }

    public void setIs_audio(int is_audio) {
        this.is_audio = is_audio;
    }

    public int getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(int is_completed) {
        this.is_completed = is_completed;
    }

    public int getIs_practice() {
        return is_practice;
    }

    public void setIs_practice(int is_practice) {
        this.is_practice = is_practice;
    }

    public int getIs_video() {
        return is_video;
    }

    public void setIs_video(int is_video) {
        this.is_video = is_video;
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int section_id) {
        this.section_id = section_id;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public MvsVideoInfo getMvs_video_info() {
        return mvs_video_info;
    }

    public void setMvs_video_info(MvsVideoInfo mvs_video_info) {
        this.mvs_video_info = mvs_video_info;
    }
}
