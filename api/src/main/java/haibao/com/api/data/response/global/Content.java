package haibao.com.api.data.response.global;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import haibao.com.api.common.HttpCommon;
import haibao.com.api.data.response.account.User;
import haibao.com.api.data.response.content.BindBooks;
import haibao.com.api.data.response.content.ContentBaby;
import haibao.com.api.data.response.school.LastComment;
import haibao.com.api.data.response.school.TopicBean;
import haibao.com.api.data.response.school.VideoBean;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class Content implements Serializable {
    public Integer is_publishing = 0;//自己加的字段，用来判断日记是否正在发布中，0代表已发布，1代表正在发布
    public int progress;    //自己加的字段。用来保存上传进度
    public String temp_VideoPath;//自己加的字段，用来零时存储视频的地址
    public ArrayList<String> mImagePaths;//自己加的字段，用来零时存储图片
    public int upload_id;//自己加的字段，用来零时存储上传日记id
    public int net_status = -1;  //自己加的字段。用来保存网络状态. -1是正常的。0以上是网络出现问题

    public String collection_id;//收藏独有的一个属性

    public List<LastComment> comments;

    public String audio_url;

    public ContentBaby baby;

    public ContentBaby user_baby;

    public BindBooks binded_book;

    public Integer comments_count = 0;

    public Integer content_id = -1;

    public Integer content_type = 0;

    public String create_at_format;

    public String duration_format;

    public ArrayList<ImagesBean> images;

    public Integer is_html = 0;

    public Integer is_open = 1;

    public Integer is_favorite;

    public Integer like_count;

    public Integer like_status;

    public String summary;

    public String title;

    public List<TopicBean> topics;

    public String cover_thumb;  //文章的封面图

    public String cover;

    public String cover_middle;

    public User user;

    public VideoBean video;

    public String content;

    public ShareBean share;
    public String pub_time;//新增字段（发布时间）

    public Integer click_count = 0;

    public int is_visible = HttpCommon.INVALID_INT_VALUE;

    public Integer type = 0;

    public Assistant assistant;

    public AssistantBaby assistant_baby;

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public ContentBaby getBaby() {
        return baby;
    }

    public void setBaby(ContentBaby baby) {
        this.baby = baby;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public Integer getContent_type() {
        return content_type;
    }

    public void setContent_type(Integer content_type) {
        this.content_type = content_type;
    }

    public String getCreate_at_format() {
        return create_at_format;
    }

    public void setCreate_at_format(String create_at_format) {
        this.create_at_format = create_at_format;
    }

    public String getDuration_format() {
        return duration_format;
    }

    public void setDuration_format(String duration_format) {
        this.duration_format = duration_format;
    }

    public ArrayList<ImagesBean> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImagesBean> images) {
        this.images = images;
    }

    public Integer getIs_html() {
        return is_html;
    }

    public void setIs_html(Integer is_html) {
        this.is_html = is_html;
    }

    public Integer getIs_open() {
        return is_open;
    }

    public void setIs_open(Integer is_open) {
        this.is_open = is_open;
    }

    public Integer getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(Integer is_favorite) {
        this.is_favorite = is_favorite;
    }

    public List<LastComment> getComments() {
        return comments;
    }

    public void setComments(List<LastComment> comments) {
        this.comments = comments;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getLike_status() {
        return like_status;
    }

    public void setLike_status(Integer like_status) {
        this.like_status = like_status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TopicBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicBean> topics) {
        this.topics = topics;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VideoBean getVideo() {
        return video;
    }

    public void setVideo(VideoBean video) {
        this.video = video;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }

    public int getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(int is_visible) {
        this.is_visible = is_visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content1 = (Content) o;

        if (upload_id != content1.upload_id) return false;
        if (is_visible != content1.is_visible) return false;
        if (is_publishing != null ? !is_publishing.equals(content1.is_publishing) : content1.is_publishing != null)
            return false;
        if (temp_VideoPath != null ? !temp_VideoPath.equals(content1.temp_VideoPath) : content1.temp_VideoPath != null)
            return false;
        if (mImagePaths != null ? !mImagePaths.equals(content1.mImagePaths) : content1.mImagePaths != null)
            return false;
        if (collection_id != null ? !collection_id.equals(content1.collection_id) : content1.collection_id != null)
            return false;
        if (comments != null ? !comments.equals(content1.comments) : content1.comments != null)
            return false;
        if (audio_url != null ? !audio_url.equals(content1.audio_url) : content1.audio_url != null)
            return false;
        if (baby != null ? !baby.equals(content1.baby) : content1.baby != null) return false;
        if (binded_book != null ? !binded_book.equals(content1.binded_book) : content1.binded_book != null)
            return false;
        if (comments_count != null ? !comments_count.equals(content1.comments_count) : content1.comments_count != null)
            return false;
        if (content_id != null ? !content_id.equals(content1.content_id) : content1.content_id != null)
            return false;
        if (content_type != null ? !content_type.equals(content1.content_type) : content1.content_type != null)
            return false;
        if (create_at_format != null ? !create_at_format.equals(content1.create_at_format) : content1.create_at_format != null)
            return false;
        if (duration_format != null ? !duration_format.equals(content1.duration_format) : content1.duration_format != null)
            return false;
        if (images != null ? !images.equals(content1.images) : content1.images != null)
            return false;
        if (is_html != null ? !is_html.equals(content1.is_html) : content1.is_html != null)
            return false;
        if (is_open != null ? !is_open.equals(content1.is_open) : content1.is_open != null)
            return false;
        if (is_favorite != null ? !is_favorite.equals(content1.is_favorite) : content1.is_favorite != null)
            return false;
        if (like_count != null ? !like_count.equals(content1.like_count) : content1.like_count != null)
            return false;
        if (like_status != null ? !like_status.equals(content1.like_status) : content1.like_status != null)
            return false;
        if (summary != null ? !summary.equals(content1.summary) : content1.summary != null)
            return false;
        if (title != null ? !title.equals(content1.title) : content1.title != null) return false;
        if (topics != null ? !topics.equals(content1.topics) : content1.topics != null)
            return false;
        if (cover_thumb != null ? !cover_thumb.equals(content1.cover_thumb) : content1.cover_thumb != null)
            return false;
        if (cover != null ? !cover.equals(content1.cover) : content1.cover != null) return false;
        if (cover_middle != null ? !cover_middle.equals(content1.cover_middle) : content1.cover_middle != null)
            return false;
        if (user != null ? !user.equals(content1.user) : content1.user != null) return false;
        if (video != null ? !video.equals(content1.video) : content1.video != null) return false;
        if (content != null ? !content.equals(content1.content) : content1.content != null)
            return false;
        if (share != null ? !share.equals(content1.share) : content1.share != null) return false;
        if (pub_time != null ? !pub_time.equals(content1.pub_time) : content1.pub_time != null)
            return false;
        return click_count != null ? click_count.equals(content1.click_count) : content1.click_count == null;

    }

    @Override
    public int hashCode() {
        int result = is_publishing != null ? is_publishing.hashCode() : 0;
        result = 31 * result + (temp_VideoPath != null ? temp_VideoPath.hashCode() : 0);
        result = 31 * result + (mImagePaths != null ? mImagePaths.hashCode() : 0);
        result = 31 * result + upload_id;
        result = 31 * result + (collection_id != null ? collection_id.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (audio_url != null ? audio_url.hashCode() : 0);
        result = 31 * result + (baby != null ? baby.hashCode() : 0);
        result = 31 * result + (binded_book != null ? binded_book.hashCode() : 0);
        result = 31 * result + (comments_count != null ? comments_count.hashCode() : 0);
        result = 31 * result + (content_id != null ? content_id.hashCode() : 0);
        result = 31 * result + (content_type != null ? content_type.hashCode() : 0);
        result = 31 * result + (create_at_format != null ? create_at_format.hashCode() : 0);
        result = 31 * result + (duration_format != null ? duration_format.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (is_html != null ? is_html.hashCode() : 0);
        result = 31 * result + (is_open != null ? is_open.hashCode() : 0);
        result = 31 * result + (is_favorite != null ? is_favorite.hashCode() : 0);
        result = 31 * result + (like_count != null ? like_count.hashCode() : 0);
        result = 31 * result + (like_status != null ? like_status.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (topics != null ? topics.hashCode() : 0);
        result = 31 * result + (cover_thumb != null ? cover_thumb.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (cover_middle != null ? cover_middle.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (share != null ? share.hashCode() : 0);
        result = 31 * result + (pub_time != null ? pub_time.hashCode() : 0);
        result = 31 * result + (click_count != null ? click_count.hashCode() : 0);
        result = 31 * result + is_visible;
        return result;
    }

    @Override
    public String toString() {
        return content_id + "";
    }
}
