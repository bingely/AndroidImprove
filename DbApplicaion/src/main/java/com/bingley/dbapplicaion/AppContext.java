package com.bingley.dbapplicaion;

import android.app.Application;
import android.content.Context;

import com.bingley.dbapplicaion.dbgreen.DbUtil;
import com.bingley.dbapplicaion.dborigin.DBHelper;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @author bingley
 * @date 2019/9/16.
 */
public class AppContext extends Application {
    private static AppContext instance;
    static Context _context;
    private static DbUtil mDbUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        _context = getApplicationContext();


        // 初始化数据库

        // greendao
        mDbUtil = DbUtil.getInstance(this);
       // dbflow
        FlowManager.init(this);

        DBHelper instance = DBHelper.getInstance();

    }

    public static synchronized AppContext context() {
        return (AppContext) _context;
    }
    /**
     * 获得当前app运行的AppContext
     *
     * @return AppContext
     */
    public static AppContext getInstance() {
        return instance;
    }

    public static DbUtil getDbUtil() {
        return mDbUtil;
    }
}
