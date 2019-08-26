package com.bingley.androidimprove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;

/**
 * @author bingley
 * @date 2019/8/22.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutId());

        iniWight();

    }

    protected abstract void iniWight();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = AppContext.getRefWatcher(this);
        refWatcher.watch(this);
    }

    protected abstract int setLayoutId();


}
