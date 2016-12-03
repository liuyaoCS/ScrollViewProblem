package com.ly.scrollviewproblem;

/**
 * Created by Administrator on 2016/12/3 0003.
 */

public class ViewMedium {
    private static ViewMedium instance;
    private ViewMedium(){}
    public static ViewMedium getInstance(){
        if(instance==null){
            instance=new ViewMedium();
        }
        return instance;
    }
    private MyListView mList;
    private MyScrollView mScroll;
    public void registerList(MyListView list){
        mList=list;
    }
    public void registerScroll(MyScrollView scroll){
        mScroll=scroll;
    }
    public void setIsDisableParentIntercept(boolean flag){
        mScroll.setIsDisableIntercept(flag);
    }
    public int getListState(){
        return mList.getState();
    }
    public boolean getScrollIsMaxScroll(){
        return  mScroll.isMaxScroll();
    }


}
