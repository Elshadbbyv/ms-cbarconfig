package com.example.mscbarconfig.rest.request;

import com.example.mscbarconfig.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuteRequest {
    @JsonProperty("Currency")
    private Currency currency;
    @JsonProperty("ConvertTo")
    private Currency convertTo;
    public ValuteRequest() {
    }

    public ValuteRequest(Currency currency, Currency convertTo) {
        this.currency = currency;
        this.convertTo = convertTo;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(Currency convertTo) {
        this.convertTo = convertTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValuteRequest that)) return false;

        if (currency != that.currency) return false;
        return convertTo == that.convertTo;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (convertTo != null ? convertTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ValuteRequest{" +
                "code=" + currency +
                ", convertTo=" + convertTo +
                '}';
    }
}
