package com.stenart.exchangerate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.stenart.exchangerate.adapter.RateAdapter;
import com.stenart.exchangerate.pojo.ExchangeRate;
import com.stenart.exchangerate.pojo.OldRate;
import com.stenart.exchangerate.pojo.Rate;
import com.stenart.exchangerate.retrofit.PrivatService;
import com.stenart.exchangerate.service.MoneyService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                List rates = null;
                OldRate oldRates = null;
                try {
                    rates = MoneyService.getRate();
                    oldRates = MoneyService.getOldRates();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                final List finalRates = rates;
                final OldRate finalOldRates = oldRates;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RecyclerView recyclerView = findViewById(R.id.rvRates);
                        RateAdapter rateAdapter = new RateAdapter(finalRates, finalOldRates);
                        recyclerView.setAdapter(rateAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                });

            }
        }).start();

    }
}