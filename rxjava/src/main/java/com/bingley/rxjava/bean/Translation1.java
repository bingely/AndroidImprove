package com.bingley.rxjava.bean;

import android.util.Log;

/**
 * @author bingley
 * @date 2019/8/16.
 */
public class Translation1 {
    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public String show() {
        Log.d("RxJava", content.out );
        return content.out;
    }
}
