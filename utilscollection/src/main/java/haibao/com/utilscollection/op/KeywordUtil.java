package haibao.com.utilscollection.op;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/14 0014.
 */

public class KeywordUtil {

    /**
     * 关键字高亮变色
     *
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字
     * @return
     */
    public static SpannableString matcherSearchTitle(int color, String text,
                                                     String keyword) {
        SpannableString s = new SpannableString(text);
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(color), start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return s;
    }

    /**
     * 第一个关键字高亮变色
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字
     * @return
     */
    public static SpannableString matcherFirstSearchTitle(int color, String text,
                                                     String keyword) {
        SpannableString s = new SpannableString(text);
        Pattern p = Pattern.compile(keyword);
        Matcher m = p.matcher(s);
        if (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(color), start, end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return s;
    }

    /**
     * 多个关键字高亮变色
     *
     * @param color   变化的色值
     * @param text    文字
     * @param keyword 文字中的关键字数组
     * @return
     */
    public static SpannableString matcherSearchTitle(int color, String text,
                                                     String[] keyword) {
        SpannableString s = new SpannableString(text);
        for (int i = 0; i < keyword.length; i++) {
            Pattern p = Pattern.compile(keyword[i]);
            Matcher m = p.matcher(s);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                s.setSpan(new ForegroundColorSpan(color), start, end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return s;
    }

    // 直接拷贝这些代码到你希望的位置，然后在TextView设置了文本之后调用就ok了
    public static void SetLinkClickIntercept(TextView tv, OnUrlSpanClickListener onClickListener) {
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tv.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable sp = (Spannable) tv.getText();
            URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);
            if (urls.length == 0) {
                return;
            }

            SpannableStringBuilder spannable = new SpannableStringBuilder(text);
            // 只拦截 http:// URI
            LinkedList<String> myurls = new LinkedList<String>();
            for (URLSpan uri : urls) {
                String uriString = uri.getURL();
                if (uriString.indexOf("http://") == 0) {
                    myurls.add(uriString);
                }
            }
            //循环把链接发过去
            for (URLSpan uri : urls) {
                String uriString = uri.getURL();
                if (uriString.indexOf("http://") == 0) {
                    MyURLSpan myURLSpan = new MyURLSpan(uriString, myurls, onClickListener);
                    spannable.setSpan(myURLSpan, sp.getSpanStart(uri),
                            sp.getSpanEnd(uri), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                }
            }
            tv.setText(spannable);
        }
    }

    public interface OnUrlSpanClickListener {
        void onClick(String mUrl);
    }

    /**
     * 处理TextView中的链接点击事件
     * 链接的类型包括：url，号码，email，地图
     * 这里只拦截url，即 http:// 开头的URI
     */
    public static class MyURLSpan extends ClickableSpan {
        private final OnUrlSpanClickListener onUrlSpanClickListener;
        private String mUrl;                    // 当前点击的实际链接
        private LinkedList<String> mUrls; // 根据需求，一个TextView中存在多个link的话，这个和我求有关，可已删除掉

        // 无论点击哪个都必须知道该TextView中的所有link，因此添加改变量
        MyURLSpan(String url, LinkedList<String> urls, OnUrlSpanClickListener onUrlSpanClickListener) {
            mUrl = url;
            mUrls = urls;
            this.onUrlSpanClickListener = onUrlSpanClickListener;
        }

        @Override
        public void onClick(View widget) {
            // 这里你可以做任何你想要的处理
            // 比如在你自己的应用中用webview打开，而不是打开系统的浏览器
            String info = new String();
            if (mUrls.size() == 1) {
                // 只有一个url，根据策略弹出提示对话框
                info = mUrls.get(0);
            } else {
                // 多个url，弹出选择对话框，意思一下
                info = mUrls.get(0) + "\n" + mUrls.get(1);
            }
            if (onUrlSpanClickListener != null) {
                onUrlSpanClickListener.onClick(info);
            }

        }
    }
}
