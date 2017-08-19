package haibao.com.api.data.response.school;


import java.io.Serializable;

import haibao.com.api.common.HttpCommon;

/**
 * 商品名称返回数据模型
 * Created by Android on 2015-10-26 026.
 */
public class GoodsName implements Serializable {

    private int isbn_id = HttpCommon.INVALID_INT_VALUE;
    private String bookname;

    public int getIsbn_id() {
        return isbn_id;
    }

    public void setIsbn_id(int isbn_id) {
        this.isbn_id = isbn_id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
