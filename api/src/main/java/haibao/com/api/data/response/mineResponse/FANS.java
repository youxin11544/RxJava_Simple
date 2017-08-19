package haibao.com.api.data.response.mineResponse;


import java.io.Serializable;
import java.util.List;

import haibao.com.api.common.HttpCommon;

/**
 * Created by fu on 2016/11/2 0002.
 */

public class FANS implements Serializable {

    private int next = HttpCommon.INVALID_INT_VALUE;
    private int prev = HttpCommon.INVALID_INT_VALUE;
    private List<AttentionFans> items;

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public List<AttentionFans> getItems() {
        return items;
    }

    public void setItems(List<AttentionFans> items) {
        this.items = items;
    }

}