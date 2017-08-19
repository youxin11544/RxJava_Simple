package haibao.com.api.service;

import haibao.com.api.data.response.message.GetMessagesUnreadNumberResponse;
import haibao.com.api.data.response.message.MessagesResponse;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 消息
 * groupDescription=<p>我的消息相关</p>
 */
//@ApiFactory(
//    packageName = "haibao.com.api"
//)
public interface MessageApiService {

  /**
   * title= 获取消息列表
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-messageGroup-get_messages">获取消息列表</>
   */
  @GET("messages")
  Observable<MessagesResponse> GetMessages(@Query("status") Integer status,
                                           @Query("page") Integer page, @Query("per_page") Integer per_page);


  /**
   * title= 获取未读消息数
   * version=1.0.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-messageGroup-get_messages_unread_number">获取未读消息数</>
   */
  @GET("messages/unread/number")
  Observable<GetMessagesUnreadNumberResponse> GetMessagesUnreadNumber();


  /**
   * title= 设置全部消息已读
   * version=1.1.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-messageGroup-put_messages">设置全部消息已读</>
   */
  @PUT("messages/read")
  Observable<Void> PutMessages();



  /**
   * title=设置单个消息已读
   * version=1.1.0
   * api url = <a href="https://hbapidev.baobaobooks.net/docs/user/#api-messageGroup-put_messages">设置单个消息已读</>
   */
  @PUT("messages/{message_id}/read")
  Observable<Void> putReadNotice(@Path("message_id") String message_id);
}
