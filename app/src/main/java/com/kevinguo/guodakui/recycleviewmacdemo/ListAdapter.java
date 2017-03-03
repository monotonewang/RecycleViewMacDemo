package com.kevinguo.guodakui.recycleviewmacdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guodakui on 16/11/5.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {

    private List<String> mDatas;
    private LayoutInflater minflater;
    private OnItemClickLister onItemClickLister;
    private boolean mSelect = false;
    private Context mContext;
    private Drawable mSelectedDrawable;
    private Drawable mNoSelectedDrawable;

    public ListAdapter(Context context, List<String> data) {
        this.mDatas = data;
        this.mContext = context;
        minflater = LayoutInflater.from(context);
        mSelectedDrawable = mContext.getResources().getDrawable(R.mipmap.iv_photo_select);
        mNoSelectedDrawable = mContext.getResources().getDrawable(R.mipmap.iv_photo_noselect);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewHolder holder = new ItemViewHolder(minflater.inflate(
                R.layout.item_layout, parent, false));
        return holder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.mtextView.setText(mDatas.get(position));
        if (onItemClickLister != null) {
            holder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mSelect = !mSelect;
                    if (mSelect) {
                        holder.mImageView.setImageDrawable(mSelectedDrawable);
                    } else {
                        holder.mImageView.setImageDrawable(mNoSelectedDrawable);
                    }
                    onItemClickLister.onImageClick(view, pos);
                }
            });

            if (!holder.mtextView.hasOnClickListeners()) {
                holder.mtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getLayoutPosition();
                        onItemClickLister.OnItemClick(view, pos);
                    }
                });

                holder.mtextView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        int pos = holder.getLayoutPosition();
                        onItemClickLister.OnItemLongClick(view, pos);
                        return true;
                    }
                });

            }
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setOnitermClickLister(OnItemClickLister onItemClickLister) {
        this.onItemClickLister = onItemClickLister;
    }

    public void add(int position, String value) {
        if (position > mDatas.size()) {
            position = mDatas.size();
        }
        if (position < 0) {
            position = 0;
        }
        mDatas.add(position, value);

        notifyItemInserted(position);
    }

    public String remove(int position) {
        if (position > mDatas.size()) {
            return null;
        }
        if (position < 0) {
            return null;
        }
        String value = mDatas.remove(position);
        notifyItemRemoved(position);

        return value;
    }

    interface OnItemClickLister {
        void OnItemClick(View view, int position);

        void OnItemLongClick(View view, int position);

        void onImageClick(View view, int position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mtextView;
        private ImageView mImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mtextView = (TextView) itemView.findViewById(R.id.textview);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
