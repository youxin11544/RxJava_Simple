package haibao.com.api.data.response.baby;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class Qa implements Serializable {

    private List<Answer> answers;
    private String qst_key;
    private String question;

    public class Answer  {
        private String desc;
        private String option;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getQst_key() {
        return qst_key;
    }

    public void setQst_key(String qst_key) {
        this.qst_key = qst_key;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}