package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.baby.Baby;
import haibao.com.api.data.response.account.User;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class Homepage implements Serializable {

    private List<Baby> babyInfo;
    private int baby_count;
    private int friend_status;
    private User userInfo;

    public int getFriend_status() {
        return friend_status;
    }

    public void setFriend_status(int friend_status) {
        this.friend_status = friend_status;
    }

    public List<Baby> getBabyInfo() {
        return babyInfo;
    }

    public void setBabyInfo(List<Baby> babyInfo) {
        this.babyInfo = babyInfo;
    }

    public int getBaby_count() {
        return baby_count;
    }

    public void setBaby_count(int baby_count) {
        this.baby_count = baby_count;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
