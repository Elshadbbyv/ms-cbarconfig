package com.example.mscbarconfig.config;

import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.rest.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "ms-currency-converter", url = "${client.ms-currency-converter.endpoint}")
public interface CurrencyConverterClient {
    @RequestMapping("/convert")
    ResponseEntity<List<CurrencyResponse>> convertFromCurrency(@RequestBody CurrencyRequest request);
}
