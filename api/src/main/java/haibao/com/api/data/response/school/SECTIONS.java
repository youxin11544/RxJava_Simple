package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * 章节列表数据模型
 * Created by Android on 2016-05-14.
 */
public class SECTIONS implements Serializable {

    private List<Section> items;

    public List<Section> getItems() {
        return items;
    }

    public void setItems(List<Section> items) {
        this.items = items;
    }
}
