package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;

import haibao.com.api.data.response.global.ShareBean;

/**
 * 获取绘本详情
 * {@link }
 * Created by Administrator on 2016/10/26 0026.
 */

public class BookInfoResponse implements Serializable {
    /**
     * isbn_id : 1330
     * isbn_id : 5705
     * book_name : 美国加州 Evan-Moor 出品学生用书 技巧磨练阅读系列 Skill Sharpeners Reading Grade K【平装】（幼儿园）
     * book_brief : 美国原装进口。
     * Evan-Moor Educational Publishers
     * 美国加州非常著名的教材出版社，自1979年以来，便一直致力于提供教育者最实用、创意及吸引人的幼儿教育产品，支援与丰富教学课程。
     * is_audio : 1
     * is_video : 0
     * is_course : 0
     * is_content : 1
     * is_allabout : 0
     * author_name : Jane Yolen
     * drawer_name : Mark Teague
     * book_img_thumb : https://oss.baobaobooks.net/images/201408/thumb_img/5705_thumb_G_1407312354926.jpg?w=320&h=320
     * shop_url : https://fxm5547.baobaobooks.net/goods/5705
     * share : {"title":"","content":"","url":"","image":""}
     */

    private int isbn_id;
    private int goods_id;
    private String book_name;
    private String book_brief;
    private int is_audio;
    private int is_video;
    private int is_course;
    private int is_content;
    private int is_allabout;
    private String author_name;
    private String drawer_name;
    private String book_img_thumb;
    private String shop_url;
    private ShareBean share;
    //新增加的字段
    public int family_count;//阅读此书的家庭数
    public int is_added;//是否已加入书架，1-是，0-否
    public int is_haibao;//是否从孩宝官方渠道购买，1-是，0-否
    public Object wechatSign; //可选,微信签名（只有在微信内访问时才有）
    public String appId;//微信ID
    public String timestamp;//微信时间戳
    public String nonceStr;//微信字符串
    public String signature;//微信验证
    public String url;//签名连接
    public String rawString;//签名参数


    public int getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(int isbn_id) {
        this.isbn_id = isbn_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_brief() {
        return book_brief;
    }

    public void setBook_brief(String book_brief) {
        this.book_brief = book_brief;
    }

    public int getIs_audio() {
        return is_audio;
    }

    public void setIs_audio(int is_audio) {
        this.is_audio = is_audio;
    }

    public int getIs_video() {
        return is_video;
    }

    public void setIs_video(int is_video) {
        this.is_video = is_video;
    }

    public int getIs_course() {
        return is_course;
    }

    public void setIs_course(int is_course) {
        this.is_course = is_course;
    }

    public int getIs_content() {
        return is_content;
    }

    public void setIs_content(int is_content) {
        this.is_content = is_content;
    }

    public int getIs_allabout() {
        return is_allabout;
    }

    public void setIs_allabout(int is_allabout) {
        this.is_allabout = is_allabout;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDrawer_name() {
        return drawer_name;
    }

    public void setDrawer_name(String drawer_name) {
        this.drawer_name = drawer_name;
    }

    public String getBook_img_thumb() {
        return book_img_thumb;
    }

    public void setBook_img_thumb(String book_img_thumb) {
        this.book_img_thumb = book_img_thumb;
    }

    public String getShop_url() {
        return shop_url;
    }

    public void setShop_url(String shop_url) {
        this.shop_url = shop_url;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }
}
