package haibao.com.api.data.response.baby;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public class QuestionNaire implements Serializable {
    public String channel_name;
    public String need_qstnaire;
    public Qa qa;
    public String stage;



    private int baby_id = HttpCommon.INVALID_INT_VALUE;

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }


    public int getBaby_id() {
        return baby_id;
    }

    public void setBaby_id(int baby_id) {
        this.baby_id = baby_id;
    }

    public Qa getQa() {
        return qa;
    }

    public void setQa(Qa mqa) {
        qa = mqa;
    }
}
