package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * 上传日记相关图片返回数据模型
 * Created by Android on 2015-10-27 027.
 */
public class UPLOAD_CONTENT_IMAGE implements Serializable {

    private List<String> image_ids;

    public List<String> getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(List<String> image_ids) {
        this.image_ids = image_ids;
    }
}
