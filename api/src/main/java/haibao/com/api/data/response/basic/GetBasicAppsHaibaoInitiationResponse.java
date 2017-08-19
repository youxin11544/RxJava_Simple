package haibao.com.api.data.response.basic;

import java.io.Serializable;

public class GetBasicAppsHaibaoInitiationResponse implements Serializable {
    /**
     * urls : {"agreement_url":"https://account.baobaobooks.net/terms","about_url_path":"/app/about","order_url_path":"/orders","wallet_url_path":"/wallet"}
     * contact : {"wechat_qrcode":"https://osstest.baobaobooks.net/qrcode/wechat_babybabytown.png","tel":"0755-29485501","mail":"800085086@qq.com","qq":"800085086"}
     */

    public UrlsBean urls;
    public ContactBean contact;
    public ImgStylesBean img_styles;


    public static class UrlsBean implements Serializable {
        /**
         * agreement_url : https://account.baobaobooks.net/terms
         * about_url_path : /app/about
         * order_url_path : /orders
         * wallet_url_path : /wallet
         */

        public String agreement_url;
        public String about_url_path;
        public String order_url_path;
        public String wallet_url_path;

    }

    public static class ContactBean implements Serializable {
        /**
         * wechat_qrcode : https://osstest.baobaobooks.net/qrcode/wechat_babybabytown.png
         * tel : 0755-29485501
         * mail : 800085086@qq.com
         * qq : 800085086
         */

        public String wechat_qrcode;
        public String tel;
        public String mail;
        public String qq;


    }

    public static class ImgStylesBean implements Serializable {
        /**
         * wechat_qrcode : https://osstest.baobaobooks.net/qrcode/wechat_babybabytown.png
         * tel : 0755-29485501
         * mail : 800085086@qq.com
         * qq : 800085086
         */
        public String avatar_thumb;
        public String avatar_thumb_im;
    }


//  public ContactBean contact;
//
//  public UrlsBean urls;
//
//  public static class ContactBean {
//    public String mail;
//
//    public String qq;
//
//    public String tel;
//
//    public String wechat_qrcode;
//  }
//
//  public static class UrlsBean {
//    public String about_url;
//
//    public String agreement_url;
//
//    public String order_url;
//  }


}
