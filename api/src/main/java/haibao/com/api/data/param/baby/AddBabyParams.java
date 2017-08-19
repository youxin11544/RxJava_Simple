package haibao.com.api.data.param.baby;

import android.text.TextUtils;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class AddBabyParams {

    /**
     * 添加宝贝
     *
     * @param name     宝宝昵称
     * @param birthday 出生日期，格式：YYYY-mm-dd
     * @param sex      性别，取值：1-男、2-女
     * @param avatar   宝宝头像URL
     * @param stage    适合阅读的阶段（评测之后的结果）
     */
    public String avatar;
    public String birthday;
    public String name;
    public String sex;
    public String stage;

    public AddBabyParams(String name, String birthday, String sex, String avatar, String stage) {

        if (!TextUtils.isEmpty(avatar)) {
            this.avatar = avatar;
        }
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;

        this.stage = String.valueOf(stage);


    }
}
