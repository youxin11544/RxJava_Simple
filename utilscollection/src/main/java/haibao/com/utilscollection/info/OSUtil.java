package haibao.com.utilscollection.info;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

import haibao.com.utilscollection.UtilsCollection;

public class OSUtil {

    public OSUtil() {
    }

    /**
     * @return null may be returned if the specified process not found
     */
    public static String getProcessName(int pid) {
        ActivityManager am = (ActivityManager) UtilsCollection.core.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps == null) {
            return null;
        }
        for (RunningAppProcessInfo procInfo : runningApps) {
            if (procInfo.pid == pid) {
                return procInfo.processName;
            }
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    public static String getTopTask() {
        ActivityManager am = (ActivityManager) UtilsCollection.core.getSystemService(Context.ACTIVITY_SERVICE);

        List<RunningTaskInfo> runningTasks = am.getRunningTasks(1);

        RunningTaskInfo rti = runningTasks.get(0);
        ComponentName component = rti.topActivity;
        return component.getClassName();
    }

    private static void bindPort(String host, int port) throws Exception {
        Socket s = new Socket();
        s.bind(new InetSocketAddress(host, port));
        s.close();
    }

    public static boolean isPortAvailable(int port) {
        try {
            bindPort("0.0.0.0", port);
            bindPort(InetAddress.getLocalHost().getHostAddress(), port);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean runOnMainProcess() {
        ActivityManager am = ((ActivityManager) UtilsCollection.core.getSystemService(Context.ACTIVITY_SERVICE));
        List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = UtilsCollection.core.getApplicationContext().getPackageName();
        int myPid = Process.myPid();
        if (processInfos != null) {
            for (RunningAppProcessInfo info : processInfos) {
                if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void refreshMediaStore(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            MediaScannerConnection.scanFile(context, new String[]{Environment.getExternalStorageDirectory().getAbsolutePath()}, null, null);
        } else {
            IntentFilter intentFilter = new IntentFilter(Intent.ACTION_MEDIA_SCANNER_STARTED);
            intentFilter.addAction(Intent.ACTION_MEDIA_SCANNER_FINISHED);
            intentFilter.addDataScheme("file");
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath())));
        }
    }

    public static void refreshMediaStore(File file, String fname) {
        try {
            MediaStore.Images.Media.insertImage(UtilsCollection.core.getContentResolver(), file.getAbsolutePath(), fname, null);//图片插入到系统图库
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        UtilsCollection.core.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsolutePath())));//通知图库刷新
    }


    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion() {
        try {
            PackageManager manager = UtilsCollection.core.getPackageManager();
            PackageInfo info = manager.getPackageInfo(UtilsCollection.core.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "2.3.3";
        }
    }
//    public static void syncCookie(String url, String token, String sid) {
//        if (TextUtils.isEmpty(url)) {
//            return;
//        }
//
////        String mCurrentToken = HaiBaoApplication.getToken();
//        String mCurrentToken = token;
//        CookieSyncManager.createInstance(UtilsCollection.core);
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);
//        cookieManager.removeSessionCookie();//移除
//
//        String Domain = ".baobaobooks.com";
//        String Path = "/";
//        String key = "HBSID";
//        String value = mCurrentToken;
//        String a = key + "=" + value + ";" + "domain=" + Domain + ";" + "path=" + Path;
//
////        String cookieStr = HttpCommon.KEY_HBSID + "=" + mCurrentToken;
//        String cookieStr = sid + "=" + mCurrentToken;
//
//        cookieManager.setCookie(url, a);//cookies是在HttpClient中获得的cookie
//
//        if (Build.VERSION.SDK_INT < 21) {
//            CookieSyncManager.getInstance().sync();
//        } else {
//            CookieManager.getInstance().flush();
//        }
//    }



    /**
     * 获取application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getAppMetaData(String key) {
        Context ctx = UtilsCollection.core;
        if (ctx == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData;
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.contains("Meizu");
    }

}
