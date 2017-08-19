package haibao.com.api.data.response.content;


import java.io.Serializable;
import java.util.List;

public class PostContentsImagesResponse implements Serializable {
    public List<String> image_ids;

    public List<String> getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(List<String> image_ids) {
        this.image_ids = image_ids;
    }
}
