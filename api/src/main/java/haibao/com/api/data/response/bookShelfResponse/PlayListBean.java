package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;
import java.util.ArrayList;

import haibao.com.api.data.response.global.Resource;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class PlayListBean implements Serializable{
    /**
     * playlist_id : 121
     * playlist_name : 默认播放列表
     * playlist_cover : https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg
     * resource_count : 12
     */

    public int playlist_id;
    public String playlist_name;
    public String playlist_cover;
    public int resource_count;
    public ArrayList<Resource> resources;

    public boolean isCreateData = false;

    @Override
    public String toString() {
        return "PlayListBean{" +
                "playlist_id=" + playlist_id +
                ", playlist_name='" + playlist_name + '\'' +
                ", playlist_cover='" + playlist_cover + '\'' +
                ", resource_count=" + resource_count +
                ", isCreateData=" + isCreateData +
                '}';
    }
}
