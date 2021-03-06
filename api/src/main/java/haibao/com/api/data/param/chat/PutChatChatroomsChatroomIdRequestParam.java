package haibao.com.api.data.param.chat;

import java.lang.String;

/**
 * AutoGenerated RequestParam  */
public final class PutChatChatroomsChatroomIdRequestParam {
  /**
   * type= String  
   * description=<p>聊天室名称，绑定课程时设置为课程名称，128字符以内</p>  
   * optional=true 
   */
  public String name;

  /**
   * type= String  
   * description=<p>聊天室公告，1000字符以内</p>  
   * optional=true 
   */
  public String announcement;
}
