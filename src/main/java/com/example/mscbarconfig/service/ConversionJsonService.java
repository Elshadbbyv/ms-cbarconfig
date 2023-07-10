package com.example.mscbarconfig.service;

import com.example.mscbarconfig.config.AppConfig;
import com.example.mscbarconfig.config.UrlConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URL;


@Service
public class ConversionJsonService {
    private final RestTemplate restTemplate;
    private final UrlConfig urlConfig;
    private final String apiUrl;
    private final AppConfig config;

    public ConversionJsonService(RestTemplate restTemplate,
                                 UrlConfig urlConfig,
                                 @Value("${openapi.url}") String apiUrl,
                                 AppConfig config) {
        this.urlConfig = urlConfig;
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.config = config;}

    public JsonNode convertToJson(){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            String response  = restTemplate.getForEntity(apiUrl+ urlConfig.changeUrlByDate(), String.class).getBody();
            return xmlMapper.readTree(response);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}

