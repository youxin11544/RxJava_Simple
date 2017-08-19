package haibao.com.api.data.response.user;

import java.util.List;

import haibao.com.api.data.response.baby.Baby;
import haibao.com.api.data.response.global.LocationBean;
import haibao.com.api.data.response.global.ShareBean;

public class GetUsersUserIdResponse {
  /**
   * avatar : https://ossimg.baobaobooks.net/images/avatar/201606/146708586227969.jpg
   * babies : [{"age_desc":"1个月","avatar":"","baby_id":"31067","name":"gg","sex":"1"}]
   * contents_count : 9
   * covers :
   * followers_count : 0
   * following_count : 1
   * friend_status : 0
   * is_lecturer : 0
   * is_promoter : 0
   * lecturer_desc :
   * location : {"address":"","address_detail":"","city":"","district":"","province":""}
   * promoter_desc :
   * sex : 1
   * share : {"content":"他记录了9篇阅读日记，共收获了0位粉丝","image":"https://ossimg.baobaobooks.net/images/avatar/201606/146708586227969.jpg","title":"yunxin1分享了孩宝小镇的个人主页","url":"https://hello3.baobaobooks.net/users/77777862?baby_id=0"}
   * signature : 每个宝贝都是一个天使！
   * user_id : 77777862
   * user_name : yunxin1
   */

  public String avatar;

  public List<Baby> babies;

  public Integer contents_count;

  public String cover;

  public Integer followers_count;

  public Integer following_count;

  public Integer friend_status;

  public Integer is_lecturer;

//  public Integer is_promoter;

  public String lecturer_desc;

  public LocationBean location;

//  public String promoter_desc;

  public Integer sex;

  public String signature;

  public Integer user_id;

  public String user_name;

  public ShareBean share;

}
