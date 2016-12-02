package com.ly.scrollviewproblem;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/12/2 0002.
 */

public class MyRelativeLayout extends RelativeLayout{
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean ret=super.onInterceptTouchEvent(ev);
        Log.i("ly","MyRelativeLayout onInterceptTouchEvent->"+ret);
        return ret;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("ly","MyRelativeLayout onTouchEvent->");
        return super.onTouchEvent(event);
    }
}
