package haibao.com.utilscollection.op;

import android.text.Layout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/1 0001.
 */

public class TextUtils {
    public static String ToSBC(String input) {
        // 半角转全角：
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 32) {
                c[i] = (char) 12288;
                continue;
            }
            if (c[i] < 127)
                c[i] = (char) (c[i] + 65248);
        }
        return new String(c);
    }

    /**
     * 全角转换为半角
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    public static int getLineCount(TextView textView, String content) {
        int totalLineCount;
        float totalWidth = textView.getPaint().measureText(content);
        Layout layout = textView.getLayout();
        if (layout != null) {
            float singleLineWidth = layout.getLineWidth(0);
            totalLineCount = (int) Math.ceil(totalWidth / singleLineWidth);
        } else {
            totalLineCount = textView.getLineCount();
        }
        return totalLineCount;
    }

    public static int getLineCount(TextView textView) {
        int totalLineCount;
        float totalWidth = textView.getPaint().measureText(textView.getText().toString());
        Layout layout = textView.getLayout();
        if (layout != null) {
            float singleLineWidth = layout.getLineWidth(0);
            totalLineCount = (int) Math.ceil(totalWidth / singleLineWidth);
        } else {
            totalLineCount = textView.getLineCount();
        }
        return totalLineCount;
    }
}
