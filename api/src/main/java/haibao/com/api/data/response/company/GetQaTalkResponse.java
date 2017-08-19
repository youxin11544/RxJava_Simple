package haibao.com.api.data.response.company;

import haibao.com.api.data.response.global.ShareBean;

/**
 * Created by Administrator on 2017/6/8.
 */
public class GetQaTalkResponse {

    /**
     * {
     * "type":"1",
     * "title":"",
     * "desc":"",
     * "covers":"",
     * "share":{
     * "title":"",
     * "content":"",
     * "url":"",
     * "image":""
     * }
     * }
     */
    public int type;
    public String title;
    public String desc;
    public String icon;
    public ShareBean share;

}
