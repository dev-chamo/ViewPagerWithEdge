package com.chamoapp.viewpagerwithedgeexample.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chamoapp.viewpagerwithedgeexample.R;
import com.chamoapp.viewpagerwithedgeexample.SpaceItemDecoration;
import com.chamoapp.viewpagerwithedgeexample.adapter.BestSellingProductAdapter;
import com.chamoapp.viewpagerwithedgeexample.model.BestSellingProduct;

import static com.chamoapp.viewpagerwithedgeexample.MainActivity.PixelFromDP;

/**
 * Created by Koo on 2017. 1. 6..
 */

public class BestSellingProductPagerAdapter extends PagerAdapter{

    private Context mContext;

    public BestSellingProductPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.view_pager_best_selling_product, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.best_selling_product_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(PixelFromDP(mContext, 5), true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        SparseArray<BestSellingProduct> mBestSellingProductArray = new SparseArray<>();
        for (int i = 0; i < 6; i++) {
            BestSellingProduct product = new BestSellingProduct(String.format("Product Name %d", i), "", "");
            mBestSellingProductArray.append(i, product);
        }
        BestSellingProductAdapter mBestSellingProductAdapter = new BestSellingProductAdapter(mContext, mBestSellingProductArray);
        recyclerView.setAdapter(mBestSellingProductAdapter);

        container.addView(rootView);
        return rootView;
    }

    @Override
    public void finishUpdate(ViewGroup container) {
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
