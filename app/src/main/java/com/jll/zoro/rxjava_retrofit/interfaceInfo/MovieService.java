package com.jll.zoro.rxjava_retrofit.interfaceInfo;


import com.jll.zoro.rxjava_retrofit.info.HttpResult;
import com.jll.zoro.rxjava_retrofit.info.Subject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @Author : Zoro.
 * @Date : 2017/2/16.
 * @Describe :
 */

public interface MovieService {
    @GET("top250")
    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
