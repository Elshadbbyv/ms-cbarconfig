package com.example.mscbarconfig.rest.response;


import com.example.mscbarconfig.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CurrencyResponse {
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("Amount")
    private Double amount;

    public CurrencyResponse() {
    }

    public CurrencyResponse(String  currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }




    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyResponse that)) return false;

        if (currency != that.currency) return false;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}