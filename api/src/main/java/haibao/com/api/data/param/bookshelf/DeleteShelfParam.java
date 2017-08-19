package haibao.com.api.data.param.bookshelf;

/**
 * Created by Administrator on 2016/10/28 0028.
 */

public class DeleteShelfParam {
    private int[] shelf_ids;

    public DeleteShelfParam() {
    }

    public DeleteShelfParam(int[] shelf_ids) {
        this.shelf_ids = shelf_ids;
    }

    public int[] getShelf_ids() {
        return shelf_ids;
    }

    public void setShelf_ids(int[] shelf_ids) {
        this.shelf_ids = shelf_ids;
    }
}
