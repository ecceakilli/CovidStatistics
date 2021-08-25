package com.eceakilli.covidstatistics.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {


    @GET("all")
    Call<Map<String, Double>> getWorldData();

    @GET("countries?sort=cases")
    Call<Map<String, Double>> getCountriesData();
}
