package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 查询是否是第三方账号返回数据模型
 */
public class CheckSnsUsername implements Serializable {

    private int is_sns;

    public int getIs_sns() {
        return is_sns;
    }

    public void setIs_sns(int is_sns) {
        this.is_sns = is_sns;
    }
}
