package haibao.com.api.data.param.mine;

import java.io.File;

/**
 * Created by fu on 2016/11/2 0002.
 */

public class FeedBackParams {

    public String content;
    public String contact;

    public File img;
    public String model;
    public String system;
    public String screen;
    public String app_version;
    public String gsm;

    public FeedBackParams(String content, String contact, File img, String model, String system, String screen, String app_version, String gsm) {
        this.content = content;
        this.contact = contact;
        this.img = img;
        this.model = model;
        this.system = system;
        this.screen= screen;
        this.app_version= app_version;
        this.gsm= gsm;

    }


}
