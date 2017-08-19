package haibao.com.api.data.param.school;

import java.util.List;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class ErrorLogParams {


    private List<LogInfoBean> logInfo;

    public List<LogInfoBean> getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(List<LogInfoBean> logInfo) {
        this.logInfo = logInfo;
    }

    public static class LogInfoBean {
        /**
         * content : zzzzzzzzzzzzzzzzzzz
         * log_at : 12323435
         */

        private String content;
        private int log_at;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getLog_at() {
            return log_at;
        }

        public void setLog_at(int log_at) {
            this.log_at = log_at;
        }
    }
}
