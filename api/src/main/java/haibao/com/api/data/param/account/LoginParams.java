package haibao.com.api.data.param.account;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class LoginParams {

    public String account;
    public String password;
    public String mobile_country_code;//mobile_country_code 可选	String	 国际码

    public LoginParams(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
