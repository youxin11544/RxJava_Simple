package haibao.com.api.data.response.mineResponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class UploadAvatar implements Serializable {

    private String avatar;
    private String avatar_thumb;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_thumb() {
        return avatar_thumb;
    }

    public void setAvatar_thumb(String avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
    }
}