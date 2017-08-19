package haibao.com.utilscollection.io;

import android.app.Activity;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import haibao.com.utilscollection.ex.ExceptionUtil;
import haibao.com.utilscollection.info.SystemTool;

public final class FileUtils {


    /**
     *  判断文件是否存在
     * @returns
     */
    public static boolean isFilexists(String pathName) {
        File dir = new File(pathName);
        return dir.exists();

    }

    public static class FileInfo{
        public long lastModified ;
        public File file;
    }

    public static ArrayList<FileInfo> sortFileTime(File parentFile) {
        File[] files =parentFile.listFiles();//通过fileFileter过滤器来获取parentFile路径下的想要类型的子文件
        ArrayList<FileInfo> fileList = new ArrayList<FileInfo>();//将需要的子文件信息存入到FileInfo里面
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            FileInfo fileInfo = new FileInfo();
            fileInfo.file = file;
            fileInfo.lastModified= file.lastModified();
            fileList.add(fileInfo);
        }
        Collections.sort(fileList, new FileComparator());//通过重写Comparator的实现类FileComparator来实现按文件创建时间排序。
        return fileList;
    }




    public static class FileComparator implements Comparator<FileInfo> {
        public int compare(FileInfo file1, FileInfo file2) {
            if(file1.lastModified < file2.lastModified)
            {
                return -1;
            }else
            {
                return 1;
            }
        }
    }



    public static void deleteAllFiles(File root) {
        File files[] = root.listFiles();
        if (files != null)
            for (File f : files) {
                if (f.isDirectory()) { // 判断是否为文件夹
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else {
                    if (f.exists()) { // 判断是否存在
                        deleteAllFiles(f);
                        try {
                            f.delete();
                        } catch (Exception e) {
                        }
                    }
                }
            }
    }

    public static  void delete(File file) {
        if ( !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles == null || childFiles.length == 0) {
                file.delete();
                return;
            }
            for (int i = 0; i < childFiles.length; i++) {
                delete(childFiles[i]);
            }
            file.delete();
        }
    }

    /**
     * @param type  0 是音频 1 是视频
     */
//	public static void saveToSDCard(final Context mContext, final String content, final int type){
//		HaiBaoApplication.getInstance().getExecutor().execute(new Runnable() {
//			@Override
//			public void run() {
//				String name = "";
//				if (type == 0) {
//					name = "音频上传成功";
//				}else{
//					name = "视频上传成功";
//				}
//				// 和log 日志一个目录
//				File file = MyFileUtils.getSaveFile(mContext.getPackageName()+ File.separator + "log", name+SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log");
//
//				BufferedWriter bw= null;
//				try {
//					bw = new BufferedWriter(new FileWriter(file));
//					bw.write(content);
//					bw.flush();
//					bw.close();
//
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//	}

    public static final int SIZETYPE_B = 1;//获取文件大小单位为B的double值
    public static final int SIZETYPE_KB = 2;//获取文件大小单位为KB的double值
    public static final int SIZETYPE_MB = 3;//获取文件大小单位为MB的double值
    public static final int SIZETYPE_GB = 4;//获取文件大小单位为GB的double值
    /**
     * 获取文件指定文件的指定单位的大小
     * @param filePath 文件路径
     * @param sizeType 获取大小的类型1为B、2为KB、3为MB、4为GB
     * @return double值的大小
     */
    public static double getFileOrFilesSize(String filePath,int sizeType){
        File file=new File(filePath);
        long blockSize=0;
        try {
            if(file.isDirectory()){
                blockSize = getFileSizes(file);
            }else{
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FormetFileSize(blockSize, sizeType);
    }
    /**
     * 调用此方法自动计算指定文件或指定文件夹的大小
     * @param filePath 文件路径
     * @return 计算好的带B、KB、MB、GB的字符串
     */
    public static String getAutoFileOrFilesSize(String filePath){
        File file=new File(filePath);
        long blockSize=0;
        try {
            if(file.isDirectory()){
                blockSize = getFileSizes(file);
            }else{
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FormetFileSize(blockSize);
    }
    /**
     * 获取指定文件大小
     * @return
     * @throws Exception
     */
    private static long getFileSize(File file) throws Exception
    {
        long size = 0;
        if (file.exists()){
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        }
//		else{
//			file.createNewFile();
//		}
        return size;
    }

    /**
     * 获取指定文件夹
     * @param f
     * @return
     * @throws Exception
     */
    private static long getFileSizes(File f) throws Exception
    {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++){
            if (flist[i].isDirectory()){
                size = size + getFileSizes(flist[i]);
            }
            else{
                size =size + getFileSize(flist[i]);
            }
        }
        return size;
    }
    /**
     * 转换文件大小
     * @param fileS
     * @return
     */
    private static String FormetFileSize(long fileS)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize="0B";
        if(fileS==0){
            return wrongSize;
        }
        if (fileS < 1024){
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576){
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else if (fileS < 1073741824){
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
        else{
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }
    /**
     * 转换文件大小,指定转换的类型
     * @param fileS
     * @param sizeType
     * @return
     */
    private static double FormetFileSize(long fileS,int sizeType)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        double fileSizeLong = 0;
        switch (sizeType) {
            case SIZETYPE_B:
                fileSizeLong=Double.valueOf(df.format((double) fileS));
                break;
            case SIZETYPE_KB:
                fileSizeLong=Double.valueOf(df.format((double) fileS / 1024));
                break;
            case SIZETYPE_MB:
                fileSizeLong=Double.valueOf(df.format((double) fileS / 1048576));
                break;
            case SIZETYPE_GB:
                fileSizeLong=Double.valueOf(df.format((double) fileS / 1073741824));
                break;
            default:
                break;
        }
        return fileSizeLong;
    }

    /**
     *  获得 音频 路径名称
     * @return
     */
    public static String getRecordAudioFilePathName(String  recordPath) {
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String result = Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath + "/" + System.currentTimeMillis() + getRandomNumber() + ".mp3";
        File f = new File(result);
        try {
            if (f.exists()) {
                f.delete();
            }
            boolean result1 = f.createNewFile();
            if (!result1) {
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *  获得 音频 路径名称
     * @return
     */
    public static String getRecordAudioFilePath(String recordPath) {
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String result = Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath;

        return result;
    }

    private static int getRandomNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return Integer.valueOf(sb.toString());
    }

    /**
     *  获得 视频频 路径名称
     * @return
     */
    public static String getRecordVideoFilePathName(String recordPath) {
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String result = Environment.getExternalStorageDirectory().getAbsolutePath() + recordPath + "/" + System.currentTimeMillis() + ".mp4";
        File f = new File(result);
        try {
            boolean result1 = f.createNewFile();
            if (!result1) {
                return null;
            }
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return null;
        }
        return result;
    }


    /**
     *  获得 视频频 路径名称
     * @return
     */
    public static String getRecordVideoFileRootPathName(String recordPath) {
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +recordPath);
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//		String result = Environment.getExternalStorageDirectory().getAbsolutePath() + Common.DIR_RECORD_VIDEO + "/" + System.currentTimeMillis() + ".mp4";
//		File f = new File(result);
//		try {
//			boolean result1 = f.createNewFile();
//			if (!result1) {
//				return null;
//			}
//		} catch (Exception e) {
//			ExceptionUtil.handleException(e);
//			return null;
//		}
        return dir.getAbsolutePath();
    }

    /**
     *  获得 语音评测路径 路径名称
     * @return  Environment.getExternalStorageDirectory().getAbsolutePath() + Common.DIR_MSC + "/ise.wav"
     */
//	public static String getSpeechEvaluatorPathName() {
//		File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + Common.DIR_MSC);
//		if (!dir.exists()) {
//			dir.mkdirs();
//		}
//		String result = Environment.getExternalStorageDirectory().getAbsolutePath() + Common.DIR_MSC + "/" + System.currentTimeMillis() + "ise.wav";
//		File f = new File(result);
//		try {
//			boolean result1 = f.createNewFile();
//			if (!result1) {
//				return null;
//			}
//		} catch (Exception e) {
//			Log.e(Common.DIR_MSC,"创建失败");
////			ExceptionUtil.handleException(e);
//			return null;
//		}
//		return result;
//	}


    public static String saveBitmap(String cacheImagePath,Bitmap bitmap) {
//		String path = Environment.getExternalStorageDirectory() + Common.DIR_CACHE_IMAGE + "/" + new Date().getTime()  + ".jpg";
        String path = null;
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + cacheImagePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + cacheImagePath + "/" + System.currentTimeMillis() + ".jpg";
        File f = new File(path);
        try {
            boolean result1 = f.createNewFile();
            if (!result1) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        if (bitmap == null)
            return null;
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(f), 8192);
            boolean isSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 70, out);
            if(isSuccess){
                return path;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeIO(new Closeable[] { out });
        }
        return null;
    }


    public static boolean checkSDcard() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static void debugFile(Context mContext, String str) throws Exception {
        File file = FileUtils.getSaveFile(mContext.getPackageName() + File.separator + "debug", SystemTool.getDataTime("yyyy-MM-dd-HH-mm-ss") + ".log");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(str);
        bw.flush();
        bw.close();
    }

    public static void saveFileCache(byte[] fileData, String folderPath,
                                     String fileName) {
        File folder = new File(folderPath);
        folder.mkdirs();
        File file = new File(folderPath, fileName);
        ByteArrayInputStream is = new ByteArrayInputStream(fileData);
        OutputStream os = null;
        if (file.exists())
            return;
        try {
            file.createNewFile();
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while (-1 != (len = is.read(buffer))) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeIO(new Closeable[]{is, os});
        }
    }

    public static File getSaveFile(String folderPath, String fileName) {
        File file = new File(getSavePath(folderPath) + File.separator + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static String getSavePath(String folderName) {
        return getSaveFolder(folderName).getAbsolutePath();
    }

    public static File getSaveFolder(String folderName) {
        File file = new File(Environment.getExternalStorageDirectory()
                .getAbsoluteFile()
                + File.separator
                + folderName
                + File.separator);
        file.mkdirs();
        return file;
    }

    public static byte[] input2byte(InputStream inStream) {
        if (inStream == null)
            return null;
        byte[] in2b = null;
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc;
        try {
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            in2b = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeIO(new Closeable[]{swapStream});
        }
        return in2b;
    }

    public static File uri2File(Activity aty, Uri uri) {
        if (SystemTool.getSDKVersion() < 11) {
            String[] proj = {"_data"};

            Cursor actualImageCursor = aty.managedQuery(uri, proj, null, null,
                    null);
            int actual_image_column_index = actualImageCursor
                    .getColumnIndexOrThrow("_data");
            actualImageCursor.moveToFirst();
            String img_path = actualImageCursor
                    .getString(actual_image_column_index);
            return new File(img_path);
        }

        String[] projection = {"_data"};
        CursorLoader loader = new CursorLoader(aty, uri, projection, null,
                null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow("_data");
        cursor.moveToFirst();
        return new File(cursor.getString(column_index));
    }

    public static void copyFile(File from, File to) {
        if ((from == null) || (!(from.exists())))
            return;
        if (to == null)
            return;
        FileInputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(from);
            if (!(to.exists())) {
                to.createNewFile();
            }
            os = new FileOutputStream(to);
            copyFileFast(is, os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeIO(new Closeable[]{is, os});
        }
    }

    public static void copyFileFast(FileInputStream is, FileOutputStream os)
            throws IOException {
        FileChannel in = is.getChannel();
        FileChannel out = os.getChannel();
        in.transferTo(0L, in.size(), out);
    }

    public static void closeIO(Closeable[] closeables) {
        if ((closeables == null) || (closeables.length <= 0))
            return;
        for (Closeable cb : closeables)
            try {
                if (cb != null) {
                    cb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static boolean bitmapToFile(Bitmap bitmap, String filePath) {
        boolean isSuccess = false;
        if (bitmap == null)
            return isSuccess;
        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(filePath), 8192);
            isSuccess = bitmap.compress(Bitmap.CompressFormat.PNG, 70, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeIO(new Closeable[]{out});
        }
        return isSuccess;
    }

    public static String readFile(String filePath) {
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
//			throw new KJException(FileUtils.class.getName() + "readFile---->"
//					+ filePath + " not found");
        }
        return inputStream2String(is);
    }

    public static String readFileFromAssets(Context context, String name) {
        InputStream is = null;
        try {
            is = context.getResources().getAssets().open(name);
        } catch (Exception e) {
            e.printStackTrace();
//			throw new KJException(FileUtils.class.getName()
//					+ ".readFileFromAssets---->" + name + " not found");
        }
        return inputStream2String(is);
    }

    public static String inputStream2String(InputStream is) {
        if (is == null)
            return null;
        StringBuilder resultSb = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            resultSb = new StringBuilder();
            String len;
            while ((len = br.readLine()) != null) {
                resultSb.append(len);
            }
        } catch (Exception localException) {
        } finally {
            closeIO(new Closeable[]{is});
        }
        return ((resultSb == null) ? null : resultSb.toString());
    }

    public static String getMimeType(String fileUrl) throws IOException,
            MalformedURLException {
        String type = null;
        URL u = new URL(fileUrl);
        URLConnection uc = null;
        uc = u.openConnection();
        type = uc.getContentType();
        return type;
    }

    public static boolean renameFile(String file, String toFile) {
        File toBeRenamed = new File(file);
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
//            KLog.e("File does not exist: " + file);
            return false;
        }
        File newFile = new File(toFile);
        if (toBeRenamed.renameTo(newFile)) {
//            KLog.e("File has been renamed.");
            return true;
        } else {
//            KLog.e("Error renmaing file");
            return false;
        }
    }


    public static boolean isFile(String file) {
        File toBeRenamed = new File(file);
        if (!toBeRenamed.exists()) {
            return false;
        }else {
            return true;
        }
    }


}