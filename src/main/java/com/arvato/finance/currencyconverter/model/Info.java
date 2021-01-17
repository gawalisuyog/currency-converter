package com.arvato.finance.currencyconverter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

class Info {

    @JsonProperty("timestamp")
    private Integer timestamp;
    @JsonProperty("rate")
    private Double rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timestamp")
    public Integer getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Info{" +
                "timestamp=" + timestamp +
                ", rate=" + rate +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}