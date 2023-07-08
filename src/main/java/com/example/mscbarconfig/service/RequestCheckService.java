package com.example.mscbarconfig.service;

import com.example.mscbarconfig.model.Currency;
import com.example.mscbarconfig.model.dto.CurrencyDto;
import com.example.mscbarconfig.rest.response.ValuteResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class RequestCheckService {
    public CurrencyDto checkAznCurrency(Optional<ValuteResponse> response){

//        if (response.getCode().equals(Currency.AZN)) {
//            return new CurrencyDto(Currency.AZN,BigDecimal.ONE);
//        }
//        throw new RuntimeException("Currency is not suitable");
//

        return response.filter(dto -> dto.getCode().equals(Currency.AZN))
                .map(dto -> new CurrencyDto(Currency.AZN, BigDecimal.ONE))
                .orElseThrow(() -> new RuntimeException("Currency is not suitable"));
    }
}
