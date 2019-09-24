package com.bingley.viewapplication.androidnote.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;

import com.bingley.viewapplication.R;
import com.bingley.viewapplication.androidnote.BaseView;


/**
 * @author bingley
 * @date 2019/3/25.
 */

public class MatrixSetPolyToPolyTest extends BaseView {

    private Bitmap mBitmap;
    private Matrix mPolyMatrix;

    public MatrixSetPolyToPolyTest(Context context) {
        super(context);

        initBitmapAndMatrix();
    }

    private void initBitmapAndMatrix() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.t_declare_addimg);

        mPolyMatrix = new Matrix();


        float[] src = {
        };

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(50f);

//        Matrix matrix = new Matrix();
     //   matrix.postScale(2, 2);
//        canvas.save();
 //       canvas.setMatrix(matrix);
//        canvas.concat(matrix);
        canvas.drawRect(100, 100, 300, 300, mPaint);
//        canvas.restore();
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(300, 300, 500, 500, mPaint);
        canvas.drawText("canvas.setMatrix(matrix)", 50, 600, mPaint);

    }
}
