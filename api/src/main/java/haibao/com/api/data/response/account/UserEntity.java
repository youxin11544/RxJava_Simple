package haibao.com.api.data.response.account;

/**
 *
 * Created by Administrator on 2016/10/21 0021.
 */
public class UserEntity {

    private Integer ttl;
    private Integer user_id;
    private String token;
    private String continue_url;//https://fxm5547.baobaobooks.com"
    private String accid_token;//https://fxm5547.baobaobooks.com"

    public String getAccid_token() {
        return accid_token;
    }

    public UserEntity setAccid_token(String accid_token) {
        this.accid_token = accid_token;
        return this;
    }

    public String getContinue_url() {
        return continue_url;
    }

    public void setContinue_url(String continue_url) {
        this.continue_url = continue_url;
    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
}
