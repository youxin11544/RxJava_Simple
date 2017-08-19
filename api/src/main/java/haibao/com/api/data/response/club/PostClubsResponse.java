package haibao.com.api.data.response.club;

import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class PostClubsResponse {
  public List<ChannelsBean> channels;

  public String club_avatar;

  public String club_cover;

  public String club_desc;

  public Integer club_id;

  public String club_name;

  public static class ChannelsBean {
    public String channel_name;

    public Integer channle_id;
  }
}
