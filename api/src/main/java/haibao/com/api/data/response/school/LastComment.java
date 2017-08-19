package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class LastComment implements Serializable{
    public String comment_id;
    public Integer user_id;
    public String user_name;
    public String user_avatar;
    public Integer sub_comments_count = 0;
    public String create_at_format;
    public String audio_url;
    public String audio_duration_format;
    public String content;
    public Integer to_user_id = -100;
    public String to_user_name;
    public List<LastComment> sub_comments;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public Integer getSub_comments_count() {
        return sub_comments_count;
    }

    public void setSub_comments_count(Integer sub_comments_count) {
        this.sub_comments_count = sub_comments_count;
    }

    public String getCreate_at_format() {
        return create_at_format;
    }

    public void setCreate_at_format(String create_at_format) {
        this.create_at_format = create_at_format;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getAudio_duration_format() {
        return audio_duration_format;
    }

    public void setAudio_duration_format(String audio_duration_format) {
        this.audio_duration_format = audio_duration_format;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LastComment> getSub_comments() {
        return sub_comments;
    }

    public void setSub_comments(List<LastComment> sub_comments) {
        this.sub_comments = sub_comments;
    }

    @Override
    public String toString() {
        return "LastComment{" +
                "comment_id='" + comment_id + '\'' +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", sub_comments_count=" + sub_comments_count +
                ", create_at_format='" + create_at_format + '\'' +
                ", audio_url='" + audio_url + '\'' +
                ", audio_duration_format='" + audio_duration_format + '\'' +
                ", content='" + content + '\'' +
                ", to_user_id=" + to_user_id +
                ", to_user_name='" + to_user_name + '\'' +
                ", sub_comments=" + sub_comments +
                '}';
    }
}
