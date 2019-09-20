package com.bingley.base;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



/**
 * Author:  Mr.bingley
 * Version:
 * Date:  2019/6/12
 */

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner {


    protected Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;


        if (initBundle(getIntent().getExtras())) {
            setContentView(getContentView());


            //将activity加入到AppManager堆栈中
            AppManager.getAppManager().addActivity(this);

            // ButterKnife.bind(this);

            initWidget();
            initListerner();
            //初始化沉浸式
            initImmersionBar();
            initData();

        } else {
            finish();
        }
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {

    }

    // 可以直接替代 bind
    protected <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }




    protected void initListerner() {
    }


    protected abstract int getContentView();

    protected boolean initBundle(Bundle bundle) {
        return true;
    }

    protected void initWidget() {
    }

    protected void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);

    }


    protected void replaceFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
            transaction.replace(frameLayoutId, fragment);
            // commit方法是在Activity的onSaveInstanceState()之后调用的，这样会出错
            transaction.commitAllowingStateLoss();
        }

    }


}
