package haibao.com.api.data.response.bookShelfResponse;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/16.
 */

public  class BooksBean implements Serializable{


    public String author_name;
    public String book_name;
    public String book_img_thumb;
    public String drawer_name;
    public String isbn_id;
    public int is_audio;
    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_img_thumb() {
        return book_img_thumb;
    }

    public void setBook_img_thumb(String book_img_thumb) {
        this.book_img_thumb = book_img_thumb;
    }

    public String getDrawer_name() {
        return drawer_name;
    }

    public void setDrawer_name(String drawer_name) {
        this.drawer_name = drawer_name;
    }

    public String getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(String isbn_id) {
        this.isbn_id = isbn_id;
    }
}