package com.example.mscbarconfig.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class CurrencyApiResponse {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ValType")
    private List<CurrencyType> valType;

    public CurrencyApiResponse() {
    }

    public CurrencyApiResponse(String date, String name, String description, List<CurrencyType> valType) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.valType = valType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CurrencyType> getValType() {
        return valType;
    }

    public void setValType(List<CurrencyType> valType) {
        this.valType = valType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyApiResponse that)) return false;

        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(valType, that.valType);
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (valType != null ? valType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyApiResponse{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", valType=" + valType +
                '}';
    }
}
