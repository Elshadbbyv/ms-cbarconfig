package com.example.mscbarconfig.service;

import com.example.mscbarconfig.model.Currency;
import com.example.mscbarconfig.model.CurrencyApiResponse;
import com.example.mscbarconfig.model.dto.CurrencyApiResponseDto;
import com.example.mscbarconfig.model.dto.CurrencyDto;
import com.example.mscbarconfig.rest.request.CurrencyRequest;
import com.example.mscbarconfig.rest.response.ValuteResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversionJsonService {
    private final RestTemplate restTemplate;

    private final String apiUrl;
    private final RequestCheckService service;

    public ConversionJsonService(RestTemplate restTemplate, @Value("${openapi.url}") String apiUrl, RequestCheckService service) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.service = service;
    }


    public CurrencyApiResponseDto convertToJson(){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            URL url = new URL(apiUrl);
            JsonNode xmlNode = xmlMapper.readTree(url);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(xmlNode);
            return objectMapper.readValue(jsonString, CurrencyApiResponseDto.class);




        }catch (Exception ex){
            return null;
        }
    }
    public List<CurrencyDto> getCurrencyAndConvertList(CurrencyRequest request) throws IOException {

        try {

            Optional<ValuteResponse> responseValuteCurrency = convertToJson().getValType().stream()
                    .flatMap(currencyType -> currencyType.getValute().stream())
                    .filter(currencyRate -> currencyRate.getCode().equals(Currency.getName(request.getCurrency())))
                    .map(currencyRate -> new ValuteResponse(Currency.valueOf(currencyRate.getCode()), currencyRate.getNominal(), currencyRate.getName(), currencyRate.getValue()))
                    .findFirst();

            Optional<ValuteResponse> responseValuteConvertTo = convertToJson().getValType().stream()
                    .flatMap(currencyType -> currencyType.getValute().stream())
                    .filter(currencyRate -> currencyRate.getCode().equals(Currency.getName(request.getConvertTo())))
                    .map(currencyRate -> new ValuteResponse(Currency.valueOf(currencyRate.getCode()), currencyRate.getNominal(), currencyRate.getName(), currencyRate.getValue()))
                    .findFirst();


            CurrencyDto currencyFirst = new CurrencyDto(
                    responseValuteCurrency.stream().map(ValuteResponse::getCode).findFirst().orElse(null),
                    responseValuteCurrency.stream().map(ValuteResponse::getValue).findFirst().orElse(BigDecimal.ZERO));
            CurrencyDto currencyConvertTo = new CurrencyDto(
                    responseValuteConvertTo.stream().map(ValuteResponse::getCode).findFirst().orElse(null),
                    responseValuteConvertTo.stream().map(ValuteResponse::getValue).findFirst().orElse(BigDecimal.ZERO));
            List<CurrencyDto> returnCurrencyDto = new ArrayList<>();
            returnCurrencyDto.add(currencyFirst);
            returnCurrencyDto.add(currencyConvertTo);
            return returnCurrencyDto;

//            BigDecimal newAmount = currencyFirst.getValue().divide(currencyConvertTo.getValue(), RoundingMode.CEILING);
//            return new CurrencyResponse(currencyConvertTo.getCode(),newAmount.multiply(request.getAmount()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;}





}

