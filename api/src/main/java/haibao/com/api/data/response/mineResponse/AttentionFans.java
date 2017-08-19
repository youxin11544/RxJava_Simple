package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by fu on 2016/11/2 0002.
 */
public class AttentionFans implements Serializable {

    public String avatar;

    private int friend_status = HttpCommon.INVALID_INT_VALUE;

    public String signature;

    public Integer user_id;

    public String user_name;


    private String follower_id;
    private String following_id;
    private String is_columnist;
    private String store_id;
    private String age;
    private String avatar_thumb;
    private String city;
    private String created_at;
    private String province;
    private String store_domain;
    private String store_logo;
    private String store_name;



    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(String following_id) {
        this.following_id = following_id;
    }

    public String getIs_columnist() {
        return is_columnist;
    }

    public void setIs_columnist(String is_columnist) {
        this.is_columnist = is_columnist;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStore_domain() {
        return store_domain;
    }

    public void setStore_domain(String store_domain) {
        this.store_domain = store_domain;
    }

    public String getStore_logo() {
        return store_logo;
    }

    public void setStore_logo(String store_logo) {
        this.store_logo = store_logo;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public int getFriend_status() {
        return friend_status;
    }

    public void setFriend_status(int friend_status) {
        this.friend_status = friend_status;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAvatar_thumb() {
        return avatar_thumb;
    }

    public void setAvatar_thumb(String avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

}
