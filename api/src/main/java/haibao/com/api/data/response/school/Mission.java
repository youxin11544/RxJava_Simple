package haibao.com.api.data.response.school;

import java.io.Serializable;

/**
 * 课程任务数据模型
 */
public class Mission implements Serializable {

    private int is_completed;
    private String is_enforce;
    private String mission_id;
    private String mission_name;
    private String mission_type;

    public String getMission_id() {
        return mission_id;
    }

    public void setMission_id(String mission_id) {
        this.mission_id = mission_id;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getMission_type() {
        return mission_type;
    }

    public void setMission_type(String mission_type) {
        this.mission_type = mission_type;
    }

    public String getIs_enforce() {
        return is_enforce;
    }

    public void setIs_enforce(String is_enforce) {
        this.is_enforce = is_enforce;
    }

    public int getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(int is_completed) {
        this.is_completed = is_completed;
    }
}
