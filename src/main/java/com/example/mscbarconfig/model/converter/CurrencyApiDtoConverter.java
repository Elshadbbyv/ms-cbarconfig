package com.example.mscbarconfig.model.converter;

import com.example.mscbarconfig.model.CurrencyApiResponse;

import com.example.mscbarconfig.model.dto.CurrencyApiResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyApiDtoConverter {
    public CurrencyApiResponseDto convertToCurrencyApiDto(CurrencyApiResponse response){
        return new CurrencyApiResponseDto(
                response.getDate(),
                response.getName(),
                response.getDescription(),
                response.getValType());
    }
}
