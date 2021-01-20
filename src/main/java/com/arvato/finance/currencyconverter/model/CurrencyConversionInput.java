package com.arvato.finance.currencyconverter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyConversionInput {

    @JsonProperty("currency1")
    private String currency1;
    @JsonProperty("currency2")
    private String currency2;
    @JsonProperty("amount")
    private String amount;

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }
}
