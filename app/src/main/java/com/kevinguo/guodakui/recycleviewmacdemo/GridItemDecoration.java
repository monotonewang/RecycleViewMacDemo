package com.kevinguo.guodakui.recycleviewmacdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by guodakui on 16/11/9.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDrawable;

    public GridItemDecoration(Context context){
        mDrawable = context.getResources().getDrawable(R.drawable.divider);
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //super.onDraw(c, parent, state);
        drawHorizontal(c,parent);
        drawVertical(c,parent);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }

    public void drawHorizontal(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                int left = child.getLeft();
                int right = child.getRight();
                int top = child.getBottom();
                int bottom = child.getBottom()+mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);

        }
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                int top = child.getTop() - params.topMargin;
                int bottom = child.getBottom() + params.bottomMargin;
                int left = child.getRight() + params.rightMargin;
                int right = left + mDrawable.getIntrinsicWidth();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);

        }
    }

}
