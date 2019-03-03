package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {
//    private ScrollViewListener listener;

    MyScrollView(Context context) {
        super(context);
    }

    MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public void setOnScrollChangedListener(ScrollViewListener listener) {
//        this.listener = listener;
//    }

    @Override
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        super.onScrollChanged(x, y, oldX, oldY);
//        listener.onScrollChanged(x, y, oldX, oldY);
        Log.d("MyScrollViewX", x + " px");
        Log.d("MyScrollViewY", convertPx2Dp(y, getContext()) + " dp");
    }

    public static float convertPx2Dp(int px, Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / metrics.density;
    }

//    public interface ScrollViewListener {
//        void onScrollChanged(int x, int y, int oldX, int oldY);
//    }
}
