package com.example.mscbarconfig.rest.request;

import com.example.mscbarconfig.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class CurrencyRequest {
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Amount")
    private BigDecimal amount;
    @JsonProperty("ConvertTo")
    private Currency convertTo;

    public CurrencyRequest() {
    }

    public CurrencyRequest(Currency currency, BigDecimal amount, Currency convertTo) {
        this.currency = currency;
        this.amount = amount;
        this.convertTo = convertTo;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(Currency convertTo) {
        this.convertTo = convertTo;
    }
    @Override
    public String toString() {
        return "CurrencyRequest{" +
                "currency=" + currency +
                ", amount=" + amount +
                ", convertTo=" + convertTo +
                '}';
    }
}
