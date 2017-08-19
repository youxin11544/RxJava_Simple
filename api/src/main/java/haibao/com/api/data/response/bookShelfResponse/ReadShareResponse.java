package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/16 0016.
 */

public class ReadShareResponse implements Serializable {


    public Integer content_id;
    public Integer content_type;
    public Integer user_id;
    public String title;
    public String summary;
    public String cover_middle;
    public String cover_thumb;
    public String pub_time;
    public String user_name;
    public Integer like_count;
    public Integer comments_count;

   
}
