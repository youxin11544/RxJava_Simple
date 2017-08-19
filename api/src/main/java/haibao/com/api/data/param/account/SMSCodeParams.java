package haibao.com.api.data.param.account;

/**
 * 作者: fyd   2016/10/24 0024.
 * 邮箱: fuyidong@163.com
 */

public class SMSCodeParams {
    /**
     * 验证短信验证码
     *
     * @param mobile   手机号
     * @param code     验证码
     * @param type     验证类型
     */

    public String mobile;
    public String country_code;
    public String code;
    public String type;
    public String sign;

    public SMSCodeParams(String mobile, int country_code, String code, String type,String sign){
        this.mobile=mobile;
        this.country_code=String.valueOf(country_code);
        this.code=code;
        this.type=type;
        this.sign=sign;
    }

}
