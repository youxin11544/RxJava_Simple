package haibao.com.utilscollection.op;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;

/**
 * 模糊工具类
 * Created by qigengxin on 16/8/1.
 */
public class BlurUtil {
    private static final int MAX_BLUR_IMG_SIZE = 100;
    private static Bitmap S_DRAW_BITMAP = null;
    public final static int SCALE = 8;

    /**
     * 生成对应View的磨砂图
     *
     * @param view
     * @return
     */
    public static Bitmap getBlurWhiteBgBitmapFromView(View view) {
        long startTime = System.currentTimeMillis();
        Bitmap overlay = BlurUtil.getBlurImgFromView(view);
        if (overlay == null) {
            overlay = Bitmap.createBitmap(
                    view.getMeasuredWidth() / 10, view.getMeasuredHeight() / 10, Bitmap.Config.RGB_565);
        }

        Canvas canvas = new Canvas(overlay);
        Paint paint = new Paint();

        // 白色透明层
        paint.setColor(0x66FFFFFF);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, overlay.getWidth(), overlay.getHeight(), paint);

        Log.i("BlurView", "ImageUtil blur time: " + (System.currentTimeMillis() - startTime) + "ms");
        return overlay;
    }

    public static Bitmap getBlurImgFromView(View view) {
        long startTime = System.currentTimeMillis();
        Bitmap viewCache = getViewCacheWithMaxSize(view, MAX_BLUR_IMG_SIZE, MAX_BLUR_IMG_SIZE);
        if (viewCache == null) {
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        viewCache.compress(Bitmap.CompressFormat.JPEG, 10, bos);

        Bitmap res;
        byte[] outs = bos.toByteArray();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inMutable = true;
            res = BitmapFactory.decodeByteArray(outs, 0, outs.length, options);
            BlurUtil.blurWithRenderScript(view.getContext(), res, 12, true);
        } else {
            res = BlurUtil.getBlurImage(viewCache, 20, 50);
        }
        Log.i("BlurView", "获取blur所需时间: +" + (System.currentTimeMillis() - startTime) + "ms");
        return res;
    }


    public static Bitmap getBlurImgFromView(Context context, Bitmap mViewCach, float radius) {
        long startTime = System.currentTimeMillis();
        Bitmap viewCache = mViewCach;
        if (viewCache == null) {
            return null;
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        viewCache.compress(Bitmap.CompressFormat.JPEG, 10, bos);

        Bitmap res;
        byte[] outs = bos.toByteArray();

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inMutable = true;
            res = BitmapFactory.decodeByteArray(outs, 0, outs.length, options);
            BlurUtil.blurWithRenderScript(context, res, radius, true);
        } else {
            res = BlurUtil.getBlurImage(viewCache, 20, 50);
        }
        Log.i("BlurView", "获取blur所需时间: +" + (System.currentTimeMillis() - startTime) + "ms");
        return res;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap blurWithRenderScript(Context context, Bitmap in, float radius, boolean canReuseInBitmap) {
        RenderScript rs;
        if (context instanceof Application) {
            rs = RenderScript.create(context);
        } else {
            rs = RenderScript.create(context.getApplicationContext());
        }

        Bitmap outBitmap;

        if (canReuseInBitmap) {
            outBitmap = in;
        } else {
            outBitmap = Bitmap.createBitmap(in.getWidth(), in.getHeight(), Bitmap.Config.ARGB_8888);
        }

        final Allocation input = Allocation.createFromBitmap(rs, in, Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT);
        final Allocation output = Allocation.createTyped(rs, input.getType());
        final ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(radius);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(outBitmap);
        rs.destroy();

        return outBitmap;
    }

//
//    public static Bitmap setBitmapWithMaxSize(View rootView, Bitmap in, int maxWidth, int maxHeight) throws OutOfMemoryError {
//
//        Rect rect = new Rect();
//        Bitmap outBitmap=null;
//
//        rootView.getWindowVisibleDisplayFrame(rect);
//        if (rootView.getWidth() == 0 || rootView.getHeight() == 0) {
//            rootView.measure(
//                    View.MeasureSpec.makeMeasureSpec(rect.width(), View.MeasureSpec.EXACTLY),
//                    View.MeasureSpec.makeMeasureSpec(rect.height(), View.MeasureSpec.EXACTLY)
//            );
//            rootView.layout(0, 0, rootView.getMeasuredWidth(),
//                    rootView.getMeasuredHeight());
//        }
//        float w = rootView.getWidth(), h = rootView.getHeight();
//        if (w <= 0 || h <= 0) {
//            return null;
//        }
//
//        float minScale = Math.min(maxWidth / w, maxHeight / h);
//        int bitmapWidth = (int) (w * minScale), bitmapHeight = (int) (h * minScale);
//        if (outBitmap == null) {
//            outBitmap = Bitmap.createBitmap(
//                    bitmapWidth, bitmapHeight, Bitmap.Config.RGB_565);
//        } else if (outBitmap.getWidth() != bitmapWidth || outBitmap.getHeight() != bitmapHeight) {
//            outBitmap.recycle();
//            outBitmap = Bitmap.createBitmap(
//                    bitmapWidth, bitmapHeight, Bitmap.Config.RGB_565);
//        }
//
//        Canvas canvas = new Canvas(outBitmap);
////        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
//
//        // 设置缩放
//        canvas.scale(minScale, minScale);
//        rootView.draw(canvas);
//
//        Paint paint = new Paint();
////        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
//        canvas.drawBitmap(in, 0, 0, paint);
//
//        return outBitmap;
//    }

    public static Bitmap getBlurImage(Bitmap in, float scaleFactor, int radius) {
        Bitmap overlay = Bitmap.createBitmap((int) (in.getWidth() / scaleFactor),
                (int) (in.getHeight() / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(in, 0, 0, paint);
        overlay = fastBlur(overlay, radius, true);
        return overlay;
    }

    /**
     * 快速模糊算法
     */
    public static Bitmap fastBlur(Bitmap sentBitmap, int radius, boolean canReuseInBitmap) {
        Bitmap bitmap;
        if (canReuseInBitmap) {
            bitmap = sentBitmap;
        } else {
            bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);
        }

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int dv[] = new int[256 * divsum];
        for (i = 0; i < 256 * divsum; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                // Preserve alpha channel: ( 0xff000000 & pix[yi] )
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        bitmap.setPixels(pix, 0, w, 0, 0, w, h);

        return (bitmap);
    }

    private static Bitmap getViewCacheWithMaxSize(View rootView, int maxWidth, int maxHeight) throws OutOfMemoryError {
        Rect rect = new Rect();

        rootView.getWindowVisibleDisplayFrame(rect);
        if (rootView.getWidth() == 0 || rootView.getHeight() == 0) {
            rootView.measure(
                    View.MeasureSpec.makeMeasureSpec(rect.width(), View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(rect.height(), View.MeasureSpec.EXACTLY)
            );
            rootView.layout(0, 0, rootView.getMeasuredWidth(),
                    rootView.getMeasuredHeight());
        }
        float w = rootView.getWidth(), h = rootView.getHeight();
        if (w <= 0 || h <= 0) {
            return null;
        }

        float minScale = Math.min(maxWidth / w, maxHeight / h);
        int bitmapWidth = (int) (w * minScale), bitmapHeight = (int) (h * minScale);
        if (S_DRAW_BITMAP == null) {
            S_DRAW_BITMAP = Bitmap.createBitmap(
                    bitmapWidth, bitmapHeight, Bitmap.Config.RGB_565);
        } else if (S_DRAW_BITMAP.getWidth() != bitmapWidth
                || S_DRAW_BITMAP.getHeight() != bitmapHeight) {
            S_DRAW_BITMAP.recycle();
            S_DRAW_BITMAP = Bitmap.createBitmap(
                    bitmapWidth, bitmapHeight, Bitmap.Config.RGB_565);
        }

        Canvas canvas = new Canvas();
        canvas.setBitmap(S_DRAW_BITMAP);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        // 设置缩放
        canvas.scale(minScale, minScale);
        rootView.draw(canvas);

        return S_DRAW_BITMAP;
    }


    public static Bitmap getTransparentBitmap(Bitmap sourceImg, int number) {
        int[] argb = new int[sourceImg.getWidth() * sourceImg.getHeight()];

        sourceImg.getPixels(argb, 0, sourceImg.getWidth(), 0, 0, sourceImg

                .getWidth(), sourceImg.getHeight());// 获得图片的ARGB值

        number = number * 255 / 100;

        for (int i = 0; i < argb.length; i++) {

            argb[i] = (number << 24) | (argb[i] & 0x00FFFFFF);

        }

        sourceImg = Bitmap.createBitmap(argb, sourceImg.getWidth(), sourceImg

                .getHeight(), Bitmap.Config.ARGB_8888);

        return sourceImg;
    }


}
