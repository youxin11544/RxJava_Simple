package haibao.com.api.data.response.bookShelfResponse;


import java.io.Serializable;
import java.util.List;


/**
 * 扫码成功后的对象
 * {@link  }
 * {@link }
 * Created by Administrator on 2016/10/26 0026.
 */

public class ScanResponse implements Serializable {

    /**
     * book_exists : 1   1-找到该书，0-未找到该书
     * items : [{"isbn_id":"846","book_name":"## 原装进口 安东尼·布朗 Willy the Dreamer 梦想家威利【平装】有JY音频","book_img_thumb":null,"is_added":0,"is_group":"0","isbn_id":"121"}]
     */

    private int book_exists;
    /**
     * isbn_id : 846
     * book_name : ## 原装进口 安东尼·布朗 Willy the Dreamer 梦想家威利【平装】有JY音频
     * book_img_thumb : null  书架图（书的封面图），尺寸320*X
     * is_added : 0  1-已添加至书架，0-未添加至书架
     * is_group : 0  1-是合集，0-不是合集
     * isbn_id : 121  ISBN的ID，是主键
     */

    private List<Book> items;

    public int getBook_exists() {
        return book_exists;
    }

    public void setBook_exists(int book_exists) {
        this.book_exists = book_exists;
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }
}
