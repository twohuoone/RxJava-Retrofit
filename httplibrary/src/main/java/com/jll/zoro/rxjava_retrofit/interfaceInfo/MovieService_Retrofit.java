package com.jll.zoro.rxjava_retrofit.interfaceInfo;


import com.jll.zoro.rxjava_retrofit.info.MovieEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author : Zoro.
 * @Date : 2017/2/16.
 * @Describe :
 */

public interface MovieService_Retrofit {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
