package com.example.viewshader;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 2016/3/23.
 */
public class RecyclerTest extends Activity {
    private List<String> mData = new ArrayList<>();
    private RecyclerAdapter mAdapter;
    private RecyclerView RCList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        RCList = (RecyclerView)findViewById(R.id.rc_list);
        initData();
        RCList.setAdapter(mAdapter);
        RCList.setLayoutManager(new LinearLayoutManager(this));
        RCList.setHasFixedSize(true);

    }


    //测试数据
    private void initData() {
        for(int i=0;i<30;i++) {
            mData.add("Recycler");
        }
        mAdapter = new RecyclerAdapter(mData);
    }
}
