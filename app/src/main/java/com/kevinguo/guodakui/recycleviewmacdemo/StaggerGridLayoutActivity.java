package com.kevinguo.guodakui.recycleviewmacdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaggerGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private List<String> mdatas;
    private StaggerAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger_grid_layout);
        initData();
        mrecyclerView = (RecyclerView)findViewById(R.id.staggerRecycleview);
        madapter=new StaggerAdapter(this,mdatas);
        madapter.setOnItemClickListener(new StaggerAdapter.OnItemClickListener() {

            @Override
            public void onClick(int position) {
                Toast.makeText(StaggerGridLayoutActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(StaggerGridLayoutActivity.this,"long"+position,Toast.LENGTH_SHORT).show();
            }
        });

        mrecyclerView.setAdapter(madapter);
        mrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

        mrecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    public static Intent openStaggerGridLayoutActivity(Context context){
        Intent intent = new Intent(context,StaggerGridLayoutActivity.class);
        return intent;
    }

    private void initData(){
        mdatas = new ArrayList<String>();

        for (int i=0;i<50;i++){
            mdatas.add(String.valueOf(i));
        }
    }
}
