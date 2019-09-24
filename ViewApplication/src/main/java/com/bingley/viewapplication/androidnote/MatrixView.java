package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;

/**
 * @author bingley
 * @date 2019/3/22.
 */

public class MatrixView extends BaseView {

    public static final String TAG = "MatrixView";


    public MatrixView(Context context) {
        super(context);

        init();
    }

    private void init() {
        float[] pts = new float[]{0, 0, 80, 100, 400, 300};

        Matrix matrix = new Matrix();
        // matrix.setScale(0.5f, 1f);


        Matrix invert = new Matrix();
        invert.setTranslate(200, 500);

        Log.e(TAG, "before--- matrix" + matrix.toShortString());


        // invert
        Boolean result = matrix.invert(invert);

        Log.e(TAG, "after --- matrix" + result);


        // isAffine
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.e(TAG, "is--isAffine" + matrix.isAffine());
        }



    }


}
