package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * @author bingley
 * @date 2019/3/21.
 */

class PathView extends BaseView {


    public PathView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidthsize / 2, mHeightsize / 2);

        Path path = new Path();

        /*************************************/
        /*
        path.lineTo(200, 200);
     //   path.moveTo(200, 100);
        path.setLastPoint(200, 100);
        path.lineTo(200, 0);
        path.close();
        */

        /*
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        path.setLastPoint(-300, 300);
        */

        /*************************************/
        // 翻转y轴坐标
     //   canvas.scale(1, -1);

        /**
        Path srcPath = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        srcPath.addCircle(0, 0, 100, Path.Direction.CW);
        path.addPath(srcPath, 0, 200);
        mPaint.setColor(Color.BLACK);

         **/

        /**************************************/

        //
        path.lineTo(100, 100);

        RectF oval = new RectF(0, 0, 300, 300);

        path.arcTo(oval, 0, 270);



        canvas.drawPath(path, mPaint);
    }
}
