package haibao.com.api.data.response.school;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * 未读消息数量
 * Created by Android on 2015-12-16 016.
 */
public class UnreadCircleNumber implements Serializable {

    private int number = HttpCommon.INVALID_INT_VALUE;
    private long timestamp = HttpCommon.INVALID_INT_VALUE;
    private String user_avatar;

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
