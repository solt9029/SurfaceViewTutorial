package com.example.shiode.surfaceviewtutorial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class OvlView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;

    //コンストラクタ
    public OvlView(Context context) {
        super(context);

        holder = this.getHolder();
        holder.addCallback(this);

        //ビューの背景を透過させる
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        //最前面に描画する
//        setZOrderOnTop(true);
    }

    public OvlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        holder = this.getHolder();
        holder.addCallback(this);

        //ビューの背景を透過させる
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        //最前面に描画する
//        setZOrderOnTop(true);
    }

    public OvlView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        holder = this.getHolder();
        holder.addCallback(this);

        //ビューの背景を透過させる
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        //最前面に描画する
//        setZOrderOnTop(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        //描画例（円を描く）
        Paint p = new Paint();
        p.setARGB(255, 255, 0, 0);
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 300, p);

        holder.unlockCanvasAndPost(canvas);
    }
}
