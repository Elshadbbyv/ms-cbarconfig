package com.example.mscbarconfig.controller;

import com.example.mscbarconfig.service.ConversionJsonService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rates")
public class ConversionController {
    private final ConversionJsonService conversionJsonService;
    public ConversionController(ConversionJsonService conversionJsonService) {
        this.conversionJsonService = conversionJsonService;
    }
    @GetMapping
    public ResponseEntity<JsonNode> convertToJson(){
        return ResponseEntity.ok(conversionJsonService.convertToJson());
    }


}
