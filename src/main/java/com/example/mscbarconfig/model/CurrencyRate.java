package com.example.mscbarconfig.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import java.util.Objects;

public class CurrencyRate {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Nominal")
    private String nominal;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private BigDecimal value;

    public CurrencyRate() {
    }

    public CurrencyRate(String code, String nominal, String name, BigDecimal value) {
        this.code = code;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyRate that)) return false;

        if (!Objects.equals(code, that.code)) return false;
        if (!Objects.equals(nominal, that.nominal)) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (nominal != null ? nominal.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "code='" + code + '\'' +
                ", nominal='" + nominal + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
