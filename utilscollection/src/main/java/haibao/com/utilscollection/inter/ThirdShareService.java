package haibao.com.utilscollection.inter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.PopupWindow;

import java.util.Map;

/**
 * 第三方分享登陆
 * Created by Administrator on 2017/3/7 0007.
 */
public interface ThirdShareService {

    void release();

    ThirdShareService init();

    void doOauthVerify(Activity activity, int shareType, ShareCompleteCallBack completeCallBack);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    PopupWindow createActivityShareWindow(Activity activity,String share_url, String title, String content, String img_url);

    PopupWindow createActivityShareWindow(Activity activity, ViewGroup viewGroup, String share_url, String title, String content, String img_url);

    PopupWindow createWebShareWindow(Activity activity,WebView wv, String share_url, String title, String content, String img_url, String webCallback);

     View createShareView(Activity mContext, String share_url, String title, String content, String img_url, PopupWindow pw);

    interface ShareCompleteCallBack {

        void oath(String sns_user_id, String snsTypeQq, Map<String, String> map, Object o);
    }
    interface ShareType {
        int TYPE_QQ = 0;
        int TYPE_WECHAT = 1;
        int TYPE_SINA = 2;
    }
}
