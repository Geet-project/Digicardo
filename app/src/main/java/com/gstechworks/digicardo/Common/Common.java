package com.gstechworks.digicardo.Common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gstechworks.digicardo.Retrofit.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Common {
    private Common(){}

    public static final String BASE_URL = "http://digicardo.geetinfo.in";



    public static ApiInterface getAPIService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiInterface.class);
//        return RetrofitClient.getClient(BASE_URL).create(ApiInterface.class);
    }
}
