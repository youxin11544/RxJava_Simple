package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.account.Report;

/**
 * 课程报告返回数据模型
 * Created by Android on 2016-06-17.
 */
public class CourseReport implements Serializable {

    private List<Report> reports;
    private int is_completed;
    private int score;
    private String audio_duration;
    private String video_duration;

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public int getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(int is_completed) {
        this.is_completed = is_completed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAudio_duration() {
        return audio_duration;
    }

    public void setAudio_duration(String audio_duration) {
        this.audio_duration = audio_duration;
    }

    public String getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(String video_duration) {
        this.video_duration = video_duration;
    }
}
