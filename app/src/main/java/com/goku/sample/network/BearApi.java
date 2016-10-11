package com.goku.sample.network;

import com.goku.sample.model.ReponseResult;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Trang Pham on 10/7/2016.
 */
public interface BearApi {

    @POST("api/products")
    Call<ReponseResult> search(@Query("category_id") int categoryId, @Query("page") int page, @Query("recordNo") int recordNo);

}
