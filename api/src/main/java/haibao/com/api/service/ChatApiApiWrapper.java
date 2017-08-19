package haibao.com.api.service;

import java.util.ArrayList;

import haibao.com.api.BaseApi;
import haibao.com.api.BaseApi.ClearWrapper;
import haibao.com.api.common.CommonUrl;
import haibao.com.api.data.param.chat.ChatGroupsGroupIdUsersRequestParam;
import haibao.com.api.data.param.chat.PostChatChatroomsRequestParam;
import haibao.com.api.data.param.chat.PostChatGroupsRequestParam;
import haibao.com.api.data.param.chat.PutChatChatroomsChatroomIdRequestParam;
import haibao.com.api.data.param.chat.PutChatGroupsGroupIdRequestParam;
import haibao.com.api.data.response.chat.GetChatGroupsGroupIdResponse;
import haibao.com.api.data.response.chat.GetChatGroupsGroupIdUsersResponse;
import haibao.com.api.data.response.chat.PostChatChatroomsResponse;
import haibao.com.api.data.response.chat.PostChatGroupsResponse;
import haibao.com.api.data.response.chat.PutChatChatroomsChatroomIdResponse;
import haibao.com.api.data.response.chat.PutChatGroupsGroupIdResponse;
import okhttp3.MultipartBody;
import rx.Observable;

/**
 * @ API包装类 此类由apt自动生成 */
public final class ChatApiApiWrapper implements ClearWrapper {
  private static ChatApiApiWrapper INSTANCE;

  private static ChatApiService ChatApiService;

  public static ChatApiApiWrapper getInstance() {
    if (INSTANCE==null) {
      INSTANCE=new ChatApiApiWrapper();
      BaseApi.addToBaseApi(INSTANCE);
    }
    return INSTANCE;
  }

  public ChatApiService getChatApiService() {
    if (ChatApiService==null) {
      ChatApiService=BaseApi.getRetrofit(CommonUrl.ChatApiService_BaseUrl).create(ChatApiService.class);
    }
    return ChatApiService;
  }

  public void clearService() {
    ChatApiService=null;
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteChatChatroomsChatroomId(String chatroom_id) {
    return getChatApiService().DeleteChatChatroomsChatroomId(chatroom_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteChatChatroomsChatroomIdMute(String chatroom_id) {
    return getChatApiService().DeleteChatChatroomsChatroomIdMute(chatroom_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteChatChatroomsChatroomIdUsersUserIdMute(String chatroom_id,
      String user_id) {
    return getChatApiService().DeleteChatChatroomsChatroomIdUsersUserIdMute(chatroom_id,user_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteChatGroupsGroupId(String group_id) {
    return getChatApiService().DeleteChatGroupsGroupId(group_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> DeleteChatGroupsGroupIdUsers(String group_id, String user_id,
      ChatGroupsGroupIdUsersRequestParam ChatGroupsGroupIdUsersRequestParam) {
    return getChatApiService().DeleteChatGroupsGroupIdUsers(group_id,user_id,ChatGroupsGroupIdUsersRequestParam).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetChatGroupsGroupIdResponse> GetChatGroupsGroupId(String group_id) {
    return getChatApiService().GetChatGroupsGroupId(group_id).compose(BaseApi.<GetChatGroupsGroupIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<GetChatGroupsGroupIdUsersResponse> GetChatGroupsGroupIdUsers(String group_id,
      String q, Integer page, Integer per_page) {
    return getChatApiService().GetChatGroupsGroupIdUsers(group_id,q,page,per_page).compose(BaseApi.<GetChatGroupsGroupIdUsersResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostChatChatroomsResponse> PostChatChatrooms(PostChatChatroomsRequestParam PostChatChatroomsRequestParam) {
    return getChatApiService().PostChatChatrooms(PostChatChatroomsRequestParam).compose(BaseApi.<PostChatChatroomsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PostChatGroupsResponse> PostChatGroups(PostChatGroupsRequestParam PostChatGroupsRequestParam) {
    return getChatApiService().PostChatGroups(PostChatGroupsRequestParam).compose(BaseApi.<PostChatGroupsResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<ArrayList<String>> PostChatImages(MultipartBody multipartBody) {
    return getChatApiService().PostChatImages(multipartBody).compose(BaseApi.<ArrayList<String>>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PutChatChatroomsChatroomIdResponse> PutChatChatroomsChatroomId(String chatroom_id,
      PutChatChatroomsChatroomIdRequestParam PutChatChatroomsChatroomIdRequestParam) {
    return getChatApiService().PutChatChatroomsChatroomId(chatroom_id,PutChatChatroomsChatroomIdRequestParam).compose(BaseApi.<PutChatChatroomsChatroomIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutChatChatroomsChatroomIdMute(String chatroom_id) {
    return getChatApiService().PutChatChatroomsChatroomIdMute(chatroom_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutChatChatroomsChatroomIdUsersUserIdMute(String chatroom_id,
      String user_id) {
    return getChatApiService().PutChatChatroomsChatroomIdUsersUserIdMute(chatroom_id,user_id).compose(BaseApi.<Void>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<PutChatGroupsGroupIdResponse> PutChatGroupsGroupId(String group_id,
      PutChatGroupsGroupIdRequestParam PutChatGroupsGroupIdRequestParam) {
    return getChatApiService().PutChatGroupsGroupId(group_id,PutChatGroupsGroupIdRequestParam).compose(BaseApi.<PutChatGroupsGroupIdResponse>defaultSchedulers());
  }

  /**
   * 此方法由apt自动生成 */
  public Observable<Void> PutChatGroupsGroupIdUsers(String group_id,
      ChatGroupsGroupIdUsersRequestParam PutChatGroupsGroupIdUsersRequestParam) {
    return getChatApiService().PutChatGroupsGroupIdUsers(group_id,PutChatGroupsGroupIdUsersRequestParam).compose(BaseApi.<Void>defaultSchedulers());
  }
}
