package haibao.com.api.data.response.global;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class UserBean implements Serializable {

    public Integer friend_status;

    public String signature;//获取活动打卡里面没有这个属性

    public String avatar;

    public Integer is_lecturer;


    public Integer user_id = 0;

    public String user_name;

}
