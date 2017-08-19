package haibao.com.api.data.response.school;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class TopicBean implements Serializable {
    /**
     * topic_id	Integer
     * 话题的id
     * <p>
     * content	String
     * 话题的日记，以两个#包含
     * <p>
     * type	Integer	<p>话题类型，默认0，0默认话题，1活动类(即点击进入活动详情页)，2课程类(即点击进入课程话题详情页),3 图书类(点击进入图书话题详情页)</p>
     * type_id	Integer
     * 话题类型对应的id，比如活动时，为具体活动的id
     */
    public String content;

    public String topic_id;

    public String type;

    public String type_id;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }
}
