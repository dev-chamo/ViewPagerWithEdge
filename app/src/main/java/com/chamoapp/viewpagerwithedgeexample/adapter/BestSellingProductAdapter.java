package com.chamoapp.viewpagerwithedgeexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chamoapp.viewpagerwithedgeexample.MainActivity;
import com.chamoapp.viewpagerwithedgeexample.R;
import com.chamoapp.viewpagerwithedgeexample.model.BestSellingProduct;

/**
 * Created by Koo on 2017. 1. 6..
 */

public class BestSellingProductAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private SparseArray<BestSellingProduct> mBestSellingProductArray;

    public BestSellingProductAdapter(Context context, SparseArray<BestSellingProduct> productArray) {
        mContext = context;
        mBestSellingProductArray = productArray;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View rootView = inflater.inflate(R.layout.best_selling_product_item, parent, false);
        return new ProductViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProductViewHolder viewHolder = (ProductViewHolder) holder;

        BestSellingProduct product = mBestSellingProductArray.valueAt(position);

        viewHolder.coverIv.getLayoutParams().height = MainActivity.PixelFromDP(mContext, 165);

        switch (position){
            case 0:
                viewHolder.rankIv.setImageResource(R.drawable.shop_number_01);
                break;
            case 1:
                viewHolder.rankIv.setImageResource(R.drawable.shop_number_02);
                break;
            case 2:
                viewHolder.rankIv.setImageResource(R.drawable.shop_number_03);
                break;
            default:
                viewHolder.rankIv.setImageResource(0x0);
        }

        viewHolder.nameTv.setText(product.getName());

    }

    @Override
    public int getItemCount() {
        return mBestSellingProductArray.size();
    }

    private static class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView coverIv;
        private ImageView rankIv;
        private TextView nameTv;

        public ProductViewHolder(View itemView) {
            super(itemView);

            coverIv = (ImageView) itemView.findViewById(R.id.best_selling_product_cover_iv);
            rankIv = (ImageView) itemView.findViewById(R.id.best_selling_product_rank_iv);
            nameTv = (TextView) itemView.findViewById(R.id.best_selling_product_name_tv);
        }
    }
}
