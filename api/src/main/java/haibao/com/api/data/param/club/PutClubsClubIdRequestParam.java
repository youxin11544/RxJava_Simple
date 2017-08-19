package haibao.com.api.data.param.club;

import java.lang.String;
import java.util.ArrayList;

/**
 * AutoGenerated RequestParam  */
public final class PutClubsClubIdRequestParam {
  /**
   * type= String  
   * description=<p>圈子名称，20字符以内</p>  
   * optional=true 
   */
  public String club_name;

  /**
   * type= String  
   * description=<p>圈子头像URL，通过上传图片后获得</p>  
   * optional=true 
   */
  public String club_avatar;

  /**
   * type= String  
   * description=<p>圈子头像背景URL，通过上传图片后获得</p>  
   * optional=true 
   */
  public String club_cover;

  /**
   * type= String  
   * description=<p>圈子简介，1000字符以内</p>  
   * optional=true 
   */
  public String club_desc;

  /**
   * type= Array  
   * description=<p>圈子服务的频道阶段id数组</p>  
   * optional=true 
   */
  public ArrayList channel_ids;
}
