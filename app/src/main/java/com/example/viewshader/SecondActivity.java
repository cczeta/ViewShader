package com.example.viewshader;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

/**
 * Created by Sony on 2016/3/23.
 */
public class SecondActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        View v1 = findViewById(R.id.tv_rect);
        View v2  = findViewById(R.id.tv_circle);

        //获取Outline
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改Outline为特定形状
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),30);
            }
        };

        //获取Outline
        ViewOutlineProvider viewOutlineProvider2 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //修改Outline为特定形状
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        };

        //设置形状
        v1.setOutlineProvider(viewOutlineProvider1);
        v2.setOutlineProvider(viewOutlineProvider2);

    }
}
