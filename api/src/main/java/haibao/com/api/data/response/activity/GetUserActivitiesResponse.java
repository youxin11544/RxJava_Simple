package haibao.com.api.data.response.activity;

import java.math.BigDecimal;
import java.util.List;

public class GetUserActivitiesResponse {
  public List<ItemsBean> items;

  public Integer next_page;

  public Integer total_pages;

  public static class ItemsBean {
    public Integer activity_id;

    public Integer club_id;

    public String cover;

    public Integer end_time;

    public Integer is_joined;

    public Integer is_online;

    public Integer latest_time;

    public LocationBean location;

    public BigDecimal price;

    public Long start_time;

    public String title;

    public static class LocationBean {
      public String address;

      public String address_detail;

      public String city;

      public String district;

      public BigDecimal latitude;

      public BigDecimal longitude;

      public String province;
    }
  }
}
