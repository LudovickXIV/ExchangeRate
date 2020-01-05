package com.stenart.exchangerate.service;

import com.stenart.exchangerate.pojo.OldRate;
import com.stenart.exchangerate.pojo.Rate;
import com.stenart.exchangerate.retrofit.PrivatService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoneyService {

    private static Retrofit retrofit;
    private static PrivatService service;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/p24api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(PrivatService.class);
    }

    private MoneyService() {

    }

    public static List<Rate> getRate() throws IOException {
        Call<List<Rate>> call = service.listRates();
        return call.execute().body();
    }

    public static OldRate getOldRates() throws IOException {
        Call<OldRate> call = service.listRatesOld(yesterday());
        return call.execute().body();
    }

    public static String yesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, - 1);
        DateFormat format = new SimpleDateFormat("dd.MM.YYYY");
        return format.format(calendar.getTime());
    }
}
