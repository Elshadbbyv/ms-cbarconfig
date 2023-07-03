package com.example.mscbarconfig.controller;

import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.rest.request.ValuteRequest;
import com.example.mscbarconfig.rest.response.CurrencyResponse;
import com.example.mscbarconfig.rest.response.ValuteResponse;
import com.example.mscbarconfig.service.ConversionService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
public class ConversionController {
    private final ConversionService conversionService;


    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }



    @GetMapping("/convert/all")
    public ResponseEntity<JsonNode> convertToJson(){
        return ResponseEntity.ok(conversionService.convertToJson());
    }
    @GetMapping("/convert/")
    public ResponseEntity<List<CurrencyResponse>> findByCode(@RequestBody CurrencyRequest request) throws IOException {
        return ResponseEntity.ok(conversionService.findByCode(request));
    }


}
