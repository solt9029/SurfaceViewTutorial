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

        binding.scrollContainerView.setOnScrollChangeListener(new ScrollContainerView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(int x, int y, int oldX, int oldY) {
                viewModel.offset.set(y);
            }
        });

    }
}
