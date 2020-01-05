
package com.stenart.exchangerate.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExchangeRate {

    @SerializedName("baseCurrency")
    @Expose
    private String baseCurrency;
    @SerializedName("saleRateNB")
    @Expose
    private String saleRateNB;
    @SerializedName("purchaseRateNB")
    @Expose
    private String purchaseRateNB;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("saleRate")
    @Expose
    private String saleRate;
    @SerializedName("purchaseRate")
    @Expose
    private String purchaseRate;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getSaleRateNB() {
        return saleRateNB;
    }

    public void setSaleRateNB(String saleRateNB) {
        this.saleRateNB = saleRateNB;
    }

    public String getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public void setPurchaseRateNB(String purchaseRateNB) {
        this.purchaseRateNB = purchaseRateNB;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(String saleRate) {
        this.saleRate = saleRate;
    }

    public String getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(String purchaseRate) {
        this.purchaseRate = purchaseRate;
    }


    @Override
    public String toString() {
        return "ExchangeRate{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                ", currency='" + currency + '\'' +
                ", saleRate=" + saleRate +
                ", purchaseRate=" + purchaseRate +
                '}';
    }
}
