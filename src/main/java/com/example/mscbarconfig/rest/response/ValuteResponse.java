package com.example.mscbarconfig.rest.response;

import com.example.mscbarconfig.model.Currency;

import java.math.BigDecimal;

import java.util.Objects;

public class ValuteResponse {
    private Currency code;
    private String nominal;
    private String name;
    private BigDecimal value;

    public ValuteResponse() {
    }

    public ValuteResponse(Currency code, String nominal, String name, BigDecimal value) {
        this.code = code;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }


    public Currency getCode() {
        return code;
    }

    public void setCode(Currency code) {
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
        if (!(o instanceof ValuteResponse valuteResponse)) return false;

        if (!Objects.equals(code, valuteResponse.code)) return false;
        if (!Objects.equals(nominal, valuteResponse.nominal)) return false;
        if (!Objects.equals(name, valuteResponse.name)) return false;
        return Objects.equals(value, valuteResponse.value);
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (nominal != null ? nominal.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }


}
