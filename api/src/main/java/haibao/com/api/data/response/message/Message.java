package haibao.com.api.data.response.message;

import java.io.Serializable;

public class Message implements Serializable {

    public String content;

    public String cover;

    public String create_at_format;

    public String link;

    public String message_id;

    public Integer status;

    public String title;

    public String type;

    public String type_id;

    public int getState() {
        return status;
    }

    public void setState(int state) {
        this.status = state;
    }


}
