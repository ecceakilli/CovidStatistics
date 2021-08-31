package com.eceakilli.covidstatistics.api;

import com.eceakilli.covidstatistics.data.Country;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {


    @GET("all")
    Call<Map<String, Double>> getWorldData();

    @GET("countries?sort=cases")
    Call<ArrayList<Country>> getCountriesData();
}
