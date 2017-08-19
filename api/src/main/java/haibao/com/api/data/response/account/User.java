package haibao.com.api.data.response.account;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.LocationBean;

public class User implements Serializable {

    //accid_token

    /**
     * user_id : 36845
     * user_name : fxm5547
     * signature : 哈哈O(∩_∩)O哈哈~(*^__^*) 嘻嘻……
     * covers :      //用户海报图URL，用于设置个人主页头像背景
     * avatar : https://osstestimg.baobaobooks.net/images/avatar/201609/147435640863490.jpg@1e_1c_180w_180h_95q
     * avatar_thumb : https://osstestimg.baobaobooks.net/images/avatar/201609/147435640863490.jpg@1e_1c_0o_1l_50h_50w_95q
     * sex : 1
     * role : ["妈妈","老师"]
     * mobile_phone : 18696152761
     * country_code : 86
     * user_money : 10723.40
     * pay_points : 299
     * pay_points_money : 1.5
     * rank_points : 24746
     * rank_name : 钻石会员
     * discount : 9.5
     * next_rank_name : 采购商
     * next_discount : 9.2
     * next_diff_rank_points : 5254
     * location : {"province":"安徽","city":"巢湖","district":"","address":"","address_detail":"","longitude":"","latitude":""}
     * is_promoter : 1
     * is_reseller : 0
     * is_bizbuyer : 0
     * is_family : 1
     * is_lecturer : 1
     * promoter_desc : 我一厢情愿徐熙媛一XPwry是也破也破也破也我我一厢情愿徐熙媛一XPwry是也破也破也破也我
     * lecturer_desc :
     */

    public Integer friend_status;
    public String user_id;
    public String user_name;
    public String signature;
    public List<String> covers;
    public String avatar;
    public String avatar_thumb;
    public String sex;
    public String mobile_phone;
    public String country_code;
    public String user_money;
    public String pay_points;
    public double pay_points_money;
    public String rank_points;
    public String rank_name;
    public double discount;
    public String next_rank_name;
    public double next_discount;
    public int next_diff_rank_points;
    public LocationBean location;
    public int is_promoter;
    public int is_reseller;
    public int is_bizbuyer;
    public int is_family;
    public Integer is_lecturer;
    public String promoter_desc;
    public String lecturer_desc;
    public List<String> role;
    public String user_role;
    public String created_at;
    //添加云信的token在用户详情内
    public String accid_token;

    public String getAccid_token() {
        return accid_token;
    }

    public User setAccid_token(String accid_token) {
        this.accid_token = accid_token;
        return this;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    //下面字段是第三方登陆返回的，自己设置到这个对象保存
    public String sns_user_id;
    public String province;
    public String city;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getCovers() {
        return covers;
    }

    public void setCovers(List<String> covers) {
        this.covers = covers;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar_thumb() {
        return avatar_thumb;
    }

    public void setAvatar_thumb(String avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getUser_money() {
        return user_money;
    }

    public void setUser_money(String user_money) {
        this.user_money = user_money;
    }

    public String getPay_points() {
        return pay_points;
    }

    public void setPay_points(String pay_points) {
        this.pay_points = pay_points;
    }

    public double getPay_points_money() {
        return pay_points_money;
    }

    public void setPay_points_money(double pay_points_money) {
        this.pay_points_money = pay_points_money;
    }

    public String getRank_points() {
        return rank_points;
    }

    public void setRank_points(String rank_points) {
        this.rank_points = rank_points;
    }

    public String getRank_name() {
        return rank_name;
    }

    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getNext_rank_name() {
        return next_rank_name;
    }

    public void setNext_rank_name(String next_rank_name) {
        this.next_rank_name = next_rank_name;
    }

    public double getNext_discount() {
        return next_discount;
    }

    public void setNext_discount(double next_discount) {
        this.next_discount = next_discount;
    }

    public int getNext_diff_rank_points() {
        return next_diff_rank_points;
    }

    public void setNext_diff_rank_points(int next_diff_rank_points) {
        this.next_diff_rank_points = next_diff_rank_points;
    }


    public int getIs_promoter() {
        return is_promoter;
    }

    public void setIs_promoter(int is_promoter) {
        this.is_promoter = is_promoter;
    }

    public int getIs_reseller() {
        return is_reseller;
    }

    public void setIs_reseller(int is_reseller) {
        this.is_reseller = is_reseller;
    }

    public int getIs_bizbuyer() {
        return is_bizbuyer;
    }

    public void setIs_bizbuyer(int is_bizbuyer) {
        this.is_bizbuyer = is_bizbuyer;
    }

    public int getIs_family() {
        return is_family;
    }

    public void setIs_family(int is_family) {
        this.is_family = is_family;
    }

    public Integer getIs_lecturer() {
        return is_lecturer;
    }

    public void setIs_lecturer(int is_lecturer) {
        this.is_lecturer = is_lecturer;
    }

    public String getPromoter_desc() {
        return promoter_desc;
    }

    public void setPromoter_desc(String promoter_desc) {
        this.promoter_desc = promoter_desc;
    }

    public String getLecturer_desc() {
        return lecturer_desc;
    }

    public void setLecturer_desc(String lecturer_desc) {
        this.lecturer_desc = lecturer_desc;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }


    public String getSns_user_id() {
        return sns_user_id;
    }

    public void setSns_user_id(String sns_user_id) {
        this.sns_user_id = sns_user_id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return user_id != null ? user_id.equals(user.user_id) : user.user_id == null;

    }

    @Override
    public String toString() {
        return "User{" +
                "friend_status=" + friend_status +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", signature='" + signature + '\'' +
                ", covers=" + covers +
                ", avatar='" + avatar + '\'' +
                ", avatar_thumb='" + avatar_thumb + '\'' +
                ", sex='" + sex + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", country_code='" + country_code + '\'' +
                ", user_money='" + user_money + '\'' +
                ", pay_points='" + pay_points + '\'' +
                ", pay_points_money=" + pay_points_money +
                ", rank_points='" + rank_points + '\'' +
                ", rank_name='" + rank_name + '\'' +
                ", discount=" + discount +
                ", next_rank_name='" + next_rank_name + '\'' +
                ", next_discount=" + next_discount +
                ", next_diff_rank_points=" + next_diff_rank_points +
                ", location=" + location +
                ", is_promoter=" + is_promoter +
                ", is_reseller=" + is_reseller +
                ", is_bizbuyer=" + is_bizbuyer +
                ", is_family=" + is_family +
                ", is_lecturer=" + is_lecturer +
                ", promoter_desc='" + promoter_desc + '\'' +
                ", lecturer_desc='" + lecturer_desc + '\'' +
                ", role=" + role +
                ", user_role='" + user_role + '\'' +
                ", created_at='" + created_at + '\'' +
                ", accid_token='" + accid_token + '\'' +
                ", sns_user_id='" + sns_user_id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
