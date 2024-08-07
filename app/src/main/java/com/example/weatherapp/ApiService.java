package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1/current.json")
    Call<Weather> getWeather(@Query("key") String key,@Query("q") String location);

    @GET("v1/forecast.json")
    Call<Forcast> getForcasting(@Query("key") String key,@Query("q") String location);

}
