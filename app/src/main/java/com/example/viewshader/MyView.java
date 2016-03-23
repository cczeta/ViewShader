package com.example.viewshader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sony on 2016/3/22.
 */
public class MyView extends View{
    private Bitmap mBitmap;
    private Shader mBitmapShader;
    private Paint mPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
        //拉伸模式
        mBitmapShader = new BitmapShader(mBitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);
        mPaint = new Paint();
        mPaint.setShader(mBitmapShader);
        canvas.drawCircle(200,200,200,mPaint);
    }
}
