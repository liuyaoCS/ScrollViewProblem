package com.ly.scrollviewproblem;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/12/2 0002.
 */

public class MyScrollView extends ScrollView {
    private boolean isIntercepted=false;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setIntercept(boolean flag){
        isIntercepted=flag;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if(isIntercepted){
            Log.i("ly","MyScrollView onInterceptTouchEvent->"+isIntercepted);
            return true;
        }
        boolean ret=super.onInterceptTouchEvent(ev);
        Log.i("ly","MyScrollView onInterceptTouchEvent->"+ret);
        return ret;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("ly","MyScrollView onTouchEvent->");
        return super.onTouchEvent(ev);
    }
}
