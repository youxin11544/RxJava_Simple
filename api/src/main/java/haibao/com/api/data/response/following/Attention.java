package haibao.com.api.data.response.following;


import java.io.Serializable;

/**
 * Created by fu on 2016/11/2 0002.
 */
public class Attention implements Serializable {

    public String avatar;

    public Integer friend_status;

    public String signature;

    public Integer user_id;

    public String user_name;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getFriend_status() {
        return friend_status;
    }

    public void setFriend_status(Integer friend_status) {
        this.friend_status = friend_status;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
