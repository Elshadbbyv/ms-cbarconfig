package com.example.mscbarconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCbarconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCbarconfigApplication.class, args);
    }

}
