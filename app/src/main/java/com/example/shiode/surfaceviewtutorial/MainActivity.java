package com.example.shiode.surfaceviewtutorial;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;

import com.example.shiode.surfaceviewtutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel viewModel;
    ScrollContainerView scrollContainerView;
    MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        mySurfaceView = binding.mySurfaceView;
        scrollContainerView = binding.scrollContainerView;
        scrollContainerView.setOnScrollChangedListener(new ScrollContainerView.OnScrollChangeListener() {
            @Override
            public void onScrollChanged(int x, int y, int oldX, int oldY) {
                viewModel.scrollY.set(y);
                mySurfaceView.draw(y);
            }
        });
        scrollContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                viewModel.height.set(scrollContainerView.getHeight());
            }
        });
    }
}
