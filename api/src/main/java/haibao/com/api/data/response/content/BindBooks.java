package haibao.com.api.data.response.content;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class BindBooks implements Serializable {
    /**
     * binded_book	Object
     * 绑定的相关图书，可为空
     * <p>
     * isbn_id	Integer
     * 图书的isbn_id
     * <p>
     * book_name	String
     * 图书的名称
     * <p>
     * book_img_thumb
     */
    public Integer isbn_id = -1;

    public String book_name;

    public String book_img_thumb;

    public String book_brief;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BindBooks bindBooks = (BindBooks) o;

        if (!isbn_id.equals(bindBooks.isbn_id)) return false;
        if (!book_name.equals(bindBooks.book_name)) return false;
        if (!book_img_thumb.equals(bindBooks.book_img_thumb)) return false;
        return book_brief.equals(bindBooks.book_brief);

    }

    @Override
    public int hashCode() {
        int result = isbn_id.hashCode();
        result = 31 * result + book_name.hashCode();
        result = 31 * result + book_img_thumb.hashCode();
        result = 31 * result + book_brief.hashCode();
        return result;
    }
}
