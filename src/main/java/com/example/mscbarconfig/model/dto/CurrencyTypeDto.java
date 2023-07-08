package com.example.mscbarconfig.model.dto;

import com.example.mscbarconfig.model.CurrencyRate;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class CurrencyTypeDto {
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Valute")
    private List<CurrencyRate> valute;

    public CurrencyTypeDto() {
    }

    public CurrencyTypeDto(String type, List<CurrencyRate> valute) {
        this.type = type;
        this.valute = valute;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CurrencyRate> getValute() {
        return valute;
    }

    public void setValute(List<CurrencyRate> valute) {
        this.valute = valute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyTypeDto that)) return false;

        if (!Objects.equals(type, that.type)) return false;
        return Objects.equals(valute, that.valute);
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (valute != null ? valute.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyTypeDto{" +
                "type='" + type + '\'' +
                ", valute=" + valute +
                '}';
    }
}
