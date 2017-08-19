package haibao.com.utilscollection.op;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by anzhuo002 on 2016/7/14.
 */

public class BitmapUtils {

    public static final int DEFAULT_COMPRESS_QUALITY = 60;

    public static Bitmap blur(Activity mActivity) {
        Bitmap overlay;
        long startMs = System.currentTimeMillis();

        View view = mActivity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);


        Bitmap mBitmap = view.getDrawingCache();

        float scaleFactor = 8;
        float radius = 10;
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        overlay = Bitmap.createBitmap((int) (width / scaleFactor), (int) (height / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(mBitmap, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, (int) radius, true);
        return overlay;
    }

    /**
     * 模糊图片
     *
     * @param bkg
     * @param radius
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void blur(Context mContext, View fl_root, Bitmap bkg, float radius) {
        try {
            float scaleFactor = 8;
            Bitmap overlay = Bitmap.createBitmap((int) (bkg.getWidth() / scaleFactor), (int) (bkg.getHeight() / scaleFactor), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(overlay);
            canvas.translate(-fl_root.getLeft() / scaleFactor, -fl_root.getTop() / scaleFactor);
            canvas.scale(1 / scaleFactor, 1 / scaleFactor);
            Paint paint = new Paint();
            paint.setFlags(Paint.FILTER_BITMAP_FLAG);
            canvas.drawBitmap(bkg, 0, 0, paint);
            overlay = FastBlur.doBlur(overlay, (int) radius, true);
            fl_root.setBackground(new BitmapDrawable(mContext.getResources(), overlay));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<String> compressImages(String cache_path, List<String> data) {
        List<String> result = new ArrayList<>();
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                String path = data.get(i);
                File f = new File(path);
                if (f.exists() && f.canWrite()) {
                    if (f.length() >= 2 * 1024 * 1024L) {
                        String name = path.substring(path.lastIndexOf("/") + 1);
                        String newPath = saveBitmap(cache_path, path, name);
                        if (!TextUtils.isEmpty(newPath)) {
                            result.add(newPath);
                            File newFile = new File(newPath);
                            while (newFile.exists() && newFile.canWrite() && newFile.length() >= 2 * 1024 * 1024L) {
                                newPath = saveBitmap(cache_path, newPath, name);
                                if (!TextUtils.isEmpty(newPath)) {
                                    newFile = new File(newPath);
                                    if (newFile.exists() && newFile.canWrite() && newFile.length() < 2 * 1024 * 1024L) {
                                        result.add(newPath);
                                        break;
                                    }
                                } else {
//                                    CrashHandler.create(HaiBaoApplication.getInstance()).saveLogToSDCard("compressImages() ------   newPath = saveBitmap(newPath, name);;; 是空" +
//                                            "use_id--" + HaiBaoApplication.getUserId()
//                                    );
                                }
                            }
                        } else {
//                            CrashHandler.create(HaiBaoApplication.getInstance()).saveLogToSDCard("compressImages() ------   String newPath = saveBitmap(path, name);; 是空" +
//                                    "use_id--" + HaiBaoApplication.getUserId()
//                            );
                        }
                    } else {
                        result.add(path);
                    }
                } else {
//                    CrashHandler.create(HaiBaoApplication.getInstance()).saveLogToSDCard("compressImages() ------ File f = new File(path); 是空" +
//                            "use_id--" + HaiBaoApplication.getUserId()
//                    );
                }
            }
        }
        return result;
    }

    /**
     * 保存压缩过后的Bitmap
     *
     * @param filePath 源文件路径
     * @param fileName 压缩后的图片文件名称，带后缀
     * @return 压缩后的图片文件路径
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static String saveBitmap(String cache_image, String filePath, String fileName) {
        String path = getExternalStorageDirectory().toString();
        File dir = new File(path + cache_image);
        dir.mkdirs();
        File f = new File(path + cache_image, fileName);
        if (f.exists()) {
            f.delete();
        }
        try {
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
//            Bitmap bm = getSmallBitmap(filePath);
            Bitmap bm = comp(filePath);

            if (bm != null) {
                bm.compress(Bitmap.CompressFormat.JPEG, DEFAULT_COMPRESS_QUALITY, out);
            } else {
                return null;
            }
            out.flush();
            out.close();
            return path + cache_image + "/" + fileName;
        } catch (Exception e) {
//            CrashHandler.create(HaiBaoApplication.getInstance()).saveLogToSDCard("统计发表图片的数量------" +
//                    "use_id--" + HaiBaoApplication.getUserId()
//            );
        }
        return null;
    }

    // 根据路径获得图片并压缩，返回bitmap用于显示
    private static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, option);
        int outWidth = option.outWidth;
        int outHeight = option.outHeight;
        if (option.outWidth <= 1080) {
            option.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(filePath);
        }
        option.inJustDecodeBounds = false;
        Bitmap bmp = BitmapFactory.decodeFile(filePath, option);
        return ThumbnailUtils.extractThumbnail(bmp, 1080, outHeight * 1080 / outWidth, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
    }

    /**
     * 获取视频缩略图（这里获取第一帧）
     *
     * @param filePath
     * @return
     */
    public static Bitmap getVideoThumbnail(String filePath) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }


    public static Bitmap getVideoNetThumbnail(String url, long time) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //获取网络视频
            retriever.setDataSource(url, new HashMap<String, String>());
            String video_width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH);
            String video_height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT);
            bitmap = retriever.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(time));
//            bitmap = ThumbnailUtils.extractThumbnail(bitmap, Integer.parseInt(video_width), Integer.parseInt(video_height), ThumbnailUtils.OPTIONS_RECYCLE_INPUT);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }


    //    混合方式压缩
    public static Bitmap comp(String filePath) {
        final BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, option);
        int outWidth = option.outWidth;
        int outHeight = option.outHeight;
        if (option.outWidth <= 1080) {
            option.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(filePath);
        }
        option.inJustDecodeBounds = false;
        Bitmap image = BitmapFactory.decodeFile(filePath, option);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        if (baos.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, DEFAULT_COMPRESS_QUALITY, baos);//这里压缩50%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
    }

    //    质量压缩
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = DEFAULT_COMPRESS_QUALITY;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

//    public static Bitmap drawableToBitmap(Drawable drawable) {
//
//        Bitmap bitmap = Bitmap.createBitmap(
//
//                drawable.getIntrinsicWidth(),
//
//                drawable.getIntrinsicHeight(),
//
//                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
//
//                        : Bitmap.Config.RGB_565);
//
//        Canvas canvas = new Canvas(bitmap);
//
//        //canvas.setBitmap(bitmap);
//
//        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//
//        drawable.draw(canvas);
//
//        return bitmap;
//
//    }


    /**
     * 截取scrollview的屏幕
     *
     * @param scrollView
     * @return
     */
    public static Bitmap getBitmapByView(ScrollView scrollView) {
        int h = 0;
        Bitmap bitmap = null;
        // 获取scrollview实际高度
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
//            scrollView.getChildAt(i).setBackgroundColor(olor.parseColor("#ffffff"));
        }

        // 创建对应大小的bitmap
        bitmap = Bitmap.createBitmap(scrollView.getWidth(), h, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);

        return bitmap;
    }


    /**
     * 保存到sd卡
     *
     * @param savePath String savePath  =  Common.DIR_CACHE_IMAGE;;
     * @param b
     * @return
     */
    public static String savePic(Context context, String savePath, Bitmap b) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);

        File outfile = new File(savePath);
        // 如果文件不存在，则创建一个新文件
        if (!outfile.isDirectory()) {
            try {
                outfile.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String fname = sdf.format(new Date()) + ".png";
        File file = new File(savePath, fname);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            if (null != fos) {
                b.compress(Bitmap.CompressFormat.PNG, DEFAULT_COMPRESS_QUALITY, fos);
                fos.flush();
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通知图框更新
        notifySystemLoadImageThumb(context, file.getAbsolutePath(), fname);
        return fname;
    }

    public static void notifySystemLoadImageThumb(Context context, String absolutePath, String fileName) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), absolutePath, fileName, null);//图片插入到系统图库
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + absolutePath)));//通知图库刷新
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

}
