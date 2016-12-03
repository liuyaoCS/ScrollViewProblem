package com.ly.scrollviewproblem;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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

    float lastDownY=0;
    public int getState() {
        int scrollY=0;
        View child=this.getChildAt(0);
        if(child!=null){
            scrollY=child.getTop();
        }else{
            scrollY=0;
        }
        return scrollY==0?ViewState.STATE_HEAD:ViewState.STATE_NOT_HEAD;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                lastDownY=ev.getY();
                Log.i("ly","list touchevent down");
                break;
            case MotionEvent.ACTION_MOVE:
                if(ViewMedium.getInstance().getScrollIsMaxScroll() && (getState()==ViewState.STATE_NOT_HEAD || ev.getY()<lastDownY)){
                    //等同于getParent().requestDisallowInterceptTouchEvent(true);
                    ViewMedium.getInstance().setIsDisableParentIntercept(true);
                    Log.i("ly","list touchevent move list do");
                }else{
                    //等同于getParent().requestDisallowInterceptTouchEvent(false);
                    //但是如果是用getParent这种方式，这里就不用写了，因为默认只对一个down事件有效。
                    //                             scroll里的onInterceptTouchEvent也不用写了，更简洁。
                    ViewMedium.getInstance().setIsDisableParentIntercept(false);
                    Log.i("ly","list touchevent move parent do");
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.i("ly","list touchevent up");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("ly","list touchevent cancel");
                break;
        }
        boolean ret=super.onTouchEvent(ev);
        Log.i("ly","list touchevent ret="+ret);
        return ret;
    }


}
