package com.chamoapp.viewpagerwithedgeexample;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chamoapp.viewpagerwithedgeexample.adapter.BannerIndicatorAdapter;
import com.chamoapp.viewpagerwithedgeexample.adapter.BannerViewPagerAdapter;
import com.chamoapp.viewpagerwithedgeexample.adapter.BestSellingProductPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private int mBannerItemCurrentPosition = 0;
    private int mBannerItemsSize = 3;
    private ViewPager mBannerViewPager;
    private BannerViewPagerAdapter mBannerViewPagerAdapter;

    private RecyclerView mBannerIndicatorRv;
    private BannerIndicatorAdapter mBannerIndicatorAdapter;
    private SparseBooleanArray mBannerIndicatorArray;

    private TabLayout mBestSellingProductTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        init();

        // 배너 아이템 불러오기
        loadBannerItems();
    }

    private void init() {

        // Banner
        mBannerViewPager = (ViewPager) findViewById(R.id.diet_shopping_banner_vp);
        mBannerViewPager.setOffscreenPageLimit(3);
        mBannerViewPager.setClipToPadding(false);
        mBannerViewPager.setPageMargin(PixelFromDP(mContext, 10));
        mBannerViewPager.setPadding(PixelFromDP(mContext, 20), 0, PixelFromDP(mContext, 20), 0);
        mBannerViewPagerAdapter = new BannerViewPagerAdapter(mContext, mBannerItemsSize);
        mBannerViewPager.setAdapter(mBannerViewPagerAdapter);
        mBannerViewPager.setCurrentItem(Integer.MAX_VALUE / 2);

        mBannerIndicatorRv = (RecyclerView) findViewById(R.id.diet_shopping_banner_indicator_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        mBannerIndicatorRv.setLayoutManager(linearLayoutManager);

        View goLeftBtn = findViewById(R.id.diet_shopping_banner_go_left_btn);
        goLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBannerViewPager.setCurrentItem(mBannerViewPager.getCurrentItem() - 1);
            }
        });
        View goRightBtn = findViewById(R.id.diet_shopping_banner_go_right_btn);
        goRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBannerViewPager.setCurrentItem(mBannerViewPager.getCurrentItem() + 1);
            }
        });

    }

    private void initTabItem(){
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View item0RootView = inflater.inflate(R.layout.best_selling_product_tab_item, null);
        ((TextView) item0RootView.findViewById(R.id.best_selling_product_tab_title_tv)).setText("단백질");
        mBestSellingProductTab.getTabAt(0).setCustomView(item0RootView);

        View item1RootView = inflater.inflate(R.layout.best_selling_product_tab_item, null);
        ((TextView) item1RootView.findViewById(R.id.best_selling_product_tab_title_tv)).setText("탄수화물");
        mBestSellingProductTab.getTabAt(1).setCustomView(item1RootView);

        View item2RootView = inflater.inflate(R.layout.best_selling_product_tab_item, null);
        ((TextView) item2RootView.findViewById(R.id.best_selling_product_tab_title_tv)).setText("건강간식");
        mBestSellingProductTab.getTabAt(2).setCustomView(item2RootView);

        View item3RootView = inflater.inflate(R.layout.best_selling_product_tab_item, null);
        ((TextView) item3RootView.findViewById(R.id.best_selling_product_tab_title_tv)).setText("다노 아이템");
        mBestSellingProductTab.getTabAt(3).setCustomView(item3RootView);
    }

    private void loadBannerItems() {
        // 테스트 코드 -> todo 서버 API 요청
        mBannerIndicatorArray = new SparseBooleanArray();
        for (int i = 0; i < mBannerItemsSize; i++) {
            mBannerIndicatorArray.append(i, i == mBannerItemCurrentPosition);
        }
        //

        mBannerIndicatorAdapter = new BannerIndicatorAdapter(mContext, mBannerIndicatorArray);
        mBannerIndicatorRv.setAdapter(mBannerIndicatorAdapter);
        mBannerIndicatorRv.addItemDecoration(new BannerIndicatorAdapter.HorizontalSpaceItemDecoration(PixelFromDP(mContext, 4)));

        mBannerViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBannerIndicatorArray.append(mBannerItemCurrentPosition, false);
                mBannerIndicatorArray.append(position % mBannerItemsSize, true);
                mBannerIndicatorAdapter.notifyDataSetChanged();
                mBannerItemCurrentPosition = position % mBannerItemsSize;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Best Selling Product
        mBestSellingProductTab = (TabLayout) findViewById(R.id.diet_shopping_best_selling_product_tab);
        ViewPager mBestSellingProductViewPager = (ViewPager) findViewById(R.id.diet_shopping_best_selling_product_vp);
        BestSellingProductPagerAdapter mBestSellingProductPagerAdapter = new BestSellingProductPagerAdapter(mContext);
        mBestSellingProductViewPager.setAdapter(mBestSellingProductPagerAdapter);

        mBestSellingProductTab.setupWithViewPager(mBestSellingProductViewPager);
        initTabItem();

    }

    public static int PixelFromDP(Context context, int DP) {
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DP, r.getDisplayMetrics());
        return (int) px;
    }
}
