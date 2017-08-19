package haibao.com.api.data.response.school;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class VideoBean  implements Serializable {

    public String cover;

    public String height;

    public String url_f10;

    public String url_f20;

    public String url_f30;

    public String width;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUrl_f10() {
        return url_f10;
    }

    public void setUrl_f10(String url_f10) {
        this.url_f10 = url_f10;
    }

    public String getUrl_f20() {
        return url_f20;
    }

    public void setUrl_f20(String url_f20) {
        this.url_f20 = url_f20;
    }

    public String getUrl_f30() {
        return url_f30;
    }

    public void setUrl_f30(String url_f30) {
        this.url_f30 = url_f30;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "VideoBean{" +
                "cover='" + cover + '\'' +
                ", height='" + height + '\'' +
                ", url_f10='" + url_f10 + '\'' +
                ", url_f20='" + url_f20 + '\'' +
                ", url_f30='" + url_f30 + '\'' +
                ", width='" + width + '\'' +
                '}';
    }
}
