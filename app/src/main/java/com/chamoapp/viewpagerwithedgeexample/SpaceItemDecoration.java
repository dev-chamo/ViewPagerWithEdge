package com.chamoapp.viewpagerwithedgeexample;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Koo on 16. 4. 1..
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpaceMargin;
    private boolean mHasGridLayout;

    public SpaceItemDecoration(int margin, boolean hasGridLayout) {
        mSpaceMargin = margin;
        mHasGridLayout = hasGridLayout;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mHasGridLayout) {
            outRect.top = mSpaceMargin;
            outRect.bottom = mSpaceMargin;
            outRect.left = mSpaceMargin;
            outRect.right = mSpaceMargin;

        } else {
            outRect.bottom = mSpaceMargin;

        }

    }
}
