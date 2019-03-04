package com.example.shiode.surfaceviewtutorial;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.view.View;
import android.view.ViewGroup;

public class MainViewModel extends ViewModel {
    // MySurfaceView properties.
    public ObservableInt scrollY = new ObservableInt(0);
    public ObservableInt height = new ObservableInt(0);

    MainViewModel() {
    }

    @BindingAdapter("scrollY")
    public static void setScrollY(MySurfaceView view, int value) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.topMargin = value; // px
        view.setLayoutParams(params);
//        view.draw(value); // this makes error
    }

    @BindingAdapter("height")
    public static void setHeight(MySurfaceView view, int value) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = value;
        view.setLayoutParams(params);
    }

    // param v is ScrollContainerView
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        height.set(v.getHeight());
    }

}
