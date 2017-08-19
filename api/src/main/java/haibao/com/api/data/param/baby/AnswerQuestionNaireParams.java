package haibao.com.api.data.param.baby;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class AnswerQuestionNaireParams {

//    /**
//     * type= String
//     * description=<p>出生日期，格式：YYYY-mm-dd</p>
//     * optional=false
//     */
//    public String birthday;

    /**
     * type= String
     * description=<p><strong>问题答案选项</strong></p>
     * optional=false
     */
    public String answer;

    public AnswerQuestionNaireParams(String answer) {
//        this.birthday = birthday;
        this.answer = answer;

    }

}
