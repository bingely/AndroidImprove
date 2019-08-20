package com.bingley.androidimprove.daggerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bingley.androidimprove.R;

import javax.inject.Inject;

/**
 * https://www.jianshu.com/p/626b2087e2b1
 * @author bingley
 * @date 2019/8/20.
 */
public class LoginActivity extends AppCompatActivity implements ICommonView{
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);


        DaggerCommonComponent.builder()
               .commonModule(new CommonModule(this))
                .build()
                .inject(this);



        findViewById(R.id.bt_login)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.login(new User());
                    }
                });

    }

    @Override
    public Context getContext() {
        return this;
    }
}
