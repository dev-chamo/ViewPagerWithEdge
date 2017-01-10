package com.chamoapp.viewpagerwithedgeexample.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chamoapp.viewpagerwithedgeexample.R;

/**
 * Created by Koo on 2017. 1. 6..
 */

public class BannerViewPagerAdapter extends PagerAdapter {

    private final int[] mResources = {Color.RED, Color.GREEN, Color.BLUE};
    private Context mContext;
    private int mPageSize;

    public BannerViewPagerAdapter(Context context, int pageSize) {
        mContext = context;
        mPageSize = pageSize;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.view_pager_diet_shopping_banner, container, false);

        ImageView itemIv = (ImageView) rootView.findViewById(R.id.diet_shopping_banner_item_iv);
        itemIv.setBackgroundColor(mResources[position % mPageSize]);

        TextView titleTv = (TextView) rootView.findViewById(R.id.diet_shopping_banner_item_title_tv);
        titleTv.setText(String.format("Banner Title %d", position % mPageSize));
        TextView subTitleTv = (TextView) rootView.findViewById(R.id.diet_shopping_banner_item_subtitle_tv);
        subTitleTv.setText("Banner SubTitle");

        container.addView(rootView);

        return rootView;
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
