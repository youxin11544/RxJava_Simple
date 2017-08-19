package haibao.com.api.data.response.mineResponse;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Content;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public class CONTENTS implements Serializable {
    /**
     * next : 11
     * items : [{"content_id":2,"title":"","content_type":1,"summary":"","create_at_format":"","is_html":0,"audio_url":"","video":{"covers":"","width":1920,"height":1080,"url_f10":"","url_f20":"","url_f30":""},"duration_format":"","images":[{"url":"","thumb_url":""}],"topics":{"topic_id":12,"content":"","type":2,"type_id":23},"like_status":1,"like_count":23,"comments_count":23}]
     */

    private int next;
    private List<Content> items;

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public List<Content> getItems() {
        return items;
    }

    public void setItems(List<Content> items) {
        this.items = items;
    }


}
