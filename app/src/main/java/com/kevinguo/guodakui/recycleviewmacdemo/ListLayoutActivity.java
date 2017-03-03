package com.kevinguo.guodakui.recycleviewmacdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ListAdapter listAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        initData();
        mRecycleView = (RecyclerView) findViewById(R.id.listrecycleview);
        listAdapter = new ListAdapter(this, mData);
        listAdapter.setOnitermClickLister(new ListAdapter.OnItemClickLister() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(ListLayoutActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {
                Toast.makeText(ListLayoutActivity.this, "longClick" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onImageClick(View view, int position) {
                Toast.makeText(ListLayoutActivity.this, "imageClicj" + position, Toast.LENGTH_SHORT).show();
            }
        });
        mRecycleView.setAdapter(listAdapter);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mRecycleView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.VERTICAL));

        mRecycleView.setItemAnimator(new DefaultItemAnimator());


    }


    static public Intent openListlayoutActivity(Context context) {
        Intent intent = new Intent(context, ListLayoutActivity.class);
        return intent;
    }

    protected void initData() {
        mData = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            mData.add(String.valueOf(i));
        }
    }
}
