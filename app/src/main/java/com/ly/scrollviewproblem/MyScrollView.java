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

    private float range;
    private boolean isDisableIntercept=false;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setRange(float range){
        Log.i("ly","max Range->"+range);
        this.range=range;
    }
    public boolean isMaxScroll(){
        return getScrollY()>=range;
    }

    public void setIsDisableIntercept(boolean flag){
        isDisableIntercept=flag;

    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("ly","MyScrollView onTouchEvent-> action"+ev.getAction());
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if(!isDisableIntercept){
            //list没有请求disableIntercept的话，要走默认流程，不能直接返回true！！！
            return super.onInterceptTouchEvent(ev);
        }else{
            return false;
        }
    }
}
