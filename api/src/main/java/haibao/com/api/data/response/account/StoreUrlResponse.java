package haibao.com.api.data.response.account;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/13 0013.
 */

public class StoreUrlResponse implements Serializable {
    private int store_id;
    private String store_url;
    private String manage_store_url;
    private String user_name;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_url() {
        return store_url;
    }

    public void setStore_url(String store_url) {
        this.store_url = store_url;
    }

    public String getManage_store_url() {
        return manage_store_url;
    }

    public void setManage_store_url(String manage_store_url) {
        this.manage_store_url = manage_store_url;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
