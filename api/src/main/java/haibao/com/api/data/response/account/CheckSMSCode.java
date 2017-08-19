package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 校验短信验证码数据模型
 */
public class CheckSMSCode implements Serializable {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
