package com.goku.sample;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.goku.loadmore.LoadMoreGridView;
import com.goku.loadmore.R;
import com.goku.sample.adapter.ProductAdapter;
import com.goku.sample.model.Product;
import com.goku.sample.model.ReponseResult;
import com.goku.sample.network.BearApi;
import com.goku.sample.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Trang Pham on 10/7/2016.
 */
public class MainActivity extends AppCompatActivity implements Callback<ReponseResult>,
        LoadMoreGridView.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String BASE_URL = "http://157.7.196.188:8080/";

    Retrofit retrofit;
    BearApi bearApi;

    @BindView(R.id.product_gridview)
    LoadMoreGridView gridView;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    ProductAdapter productAdapter;

    List<Product> productList;

    int categoryId = 1;
    int page = 0;
    int recordNo = 6;

    Call<ReponseResult> call;

    boolean isLoadmore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productList);
        gridView.setAdapter(productAdapter);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bearApi = retrofit.create(BearApi.class);
        call = bearApi.search(categoryId, page, recordNo);
        call.enqueue(this);

        gridView.setOnLoadMoreListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onResponse(Call<ReponseResult> call, Response<ReponseResult> response) {
        if (response != null) {
            List<Product> appendedProducts = response.body().getData().getProducts();

            System.out.println("Request URL " + call.request().url().toString());
            System.out.println("Product count: " + appendedProducts.size());

            if (appendedProducts.isEmpty()) {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }

                if (isLoadmore) {
                    gridView.onLoadMoreComplete();
                    isLoadmore = false;
                }
                return;
            }
            if (!isLoadmore) {
                productList.clear();
            }
            productList.addAll(appendedProducts);
            productAdapter.update(productList, isLoadmore);

            if (swipeRefreshLayout.isRefreshing()) {
                System.out.println("Turn off swipeRefreshLayout");
                swipeRefreshLayout.setRefreshing(false);
            }

            if (isLoadmore) {
                gridView.onLoadMoreComplete();
                isLoadmore = false;
            }

            page = page + 1;
        }
    }

    @Override
    public void onFailure(Call<ReponseResult> call, Throwable t) {
        System.out.println("Error: " + t.getMessage());
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }

        if (isLoadmore) {
            gridView.onLoadMoreComplete();
            isLoadmore = false;
        }
    }

    @Override
    public void onLoadMore() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
            if (call != null) {
                call.cancel();
                call = null;
            }
        }
        if (!isLoadmore) {
            isLoadmore = true;
            call = bearApi.search(categoryId, page, recordNo);
            call.enqueue(this);
        }
    }

    @Override
    public void onRefresh() {
        if (isLoadmore) {
            isLoadmore = false;
            if (call != null) {
                call.cancel();
                call = null;
            }
        }

        if(NetworkUtils.isNetworkAvailable(this)) {
            page = 0;
            call = bearApi.search(categoryId, page, recordNo);
            call.enqueue(this);
        } else {
            Toast.makeText(this, "Sorry, no Internet connection", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
