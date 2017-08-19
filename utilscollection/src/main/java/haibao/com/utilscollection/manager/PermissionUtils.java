package haibao.com.utilscollection.manager;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Camera;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import haibao.com.utilscollection.UtilsCollection;

import static android.R.attr.targetSdkVersion;

/**
 * Created by anzhuo002 on 2016/9/8.
 */

public class PermissionUtils {
    // 音频获取源
    public static int audioSource = MediaRecorder.AudioSource.MIC;
    // 设置音频采样率，44100是目前的标准，但是某些设备仍然支持22050，16000，11025
    public static int sampleRateInHz = 44100;
    // 设置音频的录制的声道CHANNEL_IN_STEREO为双声道，CHANNEL_CONFIGURATION_MONO为单声道
    public static int channelConfig = AudioFormat.CHANNEL_IN_STEREO;
    // 音频数据格式:PCM 16位每个样本。保证设备支持。PCM 8位每个样本。不一定能得到设备支持。
    public static int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    // 缓冲区字节大小
    public static int bufferSizeInBytes = 0;

    public static boolean selfPermissionGranted(String permission) {
        // For Android < Android M, self permissions are always granted.
        boolean result = true;
        try {
            final PackageInfo info = UtilsCollection.core.getPackageManager().getPackageInfo(UtilsCollection.core.getPackageName(), 0);
            int targetSdkVersion = info.applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (targetSdkVersion >= Build.VERSION_CODES.M) {
                // targetSdkVersion >= Android M, we can
                // use Context#checkSelfPermission
                result = UtilsCollection.core.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
            } else {
                // targetSdkVersion < Android M, we have to use PermissionChecker
                result = PermissionChecker.checkSelfPermission(UtilsCollection.core, permission) == PermissionChecker.PERMISSION_GRANTED;
            }
        }
        return result;
    }

    /**
     * 点击跳转到权限的页面
     *
     * @param mActivity act
     */
    public static void toSetPermissionsPager(Activity mActivity) {
        String name = Build.MANUFACTURER;
        Log.i("MainActivity", Build.MODEL + "--------" + Build.MANUFACTURER);
        /**
         * HUAWEI，vivo，OPPO......手机机型标注不可以改变
         */
        if ("HUAWEI".equals(name)) {
            goHuaWeiMainager(mActivity);
        } else if ("vivo".equals(name)) {
            goVivoMainager(mActivity);
        } else if ("OPPO".equals(name)) {
            goOppoMainager(mActivity);
        } else if ("Coolpad".equals(name)) {
            goCoolpadMainager(mActivity);
        } else if ("Meizu".equals(name)) {
            goMeizuMainager(mActivity);
            // getAppDetailSettingIntent();
        } else if ("Xiaomi".equals(name)) {
            goXiaoMiMainager(mActivity);
        } else if ("samsung".equals(name)) {
            goSangXinMainager(mActivity);
        } else {
            goIntentSetting(mActivity);
        }
    }

    private static void goHuaWeiMainager(Activity mActivity) {
        try {
            Intent intent = new Intent("demo.vincent.com.tiaozhuan");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            intent.setComponent(comp);
            mActivity.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(mActivity, "跳转失败", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            goIntentSetting(mActivity);
        }
    }

    private static void goXiaoMiMainager(Activity mActivity) {
        try {
            Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", mActivity.getPackageName());
            mActivity.startActivity(localIntent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            goIntentSetting(mActivity);
        }
    }

    private static void goMeizuMainager(Activity mActivity) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.putExtra("packageName", "com.haibao");
            mActivity.startActivity(intent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            localActivityNotFoundException.printStackTrace();
            goIntentSetting(mActivity);
        }
    }

    private static void goSangXinMainager(Activity mActivity) {
        //三星4.3可以直接跳转
        goIntentSetting(mActivity);
    }

    private static void goIntentSetting(Activity mActivity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", mActivity.getPackageName(), null);
        intent.setData(uri);
        try {
            mActivity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void goOppoMainager(Activity mActivity) {
        doStartApplicationWithPackageName(mActivity, "com.coloros.safecenter");
    }

    /**
     * doStartApplicationWithPackageName("com.yulong.android.security:remote")
     * 和Intent open = getPackageManager().getLaunchIntentForPackage("com.yulong.android.security:remote");
     * startActivity(open);
     * 本质上没有什么区别，通过Intent open...打开比调用doStartApplicationWithPackageName方法更快，也是android本身提供的方法
     */
    private static void goCoolpadMainager(Activity mActivity) {
        doStartApplicationWithPackageName(mActivity, "com.yulong.android.security:remote");
      /*  Intent openQQ = getPackageManager().getLaunchIntentForPackage("com.yulong.android.security:remote");
        startActivity(openQQ);*/
    }

    /**
     * 只有在那个app里才能进行权限设置，所以这种情况下，不应该跳转到系统的设置页面，而是打开软件管家。
     * 那么想要去打开一个app就必须要知道这个app的包名。所有，只能通过adb来获取它们各自管家的包名。
     * 例如，打开vivo的 i管家，在Terminal中通过执行这个指令 adb shell dumpsys activity top来捕捉软件的主Activity。
     * <p>
     * adb结果：
     * vivo的软件管家包名：com.iqoo.secure
     * oppo的软件管家包名：com.oppo.safe
     */
    //vivo
    private static void goVivoMainager(Activity mActivity) {
        doStartApplicationWithPackageName(mActivity, "com.iqoo.secure");
     /*   Intent openQQ = getPackageManager().getLaunchIntentForPackage("com.vivo.securedaemonservice");
        startActivity(openQQ);*/
        // vivo 点击设置图标>加速白名单>我的app
        //      点击软件管理>软件管理权限>软件>我的app>信任该软件

    }

    /**
     * 此方法在手机各个机型设置中已经失效
     *
     * @return
     */
    private static Intent getAppDetailSettingIntent(Activity mActivity) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", mActivity.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", mActivity.getPackageName());
        }
        return localIntent;
    }

    private static void doStartApplicationWithPackageName(Activity mActivity, String packagename) {

        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo = mActivity.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            return;
        }
        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);
        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = mActivity.getPackageManager()
                .queryIntentActivities(resolveIntent, 0);
        Log.i("MainActivity", "resolveinfoList" + resolveinfoList.size());
        for (int i = 0; i < resolveinfoList.size(); i++) {
            Log.i("MainActivity", resolveinfoList.get(i).activityInfo.packageName + resolveinfoList.get(i).activityInfo.name);
        }
        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);
            intent.setComponent(cn);
            try {
                mActivity.startActivity(intent);
            } catch (Exception e) {
                goIntentSetting(mActivity);
                e.printStackTrace();
            }
        }
    }

    public static boolean selfPermissionGranted(Context context, String permission) {
// For Android < Android M, self permissions are always granted.

        int targetSdkVersion = -1;
        try {
            final PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            targetSdkVersion = info.applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        boolean result = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (targetSdkVersion >= Build.VERSION_CODES.M) {
// targetSdkVersion >= Android M, we can
// use Context#checkSelfPermission
                result = context.checkSelfPermission(permission)
                        == PackageManager.PERMISSION_GRANTED;
            } else {
// targetSdkVersion < Android M, we have to use PermissionChecker
                result = PermissionChecker.checkSelfPermission(context, permission)
                        == PermissionChecker.PERMISSION_GRANTED;
            }
        }
        return result;
    }

    public static boolean CheckAudioPermission() {

        bufferSizeInBytes = 0;
        bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz,
                channelConfig, audioFormat);
        AudioRecord audioRecord = new AudioRecord(audioSource, sampleRateInHz,
                channelConfig, audioFormat, bufferSizeInBytes);
        //开始录制音频
        try {
            // 防止某些手机崩溃，例如联想
            audioRecord.startRecording();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            Log.e("Tag", Log.getStackTraceString(e));
        }
        /**
         * 根据开始录音判断是否有录音权限
         */
        if (audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING
                && audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_STOPPED) {
            Log.e("Tag", "audioRecord.getRecordingState() != AudioRecord.RECORDSTATE_RECORDING : " + audioRecord.getRecordingState());
            return false;
        }

//        if (audioRecord.getRecordingState() == AudioRecord.RECORDSTATE_STOPPED) {
//            //如果短时间内频繁检测，会造成audioRecord还未销毁完成，此时检测会返回RECORDSTATE_STOPPED状态，再去read，会读到0的size，所以此时默认权限通过
//            return true;
//        }

        byte[] bytes = new byte[1024];
        int readSize = audioRecord.read(bytes, 0, 1024);
        if (readSize == AudioRecord.ERROR_INVALID_OPERATION || readSize <= 0) {
            Log.e("Tag", "readSize illegal : " + readSize);
            return false;
        }
        audioRecord.stop();
        audioRecord.release();
        audioRecord = null;

        return true;

    }


    //    权限检查
    public static boolean checkPermission() {
        int cameraId = CameraHelper.getFrontCameraID();
        Camera mCamera = CameraHelper.getCameraInstance(cameraId);
        if (null == mCamera) {
            ToastUtils.showShort("打开相机失败,请开始摄像和录音权限！");
            return false;
        } else {
            mCamera.release();
            return true;
        }
    }


}
