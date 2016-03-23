package com.example.viewshader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sony on 2016/3/22.
 */
public class Clock extends View {

    public Clock(Context context) {
        super(context);
    }

    public Clock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //时钟外圆
        Paint paintCircle = new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paintCircle);

        //时钟刻度
        Paint paintDegree = new Paint();
        paintDegree.setAntiAlias(true);
        for(int i=0;i<24;i++){
            //整点
            if(i==0|i==6|i==12|i==18){
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(30);
                canvas.drawLine(getWidth() / 2, getHeight() / 2 - getWidth() / 2,
                        getWidth() / 2, getHeight() / 2 - getWidth() / 2 + 60, paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,getWidth()/2-paintDegree.measureText(degree)/2,
                        getHeight()/2-getWidth()/2+90,paintDegree);

            }else {
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(15);
                canvas.drawLine(getWidth()/2,getHeight()/2-getWidth()/2,
                        getWidth()/2,getHeight()/2-getWidth()/2+30,paintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,getWidth()/2-paintDegree.measureText(degree)/2,getHeight()/2-getWidth()/2+60,paintDegree);
            }

            //旋转画布
            canvas.rotate(15,getWidth()/2,getHeight()/2);
        }

        //指针
        Paint paintHour = new Paint();
        paintHour.setAntiAlias(true);
        paintHour.setStrokeWidth(20);
        Paint paintMin = new Paint();
        paintMin.setAntiAlias(true);
        paintMin.setStrokeWidth(10);
        canvas.save();
        canvas.translate(getWidth()/2,getHeight()/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMin);
        canvas.restore();
    }
}
