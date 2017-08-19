package haibao.com.api.data.param.account;

/**
 * Created by fu on 2016/11/2 0002.
 */

public class ModifyPasswordParams {

    public String new_password;
    public String old_password;

    public ModifyPasswordParams(String old_pwd, String new_pwd) {
        this.old_password = old_pwd;
        this.new_password = new_pwd;

    }

}
