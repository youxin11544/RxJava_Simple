package haibao.com.api.data.response.activity;

import java.io.Serializable;

import haibao.com.api.data.response.global.LocationBean;
import haibao.com.api.data.response.global.ShareBean;

public class ActivitiesActivityResponse implements Serializable{

  public String creator_id;
  public String is_haibao;
  public String is_open;
  public int users_count;

//上面四个是新增字段

  public String activityDesc;
  public Integer activity_id;


  public Integer contents_count=0;

  public String cover;
  public String summary;
  public String content_url;

  public Long end_time;

  public Integer isbn_id;
  public String  book_name;
  public String  book_img_thumb;

  public Integer is_joined = 0;

  public Integer is_online;

  public Integer latest_time;

  public LocationBean location;

  public Double price;

  public ShareBean share;

  public Long start_time;

  public String subActivityDesc;

  public String title;

  public Integer user_contents_count;




}
