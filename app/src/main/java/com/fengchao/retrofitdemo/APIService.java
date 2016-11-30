package com.fengchao.retrofitdemo;

import com.fengchao.retrofitdemo.cook.CookBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by wyz on 16/11/25.
 */

public interface APIService {
    @GET("/image")
    Call<String> getBaidu();

    @GET("/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0")
    Call<String> getData();

    @GET("/v2/channels/101/items_v2")
    Call<String> getMessage(@Query("ad") int ad,@Query("gender")int gender,@Query("generation")int generation,@Query("limit") int limit,@Query("offset") int ofset);


    @GET("/v2/channels/{url}/items_v2")
    Call<String> getPath(@Path("url") String url,@Query("ad") int ad, @Query("gender")int gender, @Query("generation")int generation, @Query("limit") int limit, @Query("offset") int offset);


    @POST("/cook/list")
    Call<CookBean> getCookBean(@Query("page") int page, @Query("rows") int rows, @Query("id") int id);


}
