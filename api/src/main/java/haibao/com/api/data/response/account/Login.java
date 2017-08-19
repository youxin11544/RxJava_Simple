package haibao.com.api.data.response.account;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

public class Login implements Serializable {

    private int ttl;
    private String token;
    private int expire = HttpCommon.INVALID_INT_VALUE;
    private int user_id = HttpCommon.INVALID_INT_VALUE;
    private String accid_token;//https://fxm5547.baobaobooks.com"

    public String getAccid_token() {
        return accid_token;
    }

    public Login setAccid_token(String accid_token) {
        this.accid_token = accid_token;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }


    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
