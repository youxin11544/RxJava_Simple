//package haibao.com.api.data.response.bookShelfResponse;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * 书籍下的文章详情
// * {@link com.base.basesdk.data.http.service.BookshelfService#getContentsByBookIsbn(int)} (int)}
// * Created by Administrator on 2016/10/26 0026.
// */
//public class ContentsResponse implements Serializable {
//
//    /**
//     * content_id : 933 内容的ID
//     * content_type : 2 类型，2代表视频，3代表音频，4代表图文
//     * user_id : 56938 用户名 用户ID
//     * title : 测试专栏PC端上传视频封面图（未上传封面图 ） 标题
//     * summary : null 摘要
//     * cover_middle : https://osstest.baobaobooks.net/ayb/images/content/201602/145621438198560_middle.jpg 封面图（小），尺寸150*150
//     * cover_thumb : https://osstest.baobaobooks.net/ayb/images/content/201602/145621438198560_thumb.jpg 封面图（中），尺寸480*270
//     * pub_time : 28天前 发布时间
//     * user_name : luse 用户名
//     * praise : 0 点赞数
//     * click : 10 点击数
//     */
//
//    private List<ItemsBean> items;
//
//    public List<ItemsBean> getItems() {
//        return items;
//    }
//
//    public void setItems(List<ItemsBean> items) {
//        this.items = items;
//    }
//
//    public static class ItemsBean {
//        private String content_id;
//        private String content_type;
//        private String user_id;
//        private String title;
//        private String summary;
//        private String cover_middle;
//        private String cover_thumb;
//        private String pub_time;
//        private String user_name;
//        private int praise;
//        private int click;
//
//        public String getContent_id() {
//            return content_id;
//        }
//
//        public void setContent_id(String content_id) {
//            this.content_id = content_id;
//        }
//
//        public String getContent_type() {
//            return content_type;
//        }
//
//        public void setContent_type(String content_type) {
//            this.content_type = content_type;
//        }
//
//        public String getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(String user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getSummary() {
//            return summary;
//        }
//
//        public void setSummary(String summary) {
//            this.summary = summary;
//        }
//
//        public String getCover_middle() {
//            return cover_middle;
//        }
//
//        public void setCover_middle(String cover_middle) {
//            this.cover_middle = cover_middle;
//        }
//
//        public String getCover_thumb() {
//            return cover_thumb;
//        }
//
//        public void setCover_thumb(String cover_thumb) {
//            this.cover_thumb = cover_thumb;
//        }
//
//        public String getPub_time() {
//            return pub_time;
//        }
//
//        public void setPub_time(String pub_time) {
//            this.pub_time = pub_time;
//        }
//
//        public String getUser_name() {
//            return user_name;
//        }
//
//        public void setUser_name(String user_name) {
//            this.user_name = user_name;
//        }
//
//        public int getPraise() {
//            return praise;
//        }
//
//        public void setPraise(int praise) {
//            this.praise = praise;
//        }
//
//        public int getClick() {
//            return click;
//        }
//
//        public void setClick(int click) {
//            this.click = click;
//        }
//    }
//}
