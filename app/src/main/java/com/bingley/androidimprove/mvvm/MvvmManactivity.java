package com.bingley.androidimprove.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bingley.androidimprove.R;
import com.bingley.androidimprove.databinding.ActMvvmBinding;

/**
 * @author bingley
 * @date 2019/8/26.
 */
public class MvvmManactivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这个类的生成是有规则的，它是根据对应的布局文件的名字生成的
        ActMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.act_mvvm);
        UserBean userBean = new UserBean ("张三", 25);
        binding.setUserinfo(userBean);
    }
}
