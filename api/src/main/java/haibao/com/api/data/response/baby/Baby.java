package haibao.com.api.data.response.baby;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class Baby implements Serializable {


    public String age_desc;

    public String age;

    public String avatar;

    public Integer baby_id;

    public String birthday;

    public String is_selected;

    public String name;

    public String sex;

    public String stage;

    public Integer contents_count;//阅读日记数量

    public Integer read_count;//阅读量读完了几个课程

    public String read_rank;//a%阅读量超过了多少宝宝

    public Integer days;//阅读时长，单位天

    public Integer born_days=0;//宝宝已出生的天数

    public Integer getBorn_days() {
        return born_days;
    }

    public void setBorn_days(Integer born_days) {
        this.born_days = born_days;
    }

    public String getAge_desc() {
        return age_desc;
    }

    public void setAge_desc(String age_desc) {
        this.age_desc = age_desc;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getBaby_id() {
        return baby_id;
    }

    public void setBaby_id(Integer baby_id) {
        this.baby_id = baby_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(String is_selected) {
        this.is_selected = is_selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
