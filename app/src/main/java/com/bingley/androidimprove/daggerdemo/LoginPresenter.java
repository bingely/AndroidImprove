package com.bingley.androidimprove.daggerdemo;

import android.content.Context;
import android.widget.Toast;


import javax.inject.Inject;

/**
 * @author bingley
 * @date 2019/8/20.
 */
public class LoginPresenter {

    ICommonView iView;

    @Inject
    public LoginPresenter(ICommonView iView){

        this.iView = iView;
    }

    public void login(User user){

        Context mContext = iView.getContext();
        Toast.makeText(mContext,"login......",Toast.LENGTH_SHORT).show();
    }
}
