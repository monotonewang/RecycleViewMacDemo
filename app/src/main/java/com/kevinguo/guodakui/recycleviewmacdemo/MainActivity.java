package com.kevinguo.guodakui.recycleviewmacdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.list_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ListLayoutActivity.openListlayoutActivity(MainActivity.this));
            }
        });

        findViewById(R.id.grid_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(GridLayoutActivity.openGridLayoutActivity(MainActivity.this));
            }
        });

        findViewById(R.id.staggergrid_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(StaggerGridLayoutActivity.openStaggerGridLayoutActivity(MainActivity.this));
            }
        });
    }
}
