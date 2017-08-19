package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * 课程报告中学会了数据模型
 * Created by Android on 2016-06-17.
 */
public class Report implements Serializable {

    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
