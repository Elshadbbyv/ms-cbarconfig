package com.example.mscbarconfig.rest.request;

import com.example.mscbarconfig.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ValuteRequest {
    @JsonProperty("Code")
    private Currency code;
    @JsonProperty("ConvertTo")
    private Currency convertTo;
    public ValuteRequest() {
    }

    public ValuteRequest(Currency code, Currency convertTo) {
        this.code = code;
        this.convertTo = convertTo;
    }

    public Currency getCode() {
        return code;
    }

    public void setCode(Currency code) {
        this.code = code;
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

        if (code != that.code) return false;
        return convertTo == that.convertTo;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (convertTo != null ? convertTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ValuteRequest{" +
                "code=" + code +
                ", convertTo=" + convertTo +
                '}';
    }
}
