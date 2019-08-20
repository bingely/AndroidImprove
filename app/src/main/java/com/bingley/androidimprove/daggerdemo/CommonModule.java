package com.bingley.androidimprove.daggerdemo;

import dagger.Module;
import dagger.Provides;

/**
 * @author bingley
 * @date 2019/8/20.
 */
@Module
public class CommonModule {
    private ICommonView iView;
    public CommonModule(ICommonView iView){
        this.iView = iView;
    }


    @Provides
    @ActivityScope
    public ICommonView provideIcommonView(){
        return this.iView;
    }
}
