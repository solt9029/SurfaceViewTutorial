package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private int width;

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
        this.width = width;
        draw(0);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("MySurfaceView", "surfaceCreated");
        width = getWidth();
        draw(0);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public void draw(int offset) {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setStyle(Style.FILL);

        int count = 0;
        for (int y = -offset; y < Util.convertDp2Px(2000, getContext()) - offset; y += Util.convertDp2Px(80, getContext())) {
            c.drawCircle(width / 2, y, Util.convertDp2Px(10, getContext()) + count, p);
            count++;
        }

        holder.unlockCanvasAndPost(c);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, resolveSize(0, heightMeasureSpec));
    }
}
