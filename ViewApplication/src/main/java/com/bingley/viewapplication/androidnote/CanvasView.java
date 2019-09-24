package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;

/**
 * @author bingley
 * @date 2019/3/22.
 */

public class CanvasView extends BaseView {

    public CanvasView(Context context) {
        super(context);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /************⑴位移(translate)**********/
        // 请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动,每次移动是可以叠加的
        /*canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);


        mPaint.setColor(Color.BLUE);
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, mPaint);*/


        /***************⑵缩放(scale)**************************/
        canvas.translate(mWidthsize / 2, mHeightsize / 2);
     /*   Rect rect = new Rect(0, -mWidthsize / 2, mWidthsize / 2, 0);
        canvas.drawRect(rect, mPaint);

        //当缩放比例为负数的时候会根据缩放中心轴进行翻转
       // canvas.scale(0.5f, 0.5f);
        canvas.scale(0.3f, 0.3f, 20, 0);
        mPaint.setColor(Color.RED);
        canvas.drawRect(rect, mPaint);*/

       /* Rect rect = new Rect(-mWidthsize / 3, -mWidthsize / 3, mWidthsize / 3, mWidthsize / 3);
        for (int i = 0; i <= 20; i++) {
            canvas.scale(0.9f, 0.9f);
            canvas.drawRect(rect,mPaint);
        }
        */

        /*******************旋转(rotate)*******************/
        RectF rectF = new RectF(0, -400, 400, 0);
        canvas.drawRect(rectF, mPaint);
       // canvas.rotate(180);
        canvas.rotate(180, 200, 0);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF, mPaint);

        /*canvas.drawCircle(0, 0, mWidthsize / 2, mPaint);
        canvas.drawCircle(0, 0, mWidthsize / 2 - 20, mPaint);
        for (int i = 0; i <= 360; i += 10) {
            canvas.drawLine(0, mWidthsize / 2 - 20, 0, mWidthsize / 2, mPaint);
            canvas.rotate(10);
        }*/


        /**********************⑷错切(skew)*************************/

    }
}
