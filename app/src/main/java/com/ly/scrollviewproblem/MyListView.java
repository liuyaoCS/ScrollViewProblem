package com.ly.scrollviewproblem;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/12/2 0002.
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean ret=super.onInterceptTouchEvent(ev);
        Log.i("ly","MyListView onInterceptTouchEvent->"+ret);
        return ret;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        boolean ret= super.onTouchEvent(ev);
        Log.i("ly","MyListView onTouchEvent->"+ret);
        return ret;
    }
}
