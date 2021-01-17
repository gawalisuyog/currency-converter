package com.arvato.finance.currencyconverter.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "time",
        "from",
        "to",
        "amount",
        "rate",
        "convert_result"
})
public class ConvertedResult {

    @JsonProperty("time")
    private String time;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("convert_result")
    private Double convertResult;
    @JsonProperty("error")
    private Error error;

    public ConvertedResult(){

    }

    public ConvertedResult(String time, String from, String to, String amount, Double rate, Double convertResult) {
        this.time = time;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.rate = rate;
        this.convertResult = convertResult;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("rate")
    public Double getRate() {
        return rate;
    }

    @JsonProperty("rate")
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @JsonProperty("convert_result")
    public Double getConvertResult() {
        return convertResult;
    }

    @JsonProperty("convert_result")
    public void setConvertResult(Double convertResult) {
        this.convertResult = convertResult;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ConvertedResult{" +
                "time='" + time + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount='" + amount + '\'' +
                ", rate=" + rate +
                ", convertResult=" + convertResult +
                ", error=" + error +
                '}';
    }
}