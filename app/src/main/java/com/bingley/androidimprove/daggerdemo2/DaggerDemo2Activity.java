package com.bingley.androidimprove.daggerdemo2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bingley.androidimprove.R;

/**
 * @author bingley
 * @date 2019/8/20.
 */
public class DaggerDemo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_dagger2);


        //ZhaiNan waimai = DaggerPlatform.builder().build().waimai();
    }
}
