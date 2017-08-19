package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class Book implements Serializable{

    public String book_name;

    public List<BooksBean> books;

    public String book_img_thumb;

    public Integer goods_id;

    public String goods_name;

    public Integer is_audio = 0;

    public Integer is_group = 0;

    public Integer isbn_id;

    public Integer is_added;
    public Integer is_haibao;

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public String getBook_img_thumb() {
        return book_img_thumb;
    }

    public void setBook_img_thumb(String book_img_thumb) {
        this.book_img_thumb = book_img_thumb;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }



    public Integer getIs_group() {
        return is_group;
    }

    public void setIs_group(Integer is_group) {
        this.is_group = is_group;
    }

    public Integer getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(Integer isbn_id) {
        this.isbn_id = isbn_id;
    }

    public Integer getIs_added() {
        return is_added;
    }

    public void setIs_added(Integer is_added) {
        this.is_added = is_added;
    }

    public Integer getIs_haibao() {
        return is_haibao;
    }

    public void setIs_haibao(Integer is_haibao) {
        this.is_haibao = is_haibao;
    }
}