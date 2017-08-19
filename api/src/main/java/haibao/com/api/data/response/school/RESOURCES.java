package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

import haibao.com.api.data.response.global.Resource;

/**
 * 资源列表数据模型
 * Created by Android on 2016-06-18.
 */
public class RESOURCES implements Serializable {

    private List<Resource> items;

    public List<Resource> getItems() {
        return items;
    }

    public void setItems(List<Resource> items) {
        this.items = items;
    }
}
