package haibao.com.api.data.response.bookShelfResponse;


import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Resource;

/**
 * 获取书籍下的音频列表
 * {@link }
 * Created by Administrator on 2016/10/26 0026.
 */

public class AudiosResponse implements Serializable{

    /**
     * resource_id : 579
     * resource_name : 美国加州 Evan-Moor 出品学生用书 技巧磨练阅读系列 Skill Sharpeners Reading Grade K【平装】（幼儿园）-01
     * resource_cover : https://osstest.baobaobooks.net/ayb/images/content/201604/146105837282387_radio_img.jpg
     * audio_url : https://v.baobaobooks.net/audio/content/201602/145596081264974.mp3?auth_key=1467024151-0-0-7ab227ed186849e050081bb25207b92b
     * audio_lyric :
     * is_visible : 0
     * duration :
     */
    private List<Resource> items;

    public List<Resource> getItems() {
        return items;
    }

    public void setItems(List<Resource> items) {
        this.items = items;
    }
}
