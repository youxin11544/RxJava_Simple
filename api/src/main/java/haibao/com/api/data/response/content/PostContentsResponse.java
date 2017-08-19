package haibao.com.api.data.response.content;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.ImagesBean;

public class PostContentsResponse implements Serializable {
    public String audio_url;

    public Integer baby_id;

    public String content;

    public Integer content_id;

    public Integer content_type;

    public String duration_format;

    public Integer isbn_id;

    public List<ImagesBean> images;

    public Integer is_html;

    public Integer is_open;

    public String video_cover;

    public Integer video_height;

    public String video_url;

    public Integer video_width;

}
