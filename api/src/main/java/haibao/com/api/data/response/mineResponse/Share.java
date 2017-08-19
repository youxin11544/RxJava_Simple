package haibao.com.api.data.response.mineResponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public  class Share implements Serializable {

    private String message;
    private String share_img;
    private String share_url;
    private String title;

    public String getShare_img() {
        return share_img;
    }

    public void setShare_img(String share_img) {
        this.share_img = share_img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}