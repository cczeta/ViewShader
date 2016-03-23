package com.example.viewshader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sony on 2016/3/22.
 */
public class Layer extends View {
    private int LAYER_FLAGS = 1;
    public Layer(Context context) {
        super(context);
    }

    public Layer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(150, 150, 100, mPaint);

        canvas.saveLayerAlpha(0, 0, 400, 400, 127, Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(200, 200, 100, mPaint);

        canvas.saveLayerAlpha(0,0,400,400,160,Canvas.ALL_SAVE_FLAG);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(250, 150, 100, mPaint);

        canvas.restore();

    }
}
