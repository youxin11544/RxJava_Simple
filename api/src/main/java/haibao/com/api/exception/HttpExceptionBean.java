package haibao.com.api.exception;

/**
 * Created by anzhuo002 on 2016/7/5.
 */

public class HttpExceptionBean extends Exception{

    /**
     * code : AccountNotExist
     * message : 账户名不存在
     * body :
     */

    private String code;
    private String message;
    private Object body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
