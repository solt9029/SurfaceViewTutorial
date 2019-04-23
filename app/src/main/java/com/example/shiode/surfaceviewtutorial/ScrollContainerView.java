package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;

public class ScrollContainerView extends ScrollView {
    @Nullable
    private OnScrollChangeListener listener;

    ScrollContainerView(Context context) {
        super(context);
    }

    ScrollContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    ScrollContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        super.onScrollChanged(x, y, oldX, oldY);
        if (listener != null) {
            listener.onScrollChange(x, y, oldX, oldY);
        }
        Log.d("ScrollX", x + " px");
        Log.d("ScrollY", y + " px");
    }

    public interface OnScrollChangeListener {
        void onScrollChange(int x, int y, int oldX, int oldY);
    }
}
