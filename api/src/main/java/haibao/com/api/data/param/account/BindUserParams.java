package haibao.com.api.data.param.account;

import android.text.TextUtils;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class BindUserParams {

    /**
     * 绑定第三方账号
     *
     * @param bind_type    绑定类型，可能的取值：bindonly（已有账号直接绑定）
     *                     create_and_bind（没有帐号，新建账号再绑定）
     * @param sns_user_id  第三方平台用户唯一标识
     * @param type         第三方平台类型，取值：wechat（微信） 、qq（QQ） 、weibo（微博）、wechat_open（微信公众号） 、alipay（支付宝）
     * @param account_type 账号类型，取值： user_name（仅bindonly时）、email、mobile_phone
     * @param account      用户账号，可以是用户名、邮箱、手机号
     * @param password     密码
     * @param user_name    用户名，可以使用第三方账户昵称传递，仅create_and_bind时传递
     * @param sns_email    第三方用户邮箱
     * @param sns_avatar   第三方用户头像URL地址
     * @param mobile_country_code  手机号国家码
     */

    public String bind_type;
    public String sns_user_id;
    public String type;
    public String account_type;
    public String account;
    public String password;
    public String user_name;
    public String sns_email;
    public String sns_avatar;
    public String mobile_country_code;

    public BindUserParams(String bind_type, String sns_user_id, String type, String account_type,
                          String account, String password, String user_name, String sns_email, String sns_avatar,String mobile_country_code) {
        this.bind_type = bind_type;
        this.sns_user_id = sns_user_id;
        this.type = type;
        this.account_type = account_type;
        this.account = account;
        this.password = password;
        this.user_name = user_name;
        this.sns_email = sns_email;
        this.sns_avatar = sns_avatar;
        if(!TextUtils.isEmpty(mobile_country_code)){
            this.mobile_country_code = mobile_country_code;
        }
    }


}
