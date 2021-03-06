package com.eceakilli.covidstatistics.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //servis cagırdıgında kuralları yazzdıgın standart class

    private static Retrofit retrofit = null;
    private static String Base_Url = "https://corona.lmao.ninja/v2/";

    public  static Retrofit getClient(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
        }

        return retrofit;
    }




}
