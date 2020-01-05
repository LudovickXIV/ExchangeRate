package com.stenart.exchangerate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stenart.exchangerate.R;
import com.stenart.exchangerate.pojo.ExchangeRate;
import com.stenart.exchangerate.pojo.OldRate;
import com.stenart.exchangerate.pojo.Rate;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class RateAdapter extends RecyclerView.Adapter<RateAdapter.ViewHolder> {

    private List<Rate> rates;
    private OldRate oldRate;

    public RateAdapter(List<Rate> rates, OldRate oldRate) {
        this.rates = rates;
        this.oldRate = oldRate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View ratesView = inflater.inflate(R.layout.rate_element, parent, false);
        return new ViewHolder(ratesView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Rate rate = rates.get(position);

        NumberFormat format = new DecimalFormat("#0.00");
        double buy = Double.valueOf(rate.getBuy());
        double sale = Double.valueOf(rate.getSale());

        holder.rate_buy.setText(String.valueOf(format.format(buy)));
        holder.rate_sale.setText(String.valueOf(format.format(sale)));
        holder.currency.setText(rate.getCcy());
        holder.upDownIndicator.setImageResource(isHigher(rate) ? R.drawable.arrow_green : R.drawable.arrow_red);
    }

    @Override
    public int getItemCount() {
        return rates.size();
    }

    private boolean isHigher(Rate rate) {
        for (ExchangeRate exchangeRate : this.oldRate.getExchangeRate()) {
            String oldCurrency = exchangeRate.getCurrency();
            if (oldCurrency != null) {
                if (oldCurrency.equals(rate.getCcy())) {
                    double old = Double.valueOf(exchangeRate.getPurchaseRate());
                    double current = Double.valueOf(rate.getBuy());
                    return old < current;
                }
            }
        }
        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView rate_buy;
        public TextView rate_sale;
        public TextView currency;
        public ImageView upDownIndicator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rate_buy = itemView.findViewById(R.id.rate_buy);
            rate_sale = itemView.findViewById(R.id.rate_sale);
            currency = itemView.findViewById(R.id.currency);
            upDownIndicator = itemView.findViewById(R.id.up_down_indicator);
        }
    }
}
