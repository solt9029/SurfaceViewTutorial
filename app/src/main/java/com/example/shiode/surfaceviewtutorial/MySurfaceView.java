package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private float x, y, r;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("MySurfaceView", "surfaceChanged");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("MySurfaceView", "surfaceCreated");
        x = getWidth() / 2;
        y = getHeight() / 2;
        draw();
        loop();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                draw();
        }
        return super.onTouchEvent(event);
    }

    public void draw() {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setStyle(Style.FILL);
        p.setColor(Color.RED);
        c.drawCircle(x, y, r, p); // ★修正
        holder.unlockCanvasAndPost(c);
    }

    public void loop() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                r = r > 50 ? 10 : r + 5;
                draw();
            }
        }, 100, 100, TimeUnit.MILLISECONDS);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, resolveSize(0, heightMeasureSpec));
    }
}
