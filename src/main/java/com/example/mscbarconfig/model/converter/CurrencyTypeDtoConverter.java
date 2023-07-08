package com.example.mscbarconfig.model.converter;

import com.example.mscbarconfig.model.CurrencyType;
import com.example.mscbarconfig.model.dto.CurrencyTypeDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyTypeDtoConverter {
    public CurrencyTypeDto convertToCurrencyTypeDto(CurrencyType type){
        return new CurrencyTypeDto(
                type.getType(),
                type.getValute()
        );
    }

}
