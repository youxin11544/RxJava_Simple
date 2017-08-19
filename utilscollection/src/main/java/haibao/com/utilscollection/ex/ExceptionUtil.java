package haibao.com.utilscollection.ex;

import android.text.TextUtils;
import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;

import haibao.com.utilscollection.UtilsCollection;


public class ExceptionUtil {
    private ExceptionUtil() {
        throw new AssertionError();
    }

    public static void handleException(Exception e) {
        if (UtilsCollection.sConfig) {
            // 联网发送
            UtilsCollection.sReporter.reportError(UtilsCollection.core, e);//发给统计
//            MobclickAgent.reportError(HaiBaoApplication.getInstance(), e);
        } else {
            // 开发阶段
            e.printStackTrace();

        }
    }

    public static void handleException(Exception e, String content) {
        if (UtilsCollection.sConfig) {
            // 运行到真机上。
            // 程序出错了，异常信息开发人员要知道的。
            String str = "";
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            str = stringWriter.toString();
            // 联网发送
            if (TextUtils.isEmpty(content)) {
                content = "";
            }
            UtilsCollection.sReporter.reportError(UtilsCollection.core, content + str);//发给统计
//            MobclickAgent.reportError(HaiBaoApplication.getInstance(), content + str);//发给友盟统计
        } else {
            // 开发阶段
            Log.e("ExceptionUtil", content);
        }
    }


    public static void handleException(String content) {
        if (UtilsCollection.sConfig) {
            UtilsCollection.sReporter.reportError(UtilsCollection.core, content);//发给统计
//            MobclickAgent.reportError(HaiBaoApplication.getInstance(), content);//发给友盟统计
        } else {
            // 开发阶段
            Log.e("ExceptionUtil", content);
        }
    }

}
