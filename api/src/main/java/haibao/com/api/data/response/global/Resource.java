package haibao.com.api.data.response.global;

import java.io.Serializable;

/**
 * 资源数据模型
 * Created by Android on 2016-06-18.
 */
public class Resource implements Serializable {
    public boolean isSelected=false;//自己设的字段，用于判断是否选择播放
    public boolean isPlay=false;//自己设的字段，用于判断是否正在播放

    private int is_visible;//内容是否可看，1-可以，0-不可以
    private int resource_id;
    private int resource_type;
    private MvsVideoInfo mvs_video_info;
    private String duration;
    private String audio_lyric;
    private String audio_url;
    private String resource_cover;
    private String resource_name;
    private String share_url;
    private String vid;

    //这是新的 数据接口 后面会废弃掉 MvsVideoInfo
    private String f10;
    private String f20;
    private String f30;

    private int order_num;

    public int getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(int isbn_id) {
        this.isbn_id = isbn_id;
    }

    private int isbn_id;

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getF10() {
        return f10;
    }

    public void setF10(String f10) {
        this.f10 = f10;
    }

    public String getF20() {
        return f20;
    }

    public void setF20(String f20) {
        this.f20 = f20;
    }

    public String getF30() {
        return f30;
    }

    public void setF30(String f30) {
        this.f30 = f30;
    }

    public int getIs_visible() {
        return is_visible;
    }

    public void setIs_visible(int is_visible) {
        this.is_visible = is_visible;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getResource_type() {
        return resource_type;
    }

    public void setResource_type(int resource_type) {
        this.resource_type = resource_type;
    }

    public MvsVideoInfo getMvs_video_info() {
        return mvs_video_info;
    }

    public void setMvs_video_info(MvsVideoInfo mvs_video_info) {
        this.mvs_video_info = mvs_video_info;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAudio_lyric() {
        return audio_lyric;
    }

    public void setAudio_lyric(String audio_lyric) {
        this.audio_lyric = audio_lyric;
    }

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    public String getResource_cover() {
        return resource_cover;
    }

    public void setResource_cover(String resource_cover) {
        this.resource_cover = resource_cover;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return resource_id == resource.resource_id;
    }

    @Override
    public int hashCode() {
        return resource_id;
    }
}
