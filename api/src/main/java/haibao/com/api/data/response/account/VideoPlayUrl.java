package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 微视频url信息数据模型
 * Created by Android on 2016-05-14.
 */
public class VideoPlayUrl implements Serializable {

    private String f0;
    private String f10;
    private String f20;
    private String f30;

    public String getF0() {
        return f0;
    }

    public void setF0(String f0) {
        this.f0 = f0;
    }

    public String getF10() {
        return f10;
    }

    public void setF10(String f10) {
        this.f10 = f10;
    }

    public String getF20() {
        return f20;
    }

    public void setF20(String f20) {
        this.f20 = f20;
    }

    public String getF30() {
        return f30;
    }

    public void setF30(String f30) {
        this.f30 = f30;
    }
}