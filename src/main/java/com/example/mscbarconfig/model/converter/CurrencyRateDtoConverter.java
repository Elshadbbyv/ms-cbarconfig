package com.example.mscbarconfig.model.converter;

import com.example.mscbarconfig.model.Currency;
import com.example.mscbarconfig.model.CurrencyRate;
import com.example.mscbarconfig.model.dto.CurrencyRateDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRateDtoConverter {
    public CurrencyRateDto converToCurrencyRateDto(CurrencyRate rate){
        return new CurrencyRateDto(
                Currency.valueOf(rate.getCode()),
                rate.getNominal(),
                rate.getName(),
                rate.getValue()
        );
    }


}
