package com.example.shiode.surfaceviewtutorial;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;

public class MainViewModel extends ViewModel {
    public ObservableInt offset = new ObservableInt(0);

    MainViewModel() {
    }
}
