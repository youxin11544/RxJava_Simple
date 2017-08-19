package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Resource;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class PlayListAudiosResponse implements Serializable {


    /**
     * playlist_id : 121
     * playlist_name : 我的播放列表
     * playlist_cover : https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg
     * resource_count : 12
     * resources : [{"resource_id":579,"resource_name":"美国加州 Evan-Moor 出品学生用书 技巧磨练阅读系列 Skill Sharpeners Reading Grade K【平装】（幼儿园）-01","resource_cover":"https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg","audio_url":"https://v.baobaobooks.net/audio/content/201602/145596081264974.mp3","audio_lyric":"","is_visible":1,"duration":"","order_num":1},{"resource_id":580,"resource_name":"美国加州 Evan-Moor 出品学生用书 技巧磨练阅读系列 Skill Sharpeners Reading Grade K【平装】（幼儿园）-02","resource_cover":"https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg","audio_url":"https://v.baobaobooks.net/audio/content/201602/145596148077190.mp3","audio_lyric":"","is_visible":1,"duration":"","order_num":2}]
     */

    public int playlist_id;
    public String playlist_name;
    public String playlist_cover;
    public int resource_count;
    public List<Resource> resources;

}
