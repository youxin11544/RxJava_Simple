package haibao.com.api.data.response.global;

import java.io.Serializable;

import haibao.com.api.data.response.account.VideoPlayUrl;

/**
 * 微视频数据模型
 * Created by Android on 2016-05-14.
 */
public class MvsVideoInfo implements Serializable {

    private String video_cover;
    private VideoPlayUrl video_play_url;

    private String video_width;
    private String video_height;
    private String video_duration;

    public String getVideo_width() {
        return video_width;
    }

    public void setVideo_width(String video_width) {
        this.video_width = video_width;
    }

    public String getVideo_height() {
        return video_height;
    }

    public void setVideo_height(String video_height) {
        this.video_height = video_height;
    }

    public String getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(String video_duration) {
        this.video_duration = video_duration;
    }

    public String getVideo_cover() {
        return video_cover;
    }

    public void setVideo_cover(String video_cover) {
        this.video_cover = video_cover;
    }

    public VideoPlayUrl getVideo_play_url() {
        return video_play_url;
    }

    public void setVideo_play_url(VideoPlayUrl video_play_url) {
        this.video_play_url = video_play_url;
    }
}
