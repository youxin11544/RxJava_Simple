package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 作者: fyd   2016/10/24 0024.
 * 邮箱: fuyidong@163.com
 */

public class SendSMS implements Serializable {

    private int ttl;

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
}