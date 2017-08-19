package haibao.com.api.data.param.account;

import java.io.Serializable;

public class UpdateInfo implements Serializable {

	/**
	 * version : 2.0.0
	 * url : https://osstest.baobaobooks.net/ayb/images/course/201605/146465878592102.jpg
	 * sign : c9e5a3f08b58ac3e651756666a800bdf
	 * version_desc : 1.测试
	 2.测试信息
	 * is_force : 0
	 * update : 1468238773
	 */
	public String version_id;
	public String version;
	public String url;
	public String sign;
	public String version_desc;
	public String is_force;
	public int update;

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

	public String getVersion_desc() {
		return version_desc;
	}

	public void setVersion_desc(String version_desc) {
		this.version_desc = version_desc;
	}

	public String getIs_force() {
		return is_force;
	}

	public void setIs_force(String is_force) {
		this.is_force = is_force;
	}

	public int getUpdate() {
		return update;
	}

	public void setUpdate(int update) {
		this.update = update;
	}
}
