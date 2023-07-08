package com.example.mscbarconfig.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Currency;

public class CurrencyRequestDto {
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("Amount")
    private BigDecimal amount;
    @JsonProperty("ConvertTo")
    private Currency convertTo;

    public CurrencyRequestDto() {
    }

    public CurrencyRequestDto(Currency currency, BigDecimal amount, Currency convertTo) {
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

}
