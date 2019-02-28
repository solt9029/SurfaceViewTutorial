package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public MySurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getHolder().addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.BLACK);
        canvas.drawCircle(100, 200, 50, paint);
        holder.unlockCanvasAndPost(canvas);
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
    public void surfaceDestroyed(SurfaceHolder holder) {}
}
