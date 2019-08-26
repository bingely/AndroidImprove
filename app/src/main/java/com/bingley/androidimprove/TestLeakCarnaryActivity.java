package com.bingley.androidimprove;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

/**
 * @author bingley
 * @date 2019/8/16.
 */
public class TestLeakCarnaryActivity extends BaseActivity {


    @Override
    protected void iniWight() {
        TestManager manager = TestManager.getInstance(this);

        startAsyncTask();
    }

    void startAsyncTask() {

        // This async task is an anonymous class and therefore has a hidden reference to the outer
        // class MainActivity. If the activity gets destroyed before the task finishes (e.g. rotation),
        // the activity instance will leak.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // Do some slow work in background
                SystemClock.sleep(200000);
                return null;
            }
        }.execute();
        Toast.makeText(this, "请关闭这个A完成泄露", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.act_leakcarnary;
    }


}
