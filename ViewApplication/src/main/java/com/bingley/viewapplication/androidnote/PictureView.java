package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.bingley.viewapplication.R;


/**
 * @author bingley
 * @date 2019/3/22.
 */

public class PictureView extends BaseView {

    private final Bitmap mBitmap;

    public PictureView(Context context) {
        super(context);

        mBitmap = getBitmap(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //
        canvas.drawBitmap(mBitmap, new Matrix(), mPaint);

        // 将画布坐标系移动到画布中央
        canvas.translate(mWidthsize / 2, mHeightsize / 2);
        // 指定图片绘制区域(左上角的四分之一)
        Rect src = new Rect(0, 0, mBitmap.getWidth() / 2, mBitmap.getHeight() / 2);
        Rect des = new Rect(0, 0, 200, 400);
        canvas.drawBitmap(mBitmap, src, des, mPaint);
    }

    /**
     * 获取图片
     *
     * @param context 上下文
     */
    private Bitmap getBitmap(Context context) {
        Bitmap bitmap = null;

        // 资源文件(drawable/mipmap/raw):
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_background);

        // 资源文件(assets):
        /*try {
            InputStream is = context.getAssets().open("bitmap.png");
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 内存卡文件:
        // bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");


        // 此处省略了获取网络输入流的代码
       /* bitmap = BitmapFactory.decodeStream(null);
        is.close();*/

        return bitmap;

    }


}
