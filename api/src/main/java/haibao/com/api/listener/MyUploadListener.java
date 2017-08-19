package haibao.com.api.listener;

/**
 * ProgressResponseListener
 * <p>
 * 文件上传下载的进度监听
 * <p>
 * 请求体进度回调接口，比如用于文件上传中
 *
 * @author fyd
 * @time 2017/5/19
 */

public interface MyUploadListener {

    void onProgress(long currentBytes, long contentLength, boolean done);
}