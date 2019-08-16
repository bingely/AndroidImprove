package com.bingley.androidimprove;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


/**
 * @author bingley
 * @date 2019/8/16.
 */
public class AppContext extends Application {
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();



        if (LeakCanary.isInAnalyzerProcess(this)) {//1
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

       // refWatcher= setupLeakCanary();
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        AppContext leakApplication = (AppContext) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
