package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 基础图形操作
 * @author bingley
 * @date 2019/3/21.
 */

class ShapeView extends BaseView {
    public ShapeView(Context context) {
        super(context);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        /**点*******/
        canvas.drawPoint(200, 200, mPaint);
        //绘制一组点，坐标位置由float数组指定
        canvas.drawPoints(new float[]{
                500, 50,
                500, 60,
                500, 70
        }, mPaint);


        /*******line*****/
        canvas.drawLine(0, 0, 100, 200, mPaint);
        canvas.drawLines(new float[]{
                100, 200, 100, 0,
        }, mPaint);


        /********矩形*****/
        canvas.drawRect(300, 300, 400, 400, mPaint);

        RectF rect = new RectF(500, 300, 600, 400);
        canvas.drawRoundRect(rect, 20,20,mPaint);


    }


}
