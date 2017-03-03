package com.kevinguo.guodakui.recycleviewmacdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends AppCompatActivity {

    private List<String> mdatas;
    private RecyclerView mrecyclerView;
    private ListAdapter mlistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initdata();
        mrecyclerView = (RecyclerView) findViewById(R.id.gridRecyclerView);
        mlistAdapter = new ListAdapter(this, mdatas);
        mlistAdapter.setOnitermClickLister(new ListAdapter.OnItemClickLister() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(GridLayoutActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {
                Toast.makeText(GridLayoutActivity.this, "long click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImageClick(View view, int position) {
                Toast.makeText(GridLayoutActivity.this, "image click" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mrecyclerView.setAdapter(mlistAdapter);

        mrecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        mrecyclerView.addItemDecoration(new GridItemDecoration(this));

        mrecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    public static Intent openGridLayoutActivity(Context context) {
        Intent intent = new Intent(context, GridLayoutActivity.class);
        return intent;
    }

    private void initdata() {
        mdatas = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            mdatas.add(String.valueOf(i));
        }
    }
}
