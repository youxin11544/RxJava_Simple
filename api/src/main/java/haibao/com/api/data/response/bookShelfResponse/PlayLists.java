package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/16.
 */

public class PlayLists implements Serializable{

    /**
     * playlist_id : 121
     * playlist_name : 默认播放列表
     * playlist_cover : https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg
     * resource_count : 12
     */

    private int playlist_id;
    private String playlist_name;
    private String playlist_cover;
    private int resource_count;

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getPlaylist_cover() {
        return playlist_cover;
    }

    public void setPlaylist_cover(String playlist_cover) {
        this.playlist_cover = playlist_cover;
    }

    public int getResource_count() {
        return resource_count;
    }

    public void setResource_count(int resource_count) {
        this.resource_count = resource_count;
    }
}