package com.example.hannahkim.movieharmony;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hannahkim on 2018-06-06.
 */

public class BaseActivity extends AppCompatActivity{

    private static Typeface mTypeface = null;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        if (mTypeface == null) {
            mTypeface = Typeface.createFromAsset(this.getAssets(), "font/font_3.ttf");
            // 외부폰트 사용
            //mTypeface = Typeface.MONOSPACE;
        }
        //setGlobalFont(getWindow().getDecorView());

        // 또는
        View view = findViewById(android.R.id.content);
        setGlobalFont(view);
    }

    private void setGlobalFont(View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                int vgCnt = vg.getChildCount();
                for (int i = 0; i < vgCnt; i++) {
                    View v = vg.getChildAt(i);
                    if (v instanceof TextView) {
                        ((TextView) v).setTypeface(mTypeface);
                    }
                    setGlobalFont(v);
                }
            }
        }
    }
}