package com.bingley.base.log;

import android.util.Log;

/**
 * 日志util
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/12
 */

/**
 * how to use?
 * 应该先在application中设置相关属性
 * private final static String TAGBean = "NewsJsonUtils";
 * LogUtil.d(TAGBean, url);
 */

public class LogUtil {
    public static boolean DEBUG = true;
    private static String TAG= "niaoyun";

    public static void v(String message) {
        if (DEBUG) {
            Log.v(TAG, message);
        }
    }

    public static void d( String message) {
        if (DEBUG) {
            Log.d(TAG, message);
        }
    }

    public static void i(String message) {
        if (DEBUG) {
            Log.i(TAG, message);
        }
    }

    public static void w(String message) {
        if (DEBUG) {
            Log.w(TAG, message);
        }
    }

    public static void e(String message) {
        if (DEBUG) {
            LogFormatUtil.printJson(TAG,message,"");
        }
    }

    public static void e(String tag, String message) {
        if (DEBUG) {
            //Log.e(tag, message);
            //
            LogFormatUtil.printJson(tag,message,"");
        }
    }

    public static void e( String message, Exception e) {
        if (DEBUG) {
            Log.e(TAG, message, e);
        }
    }



}
