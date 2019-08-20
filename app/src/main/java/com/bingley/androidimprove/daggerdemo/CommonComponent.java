package com.bingley.androidimprove.daggerdemo;

import dagger.Component;

/**
 * @author bingley
 * @date 2019/8/20.
 */
@ActivityScope
@Component(modules = CommonModule.class)
public interface CommonComponent {
    void inject(LoginActivity activity);
}
