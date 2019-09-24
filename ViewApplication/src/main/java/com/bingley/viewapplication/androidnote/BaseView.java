package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * @author bingley
 * @date 2019/3/21.
 */

public class BaseView extends View{

    /**
     *
     * 标题	相关方法	备注
     色彩	setColor setARGB setAlpha	设置颜色，透明度
     大小	setTextSize	设置文本字体大小
     字体	setTypeface	设置或清除字体样式
     样式	setStyle	填充(FILL),描边(STROKE),填充加描边(FILL_AND_STROKE)
     对齐	setTextAlign	左对齐(LEFT),居中对齐(CENTER),右对齐(RIGHT)
     测量	measureText	测量文本大小(注意，请在设置完文本各项参数后调用)
     *
     */
    protected Paint mPaint;

    protected Context mContext;


    protected int mWidthsize;
    protected int mHeightsize;

    public BaseView(Context context) {
        super(context);
        mContext = context;
        initPath();

    }

    /**
     * 测量View大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //取出宽度的确切数值
        mWidthsize = MeasureSpec.getSize(widthMeasureSpec);
        //取出宽度的测量模式
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);

        //取出高度的确切数值
        mHeightsize = MeasureSpec.getSize(heightMeasureSpec);
        //取出高度的测量模式
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);

        // 此处为啥会调用两次
        Log.e("onMeasure-w和h", mWidthsize + "----" + mHeightsize);

    }

    /**
     * View大小确定
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidthsize = w;
        mHeightsize = h;

        // 这个回调一次
        Log.e("onSizeChanged--w:h", mWidthsize + "----" + mHeightsize);
    }

    private void initPath() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4f);

    }
}
