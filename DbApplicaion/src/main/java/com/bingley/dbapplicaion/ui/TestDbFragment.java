package com.bingley.dbapplicaion.ui;

import android.view.View;

import com.bingley.base.BaseFragment;
import com.bingley.dbapplicaion.R;
import com.bingley.dbapplicaion.TestDb;

/**
 * @author bingley
 * @date 2019/9/20.
 */
public class TestDbFragment extends BaseFragment {




    @Override
    protected int getLayoutId() {
        return R.layout.frg_test;
    }


    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        TestDb.initDb();

        root.findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // TestDb.searchAction();

                //TestDb.testRoom(mContext);
                TestDb.testDbFlowSearch();
            }
        });


        root.findViewById(R.id.delte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               TestDb.delteAction();
            }
        });
        root.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TestDb.addAction();


                TestDb.testDbFlowAdd();
            }
        });
    }
}
