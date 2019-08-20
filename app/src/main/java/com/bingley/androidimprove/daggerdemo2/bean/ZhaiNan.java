package com.bingley.androidimprove.daggerdemo2.bean;

import javax.inject.Inject;

/**
 * @author bingley
 * @date 2019/8/20.
 */
public class ZhaiNan {
    @Inject
    Baozi baozi;

    @Inject
    Noodle noodle;

    @Inject
    public ZhaiNan() {

    }

    public String eat() {
        StringBuilder sb = new StringBuilder();
        sb.append("我吃的是 ");
        if ( baozi != null ) {
            sb.append(baozi.toString());
        }

        if (noodle != null) {
            sb.append("  ");
            sb.append(noodle.toString());
        }
        return sb.toString();
    }

}
