package haibao.com.api.data.param.account;

/**
 * 作者: fyd   2016/10/24 0024.
 * 邮箱: fuyidong@163.com
 */

public class SendSMSParams {

    /**
     * 发送请求发送验证码短信的请求
     *
     * @param mobile   手机号
     * @param type     验证码的类型
     */

//    public SendSMSParams(String uri) {
//        super(uri);
//    }

    public String mobile;
    public String sign;
    public String type;
    public String country_code;


    public SendSMSParams(String mobile, int country_code, String type,String sign) {
        this.sign = sign;
        this.mobile = mobile;
        this.country_code = String.valueOf(country_code);
        this.type = type;
    }

}
