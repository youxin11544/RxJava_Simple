package me.shaohui.advancedluban.haibao.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public interface  CompressListener {
    /**
     * 压缩成功
     * @param images 已经压缩图片
     */
    void onCompressSuccess(ArrayList<String> pahtList, List<File> images);

    /**
     * 压缩失败
     * @param msg 失败的原因
     */
    void onCompressFailed(String msg);
}
