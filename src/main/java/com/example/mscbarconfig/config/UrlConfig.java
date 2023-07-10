package com.example.mscbarconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class UrlConfig {
    private static LocalDate date = LocalDate.now();
    private final String urlXml = ".xml";
    public UrlConfig() {
    }
    public String changeUrlByDate(){
        String dateEarlyDay  =date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return dateEarlyDay+urlXml;
    }
}
