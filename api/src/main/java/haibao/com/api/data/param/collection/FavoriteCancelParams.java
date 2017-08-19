package haibao.com.api.data.param.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class FavoriteCancelParams {

    private List<Integer> collection_ids;

    public FavoriteCancelParams(ArrayList<Integer> array) {
        collection_ids=array;
    }

    public List<Integer> getCollection_ids() {
        return collection_ids;
    }

    public void setCollection_ids(List<Integer> collection_ids) {
        this.collection_ids = collection_ids;
    }
}
