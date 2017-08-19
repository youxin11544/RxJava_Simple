package haibao.com.api.data.response.mineResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fu on 2016/11/4 0004.
 */

public class HomapageResponse implements Serializable {

    private int baby_count;
    private int friend_status;

    private UserInfoBean userInfo;

    private List<BabyInfoBean> babyInfo;

    public int getBaby_count() {
        return baby_count;
    }

    public void setBaby_count(int baby_count) {
        this.baby_count = baby_count;
    }

    public int getFriend_status() {
        return friend_status;
    }

    public void setFriend_status(int friend_status) {
        this.friend_status = friend_status;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean muserInfo) {
        userInfo = muserInfo;
    }

    public List<BabyInfoBean> getBabyInfo() {
        return babyInfo;
    }

    public void setBabyInfo(List<BabyInfoBean> babyInfo) {
        this.babyInfo = babyInfo;
    }

    public static class UserInfoBean {
        private String avatar;
        private int books_count;
        private String city;
        private int collection_count;
        private int content_count;
        private int content_reward;
        private int follow_count;
        private int friend_count;
        private String is_columnist;
        private String province;
        private String signature;
        private String store_desc;
        private String store_domain;
        private String store_id;
        private String store_logo;
        private String store_name;
        private String user_id;
        private String user_name;
        private List<String> role;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getBooks_count() {
            return books_count;
        }

        public void setBooks_count(int books_count) {
            this.books_count = books_count;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCollection_count() {
            return collection_count;
        }

        public void setCollection_count(int collection_count) {
            this.collection_count = collection_count;
        }

        public int getContent_count() {
            return content_count;
        }

        public void setContent_count(int content_count) {
            this.content_count = content_count;
        }

        public int getContent_reward() {
            return content_reward;
        }

        public void setContent_reward(int content_reward) {
            this.content_reward = content_reward;
        }

        public int getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(int follow_count) {
            this.follow_count = follow_count;
        }

        public int getFriend_count() {
            return friend_count;
        }

        public void setFriend_count(int friend_count) {
            this.friend_count = friend_count;
        }

        public String getIs_columnist() {
            return is_columnist;
        }

        public void setIs_columnist(String is_columnist) {
            this.is_columnist = is_columnist;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getStore_desc() {
            return store_desc;
        }

        public void setStore_desc(String store_desc) {
            this.store_desc = store_desc;
        }

        public String getStore_domain() {
            return store_domain;
        }

        public void setStore_domain(String store_domain) {
            this.store_domain = store_domain;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
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

        public List<String> getRole() {
            return role;
        }

        public void setRole(List<String> role) {
            this.role = role;
        }
    }

    public static class BabyInfoBean {
        private String age;
        private String avatar;
        private String baby_id;
        private String birthday;
        private String days;
        private String name;
        private String read_count;
        private String read_rank;
        private String sex;

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

        public String getBaby_id() {
            return baby_id;
        }

        public void setBaby_id(String baby_id) {
            this.baby_id = baby_id;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRead_count() {
            return read_count;
        }

        public void setRead_count(String read_count) {
            this.read_count = read_count;
        }

        public String getRead_rank() {
            return read_rank;
        }

        public void setRead_rank(String read_rank) {
            this.read_rank = read_rank;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }



}
