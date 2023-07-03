package com.example.mscbarconfig.service;

import com.example.mscbarconfig.config.CurrencyConverterClient;
import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.rest.response.CurrencyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConversionComponent {
    private final CurrencyConverterClient converterClient;

    public ConversionComponent(CurrencyConverterClient converterClient) {
        this.converterClient = converterClient;
    }
    public void performConversion(CurrencyRequest request) {
        ResponseEntity<List<CurrencyResponse>> response = converterClient.convertFromCurrency(request);
    }
}
