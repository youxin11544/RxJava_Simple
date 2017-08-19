package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class City implements Serializable {

    private int city_id = HttpCommon.INVALID_INT_VALUE;
    private String city_name;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

}
