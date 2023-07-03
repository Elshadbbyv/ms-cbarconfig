package com.example.mscbarconfig.service;

import com.example.mscbarconfig.model.Currency;
import com.example.mscbarconfig.model.CurrencyApiResponse;
import com.example.mscbarconfig.model.CurrencyType;
import com.example.mscbarconfig.rest.CurrencyDto;
import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.rest.request.ValuteRequest;
import com.example.mscbarconfig.rest.response.CurrencyResponse;
import com.example.mscbarconfig.rest.response.ValuteResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversionService {
    private final RestTemplate restTemplate;
    private final String apiUrl;


    public ConversionService(RestTemplate restTemplate,@Value("${openapi.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public JsonNode convertToJson(){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            ObjectMapper jsonMapper = new ObjectMapper();

            URL url = new URL(apiUrl);
            JsonNode xmlNode = xmlMapper.readTree(url);

            // Convert XML to JSON
            String jsonString = jsonMapper.writeValueAsString(xmlNode);
            return jsonMapper.readTree(jsonString);

        }catch (Exception ex){
            return null;
        }
    }
    public List<CurrencyResponse> findByCode(CurrencyRequest request) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        URL url = new URL(apiUrl);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode xmlNode = xmlMapper.readTree(url);
            String jsonString = objectMapper.writeValueAsString(xmlNode);
            CurrencyApiResponse currencyApiResponse = objectMapper.readValue(jsonString, CurrencyApiResponse.class);
            List<Optional<ValuteResponse>> listOfCurrencyAndConvert = new ArrayList<>();


            Optional<ValuteResponse> responseCurrency = currencyApiResponse.getValType().stream()
                    .flatMap(currencyType -> currencyType.getValute().stream())
                    .filter(currencyRate -> currencyRate.getCode().equals(request.getCode()))
                    .map(currencyRate -> new ValuteResponse(currencyRate.getCode(), currencyRate.getNominal(), currencyRate.getName(), currencyRate.getValue()))
                    .findFirst();

            Optional<ValuteResponse> responseConvertTo = currencyApiResponse.getValType().stream()
                    .flatMap(currencyType -> currencyType.getValute().stream())
                    .filter(currencyRate -> currencyRate.getCode().equals(request.getConvertTo()))
                    .map(currencyRate -> new ValuteResponse(currencyRate.getCode(), currencyRate.getNominal(), currencyRate.getName(), currencyRate.getValue()))
                    .findFirst();

            listOfCurrencyAndConvert.add(responseCurrency);
            listOfCurrencyAndConvert.add(responseConvertTo);
            CurrencyDto currencyFirst = new CurrencyDto(
                    responseCurrency.stream().map(ValuteResponse::getCode).findFirst().orElse("AZN"),
                    responseCurrency.stream().map(ValuteResponse::getValue).findFirst().orElse(1.0));
            CurrencyDto currencyConvertTo = new CurrencyDto(
                    responseConvertTo.stream().map(ValuteResponse::getCode).findFirst().orElse("AZN"),
                    responseConvertTo.stream().map(ValuteResponse::getValue).findFirst().orElse(1.0));

//            System.out.println(responseConvertTo);
//            System.out.println(request.getCode());
//            System.out.println(request.getConvertTo());
//            System.out.println(request.getAmount());
//            System.out.println(currencyFirst.getCode());
//            System.out.println(currencyFirst.getValue());
//            System.out.println(currencyConvertTo.getCode());//gormur
//            System.out.println(currencyConvertTo.getValue());//gormur
            Double newAmount = currencyFirst.getValue()/currencyConvertTo.getValue();
            return List.of(new CurrencyResponse(currencyConvertTo.getCode(),newAmount*request.getAmount()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;}





}

