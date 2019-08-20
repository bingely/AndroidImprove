package com.bingley.androidimprove.daggerdemo2;

import com.bingley.androidimprove.daggerdemo2.bean.ZhaiNan;

import dagger.Component;

/**
 * @author bingley
 * @date 2019/8/20.
 */
@Component()
public interface Platform {
    ZhaiNan waimai();
}
