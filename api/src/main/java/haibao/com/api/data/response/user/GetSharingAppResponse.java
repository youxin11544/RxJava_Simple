package haibao.com.api.data.response.user;

import java.io.Serializable;

import haibao.com.api.data.response.global.ShareBean;

public class GetSharingAppResponse implements Serializable{
  /**
   * share : {"url":"https://STORY.baobaobooks.net/apps/haibao","image":"https://oss.baobaobooks.net/ayb/images/logo100.png","title":"pu2邀请你使用孩宝小镇","content":"孩宝小镇，为每个家庭打造的亲子英语启蒙阅读服务"}
   */

  public ShareBean share;

}
