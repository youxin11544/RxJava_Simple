package haibao.com.api.data.response.myclass;

import java.util.List;

public class GetClubsClubIdClassesClassIdUsersResponse {
  public List<ItemsBean> items;

  public Integer next_page;

  public Integer total_pages;

  public static class ItemsBean {
    public String avatar;

    public Integer friend_status;

    public Integer is_lecturer;

    public Integer is_promoter;

    public String signature;

    public Integer user_id;

    public String user_name;
  }
}
