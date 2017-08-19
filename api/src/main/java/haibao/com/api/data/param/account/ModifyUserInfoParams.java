package haibao.com.api.data.param.account;


/**
 *  ModifyUserInfoParams
 *
 user_name 可选	String 用户名，可以使用第三方帐号昵称传递  取值范围: 1..32

 email 可选	String  邮箱，和is_validated同时传递

 is_validated 可选	String 邮箱是否验证，0-未验证，1-已验证  允许值: "0", "1"

 role 可选	String[]  身份，数组，可能为1-妈妈/2-爸爸、3-老师  允许值: "1", "2", "3"

 signature 可选	String 用户签名  取值范围: 1..100

 covers 可选	String 用户海报图URL，用于设置个人主页头像背景

 avatar 可选	String 头像url地址

 lecturer_desc 可选	String 讲师简介

 promoter_desc 可选	String 推广人简介

 sex 可选	Integer 性别，1男2女  允许值: 1, 2
 *
 *  @author fyd
 *  @time 2017/3/31
 */
public class ModifyUserInfoParams {

    public String user_name;
    public String email;
    public String is_validated;
    public String[] role;
    public String signature;
    public String cover;
    public String avatar;
    public String lecturer_desc;
    public String promoter_desc;
    public Integer sex;
}
