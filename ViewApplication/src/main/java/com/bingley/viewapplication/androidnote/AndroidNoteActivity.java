package com.bingley.viewapplication.androidnote;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.bingley.viewapplication.androidnote.example.MatrixSetPolyToPolyTest;

import androidx.annotation.Nullable;

/**
 * @author bingley
 * @date 2019/3/21.
 */

public class AndroidNoteActivity extends Activity{

    Context mContext;
    View mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = AndroidNoteActivity.this;

        // 自定义布局映射到activity
        getView();
        setContentView(mView);
    }

    private void getView() {
       // mView = new DemoView(mContext);
        //mView = new CanvasView(mContext);
      //  mView = new PathView(mContext);
     //   mView = new TextDrawView(mContext);
      //  mView = new PictureView(mContext);
      //  mView = new CanvasView(mContext);
        mView = new MatrixSetPolyToPolyTest(mContext);
    }
}
