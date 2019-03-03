package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.util.DisplayMetrics;

public class Util {
        public static float convertPx2Dp(int px, Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / metrics.density;
    }
}
