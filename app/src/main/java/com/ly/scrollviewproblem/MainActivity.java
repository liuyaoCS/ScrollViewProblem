package com.ly.scrollviewproblem;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决scrollview listview嵌套问题
 * 1 scrollview fillviewport
 * 2 listview height
 * 3 listview onTouchEvent处理：requestDisallowInterceptTouchEvent
 */
public class MainActivity extends AppCompatActivity {
    MyListView list;
    MyScrollView scroll;
    RelativeLayout title;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> data=new ArrayList<>();
        data.add("w1");
        data.add("w2");
        data.add("w3");
        data.add("w4");
        data.add("w5");
        data.add("w6");
        data.add("w7");
        data.add("w8");
        data.add("w9");
        data.add("w10");
        data.add("w11");
        data.add("w12");
        data.add("w13");
        data.add("w14");
        data.add("w15");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        list= (MyListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        title= (RelativeLayout) findViewById(R.id.title);

        scroll= (MyScrollView) findViewById(R.id.scroll);
        //通过代理模式，解耦和list和scroll，代理本身使用了单例模式
        ViewMedium.getInstance().registerList(list);
        ViewMedium.getInstance().registerScroll(scroll);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //需要设定list的全屏高度，否则scroll不能滚动的
        int height=scroll.getMeasuredHeight();
        RelativeLayout.LayoutParams lp= (RelativeLayout.LayoutParams) list.getLayoutParams();
        lp.height=height;
        list.setLayoutParams(lp);

        scroll.setRange(title.getHeight());

        Log.i("ly","set over scroll height->"+scroll.getHeight()+" list height->"+list.getHeight());
    }
}
