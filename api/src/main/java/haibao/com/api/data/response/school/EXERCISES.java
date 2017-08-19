package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * 练习列表数据模型
 * Created by Android on 2016-05-13.
 */
public class EXERCISES implements Serializable {

    private List<Exercise> items;

    public List<Exercise> getItems() {
        return items;
    }

    public void setItems(List<Exercise> items) {
        this.items = items;
    }
}
