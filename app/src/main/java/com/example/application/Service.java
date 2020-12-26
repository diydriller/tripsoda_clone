package com.example.application;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface Service {

    @FormUrlEncoded
    @POST("getPage2.php")
    Call<List<Page2Info>> createPost2(@FieldMap HashMap<String,Object> param);

    @FormUrlEncoded
    @POST("getPage1.php")
    Call<List<Page1Info>> createPost1(@FieldMap HashMap<String,Object> param);

    @FormUrlEncoded
    @POST("CodeValidate.php")
    Call<UserInfo> createPost(@FieldMap HashMap<String,Object> param);
}
