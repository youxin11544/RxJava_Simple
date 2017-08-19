package haibao.com.api.data.param.collection;

/**
 * Created by Administrator on 2016/11/2 0002.
 */

public class PublishCommentParams {
    //    评论的内容
    private String content;
    //    用户的ID,当回复某人的评论时，须带此参数，需要与to_comment_id一起传递
    private int to_user_id;
    //    评论的ID,当回复某人的评论时，须带此参数
    private int to_comment_id;//可选	Integer

    public PublishCommentParams() {
    }

    public PublishCommentParams( String content) {
        this.content = content;
    }

    public PublishCommentParams( String content, int to_user_id, int to_comment_id) {

        this.content = content;
        this.to_user_id = to_user_id;
        this.to_comment_id = to_comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(int to_user_id) {
        this.to_user_id = to_user_id;
    }

    public int getTo_comment_id() {
        return to_comment_id;
    }

    public void setTo_comment_id(int to_comment_id) {
        this.to_comment_id = to_comment_id;
    }
}
