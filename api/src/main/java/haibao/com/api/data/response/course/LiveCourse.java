package haibao.com.api.data.response.course;

import java.io.Serializable;

import haibao.com.api.data.response.global.ShareBean;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class LiveCourse implements Serializable {
    /**
     * course_id : 1
     * title : 课程名称
     * covers : https://ossimage.baobaobooks.net/image/1452423432.png
     * lecturer_id : 2
     * lecturer_name :
     * lecturer_avatar :
     * lecturer_desc :
     * live_time : 145645453
     * live_time_format :
     * live_end_time : 145645453
     * live_type : 1
     * live_status : 1
     * live_push_url : 1
     * live_pull_hls_url : 1
     * live_pull_rtmp_url : 1
     * channel_id : 19
     * channel_name : 0-12个月
     * video_url :
     * video_duration_format :
     * video_cover :
     * courseware_format : 43
     * courseware_timestamp :
     * is_learned : 1
     * is_subscribed : 1
     * learned_desc :
     * isbn_id : 9430
     * book_name :
     * book_img_thumb :
     * goods_shop_url :
     * course_desc : 课程简介
     * share : {"title":"","content":"","url":"","image":""}
     * isbn_id 可选	Integer
     * 相关图书isbn_id
     * <p>
     * book_name 可选	String
     * 图书名称
     * <p>
     * book_img_thumb 可选	String
     * 图书的cover
     * <p>
     * book_brief
     * <p>
     * "summary":"课程简介",
     * "course_desc_url":"",
     * <p>
     * <p>
     * recommend_age
     * 添加价格
     */

    public String recommend_age;
    //    课程价格，保留2位小数，格式：0.00
    public String price;

    //    是否促销，1是0否
    public Integer is_promotion;

    //    促销价格，保留2位小数，格式：0.00
    public String promotion_price;

    //    促销开始时间，时间戳
    public Integer promotion_start_time;

    //    促销结束时间，时间戳
    public Integer promotion_end_time;

    //    是否购买，1-是，0-否
    public Integer is_buy;

    public Integer live_end_time;

    public String live_push_url;
    public String live_pull_hls_url;
    public String live_pull_rtmp_url;


    public Integer is_learned;

    public Integer is_subscribed;

    public Integer channel_id;

    public String channel_name;

    public String course_desc;

    public String lecturer_avatar;

    public String lecturer_desc;

    public Integer lecturer_id;

    public String lecturer_name;

    public ShareBean share;


    public Integer chat_chatroom_id;

    public String chat_roomid;

    public Integer course_id = 0;

    public String courseware_format;

    public String cover;

    public Integer is_joined;

    public String learned_desc;

    public Integer live_status = 0;

    public Integer live_time;

    public String live_time_format;

    public Integer live_type;

    public String title;

    public String video_cover;

    public String video_duration_format;

    public String video_url;

    public Integer isbn_id;//可选	    相关童书isbn_id

    public String book_name; //可选	 童书商品名称
    @Deprecated
    public String goods_shop_url; //可选	String 童书简介

    public String book_brief;

    public String book_img_thumb; //可选	String 童书的cover

    public String summary;  //课程摘要
    public String course_desc_url; //课程详情的URL

}
