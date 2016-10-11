package com.goku.sample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.goku.loadmore.R;
import com.goku.sample.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Trang Pham on 10/7/2016.
 */
public class ProductAdapter extends BaseAdapter {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void update(List<Product> productList, boolean isLoadmore) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        Product product = productList.get(position);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.productImageView.setImageResource(R.drawable.placeholder);
        if (product.getImageProduct().size() > 0) {
            String url = product.getImageProduct().get(0);
            Glide.with(context).load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(viewHolder.productImageView);
        }

        viewHolder.productTextView.setText(product.getName());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.product_imageview)
        ImageView productImageView;

        @BindView(R.id.product_textview)
        TextView productTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
