package com.bingley.viewapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;


/**
 * @author bingley
 * @date 2019/9/24.
 * 可以展开的LinearLayout  https://github.com/chaychan/ExpandableLinearLayout/blob/master/library/src/main/java/com/chaychan/library/ExpandableLinearLayout.java
 */
public class ExpandableLinearLayout extends LinearLayout {
    public ExpandableLinearLayout(Context context) {
        this(context, null);
    }

    public ExpandableLinearLayout(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableLinearLayout(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ExpandableLinearLayout);
        ta.getInt(R.styleable.ExpandableLinearLayout_defaultItemCount, 2);

        ta.recycle();

        setOrientation(VERTICAL);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        findViews();
    }

    private void findViews() {
        /*bottomView = View.inflate(getContext(), R.layout.item_ell_bottom, null);
        ivArrow = (ImageView) bottomView.findViewById(R.id.iv_arrow);

        tvTip = (TextView) bottomView.findViewById(R.id.tv_tip);
        tvTip.getPaint().setTextSize(fontSize);
        tvTip.setTextColor(textColor);
        ivArrow.setImageResource(arrowResId);

        bottomView.setOnClickListener(this);*/
    }
}
