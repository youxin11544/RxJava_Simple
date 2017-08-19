package haibao.com.api.data.response.bookShelfResponse;


import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Resource;

/**
 * 获取书籍下的视频列表
 * {@link )}
 * Created by Administrator on 2016/10/26 0026.
 */
public class VideosResponse implements Serializable{
    /**
     * resource_id : 616
     * resource_name : From Head to Toe动物动作视频
     * resource_cover : http://p.qpic.cn/videoyun/0/200005241_2b4bf940312c11e6bc1539c6771a22c4_2/640
     * is_visible : 1
     * mvs_video_info : {"video_play_url":{"f0":"http://200005241.vod.myqcloud.com/200005241_2b4bf940312c11e6bc1539c6771a22c4.f0.mp4","f10":"http://200005241.vod.myqcloud.com/200005241_2b4bf940312c11e6bc1539c6771a22c4.f10.mp4","f20":"http://200005241.vod.myqcloud.com/200005241_2b4bf940312c11e6bc1539c6771a22c4.f20.mp4","f30":"http://200005241.vod.myqcloud.com/200005241_2b4bf940312c11e6bc1539c6771a22c4.f30.mp4"}}
     */

    private List<Resource> items;

    public List<Resource> getItems() {
        return items;
    }

    public void setItems(List<Resource> items) {
        this.items = items;
    }
}
