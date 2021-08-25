package com.eceakilli.covidstatistics;

import android.app.Application;

import com.eceakilli.covidstatistics.api.ApiClient;
import com.eceakilli.covidstatistics.api.RestInterface;

public class AppClassApplication extends Application {

    //world-countries için burda oluştur sonra fragmentlarına çek.
   static AppClassApplication instance;
    RestInterface restInterface;

    @Override
    public void onCreate() {
        super.onCreate();

        instance =this;
        restInterface= ApiClient.getClient().create(RestInterface.class);


    }
    public synchronized static AppClassApplication getInstance(){

        return instance;
    }


    //singletn(instance) kullanammızn nedeni 2 kere restint. kullanamazsın

    public RestInterface getRestInterface() {
        return restInterface;
    }
}
