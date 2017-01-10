package com.chamoapp.viewpagerwithedgeexample.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chamoapp.viewpagerwithedgeexample.R;

/**
 * Created by Koo on 2017. 1. 6..
 */

public class BannerIndicatorAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private SparseBooleanArray mItemArray;

    public BannerIndicatorAdapter(Context context, SparseBooleanArray itemArray) {
        mContext = context;
        mItemArray = itemArray;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.banner_indicator_item, parent, false);

        return new IndicatorViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IndicatorViewHolder viewHolder = (IndicatorViewHolder) holder;

        boolean isSelected = mItemArray.valueAt(position);
        viewHolder.mIndicatorView.setBackgroundResource(isSelected ? R.drawable.indicator_selected : R.drawable.indicator_unselected);
    }

    @Override
    public int getItemCount() {
        return mItemArray.size();
    }

    private static class IndicatorViewHolder extends RecyclerView.ViewHolder {
        private View mIndicatorView;

        public IndicatorViewHolder(View itemView) {
            super(itemView);
            mIndicatorView = itemView.findViewById(R.id.banner_indicator_item_view);
        }
    }

    public static class HorizontalSpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public HorizontalSpaceItemDecoration(int space) {
            mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
                outRect.right = mSpace;
            }
        }
    }
}
