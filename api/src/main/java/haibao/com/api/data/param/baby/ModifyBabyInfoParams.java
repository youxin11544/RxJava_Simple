package haibao.com.api.data.param.baby;

/**
 * 修改宝宝信息请求参数
 * Created by Android on 2015-12-23 023.
 */
public class ModifyBabyInfoParams {

    public String avatar;
    public String birthday;
    public String is_selected;
    public String name;
    public String sex;
    public String stage;

    public ModifyBabyInfoParams() {

    }

    public ModifyBabyInfoParams(String name, String birthday, String sex, String avatar, String stage) {
        this.avatar = avatar;
        this.birthday = birthday;
        this.name = name;
        this.sex = sex;
        this.stage = stage;
    }

    public ModifyBabyInfoParams(String name, String birthday, String sex, String avatar, String stage, String is_selected) {
        this.avatar = avatar;
        this.birthday = birthday;
        this.is_selected = is_selected;
        this.name = name;
        this.sex = sex;
        this.stage = stage;
    }
}
