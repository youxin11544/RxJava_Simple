/***
 * Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com)
 ***/
package haibao.com.utilscollection.ex;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import haibao.com.utilscollection.info.SystemTool;

public class CrashHandlerUtils {


    /**
     * @param application
     * @param logFilePath Common.DIR_ERROR_LOG
     * @param ex
     * @throws Exception
     */
    public static void saveToSDCard(Application application, String logFilePath, Throwable ex) throws Exception {
        try {
            String savePath = logFilePath;//日志目录
            File f = new File(savePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            String fileNmae = SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log";
            File file = new File(f.getAbsolutePath() + File.separator + fileNmae);
            file.createNewFile();
            if (file == null) {
                return;
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.println(SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss"));
            dumpPhoneInfo(application, pw);
            pw.println();
            ex.printStackTrace(pw);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写log 到sd卡
     *
     * @param log
     */
    public static void saveLogToSDCard(Application application, String logFilePath, String log) {
        try {
            String savePath = logFilePath;//日志目录
            File f = new File(savePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            String fileNmae = SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log";
            File file = new File(f.getAbsolutePath() + File.separator + fileNmae);
            file.createNewFile();

            if (file == null) {
                return;
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.println(SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss"));
            dumpPhoneInfo(application, pw);
            pw.println();
            pw.println(log);
            pw.println();
            pw.flush();
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写log 到sd卡
     **/
    public static void saveLogToSDCard(Application application, String logFilePath) {
        try {
            String savePath = logFilePath;//日志目录
            File f = new File(savePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            String fileNmae = SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log";
            File file = new File(f.getAbsolutePath() + File.separator + fileNmae);
            file.createNewFile();

            if (file == null) {
                return;
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.println(SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss"));
            dumpPhoneInfo(application, pw);
            pw.println();
            pw.println();
            pw.flush();
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("WrongConstant")
    public static void dumpPhoneInfo(Application application, PrintWriter pw)
            throws PackageManager.NameNotFoundException {
        PackageManager pm = application.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(application.getPackageName(), 1);
        pw.print("App Version: ");
        pw.print(pi.versionName);
        pw.print('_');
        pw.println(pi.versionCode);
        pw.println();

        pw.print("OS Version: ");
        pw.print(Build.VERSION.RELEASE);
        pw.print("_");
        pw.println(Build.VERSION.SDK_INT);
        pw.println();

        pw.print("Vendor: ");
        pw.println(Build.MANUFACTURER);
        pw.println();

        pw.print("Model: ");
        pw.println(Build.MODEL);
        pw.println();

        pw.print("CPU ABI: ");
        pw.println(Build.CPU_ABI);
        pw.println();
    }
}