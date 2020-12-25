package com.gstechworks.digicardo.Retrofit;

import com.gstechworks.digicardo.Response.ResponseDetail;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/api/login")
    Call<ResponseDetail> LoginSignUp(@Field("mobile") String mobile);


    @FormUrlEncoded
    @POST("api/sendOTP")
    Call<ResponseDetail> sendOtp(@Field("mobile") String mobile);
}
