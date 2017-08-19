package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.data.param.account.SMSCodeParams;
import haibao.com.api.data.param.account.SendSMSParams;
import haibao.com.api.data.response.account.CheckSMSCode;
import haibao.com.api.data.response.account.SendSMS;
import rx.Observable;

import static haibao.com.api.common.CommonUrl.SmsService_BaseUrl;

/**
 * @ API包装类 此类由apt自动生成 */
public final class SmsApiWrapper implements ClearWrapper {
  private static SmsApiWrapper INSTANCE;

  private static SmSService SmSService;

  public static SmsApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new SmsApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public SmSService getSmSService() {
    if (SmSService==null) {
      SmSService=BaseApi.getRetrofit(SmsService_BaseUrl).create(SmSService.class);
    }
    return SmSService;
  }

  public void clearService() {
    SmSService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<SendSMS> sendSMS(SendSMSParams params) {
    return getSmSService().sendSMS(params).compose(BaseApi.<SendSMS>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<CheckSMSCode> checkSMSCode(SMSCodeParams params) {
    return getSmSService().checkSMSCode(params).compose(BaseApi.<CheckSMSCode>defaultSchedulers());
  }
}
