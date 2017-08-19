package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.ArrayList;

import haibao.com.api.data.response.global.PlaySet;

/**
 * 云点播视频信息返回模型类
 * Created by Android on 2016-03-05.
 */
public class VodVideoInfo implements Serializable {

    private int code;
    private ArrayList<PlaySet> playSet;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<PlaySet> getPlaySet() {
        return playSet;
    }

    public void setPlaySet(ArrayList<PlaySet> playSet) {
        this.playSet = playSet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
