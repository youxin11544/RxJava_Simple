package haibao.com.api.data.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/27 0027.
 */

public class ApiBaseUrlBean implements Serializable {
    public AccountBean account;
    public AybBean ayb;
    public SmsBean sms;

    public static class AccountBean implements Serializable{
        /**
         * version : v1
         * endpoint : https://api.baobaobooks.net/account
         */
        public String version;
        public String endpoint;
    }

    public static class AybBean implements Serializable{
        /**
         * version : v2
         * endpoint : https://api.baobaobooks.net/ayb
         */

        public String version;
        public String endpoint;
    }

    public static class SmsBean implements Serializable{
        /**
         * version : v1
         * endpoint : https://api.baobaobooks.net/sms
         */

        public String version;
        public String endpoint;
    }

}
