package haibao.com.api.data.param.account;

/**
 * 作者: fyd   2016/10/24 0024.
 * 邮箱: fuyidong@163.com
 */

public class bindMobileParams {


    /**
     * 绑定手机号
     *
     * @param user_id  用户ID
     * @param token    令牌
     * @param mobile   手机号
     * @param smscode     验证码
     */


    public String mobile;
    public int mobile_country_code;
    public String smscode;


    public bindMobileParams(String mobile, int mobile_country_code, String smscode) {

        this.mobile = mobile;
        this.mobile_country_code = mobile_country_code;
        this.smscode = smscode;

    }


}
