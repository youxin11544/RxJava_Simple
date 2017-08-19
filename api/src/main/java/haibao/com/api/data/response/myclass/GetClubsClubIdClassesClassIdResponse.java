package haibao.com.api.data.response.myclass;

import haibao.com.api.data.response.global.ShareBean;

public class GetClubsClubIdClassesClassIdResponse {
  /**
   * booklist_id : 0
   * channel_id : 97
   * channel_name : Child's Play儿歌洞洞书一辑
   * class_desc : hi,这里是班级简介
   * class_id : 1170
   * club_id : 88
   * courses_count : 0
   * covers : https://ossimage.baobaobooks.net/image/1452423432.png
   * create_at : 1491549395
   * is_haibao : 0
   * is_joined : 1
   * is_open : 0
   * master_avatar : https://osstestimg.baobaobooks.net/images/avatar/201609/147435640863490.jpg@1e_1c_180w_180h_95q
   * master_desc : cccccccc
   * master_id : 526220
   * master_name : jmeter
   * members_count : 2
   * name : 测试创建班级失败原因
   * share : {"content":"hi,这里是班级简介","image":"https://ossimage.baobaobooks.net/image/1452423432.png","title":"测试创建班级失败原因","url":""}
   */

  public String channel_id;
  public String channel_name;
  public String courses_count;
  public String is_open;
  public String members_count;

//上面五个是新增字段

  public String booklist_id;

  public String booklist_name;

  public String booklist_url;

  public String class_desc;

  public String class_id;

  public String club_id;

  public String cover;

  public String create_at;

  public String is_haibao;

  public String is_joined;

  public String master_avatar;

  public String master_desc;

  public String master_id;

  public String master_name;

  public String name;

  public ShareBean share;

}
