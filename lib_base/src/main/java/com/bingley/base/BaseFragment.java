package com.bingley.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Fragment基础类
 */

public abstract class BaseFragment extends Fragment {
    protected View mRoot;
    protected Bundle mBundle;

    protected Toolbar toolbar;

    protected Context mContext;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        } else {
            mBundle = getArguments();
            if (mBundle != null) {
                initBundle(mBundle);
            }
            mContext = getActivity();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRoot != null) {
            ViewGroup parent = (ViewGroup) mRoot.getParent();
            if (parent != null)
                parent.removeView(mRoot);
        } else {
            mRoot = inflater.inflate(getLayoutId(), container, false);
            // toolbar = mRoot.findViewById(R.id.toolbar);
           // toolbar = mRoot.findViewById(R.id.toolbar);
            // statusBarView = mRoot.findViewById(R.id.status_bar_view);
            //fitsLayoutOverlap();
            // Bind view
            //ButterKnife.bind(this, mRoot);

            // Get savedInstanceState

            // Init
            initWidget(mRoot);
            initListerner();
            initData();

        }
        return mRoot;
    }


    protected void initListerner() {
    }




    protected abstract int getLayoutId();

    protected void initBundle(Bundle bundle) {

    }

    protected void initWidget(View root) {

    }

    protected void initData() {

    }


    protected void replaceFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(frameLayoutId, fragment);
            transaction.commitAllowingStateLoss();
        }
    }

}
