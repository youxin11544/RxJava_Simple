package haibao.com.api.data.response.global;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class BaseOffsetResponse<T> {
    public List<T> items;
    public Integer next;

}
