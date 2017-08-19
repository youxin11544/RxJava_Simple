package haibao.com.api.data.response.global;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/4 0004.
 */

public class LocationBean implements Serializable {

    /**
     * province : 广东
     * city : 深圳
     * district : 龙岗区
     * address : 南湾街道求水山公园
     * address_detail : 宝源华丰经济大厦C座51911
     * longitude : 114.02887
     * latitude : 22.61674017
     */
    public String address;

    public String address_detail;

    public String city;

    public String district;

    public String latitude;

    public String longitude;

    public String province;

    @Override
    public String toString() {
        return "LocationBean{" +
                "address='" + address + '\'' +
                ", address_detail='" + address_detail + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
