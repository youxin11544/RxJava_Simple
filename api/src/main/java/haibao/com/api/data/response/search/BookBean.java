package haibao.com.api.data.response.search;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14 0014.
 */

public class BookBean implements Serializable {
    public Integer goods_id;

    public String goods_name;

    public String goods_shop_url;

    public String goods_thumb;

    public String goods_brief;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookBean bookBean = (BookBean) o;

        if (goods_id != null ? !goods_id.equals(bookBean.goods_id) : bookBean.goods_id != null)
            return false;
        if (goods_name != null ? !goods_name.equals(bookBean.goods_name) : bookBean.goods_name != null)
            return false;
        if (goods_shop_url != null ? !goods_shop_url.equals(bookBean.goods_shop_url) : bookBean.goods_shop_url != null)
            return false;
        if (goods_thumb != null ? !goods_thumb.equals(bookBean.goods_thumb) : bookBean.goods_thumb != null)
            return false;
        return goods_brief != null ? goods_brief.equals(bookBean.goods_brief) : bookBean.goods_brief == null;

    }

    @Override
    public int hashCode() {
        int result = goods_id != null ? goods_id.hashCode() : 0;
        result = 31 * result + (goods_name != null ? goods_name.hashCode() : 0);
        result = 31 * result + (goods_shop_url != null ? goods_shop_url.hashCode() : 0);
        result = 31 * result + (goods_thumb != null ? goods_thumb.hashCode() : 0);
        result = 31 * result + (goods_brief != null ? goods_brief.hashCode() : 0);
        return result;
    }
}
