package haibao.com.utilscollection.op;

/**
 * head.haibai.com.concatteamheadview.uitls
 * <p>
 * ${CLASS_NAME}
 *
 * @author Administrator
 * @date 2017/5/2.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.NonNull;

import com.socks.library.KLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class TeamViewUtils {

    String TAG = "TeamView";
    //生成图片后，需要的uuid
    String uuid;
    private int mWidth = 600;
    private int mHeight = 600;
    private Paint mPaint;
    private int requestWidth = 300;
    private int requestHeight = 300;
    private int num = 2;

    private Paint mBitmapPaint;
    private float borderWidth = 0f;
    private float LineborderWidth = 10f;

    private Matrix transMatrix;
    private ArrayList<BitmapShader> mBitmapShaders;
    private ArrayList<Bitmap> mBitmaps;


    public TeamViewUtils() {

        //用於變換的matrix
        transMatrix = new Matrix();

        mPaint = new Paint();
        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setFlags(Paint.FILTER_BITMAP_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(borderWidth);


        mBitmaps = new ArrayList<>();
        mBitmapShaders = new ArrayList<>();
        num = mBitmaps.size();
    }


    public Bitmap getBitmap(int requestWidth, int requestHeight) {
        mWidth = requestWidth;
        mHeight = requestHeight;
        Bitmap output = Bitmap.createBitmap(mWidth,
                mHeight, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(output);

        KLog.i(TAG, "width==" + mWidth);
        KLog.i(TAG, "height==" + mHeight);

        for (int i = 0; i < mBitmaps.size(); i++) {
            canvas.save();
            drawClipBitmap(canvas, i);
            canvas.restore();
        }


        if (mBitmaps.size() == 3) {
            drawHorizontalHalfLine(canvas, mWidth, mHeight, true);
        } else if (mBitmaps.size() == 4) {
            drawHorizontalHalfLine(canvas, mWidth, mHeight, false);
        }
        drawLine(canvas);
        drawBorder(canvas);

        return output;
    }

    @NonNull
    private RectF drawClipBitmap(Canvas canvas, int index) {
        getCenterCropScaleType(index);
        clipRect(canvas, index);

        //需要
        BitmapShader bitmapShader = mBitmapShaders.get(index);
//            canvas.drawBitmap(mBmp1, matrix, mPaint);        //不知道為什麼只有使用這個方法才能將matrix应用到bitmap上
        bitmapShader.setLocalMatrix(transMatrix);
        // 设置shader
        mBitmapPaint.setShader(bitmapShader);

        RectF rectF = new RectF(0, 0, mWidth, mWidth);

        canvas.drawRoundRect(rectF, mWidth / 2, mWidth / 2,
                mBitmapPaint);
        return rectF;
    }

    private void clipRect(Canvas canvas, int index) {
        int left;
        int top;
        int right;
        int bottom;
        if (num == 2) {
            canvas.clipRect(mWidth / 2 * index, 0, mWidth / 2 * (index + 1), mHeight);
        } else if (num == 3) {
            if (index == 0) {
                canvas.clipRect(0, 0, mWidth / 2, mHeight);
            } else if (index == 1) {
                canvas.clipRect(mWidth / 2, 0, mWidth, mHeight / 2);
            } else if (index == 2) {
                canvas.clipRect(mWidth / 2, mHeight / 2, mWidth, mHeight);
            }
        } else if (num == 4) {
            if (index == 0) {
                canvas.clipRect(0, 0, mWidth / 2, mHeight / 2);
            } else if (index == 1) {
                canvas.clipRect(0, mHeight / 2, mWidth / 2, mHeight);
            } else if (index == 2) {
                canvas.clipRect(mWidth / 2, 0, mWidth, mHeight / 2);
            } else if (index == 3) {
                canvas.clipRect(mWidth / 2, mHeight / 2, mWidth, mHeight);
            }
        }
    }

    /**
     * 获取控件的高宽比
     * * @return scale
     */
    private void getCenterCropScaleType(int index) {
        Bitmap bitmap = mBitmaps.get(index);
        KLog.i(TAG, "index===" + index);
        //得到当前控件的高宽
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();


        KLog.i(TAG, "bitmap width===" + width);
        KLog.i(TAG, "bitmap height===" + height);

        //对图片进行scale放大.默认的方式是centerCrop。
        //设定是圆形。暂时不进行容错。
        float scale;
        //上下需要便宜的距离
        float[] offsetXY = {0f, 0f};
        scale = getScale(index, width, height, offsetXY);

        //2.这里还需要添加额外的位移。根据位置来确定
        offsetXY = addExternalOffsetByIndex(index, offsetXY[0], offsetXY[1]);


        KLog.i(TAG, "scale===" + scale);
        KLog.i(TAG, "offsetXY[0]===" + offsetXY[0]);
        KLog.i(TAG, "offsetXY[1]===" + offsetXY[1]);
        //3.得到目标的高宽
        transMatrix.setScale(scale, scale);
        transMatrix.postTranslate(Math.round(offsetXY[0]), Math.round(offsetXY[1]));
    }

    private float getScale(int index, int width, int height, float[] offsetXY) {
        float scale;//1.计算centerCrop本来的位移和scale
        int totalWidth = 0;
        int totalHeight = 0;

        if (num == 2) {
            totalWidth = mWidth;
            totalHeight = mHeight;
        } else if (num == 3) {
            if (index == 0) {
                totalWidth = mWidth;
                totalHeight = mHeight;
            } else {
                totalWidth = mWidth / 2;
                totalHeight = mHeight / 2;
            }
        } else if (num == 4) {
            totalWidth = mWidth / 2;
            totalHeight = mHeight / 2;
        }
        if (width * totalWidth > totalHeight * height) {
            scale = (float) totalHeight / (float) height;
            offsetXY[0] = (totalWidth - width * scale) * 0.5f;
        } else {
            scale = (float) totalWidth / (float) width;
            offsetXY[1] = (totalHeight - height * scale) * 0.5f;
        }


        KLog.i(TAG, "scale==" + scale);
        return scale;
    }

    //根据位置和图片的数量，进行一些额外的偏移计算
    private float[] addExternalOffsetByIndex(int index, float dx, float dy) {
        float[] offsetXY = new float[2];
        if (num == 2) {
            if (index == 0) {
                dx = dx - mWidth / 4f;
            } else {
                dx = dx + mWidth / 4f;
            }
        } else if (num == 3) {
            //第一个位置不需要添加，额外的变化。后面两个位置需要添加变化
            if (index == 0) {
                dx = dx - mWidth / 4f;
            } else if (index == 1) {
                dx = dx + mWidth / 2f;
//                dy = dy - mHeight / 3f;
            } else if (index == 2) {
                dx = dx + mWidth * 2 / 5f;
                dy = dy + mHeight * 3 / 5f;
            }

        } else if (num == 4) {
            if (index == 0) {
//                dx = dx ;
                dy = dy + mHeight * 1 / 6;
            } else if (index == 1) {
//                dx = dx - mWidth / 4;
                dy = dy + mHeight * 3 / 6;
            } else if (index == 2) {
                dx = dx + mWidth / 2;
                dy = dy + mHeight / 5;
            } else if (index == 3) {
                dx = dx + mWidth * 2 / 5;
                dy = dy + mHeight * 3 / 6;
            }

        }

        offsetXY[0] = dx;
        offsetXY[1] = dy;
        return offsetXY;
    }

    /**
     * 画横向的线
     *
     * @param canvas
     * @param measuredWidth
     * @param measuredHeight
     * @param isHalf
     */
    private void drawHorizontalHalfLine(Canvas canvas, int measuredWidth, int measuredHeight, boolean isHalf) {
        canvas.save();
        //画中线
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(LineborderWidth);
        canvas.drawLine(isHalf ? measuredWidth / 2 : 0, measuredHeight / 2 + LineborderWidth / 2, measuredWidth, measuredHeight / 2 + LineborderWidth / 2, mPaint);
        canvas.restore();

    }

    /**
     * 画竖向的线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        canvas.save();
        //画中线
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(LineborderWidth);
        canvas.drawLine(mWidth / 2 + LineborderWidth / 2, 0, mWidth / 2 + LineborderWidth / 2, mHeight, mPaint);
        canvas.restore();
    }


    /**
     * 绘制自定义控件边框
     *
     * @param canvas
     */
    private void drawBorder(Canvas canvas) {
        if (borderWidth > 0) {
            Paint paint = new Paint();
            paint.setStrokeWidth(borderWidth);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.WHITE);
            paint.setAntiAlias(true);
            // 根据控件类型的属性去绘制圆形或者矩形
            canvas.drawCircle(mWidth / 2, mHeight / 2, (mWidth - borderWidth) / 2 + 1, paint);
        }
    }

    public ArrayList<Bitmap> getBitmaps() {
        return mBitmaps;
    }

    public void setBitmaps(ArrayList<Bitmap> bitmaps) {
        mBitmaps.clear();
        for (int i = 0; i < bitmaps.size(); i++) {
            Bitmap bitmap = bitmaps.get(i);
            compressBitmap(bitmap);
        }
        num = mBitmaps.size();

    }

    private void compressBitmap(Bitmap bitmap) {
        KLog.i(TAG, "bitmap byteCount=" + bitmap.getByteCount());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 10, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        Bitmap smallBitmap = BitmapFactory.decodeStream(byteArrayInputStream, null, null);
        int byteCount = smallBitmap.getByteCount();
        KLog.i(TAG, "smallBitmap byteCount=" + byteCount);

    }

    public TeamViewUtils addBitmaps(InputStream inputStream) {
        if (mBitmaps.size() > 4) {
            return this;
        }

        Bitmap icon = BitmapFactory.decodeStream(inputStream);
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.outWidth = icon.getWidth();
        options1.outHeight = icon.getHeight();

//        BitmapFactory.decodeResource(context.getResources(), resId, options); // 读取图片长款
        options1.inSampleSize = calculateInSampleSize(options1, requestWidth,
                requestHeight); // 计算inSampleSize
        KLog.i(TAG, "options.inSampleSize==" + options1.inSampleSize);


//        Bitmap icon = BitmapFactory.decodeStream(inputStream, null, options); // 载入一个稍大的缩略图
        float scale = options1.outHeight / (float) options1.outWidth;
        Bitmap scaleBitmap = createScaleBitmap(icon, requestWidth, (int) (requestHeight * scale));// 进一步得到目标大小的缩略图

//        compressBitmap(scaleBitmap);
        KLog.i(TAG, "bitmap byteCount=" + scaleBitmap.getByteCount());
        mBitmaps.add(scaleBitmap);
        mBitmapShaders.add(new BitmapShader(scaleBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        num = mBitmaps.size();
        scaleBitmap.recycle();
        return this;
    }

    public TeamViewUtils addBitmaps(Context context, int resId) {
        if (mBitmaps.size() > 4) {
            return this;
        }
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resId, options); // 读取图片长款
        options.inSampleSize = calculateInSampleSize(options, requestWidth,
                300); // 计算inSampleSize
        KLog.i(TAG, "options.inSampleSize==" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), resId, options); // 载入一个稍大的缩略图
        float scale = options.outHeight / (float) options.outWidth;
        Bitmap scaleBitmap = createScaleBitmap(icon, requestWidth, (int) (requestHeight * scale));// 进一步得到目标大小的缩略图

//        compressBitmap(scaleBitmap);
        KLog.i(TAG, "bitmap byteCount=" + scaleBitmap.getByteCount());
        mBitmaps.add(scaleBitmap);
        mBitmapShaders.add(new BitmapShader(scaleBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        num = mBitmaps.size();
        scaleBitmap.recycle();

        return this;
    }

    public TeamViewUtils addBitmaps(Bitmap icon) {
        if (mBitmaps.size() > 4) {
            return this;
        }
        Bitmap copy = icon.copy(Bitmap.Config.RGB_565, false);
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.outWidth = copy.getWidth();
        options1.outHeight = copy.getHeight();

//        BitmapFactory.decodeResource(context.getResources(), resId, options); // 读取图片长款
        options1.inSampleSize = calculateInSampleSize(options1, requestWidth,
                requestHeight); // 计算inSampleSize
        KLog.i(TAG, "options.inSampleSize==" + options1.inSampleSize);


//        Bitmap icon = BitmapFactory.decodeStream(inputStream, null, options); // 载入一个稍大的缩略图
        float scale = options1.outHeight / (float) options1.outWidth;
        Bitmap scaleBitmap = createScaleBitmap(copy, requestWidth, (int) (requestHeight * scale));// 进一步得到目标大小的缩略图

//        compressBitmap(scaleBitmap);
        KLog.i(TAG, "bitmap byteCount=" + scaleBitmap.getByteCount());
        mBitmaps.add(scaleBitmap);
        mBitmapShaders.add(new BitmapShader(scaleBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        num = mBitmaps.size();
        scaleBitmap.recycle();

        return this;
    }

    private Bitmap createScaleBitmap(Bitmap src, int dstWidth,
                                     int dstHeight) {
        Bitmap dst = Bitmap.createScaledBitmap(src, dstWidth, dstHeight, false);
        if (src != dst) { // 如果没有缩放，那么不回收
            src.recycle(); // 释放Bitmap的native像素数组
        }
        return dst;
    }

    private int calculateInSampleSize(BitmapFactory.Options options,
                                      int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        KLog.i(TAG, "outHeight height==" + height);
        KLog.i(TAG, "outWidth width==" + width);
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public void recycle() {
        for (Bitmap bitmap : mBitmaps) {
            bitmap.recycle();
        }
        mBitmaps.clear();
        mBitmapShaders.clear();

        mBitmaps = null;
        mBitmapShaders = null;
    }

}
