package haibao.com.api.data.response.school;

import java.io.Serializable;

import haibao.com.api.data.response.global.MvsVideoInfo;

/**
 * 课程理论数据模型
 * Created by Android on 2016-07-20.
 */
public class ChannelTheory implements Serializable {

    private int channel_id;
    private MvsVideoInfo mvs_video_info;
    private String booklist_cover;
    private String booklist_name;
    private String booklist_url;
    private String channel_name;
    private String introduce;
    private String share_url;

    public String getBooklist_cover() {
        return booklist_cover;
    }

    public void setBooklist_cover(String booklist_cover) {
        this.booklist_cover = booklist_cover;
    }

    public String getBooklist_name() {
        return booklist_name;
    }

    public void setBooklist_name(String booklist_name) {
        this.booklist_name = booklist_name;
    }

    public String getBooklist_url() {
        return booklist_url;
    }

    public void setBooklist_url(String booklist_url) {
        this.booklist_url = booklist_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public MvsVideoInfo getMvs_video_info() {
        return mvs_video_info;
    }

    public void setMvs_video_info(MvsVideoInfo mvs_video_info) {
        this.mvs_video_info = mvs_video_info;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }
}
