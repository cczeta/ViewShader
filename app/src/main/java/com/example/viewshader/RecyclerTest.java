package com.example.viewshader;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 2016/3/23.
 */
public class RecyclerTest extends Activity {
    private List<String> mData = new ArrayList<>();
    private RecyclerAdapter mAdapter;
    private RecyclerView RCList;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        RCList = (RecyclerView)findViewById(R.id.rc_list);
        spinner = (Spinner)findViewById(R.id.spinner);
        initData();
        RCList.setAdapter(mAdapter);
        RCList.setLayoutManager(new LinearLayoutManager(this));
        RCList.setHasFixedSize(true);
        //设置显示动画
        RCList.setItemAnimator(new DefaultItemAnimator());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    RCList.setLayoutManager(
                            //设为线性布局
                            new LinearLayoutManager(RecyclerTest.this)
                    );
                }else if(position==1){
                    RCList.setLayoutManager(
                            new GridLayoutManager(RecyclerTest.this,3));
                }else if(position==2){
                    
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    //测试数据
    private void initData() {
        for(int i=0;i<30;i++) {
            mData.add("Recycler");
        }
        mAdapter = new RecyclerAdapter(mData);
        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(final View view, int position) {
                //设置点击动画
                view.animate().translationZ(40F).setDuration(300).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.animate().translationZ(0f).setDuration(500).start();
                    }
                }).start();
            }
        });
    }
}
