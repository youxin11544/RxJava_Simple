package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 绑定手机号返回数据模型
 */
public class BindMobile implements Serializable {

    private int user_id;
    private String mobile;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
