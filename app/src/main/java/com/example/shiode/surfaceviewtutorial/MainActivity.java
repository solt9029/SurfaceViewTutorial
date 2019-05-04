package com.example.shiode.surfaceviewtutorial;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.shiode.surfaceviewtutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);

        binding.scrollContainerView.setOnScrollChangeListener((x, y, oldX, oldY) -> {
            viewModel.offset.set(y);
            binding.mySurfaceView.draw(y);
        });

        binding.scrollContainerView.addOnLayoutChangeListener((view, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
            binding.mySurfaceView.draw(viewModel.offset.get());
        });

    }
}
