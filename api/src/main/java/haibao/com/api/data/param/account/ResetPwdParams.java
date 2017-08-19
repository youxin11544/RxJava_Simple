package haibao.com.api.data.param.account;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class ResetPwdParams {

    /**
     * 重置密码
     *
     * @param mobile       已绑定的手机号
     * @param new_password 新密码
     */
    public String mobile;
    public String mobile_country_code;
    public String smscode;
    public String new_password;

    public ResetPwdParams(String mobile, int country_code, String code, String new_password) {

        this.mobile = mobile;
        this.mobile_country_code = String.valueOf(country_code);
        this.smscode = code;
        this.new_password = new_password;


    }


}
