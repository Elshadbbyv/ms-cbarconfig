package com.example.mscbarconfig.controller;

import com.example.mscbarconfig.model.CurrencyApiResponse;
import com.example.mscbarconfig.model.dto.CurrencyApiResponseDto;
import com.example.mscbarconfig.model.dto.CurrencyDto;
import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.service.ConversionJsonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class ConversionController {
    private final ConversionJsonService conversionJsonService;


    public ConversionController(ConversionJsonService conversionJsonService) {
        this.conversionJsonService = conversionJsonService;
    }



    @GetMapping("/convert/all")
    public ResponseEntity<CurrencyApiResponseDto> convertToJson(CurrencyRequest request){
        return ResponseEntity.ok(conversionJsonService.convertToJson());
    }
    @PostMapping("/convert/")
    public ResponseEntity<List<CurrencyDto>> findByCode(@RequestBody CurrencyRequest request) throws IOException {
        return ResponseEntity.ok(conversionJsonService.getCurrencyAndConvertList(request));
    }


}
