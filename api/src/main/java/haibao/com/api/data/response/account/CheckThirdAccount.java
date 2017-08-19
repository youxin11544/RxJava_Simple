package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 检查是否是已经绑定过的第三方账号数据模型
 */
public class CheckThirdAccount implements Serializable {

    @Deprecated
    private int expire;

    private int user_id;
    private String token;
    private String binded;
    private String accid_token;
    private Integer ttl;


    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBinded() {
        return binded;
    }

    public void setBinded(String binded) {
        this.binded = binded;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccid_token() {
        return accid_token;
    }

    public CheckThirdAccount setAccid_token(String accid_token) {
        this.accid_token = accid_token;
        return this;
    }

    public Integer getTtl() {
        return ttl;
    }

    public CheckThirdAccount setTtl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }
}
