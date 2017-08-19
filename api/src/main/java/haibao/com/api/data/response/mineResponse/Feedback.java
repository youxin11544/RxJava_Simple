package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by fu on 2016/11/2 0002.
 */

public class Feedback implements Serializable {

    private int id = HttpCommon.INVALID_INT_VALUE;
    private int is_store = HttpCommon.INVALID_INT_VALUE;
    private int store_id = HttpCommon.INVALID_INT_VALUE;
    private int user_id = HttpCommon.INVALID_INT_VALUE;
    private String contact;
    private String content;
    private String title;
    private String user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_store() {
        return is_store;
    }

    public void setIs_store(int is_store) {
        this.is_store = is_store;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}