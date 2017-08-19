package haibao.com.api.data.response.hot;

/**
 * Created by Administrator on 2016/12/19 0019.
 */

public class HotUpdateInfo {

    /**
     * version_id : 123
     * version : 2.0.0
     * url : https://oss.baobaobooks.net/ayb/app/download/ayb-android-2.1.0.apk
     * sign : a7442bd21b13c27d24c3b96e7ecc4104
     * rsa : a7442bd21b13c27d24c3b96e7ecc4104
     */

    public String version_id;
    public String version;
    public String url;
    public String sign;
    public String rsa;

    public String getVersion_id() {
        return version_id;
    }

    public void setVersion_id(String version_id) {
        this.version_id = version_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRsa() {
        return rsa;
    }

    public void setRsa(String rsa) {
        this.rsa = rsa;
    }
}
