package haibao.com.api.data.response.global;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class ImagesBean  implements Serializable {
    public String thumb_url;

    public String url;

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
