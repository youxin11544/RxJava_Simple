//package haibao.com.api.data.response.bookShelfResponse;
//
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
//import haibao.com.api.common.HttpCommon;
//import haibao.com.api.data.response.global.MvsVideoInfo;
//import haibao.com.api.data.response.school.Exercise;
//
///**
// * babyInfo
// */
//public class Content implements Serializable {
//
//    private ArrayList<Exercise.Image> images;
//    private int baby_id = HttpCommon.INVALID_INT_VALUE;
//    private int click;
//    private int collection_status = HttpCommon.INVALID_INT_VALUE;
//    private int collectionNums;
//    private int comment_count;
//    private int content_id = HttpCommon.INVALID_INT_VALUE;
//    private int content_type = HttpCommon.INVALID_INT_VALUE;
//    private int editor_id = HttpCommon.INVALID_INT_VALUE;
//    private int friend_status = HttpCommon.INVALID_INT_VALUE;
//    private int isbn_id = HttpCommon.INVALID_INT_VALUE;
//    private int image_count;
//    private int is_html = HttpCommon.INVALID_INT_VALUE;
//    private int is_mvs = HttpCommon.INVALID_INT_VALUE;
//    private int is_open = HttpCommon.INVALID_INT_VALUE;
//    private int is_read = HttpCommon.INVALID_INT_VALUE;
//    private int is_visible = HttpCommon.INVALID_INT_VALUE;
//    private int isbn_id = HttpCommon.INVALID_INT_VALUE;
//    private int praise;
//    private int praise_status = HttpCommon.INVALID_INT_VALUE;
//    private int sort = HttpCommon.INVALID_INT_VALUE;
//    private int type = HttpCommon.INVALID_INT_VALUE;
//    private int user_id = HttpCommon.INVALID_INT_VALUE;
//    private MvsVideoInfo mvs_video_info;
//    private String age;
//    private String avatar;
//    private String book_name;
//    private String book_url;
//    private String content;
//    private String covers;
//    private String cover_middle;
//    private String cover_thumb;
//    private String current_avatar;
//    private String goods_brief;
//    private String goods_name;
//    private String book_img_thumb;
//    private String pub_time;
//    private String push_date;
//    private String push_desc;
//    private String radio_duration;
//    private String radio_img;
//    private String radio_lyric;
//    private String radio_url;
//    private String resource_path;
//    private String share_img;
//    private String share_url;
//    private String summary;
//    private String title;
//    private String user_name;
//    private String vid;
//
//    public String getRadio_lyric() {
//        return radio_lyric;
//    }
//
//    public void setRadio_lyric(String radio_lyric) {
//        this.radio_lyric = radio_lyric;
//    }
//
//    public String getRadio_duration() {
//        return radio_duration;
//    }
//
//    public void setRadio_duration(String radio_duration) {
//        this.radio_duration = radio_duration;
//    }
//
//    public String getShare_img() {
//        return share_img;
//    }
//
//    public void setShare_img(String share_img) {
//        this.share_img = share_img;
//    }
//
//    public String getBook_name() {
//        return book_name;
//    }
//
//    public void setBook_name(String book_name) {
//        this.book_name = book_name;
//    }
//
//    public int getIs_visible() {
//        return is_visible;
//    }
//
//    public void setIs_visible(int is_visible) {
//        this.is_visible = is_visible;
//    }
//
//    public int getIs_read() {
//        return is_read;
//    }
//
//    public void setIs_read(int is_read) {
//        this.is_read = is_read;
//    }
//
//    public String getRadio_img() {
//        return radio_img;
//    }
//
//    public void setRadio_img(String radio_img) {
//        this.radio_img = radio_img;
//    }
//
//    public MvsVideoInfo getMvs_video_info() {
//        return mvs_video_info;
//    }
//
//    public void setMvs_video_info(MvsVideoInfo mvs_video_info) {
//        this.mvs_video_info = mvs_video_info;
//    }
//
//    public int getIs_mvs() {
//        return is_mvs;
//    }
//
//    public void setIs_mvs(int is_mvs) {
//        this.is_mvs = is_mvs;
//    }
//
//    public String getBook_url() {
//        return book_url;
//    }
//
//    public void setBook_url(String book_url) {
//        this.book_url = book_url;
//    }
//
//    public int getIsbn_id() {
//        return isbn_id;
//    }
//
//    public void setIsbn_id(int isbn_id) {
//        this.isbn_id = isbn_id;
//    }
//
//    public String getGoods_brief() {
//        return goods_brief;
//    }
//
//    public void setGoods_brief(String goods_brief) {
//        this.goods_brief = goods_brief;
//    }
//
//    public String getCover_middle() {
//        return cover_middle;
//    }
//
//    public void setCover_middle(String cover_middle) {
//        this.cover_middle = cover_middle;
//    }
//
//    public int getCollectionNums() {
//        return collectionNums;
//    }
//
//    public void setCollectionNums(int collectionNums) {
//        this.collectionNums = collectionNums;
//    }
//
//    public int getComment_count() {
//        return comment_count;
//    }
//
//    public void setComment_count(int comment_count) {
//        this.comment_count = comment_count;
//    }
//
//    public int getFriend_status() {
//        return friend_status;
//    }
//
//    public void setFriend_status(int friend_status) {
//        this.friend_status = friend_status;
//    }
//
//    public int getImage_count() {
//        return image_count;
//    }
//
//    public void setImage_count(int image_count) {
//        this.image_count = image_count;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getPub_time() {
//        return pub_time;
//    }
//
//    public void setPub_time(String pub_time) {
//        this.pub_time = pub_time;
//    }
//
//    public String getPush_desc() {
//        return push_desc;
//    }
//
//    public void setPush_desc(String push_desc) {
//        this.push_desc = push_desc;
//    }
//
//    public int getEditor_id() {
//        return editor_id;
//    }
//
//    public void setEditor_id(int editor_id) {
//        this.editor_id = editor_id;
//    }
//
//    public int getIs_open() {
//        return is_open;
//    }
//
//    public void setIs_open(int is_open) {
//        this.is_open = is_open;
//    }
//
//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
//
//    public int getSort() {
//        return sort;
//    }
//
//    public void setSort(int sort) {
//        this.sort = sort;
//    }
//
//    public int getBaby_id() {
//        return baby_id;
//    }
//
//    public void setBaby_id(int baby_id) {
//        this.baby_id = baby_id;
//    }
//
//    public ArrayList<Exercise.Image> getImages() {
//        return images;
//    }
//
//    public void setImages(ArrayList<Exercise.Image> images) {
//        this.images = images;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public int getIs_html() {
//        return is_html;
//    }
//
//    public void setIs_html(int is_html) {
//        this.is_html = is_html;
//    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public String getShare_url() {
//        return share_url;
//    }
//
//    public void setShare_url(String share_url) {
//        this.share_url = share_url;
//    }
//
//    public String getPush_date() {
//        return push_date;
//    }
//
//    public void setPush_date(String push_date) {
//        this.push_date = push_date;
//    }
//
//    public String getCurrent_avatar() {
//        return current_avatar;
//    }
//
//    public void setCurrent_avatar(String current_avatar) {
//        this.current_avatar = current_avatar;
//    }
//
//    public int getPraise_status() {
//        return praise_status;
//    }
//
//    public void setPraise_status(int praise_status) {
//        this.praise_status = praise_status;
//    }
//
//    public int getCollection_status() {
//        return collection_status;
//    }
//
//    public void setCollection_status(int collection_status) {
//        this.collection_status = collection_status;
//    }
//
//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
//
//    public String getUser_name() {
//        return user_name;
//    }
//
//    public void setUser_name(String user_name) {
//        this.user_name = user_name;
//    }
//
//    public String getCovers() {
//        return covers;
//    }
//
//    public void setCovers(String covers) {
//        this.covers = covers;
//    }
//
//    public String getCover_thumb() {
//        return cover_thumb;
//    }
//
//    public void setCover_thumb(String cover_thumb) {
//        this.cover_thumb = cover_thumb;
//    }
//
//    public int getContent_id() {
//        return content_id;
//    }
//
//    public void setContent_id(int content_id) {
//        this.content_id = content_id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getVid() {
//        return vid;
//    }
//
//    public void setVid(String vid) {
//        this.vid = vid;
//    }
//
//    public String getRadio_url() {
//        return radio_url;
//    }
//
//    public void setRadio_url(String radio_url) {
//        this.radio_url = radio_url;
//    }
//
//    public String getGoods_name() {
//        return goods_name;
//    }
//
//    public void setGoods_name(String goods_name) {
//        this.book_name = book_name;
//    }
//
//    public int getGoods_id() {
//        return isbn_id;
//    }
//
//    public void setGoods_id(int isbn_id) {
//        this.isbn_id = isbn_id;
//    }
//
//    public String getGoods_thumb() {
//        return book_img_thumb;
//    }
//
//    public void setGoods_thumb(String book_img_thumb) {
//        this.book_img_thumb = book_img_thumb;
//    }
//
//    public int getClick() {
//        return click;
//    }
//
//    public void setClick(int click) {
//        this.click = click;
//    }
//
//    public int getPraise() {
//        return praise;
//    }
//
//    public void setPraise(int praise) {
//        this.praise = praise;
//    }
//
//    public int getContent_type() {
//        return content_type;
//    }
//
//    public void setContent_type(int content_type) {
//        this.content_type = content_type;
//    }
//
//    public String getResource_path() {
//        return resource_path;
//    }
//
//    public void setResource_path(String resource_path) {
//        this.resource_path = resource_path;
//    }
//}
