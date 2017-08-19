//package haibao.com.api.data.response.bookShelfResponse;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * 有声资源下拉提示跳资源页
// * {@link com.base.basesdk.data.http.service.BookshelfService#getAudioWebSitesSuggestionsByQKey(String)}
// * Created by Administrator on 2016/10/26 0026.
// */
//public class AudioWebSitesResponse implements Serializable{
//
//    /**
//     * goods_name : 美国加州 Evan-Moor 出品学生用书 技巧磨练科学系列 Skill Sharpeners: Science,Grade 1 【平装】（一年级）
//     * audio_url : http://zl.baobaobooks.net/ayb/audio/8478/books
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
//        private String goods_name;
//        private String audio_url;
//
//        public String getGoods_name() {
//            return goods_name;
//        }
//
//        public void setGoods_name(String goods_name) {
//            this.book_name = book_name;
//        }
//
//        public String getAudio_url() {
//            return audio_url;
//        }
//
//        public void setAudio_url(String audio_url) {
//            this.audio_url = audio_url;
//        }
//    }
//}
