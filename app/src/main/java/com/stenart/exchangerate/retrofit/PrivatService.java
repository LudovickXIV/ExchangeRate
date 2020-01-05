package com.stenart.exchangerate.retrofit;

import com.stenart.exchangerate.pojo.OldRate;
import com.stenart.exchangerate.pojo.Rate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrivatService {

    @GET("pubinfo?json&exchange&coursid=5")
    Call<List<Rate>> listRates();

    @GET("exchange_rates?json")
    Call<OldRate> listRatesOld(@Query("date") String date);

}
