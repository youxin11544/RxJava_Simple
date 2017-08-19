package haibao.com.api.service;


import haibao.com.api.data.param.account.SMSCodeParams;
import haibao.com.api.data.param.account.SendSMSParams;
import haibao.com.api.data.response.account.CheckSMSCode;
import haibao.com.api.data.response.account.SendSMS;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * API接口方法申明接口类
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface SmSService {

    /**
     * title = 发送请求发送验证码短信的请求
     * version=
     * api url =<a href=""></>
     */
    @POST("codes")
    Observable<SendSMS> sendSMS(@Body SendSMSParams params);

    /**
     * title = 验证短信验证码
     * version =
     * api url =<a href=""></>
     */
    @POST("verify_code")
    Observable<CheckSMSCode> checkSMSCode(@Body SMSCodeParams params);
}
