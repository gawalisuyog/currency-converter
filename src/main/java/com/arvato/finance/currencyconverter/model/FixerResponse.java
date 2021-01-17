package com.arvato.finance.currencyconverter.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class FixerResponse {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("query")
    private Query query;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("historical")
    private String historical;
    @JsonProperty("date")
    private String date;
    @JsonProperty("result")
    private Double result;
    @JsonProperty("error")
    private Error error;

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("historical")
    public String getHistorical() {
        return historical;
    }

    @JsonProperty("historical")
    public void setHistorical(String historical) {
        this.historical = historical;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("result")
    public Double getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(Double result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "FixerResponse{" +
                "success=" + success +
                ", query=" + query +
                ", info=" + info +
                ", historical='" + historical + '\'' +
                ", date='" + date + '\'' +
                ", result=" + result +
                ", error=" + error +
                '}';
    }
}