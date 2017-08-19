package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public class Image implements Serializable {

    private int content_id = HttpCommon.INVALID_INT_VALUE;
    private int image_id = HttpCommon.INVALID_INT_VALUE;
    private String image_url;
    private String thumb_image;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(String thumb_image) {
        this.thumb_image = thumb_image;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

}
