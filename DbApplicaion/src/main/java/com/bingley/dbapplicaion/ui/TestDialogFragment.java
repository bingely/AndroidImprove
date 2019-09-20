package com.bingley.dbapplicaion.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;

import com.bingley.base.BaseFragment;
import com.bingley.dbapplicaion.R;
import com.kongzue.dialog.interfaces.OnInputDialogButtonClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.util.InputInfo;
import com.kongzue.dialog.util.TextInfo;
import com.kongzue.dialog.v3.InputDialog;

/**
 * @author bingley
 * @date 2019/9/20.
 */
public class TestDialogFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.frg_dialog;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        root.findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                InputDialog.show((AppCompatActivity) getActivity(), "提示", "请输入密码（123456）", "确定", "取消")
                        .setOnOkButtonClickListener(new OnInputDialogButtonClickListener() {
                            @Override
                            public boolean onClick(BaseDialog baseDialog, View v, String inputStr) {
                                if (inputStr.equals("123456")) {
                                    return false;
                                } else {
                                    return true;
                                }
                            }
                        })
                        .setHintText("请输入密码")
                        .setInputInfo(new InputInfo()
                                .setMAX_LENGTH(6)
                                .setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
                                .setTextInfo(new TextInfo()
                                        .setFontColor(Color.RED)
                                )
                        )
                        .setCancelable(false)
                ;

            }
        });
    }
}
