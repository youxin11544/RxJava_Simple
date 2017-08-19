//package haibao.com.api.common;
//
//
//import static haibao.com.api.common.CommonUrl.AYB_BASE;
//
///**
// * 书架部分的URL
// * Created by Administrator on 2016/10/26 0026.    没有用过 暂时去掉
// */
//public interface BookShelfUrl {
//
//    String P_BOOKS = "books";
//
//    /**
//     * 用户书架
//     */
//    String AYB_USER_BOOKSHELF = AYB_BASE + "user/bookshelf";
//
//    /**
//     * 推荐书籍
//     */
//    String AYB_USER_BOOKSHELF_RECOMMENDED = AYB_USER_BOOKSHELF + "/recommended";
//    /**
//     * 根据书名搜索书架
//     */
//    String AYB_USER_BOOKSHELF_SEARCH = AYB_USER_BOOKSHELF + "/search";
//    /**
//     * 扫码成功后的信息
//     */
//    String AYB_SCAN = AYB_BASE + "scan";
//
//    /**
//     * 获取绘本详情
//     */
//    String AYB_BOOKSHELF_BOOKS = AYB_BASE + "bookshelf/books";
//
//    /**
//     * 批量删除书架
//     */
//    String AYB_USER_BOOKSHELF_BATCH = AYB_BASE + "user/bookshelf/batch";
//
//    /**
//     * 有声资源下拉提示
//     */
//    String AYB_USER_BOOKSHELF_AUDIO_RESOURCE_TIPS = AYB_BASE + "/user/bookshelf/suggestions";
//
//    /**
//     *  有声资源下拉提示跳资源页
//     */
//    String AYB_USER_BOOKSHELF_AUDIO_RESOURCE_TIPS_WEBSITES = AYB_BASE + "/user/bookshelf/suggestions/audio";
//
//    /**
//     * 用户相关的部分-根据goods_id得到书籍列表
//     */
//    String AYB_GOODS=AYB_BASE+ "goods";
//    /**
//     * 课堂-获取某个频道下的书籍列表
//     */
//    String AYB_CHANNELS = AYB_BASE + "channels";
//
//     interface DefaultParams {
//        /**
//         * 第几页，初始传值可以为1或者不传
//         */
//        int DEFAULT_PAGE = 1;
//        /**
//         * 每页显示的条数，默认值15
//         */
//        int DEFAULT_PER_PAGE = 15;
//        /**
//         * 只看有内容，默认值false
//         */
//        String DEFAULT_CONTENTS = "false";
//        /**
//         * 可选	String
//         * 有声资源，默认值false
//         */
//
//        String DEFAULT_IS_AUDIO = "false";
//        /**
//         * 童书馆域名，默认值空
//         */
//        String DEFAULT_DOMAIN = null;
//    }
//}
