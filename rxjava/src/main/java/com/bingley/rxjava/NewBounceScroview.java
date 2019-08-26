package com.bingley.rxjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * @author bingley
 * @date 2019/8/21.
 */
public class NewBounceScroview extends NestedScrollView {
    public NewBounceScroview(@NonNull Context context) {
        super(context);
    }

    public NewBounceScroview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NewBounceScroview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
