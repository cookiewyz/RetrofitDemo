package com.fengchao.retrofitdemo.cook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wyz on 16/11/25.
 */

public interface APIinter {
    @GET("/{path}")
    Call<Cook> getCook(@Path("path") String path, @Query("key") String key,@Query("cid") int id);


}
