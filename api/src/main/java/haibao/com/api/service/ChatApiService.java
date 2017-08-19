package haibao.com.api.service;

import java.util.ArrayList;

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
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * groupTitle= 聊天信息
 * groupDescription=<p>即时通讯相关接口,即时通信的创建群组和聊天室，需存在我们的业务服务器，这样能避免以后切换第三方服务时，群组关系还存在。即创建群和聊天室时需要通过服务端接口来创建。</p>
 */
//@ApiFactory(
//        packageName = "haibao.com.api"
//)
public interface ChatApiService {

    /**
     * title=聊天信息 - 创建群
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-post_chat_groups">创建群</>
     *
     * @param PostChatGroupsRequestParam 自动生成的Body
     */
    @POST("chat/groups")
    Observable<PostChatGroupsResponse> PostChatGroups(@Body PostChatGroupsRequestParam PostChatGroupsRequestParam);

    /**
     * title=聊天信息 - 编辑群
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-put_chat_groups__group_id">编辑群</>
     *
     * @param PutChatGroupsGroupIdRequestParam 自动生成的Body
     */
    @PUT("chat/groups/{group_id}")
    Observable<PutChatGroupsGroupIdResponse> PutChatGroupsGroupId(@Path("group_id") final String group_id,
                                                                  @Body PutChatGroupsGroupIdRequestParam PutChatGroupsGroupIdRequestParam);

    /**
     * title=聊天信息 - 聊天信息图片上传接口
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-post_chat_images">聊天信息图片上传接口</>
     */
    @POST("chat/images")
    Observable<ArrayList<String>> PostChatImages(@Body MultipartBody multipartBody);

    /**
     * title=获取群信息
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-get_chat_groups__group_id">获取群信息</>
     */
    @GET("chat/groups/{group_id}")
    Observable<GetChatGroupsGroupIdResponse> GetChatGroupsGroupId(@Path("group_id") final String group_id);


    /**
     * title=聊天信息 - 解散群
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-delete_chat_groups__group_id">解散群</>
     */
    @DELETE("chat/groups/{group_id}")
    Observable<Void> DeleteChatGroupsGroupId(@Path("group_id") final String group_id);

    /**
     * title=聊天信息 - 获取群成员
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-get_chat_groups__group_id_users">获取群成员</>
     *
     * @param page     <p>请求的页索引</p>   type= Integer   isOptional=false
     * @param per_page <p>每页返回的数据条数</p>   type= Integer   isOptional=true
     */
    @GET("chat/groups/{group_id}/users")
    Observable<GetChatGroupsGroupIdUsersResponse> GetChatGroupsGroupIdUsers(@Path("group_id") final String group_id, @Query("q") String q,
                                                                            @Query("page") Integer page, @Query("per_page") Integer per_page);

    /**
     * title=聊天信息 - 添加群成员
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-put_chat_groups__group_id_users">添加群成员</>
     *
     * @param PutChatGroupsGroupIdUsersRequestParam 自动生成的Body
     */
    @PUT("chat/groups/{group_id}/users")
    Observable<Void> PutChatGroupsGroupIdUsers(@Path("group_id") final String group_id,
                                               @Body ChatGroupsGroupIdUsersRequestParam PutChatGroupsGroupIdUsersRequestParam);

    /**
     * title=聊天信息 - 创建聊天室
     * version=1.0.0
     * api url =  <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-post_chat_chatrooms">创建聊天室</>
     *
     * @param PostChatChatroomsRequestParam 自动生成的Body
     */
    @POST("chat/chatrooms")
    Observable<PostChatChatroomsResponse> PostChatChatrooms(@Body PostChatChatroomsRequestParam PostChatChatroomsRequestParam);

    /**
     * title=聊天信息 - 编辑聊天室
     * version=1.0.0
     * api url= <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-put_chat_chatrooms__chatroom_id">编辑聊天室</>
     *
     * @param PutChatChatroomsChatroomIdRequestParam 自动生成的Body
     */
    @PUT("chat/chatrooms/{chatroom_id}")
    Observable<PutChatChatroomsChatroomIdResponse> PutChatChatroomsChatroomId(@Path("chatroom_id") final String chatroom_id,
                                                                              @Body PutChatChatroomsChatroomIdRequestParam PutChatChatroomsChatroomIdRequestParam);

    /**
     * title=聊天信息 - 解散聊天室
     * 解散聊天室,注:云信聊天室只有没有解散操作,只有关闭操作
     * version=1.0.0
     * api url= <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-delete_chat_chatrooms__chatroom_id">解散聊天室</>
     */
    @DELETE("chat/chatrooms/{chatroom_id}")
    Observable<Void> DeleteChatChatroomsChatroomId(@Path("chatroom_id") final String chatroom_id);


    /**
     * title=聊天信息 - 设置聊天室全体用户禁言
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-put_chat_chatrooms__chatroom_id_mute">设置聊天室全体用户禁言</>
     */
    @PUT("chat/chatrooms/{chatroom_id}/mute")
    Observable<Void> PutChatChatroomsChatroomIdMute(@Path("chatroom_id") final String chatroom_id);

    /**
     * title=聊天信息 - 取消聊天室全体用户禁言
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-delete_chat_chatrooms__chatroom_id_mute">取消聊天室全体用户禁言</>
     */
    @DELETE("chat/chatrooms/{chatroom_id}/mute")
    Observable<Void> DeleteChatChatroomsChatroomIdMute(@Path("chatroom_id") final String chatroom_id);

    /**
     * title=聊天信息 - 设置聊天室指定用户禁言
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-put_chat_chatrooms__chatroom_id_users__user_id_mute">设置聊天室指定用户禁言</>
     */
    @PUT("chat/chatrooms/{chatroom_id}/users/{user_id}/mute")
    Observable<Void> PutChatChatroomsChatroomIdUsersUserIdMute(@Path("chatroom_id") final String chatroom_id,
                                                               @Path("user_id") final String user_id);

    /**
     * title=聊天信息 - 取消聊天室指定用户禁言
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-delete_chat_chatrooms__chatroom_id_users__user_id_mute">取消聊天室指定用户禁言</>
     */
    @DELETE("chat/chatrooms/{chatroom_id}/users/{user_id}/mute")
    Observable<Void> DeleteChatChatroomsChatroomIdUsersUserIdMute(@Path("chatroom_id") final String chatroom_id,
                                                                  @Path("user_id") final String user_id);

    /**
     * title=删除群成员
     * version=1.0.0
     * api url = <a href="https://hbapidev.baobaobooks.net/docs/chat/#api-chatGroup-delete_chat_groups__group_id_users__user_id">删除群成员</>
     *
     * @param ChatGroupsGroupIdUsersRequestParam 自动生成的Body
     */
    @HTTP(
            method = "DELETE",
            path = "chat/groups/{group_id}/users/{user_id}",
            hasBody = true
    )
    Observable<Void> DeleteChatGroupsGroupIdUsers(
            @Path("group_id") final String group_id,
            @Path("user_id") final String user_id,
            @Body ChatGroupsGroupIdUsersRequestParam ChatGroupsGroupIdUsersRequestParam);

}
