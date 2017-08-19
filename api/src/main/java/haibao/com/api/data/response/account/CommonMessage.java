package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 频道下的课程简介列表数据模型
 * Created by Android on 2016-07-21.
 */
public class CommonMessage implements Serializable {


    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
