package com.bingley.dbapplicaion;

import android.app.Application;
import android.content.Context;

/**
 * @author bingley
 * @date 2019/9/16.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    static Context _context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        _context = getApplicationContext();
    }

    public static synchronized MyApplication context() {
        return (MyApplication) _context;
    }
    /**
     * 获得当前app运行的AppContext
     *
     * @return AppContext
     */
    public static MyApplication getInstance() {
        return instance;
    }

}
