package haibao.com.api.service;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.response.message.GetMessagesUnreadNumberResponse;
import haibao.com.api.data.response.message.MessagesResponse;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class MessageApiApiWrapper implements ClearWrapper {
  private static MessageApiApiWrapper INSTANCE;

  private static MessageApiService MessageApiService;

  public static MessageApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new MessageApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public MessageApiService getMessageApiService() {
    if (MessageApiService==null) {
      MessageApiService=BaseApi.getRetrofit(CommonUrl.MessageApiService_BaseUrl).create(MessageApiService.class);
    }
    return MessageApiService;
  }

  public void clearService() {
    MessageApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<MessagesResponse> GetMessages(Integer status, Integer page, Integer per_page) {
    return getMessageApiService().GetMessages(status,page,per_page).compose(BaseApi.<MessagesResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetMessagesUnreadNumberResponse> GetMessagesUnreadNumber() {
    return getMessageApiService().GetMessagesUnreadNumber().compose(BaseApi.<GetMessagesUnreadNumberResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutMessages() {
    return getMessageApiService().PutMessages().compose(BaseApi.<Void>defaultSchedulers());
  }
  public Observable<Void> putReadNotice(String message_id) {
    return getMessageApiService().putReadNotice(message_id).compose(BaseApi.<Void>defaultSchedulers());
  }
}
