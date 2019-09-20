package com.bingley.dbapplicaion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bingley.dbapplicaion.ui.TestDbFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(R.id.ll_container, new TestDbFragment());

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
