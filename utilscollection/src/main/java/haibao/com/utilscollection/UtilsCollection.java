package haibao.com.utilscollection;

import android.app.Application;

import haibao.com.utilscollection.inter.GoLoginListener;
import haibao.com.utilscollection.inter.Reporter;
import haibao.com.utilscollection.inter.ThirdShareService;

/**
 * 工具类的库。包括了通用的使用工具。和 Application需要实现的接口。还有第三方上传的接口
 * 主持化的时候，需要注入。
 * Created by Administrator on 2017/3/3 0003.
 */
public class UtilsCollection {
    public static Application core;
    public static Reporter sReporter;
    public static ThirdShareService sThirdShareService;
    public static boolean sConfig;
    public static GoLoginListener mGoLoginListener;


    public static void init(Application application) {
        core = application;
    }

    public static void initReporter(Reporter reporter) {
        sReporter = reporter;
    }

    public static void initShare(ThirdShareService thirdShareService) {
        sThirdShareService = thirdShareService;
    }

    public static void initGoLoginListener(GoLoginListener listener) {
        mGoLoginListener = listener;
    }

}
