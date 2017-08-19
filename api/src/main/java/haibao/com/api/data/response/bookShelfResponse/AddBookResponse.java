package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;

/**
 * 添加书籍成功后的返回
 * {@link }
 * Created by Administrator on 2016/10/26 0026.
 */

public class AddBookResponse implements Serializable {

    /**
     * user_id : 64253
     * isbn_id : 9677
     * created_at : 1秒前
     */

    private String user_id;
    private int goods_id;
    private String created_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
