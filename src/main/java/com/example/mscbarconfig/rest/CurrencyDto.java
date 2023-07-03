package com.example.mscbarconfig.rest;


import java.util.Objects;

public class CurrencyDto {
    private String code;
    private Double value;

    public CurrencyDto(String code, Double value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double amount) {
        this.value = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyDto that)) return false;

        if (!Objects.equals(code, that.code)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String
    toString() {
        return "CurrencyDto{" +
                "code=" + code +
                ", amount=" + value +
                '}';
    }
}
