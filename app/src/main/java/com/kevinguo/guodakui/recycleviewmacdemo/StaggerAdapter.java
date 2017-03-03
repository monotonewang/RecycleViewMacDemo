package com.kevinguo.guodakui.recycleviewmacdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

/**
 * Created by guodakui on 16/11/9.
 */

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.ItemViewHold>{
    private LayoutInflater minflater;
    private List<String> mdatas;
    private List<Integer> mHeight;
    private OnItemClickListener monItemClickListener;


    public  StaggerAdapter(Context context,List<String> mdatas){
        this.mdatas=mdatas;
        minflater=LayoutInflater.from(context);
        mHeight = new ArrayList<Integer>();
        for (int i=0;i<mdatas.size();i++){
            mHeight.add((int)(100+ Math.random()*300));
        }

    }
    @Override
    public ItemViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHold viewHold = new ItemViewHold(minflater.inflate(R.layout.item_layout,parent,false));
        return viewHold;
    }

    @Override
    public void onBindViewHolder(ItemViewHold holder, final int position) {
        holder.textView.setText(mdatas.get(position));
        ViewGroup.LayoutParams layoutParams= holder.textView.getLayoutParams();
        layoutParams.height=mHeight.get(position);
        holder.textView.setLayoutParams(layoutParams);

        if (monItemClickListener!=null){
            if (!holder.textView.hasOnClickListeners()){
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        monItemClickListener.onClick(position);
                    }
                });

                holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        monItemClickListener.onLongClick(position);
                        return true;
                    }
                });
            }

        }
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.monItemClickListener=onItemClickListener;
    }

    interface OnItemClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }

    class ItemViewHold extends RecyclerView.ViewHolder{

        private TextView textView;
        public ItemViewHold(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textview);
        }
    }
}
