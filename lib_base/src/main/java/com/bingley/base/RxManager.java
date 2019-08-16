package com.bingley.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author bingley
 * @date 2019/8/16.
 */
public class RxManager {

    /**
     * 或存在多个Disposable
     */
    private CompositeDisposable compositeDisposable;


    public static CompositeDisposable create() {
       return new CompositeDisposable();
    }

    /**
     * 取消订阅
     */
    public static void dispose(CompositeDisposable compositeDisposable) {
        if (compositeDisposable != null) compositeDisposable.dispose();
    }
}
