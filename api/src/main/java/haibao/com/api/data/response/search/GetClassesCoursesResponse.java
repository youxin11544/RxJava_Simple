package haibao.com.api.data.response.search;

import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class GetClassesCoursesResponse {
  public List<ItemsBean> items;

  public Integer next_page;

  public Integer total_pages;

  public static class ItemsBean {
    public Integer course_id;

    public String cover;

    public Integer is_learned;

    public Integer is_subscribed;

    public String learned_desc;

    public Integer live_status;

    public Integer live_time;

    public String live_time_format;

    public Integer live_type;

    public String teacher_avatar;

    public Integer teacher_id;

    public String teacher_name;

    public String title;
  }
}
