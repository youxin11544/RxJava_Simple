package haibao.com.api.data.param.content;

import java.util.ArrayList;

import haibao.com.api.data.response.school.TopicBean;

/**
 * AutoGenerated RequestParam  */
public final class PostContentsRequestParam {

  /**
   content_type	Integer  类型，1代表图片，2代表视频，3代表音频，4代表图文（App发表时无此类型），5代表说说

   is_open 可选	Integer是否阅读圈可见，1可见，0不可见，默认1

   baby_id 可选	Integer管理的宝宝ID

   content 可选	String日记(说说的文字，图片、视频和音频的文字说明)。发表说说必须有content，512字符以内

   isbn_id 可选	Integer绑定相关图书的isbn_id


   video_url 可选	String视频的url，阿里云OSS上传后获取，类型为视频时不能为空

   video_width 可选	Integer视频的宽，单位像素，类型为视频时不能为空

   video_height 可选	Integer视频的高，单位为像素，类型为视频时不能为空

   video_cover 可选	String视频的封面图URL，类型为视频时不能为空

   audio_url 可选	String音频的地址，阿里云OSS上传后获取，类型为音频时不能为空

   duration_format 可选	String音频或视频的时间长度，格式HH:mm:ss

   image_ids 可选	Array图片URL数组，通过图片上传接口上传后获得，如果用户有上传图片，须带此参数，该参数的值是一个数组

   type 可选	Integer话题类型，默认0，1活动类，2课程类

   type_id 可选	Integer话题类型对应的id,活动则为活动ID,课程则为课程ID

   topics	Array日记对应的话题，可为空

   content	String话题的日记，以两个#包含，如果传递了type和type_id，将不处理content

   type	Integer话题类型，默认0，0默认话题，1活动类（即点击进入活动详情页），2课程类（即点击进入课程详情）

   type_id Integer话题类型对应的id，比如活动时，为具体活动的id
   */



  public Integer content_type;
  public Integer is_open;
  public Integer baby_id;
  public String content;
  public Integer isbn_id;
  public String video_url;
  public String video_width;
  public String video_height;
  public String video_cover;
  public String audio_url;
  public String duration_format;
  public ArrayList image_ids;

  public ArrayList<TopicBean> topics;



//  public Integer is_html;//content字段是否为图文形式的，1是，0不是，App发表时必须为0
//  public String[] images;




}
