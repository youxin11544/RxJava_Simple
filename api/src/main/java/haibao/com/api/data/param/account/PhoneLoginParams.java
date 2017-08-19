package haibao.com.api.data.param.account;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class PhoneLoginParams {

    public String mobile;
    public String smscode;
    public String mobile_country_code;

    public PhoneLoginParams(String mobile, String smscode, String mobile_country_code) {
        this.mobile = mobile;
        this.smscode = smscode;
        this.mobile_country_code = mobile_country_code;
    }
}
