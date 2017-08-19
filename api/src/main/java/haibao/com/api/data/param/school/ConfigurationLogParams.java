package haibao.com.api.data.param.school;

import haibao.com.api.data.response.global.LocationBean;

/**
 * 登录请求参数
 * Created by Android on 2015-12-23 023.
 */
public class ConfigurationLogParams {

    public String model;//手机型号
    public String system;//手机系统版本
    public  String screen;//手机屏幕分辨率
    public String app_version;//App版本号
    public String gsm;//网络信号
    public int is_gps;//定位授权情况：0-关闭，1-允许
    public String coordinate;//位置坐标
    public int is_microphone;//麦克风授权情况：0-关闭，1-允许
    public  int is_camera;//摄像头授权情况：0-关闭，1-允许
    public int is_album;//相册授权情况：0-关闭，1-允许
    public int is_notify;//通知授权情况：0-关闭，1-允许
    public int is_jpush;//极光注册情况：0-失败，1-成功
    public LocationBean location;

    public ConfigurationLogParams() {

    }

    public ConfigurationLogParams(String model, String system, String screen, String app_version, String gsm, int is_gps, String coordinate, int is_microphone, int is_camera, int is_album, int is_notify,int is_jpush) {
        this.model = model;
        this.system = system;
        this.screen = screen;
        this.app_version = app_version;
        this.gsm = gsm;
        this.is_gps = is_gps;
        this.coordinate = coordinate;
        this.is_microphone = is_microphone;
        this.is_camera = is_camera;
        this.is_album = is_album;
        this.is_notify = is_notify;
        this.is_jpush = is_jpush;
    }
}
