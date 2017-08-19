package haibao.com.api.data.param.content;

import java.io.Serializable;
import java.util.ArrayList;

import haibao.com.api.data.response.content.BindBooks;
import haibao.com.api.data.response.school.TopicBean;

/**
 * Created by Administrator on 2016/10/13 0013.
 */
public class UploadDiaryParam implements Serializable {

    //自己设置的临时存储字段
    public int upload_id;//自己的id
    public String content_duration_format;//临时音频时间
    public BindBooks bindBooks;

    public int currentUserId;
    public int baby_id;
    public int content_type;
    public String content;
    public int isbn_id;
    public int is_open;

    public ArrayList<TopicBean> topics;
    public ArrayList<String> image_ids;

    public String audio_url;
    public String video_url;

    //加上传入的话题
    public String topic;
    public Integer mType;
    public Integer mTypeId;

    public String video_width;
    public String video_height;
    public String video_cover;
    public String duration_format;

    public UploadDiaryParam() {
    }

    public UploadDiaryParam(int currentUserId, int baby_id, int content_type, String content, int isbn_id, int is_open, String audio_url) {
        this.currentUserId = currentUserId;
        this.baby_id = baby_id;
        this.content_type = content_type;
        this.content = content;
        this.isbn_id = isbn_id;
        this.is_open = is_open;
        this.audio_url = audio_url;
    }

    public UploadDiaryParam(int currentUserId, int baby_id, int content_type, String content, int isbn_id, int is_open, String audio_url, ArrayList<String> image_ids) {
        this.currentUserId = currentUserId;
        this.baby_id = baby_id;
        this.content_type = content_type;
        this.content = content;
        this.isbn_id = isbn_id;
        this.is_open = is_open;
        this.audio_url = audio_url;
        this.image_ids = image_ids;
    }

    public UploadDiaryParam(int currentUserId, int baby_id, int content_type, String content, int isbn_id, int is_open, String audio_url,
                            String video_url,String video_cover,String video_width,String video_height,String content_duration_format,
                            BindBooks bindBooks,ArrayList<String> image_ids) {
        this.currentUserId = currentUserId;
        this.baby_id = baby_id;
        this.content_type = content_type;
        this.content = content;
        this.isbn_id = isbn_id;
        this.is_open = is_open;
        this.audio_url = audio_url;
        this.video_url = video_url;
        this.video_cover = video_cover;
        this.video_width = video_width;
        this.video_height = video_height;
        this.image_ids = image_ids;
        this.content_duration_format = content_duration_format;
        this.bindBooks = bindBooks;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public int getBaby_id() {
        return baby_id;
    }

    public void setBaby_id(int baby_id) {
        this.baby_id = baby_id;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(int isbn_id) {
        this.isbn_id = isbn_id;
    }

    public int getIs_open() {
        return is_open;
    }

    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public ArrayList<String> getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(ArrayList<String> image_ids) {
        this.image_ids = image_ids;
    }

    public String getTopic() {
        return topic;
    }

    public UploadDiaryParam setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public Integer getType() {
        return mType;
    }

    public UploadDiaryParam setmType(Integer mType) {
        this.mType = mType;
        return this;
    }

    public Integer getTypeId() {
        return mTypeId;
    }

    public UploadDiaryParam setmTypeId(Integer mTypeId) {
        this.mTypeId = mTypeId;
        return this;
    }
}
