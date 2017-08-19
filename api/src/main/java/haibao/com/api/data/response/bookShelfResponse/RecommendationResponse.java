//package haibao.com.api.data.response.bookShelfResponse;
//
//
//import java.io.Serializable;
//
///**
// * 推荐阅读数据模型
// * {@link BookshelfService#getRecommendedBook()}
// * Created by Android on 2016-03-14.
// */
//public class RecommendationResponse implements Serializable{
//
//    /**
//     * shelf_id : 1471750
//     * created_at :
//     * user_id : 0
//     * isbn_id : 5003
//     * book_img_thumb : https://oss.baobaobooks.net/images/201407/thumb_img/5003_thumb_G_1404268794716.jpg
//     * goods_name :
//     * book_name : 1953年凯迪克银奖作品 The Storm Book 暴风雨 【平装】
//     * is_read : 0
//     * is_group : 0
//     * isbn_id : 990
//     */
//
//    private RecommendationBean recommendation;
//
//    public RecommendationBean getRecommendation() {
//        return recommendation;
//    }
//
//    public void setRecommendation(RecommendationBean recommendation) {
//        this.recommendation = recommendation;
//    }
//
//    public static class RecommendationBean {
//        private String shelf_id;
//        private String created_at;
//        private int user_id;
//        private String isbn_id;
//        private String book_img_thumb;
//        private String goods_name;
//        private String book_name;
//        private int is_read;
//        private int is_group;
//        private String isbn_id;
//
//        public String getShelf_id() {
//            return shelf_id;
//        }
//
//        public void setShelf_id(String shelf_id) {
//            this.shelf_id = shelf_id;
//        }
//
//        public String getCreated_at() {
//            return created_at;
//        }
//
//        public void setCreated_at(String created_at) {
//            this.created_at = created_at;
//        }
//
//        public int getUser_id() {
//            return user_id;
//        }
//
//        public void setUser_id(int user_id) {
//            this.user_id = user_id;
//        }
//
//        public String getGoods_id() {
//            return isbn_id;
//        }
//
//        public void setGoods_id(String isbn_id) {
//            this.isbn_id = isbn_id;
//        }
//
//        public String getBook_img_thumb() {
//            return book_img_thumb;
//        }
//
//        public void setBook_img_thumb(String book_img_thumb) {
//            this.book_img_thumb = book_img_thumb;
//        }
//
//        public String getGoods_name() {
//            return goods_name;
//        }
//
//        public void setGoods_name(String goods_name) {
//            this.book_name = book_name;
//        }
//
//        public String getBook_name() {
//            return book_name;
//        }
//
//        public void setBook_name(String book_name) {
//            this.book_name = book_name;
//        }
//
//        public int getIs_read() {
//            return is_read;
//        }
//
//        public void setIs_read(int is_read) {
//            this.is_read = is_read;
//        }
//
//        public int getIs_group() {
//            return is_group;
//        }
//
//        public void setIs_group(int is_group) {
//            this.is_group = is_group;
//        }
//
//        public String getIsbn_id() {
//            return isbn_id;
//        }
//
//        public void setIsbn_id(String isbn_id) {
//            this.isbn_id = isbn_id;
//        }
//    }
//}
