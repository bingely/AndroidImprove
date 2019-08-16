package com.bingley.androidimprove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author bingley
 * @date 2019/8/16.
 */
public class TestLeakCarnaryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_leakcarnary);


        TestManager manager = TestManager.getInstance(this);

    }


}
