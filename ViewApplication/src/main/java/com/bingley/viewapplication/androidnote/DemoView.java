package com.bingley.viewapplication.androidnote;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author bingley
 * @date 2019/3/21.
 */

class DemoView extends View {

    private int mWidthsize;
    private int mHeightsize;
    protected Context mContext;

    /*View初始化
    */
    /**
     * 在代码中会用到
     * @param context
     */
    public DemoView(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * 在layout布局中会用到
     * @param context
     * @param attrs
     */
    public DemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


    }

    public DemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

        Log.e("onSizeChanged--w:h", mWidthsize + "----" + mHeightsize);
    }



    /**
     * 确定子View布局(自定义View包含子View时有用)
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 实际绘制内容
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    /**
     * 提供对外暴露的接口，用于控制View的状态等，或者监听View的变化.
     */
    public interface IDemoLinster{
        void demoMethod1();
        void demoMethod2();
    }
}
