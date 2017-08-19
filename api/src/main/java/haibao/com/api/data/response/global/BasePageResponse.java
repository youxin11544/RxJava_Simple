package haibao.com.api.data.response.global;

import java.io.Serializable;
import java.util.List;

/**
 * 待分页效果的response的基类
 * Created by Administrator on 2016/12/1 0001.
 */
public class BasePageResponse<T> implements Serializable{
    protected int total_pages;
    protected int total_count;
//    protected int page;
    protected int next_page;

    public List<T> items;
    public Integer next;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }

    public int getNext_page() {
        return next_page;
    }

    public void setNext_page(int next_page) {
        this.next_page = next_page;
    }
}
