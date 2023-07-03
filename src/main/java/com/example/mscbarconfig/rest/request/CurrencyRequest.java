package com.example.mscbarconfig.rest.request;

import com.example.mscbarconfig.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CurrencyRequest {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("ConvertTo")
    private String convertTo;

    public CurrencyRequest() {
    }

    public CurrencyRequest(String code, Double amount, String convertTo) {
        this.code = code;
        this.amount = amount;
        this.convertTo = convertTo;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyRequest that)) return false;

        if (code != that.code) return false;
        if (!Objects.equals(amount, that.amount)) return false;
        return convertTo == that.convertTo;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (convertTo != null ? convertTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "code=" + code +
                ", amount=" + amount +
                ", convertTo=" + convertTo +
                '}';
    }
}
