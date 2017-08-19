package haibao.com.api.data.response.global;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class ShareBean implements Serializable {

    public String content;

    public String image;

    public String title;

    public String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ShareBean{" +
                "content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
