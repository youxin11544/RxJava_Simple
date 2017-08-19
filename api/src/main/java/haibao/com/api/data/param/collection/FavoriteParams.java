package haibao.com.api.data.param.collection;

/**
 *
 * Created by Administrator on 2016/11/2 0002.
 */
public class FavoriteParams {

    /**
     * content_id : 792
     */

    private int content_id;

    public FavoriteParams(int currentContentId) {
        this.content_id = currentContentId;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }
}
