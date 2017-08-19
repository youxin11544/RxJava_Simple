package haibao.com.api.data.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/27 0027.
 */

public class HBApiBaseUrlBean implements Serializable {
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/accompany
     */
    public EndPointBean company;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/activity
     */
    public EndPointBean activity;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/bookshelf
     */
    public EndPointBean bookshelf;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/chat
     */
    public EndPointBean chat;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/content
     */

    public EndPointBean content;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/course
     */

    public EndPointBean course;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/qatalk
     */

    public EndPointBean qatalk;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/search
     */

    public EndPointBean search;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/user
     */
    public EndPointBean user;
    /**
     * version : v1
     * endpoint : https://hbapi.baobaobooks.net/article
     */
    public EndPointBean article;

    public static class EndPointBean {

        public String version;
        public String endpoint;
    }
}
