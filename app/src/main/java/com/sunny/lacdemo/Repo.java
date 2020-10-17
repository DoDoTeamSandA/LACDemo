package com.sunny.lacdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Repo {
    @GET("posts/")
    Call< List<Model>> getdata();
}
