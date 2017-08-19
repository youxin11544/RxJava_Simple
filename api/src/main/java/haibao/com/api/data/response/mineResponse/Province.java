package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class Province implements Serializable {

   private int province_id = HttpCommon.INVALID_INT_VALUE;
    private String province_name;

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

}
