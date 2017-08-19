package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;
import java.util.List;

public class GetArchivesResponse implements Serializable{
  public String archive_id;

  public String archive_name;

  public List<GoodsBean> goods;

  public Integer goods_count;

  public  class GoodsBean implements Serializable{
    public String book_img_thumb;

    public String goods_id;

    public String goods_name;

    public String isbn_id;
  }
}
