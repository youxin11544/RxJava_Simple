package haibao.com.api.data.param.account;

import android.text.TextUtils;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class RegisterParams {

    public String account;
    public String code;
    public String password;
    public String type;
    public String user_name;
    public String mobile_country_code;


    public RegisterParams(String account, int country_code, String code, String password, String username,String type) {
        this.account = account;
        this.code = code;
        this.password = password;
        if(!TextUtils.isEmpty(username)){
            this.user_name = username;
        }
        this.mobile_country_code = String.valueOf(country_code);
        this.type =type;

    }
}
