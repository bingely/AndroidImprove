package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author bingley
 * @date 2019/3/22.
 */

public class TextDrawView extends BaseView {


    public TextDrawView(Context context) {
        super(context);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = "ABCDEFGHIJKLMN";
        char[] strArray = str.toCharArray();


        // 参数分别为 (文本 基线x 基线y 画笔)
        canvas.drawText(str, 200, 300, mPaint);
        // [1,3)
        canvas.drawText(str, 1, 3, 200, 400, mPaint);
        // [1,3]字符数组表示的含义是不同的 对于字符数组char[]我们截取字符串使用起始位置(index)和长度(count)来确定。
        canvas.drawText(strArray, 1, 3, 200, 500, mPaint);


        String posStr = "ABC";
        canvas.drawPosText(posStr, new float[]{
                200, 600,
                300, 700,
                400, 800
        }, mPaint);


    }


}
