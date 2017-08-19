package haibao.com.api.data.response.favorite;

import java.util.List;

public class GetFavoritesResponse {
  public List<ItemsBean> items;

  public Integer next;

  public static class ItemsBean {
    public Integer content_type;

    public String cover;

    public Integer favorite_id;

    public Integer favorite_type;

    public Integer favorite_type_id;

    public String goods_url;

    public String market_price_format;

    public String shop_price_format;

    public String store_avatar;

    public Integer store_id;

    public String store_name;

    public String store_url;

    public String summary;

    public String title;

    public String user_avatar;

    public String user_id;

    public String user_name;
  }
}
