package com.example.shiode.surfaceviewtutorial;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.view.ViewGroup;

public class MainViewModel extends ViewModel {
    public ObservableInt offset = new ObservableInt(0);
    public ObservableInt height = new ObservableInt(0);

    MainViewModel() {
    }

    @BindingAdapter("offset")
    public static void setOffset(MySurfaceView view, int value) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.topMargin = value; // px
        view.setLayoutParams(params);
        view.draw(value);
    }

    @BindingAdapter("height")
    public static void setHeight(MySurfaceView view, int value) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = value;
        view.setLayoutParams(params);
    }
}
